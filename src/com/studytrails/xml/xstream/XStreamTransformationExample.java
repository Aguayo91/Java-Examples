package com.studytrails.xml.xstream;

import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.TraxSource;

public class XStreamTransformationExample {
	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException {
		XStreamTransformationExample transformationExample = new XStreamTransformationExample();
		transformationExample.runTransformation();
	}

	private void runTransformation() throws TransformerFactoryConfigurationError, TransformerException {
		XStream xstream = new XStream();
		xstream.alias("rss", Rss2.class);
		xstream.alias("item", Item2.class);
		Rss2 rss = new Rss2();
		Channel2 channel = new Channel2();
		rss.channel = channel;
		channel.title = "Title";
		channel.link = "link";
		channel.image = new Image2();
		channel.image.link = "image link";
		Item2 item1 = new Item2();
		item1.link = "item link";
		item1.title = "Item Title";
		channel.items = new ArrayList<Item2>();
		channel.items.add(item1);
		System.out.println(xstream.toXML(rss));
		/*-
		 *
		<rss>
		<channel>
			<title>Title</title>
			<link>link</link>
			<image>
				<link>image link</link>
			</image>
			<items>
				<item>
					<title>Item Title</title>
					<link>item link</link>
				</item>
			</items>
		</channel>
		</rss>
		 */

		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource("bbc.xsl"));
		TraxSource traxSource = new TraxSource(rss, xstream);
		StreamResult result = new StreamResult(System.out);
		transformer.transform(traxSource, result);
		
		// prints the html on console

	}
}
