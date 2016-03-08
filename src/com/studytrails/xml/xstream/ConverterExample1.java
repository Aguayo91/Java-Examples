package com.studytrails.xml.xstream;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class ConverterExample1 {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		ConverterExample1 converter = new ConverterExample1();
		converter.convert();
	}

	private void convert() throws MalformedURLException, URISyntaxException {

		BasicConverterFields basicConverterExample = new BasicConverterFields();
		basicConverterExample.initialize();

		XStream xStream = new XStream();

		xStream.registerLocalConverter(BasicConverterFields.class, "flag", BooleanConverter.BINARY);

		DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {}, TimeZone.getTimeZone("UTC"));
		xStream.registerConverter(dateConverter);

		String xml = xStream.toXML(basicConverterExample);

		System.out.println(xml);
		/*-
		 * <com.studytrails.xml.xstream.ConverterExample1_-BasicConverterFields>
		<bigDecimal>10000000000</bigDecimal>
		<bigInteger>1000000000</bigInteger>
		<flag>1</flag>
		<byteA>97</byteA>
		<charA>a</charA>
		<date>2014-04-26 04:14:38</date>
		<doubleA>1.0E12</doubleA>
		<floatA>9.9999998E12</floatA>
		<intA>100</intA>
		<longA>100000</longA>
		<shortA>1</shortA>
		<stringBufferA>test</stringBufferA>
		<stringBuilderA>test</stringBuilderA>
		<UriA>file://C/work/fileA</UriA>
		<urlA>http://www.google.com</urlA>
		<uuidA>0000000a-000b-000c-000d-00000000000e</uuidA>
		<outer-class/>
		</com.studytrails.xml.xstream.ConverterExample1_-BasicConverterFields>
		 */

		BasicConverterFields basicConverterFromXML = (BasicConverterFields) xStream.fromXML(xml);
		System.out.println(basicConverterFromXML);
		/*-
		 * BasicConverterFields [bigDecimal=10000000000, bigInteger=1000000000, flag=true, byteA=97, charA=a, date=Sat Apr 26 09:44:38 IST 2014, 
		 * doubleA=1.0E12, floatA=9.9999998E12, intA=100, longA=100000, nullA=null, shortA=1, stringBufferA=test, stringBuilderA=test, 
		 * UriA=file://C/work/fileA, urlA=http://www.google.com, uuidA=0000000a-000b-000c-000d-00000000000e]

		 */
	}

	class BasicConverterFields {
		BigDecimal bigDecimal = new BigDecimal(10000000000.0);
		BigInteger bigInteger = new BigInteger("1000000000");
		boolean flag = true;
		byte byteA = 'a';
		char charA = 'a';
		Date date = new Date();
		Double doubleA = new Double(1000000000000.0);
		Float floatA = new Float(10000000000000f);
		int intA = 100;
		Long longA = new Long(100000);
		Object nullA = null;
		Short shortA = new Short((short) 1);
		StringBuffer stringBufferA = new StringBuffer("test");
		StringBuilder stringBuilderA = new StringBuilder().append("test");
		URI UriA = null;
		URL urlA = null;
		UUID uuidA = UUID.fromString("0000000a-000b-000c-000d-00000000000e");

		public void initialize() throws URISyntaxException, MalformedURLException {
			UriA = new URI("file://C/work/fileA");
			urlA = new URL("http://www.google.com");
		}

		@Override
		public String toString() {
			return "BasicConverterFields [bigDecimal=" + bigDecimal + ", bigInteger=" + bigInteger + ", flag=" + flag + ", byteA=" + byteA
					+ ", charA=" + charA + ", date=" + date + ", doubleA=" + doubleA + ", floatA=" + floatA + ", intA=" + intA + ", longA=" + longA
					+ ", nullA=" + nullA + ", shortA=" + shortA + ", stringBufferA=" + stringBufferA + ", stringBuilderA=" + stringBuilderA
					+ ", UriA=" + UriA + ", urlA=" + urlA + ", uuidA=" + uuidA + "]";
		}

	}

}
