package com.studytrails.xml.xstream;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CustomConverterExample {

	public static void main(String[] args) throws IOException {
		CustomConverterExample customConverterExample = new CustomConverterExample();
		customConverterExample.showCustomConversionForBufferedImage();
	}

	private void showCustomConversionForBufferedImage() throws IOException {
		Company company = new Company();
		company.setName("Study Trails");
		BufferedImage in = ImageIO.read(new File("st1_200.jpg"));
		BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(in, 0, 0, null);
		g.dispose();
		company.setImage(newImage);
		XStream xStream = new XStream();
		xStream.registerConverter(new CustomBufferedImageConverter());
		String xml = xStream.toXML(company);

		Company company2 = (Company) xStream.fromXML(xml);
		File outputfile = new File("st2_200.jpg");
		ImageIO.write(company2.image, "jpg", outputfile);

	}

}

class Company {
	String name;
	BufferedImage image;

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}

class CustomBufferedImageConverter implements Converter {
	@Override
	public boolean canConvert(Class type) {

		return type.isAssignableFrom(BufferedImage.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		BufferedImage bufferedImage = (BufferedImage) source;
		try {
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
			ImageIO.write(bufferedImage, "jpg", objectOutputStream);
			outStream.flush();
			Base64Encoder encorder = new Base64Encoder();
			String imageString = encorder.encode(outStream.toByteArray());
			outStream.close();
			writer.setValue(imageString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		BufferedImage image = null;
		try {
			Base64Encoder encoder = new Base64Encoder();
			byte[] imageBytes = encoder.decode(reader.getValue());
			ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(imageBytes));
			image = ImageIO.read(inputStream);
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return image;
	}
}
