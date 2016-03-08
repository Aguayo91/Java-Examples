package com.studytrails.toc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class GenerateHeaderAndFooter {

	public String stagingDirectory = "C:\\work\\java\\tutorial\\stage\\";
	public String outputDirectory = "C:\\work\\java\\tutorial\\stage\\output\\";
	// public String tocFile = "C:\\work\\java\\site\\toc\\toc.csv";
	public String tocFile = "C:\\work\\java\\site\\toc\\java8.csv";

	public static void main(String[] args) throws IOException {
		GenerateHeaderAndFooter headerAndFooterGenerator = new GenerateHeaderAndFooter();
		headerAndFooterGenerator.generate();
	}

	private void generate() throws IOException {
		// create emtpy output directory
		FileUtils.cleanDirectory(new File(outputDirectory));

		CSVFormat format = CSVFormat.newFormat(',').withQuote('"').withHeader();
		CSVParser parser = format.parse(new FileReader(new File(tocFile)));
		List<CSVRecord> records = parser.getRecords();
		for (int i = 0; i < records.size(); i++) {
			CSVRecord record = records.get(i);
			// System.out.println(record.toString());
			// build the path
			String path = getPath(record.get(1), record.get(2), record.get(3));
			File inputDir = new File(outputDirectory + File.separator + path);
			String title = record.get(4);
			String keywords = record.get(5);
			String description = record.get(6);
			String id = record.get(7);
			String[] tokens = record.get(9).split("/");
			String file = tokens[tokens.length - 1];
			int previousOrNext = Integer.parseInt(record.get(8));
			String previousTitle = "";
			String previousLink = "";
			String nextTitle = "";
			String nextLink = "";
			if (previousOrNext != 1) {
				previousTitle = records.get(i - 1).get(4);
				previousLink = records.get(i - 1).get(9);
			}
			if (previousOrNext != -1) {
				nextTitle = records.get(i + 1).get(4);
				nextLink = records.get(i + 1).get(9);
			}

			String header = buildHeader(title, keywords, description, id,
					previousTitle, previousLink, nextTitle, nextLink);
			String footer = buildFooter(title, keywords, description,
					previousTitle, previousLink, nextTitle, nextLink);
			System.out.println(header);
			// System.out.println(footer);
			Files.createDirectories(inputDir.toPath());
			PrintWriter outputFile = new PrintWriter(new File(inputDir
					+ File.separator + file));
			outputFile.println(header);
			List<String> inputLines = FileUtils.readLines(new File(
					stagingDirectory + File.separator + path + File.separator
							+ file));
			for (String line : inputLines) {
				outputFile.println(line);
			}
			outputFile.println(footer);
			IOUtils.closeQuietly(outputFile);
			// break;
		}
	}

	private String buildFooter(String title, String keywords,
			String description, String previousTitle, String previousLink,
			String nextTitle, String nextLink) {
		String footer = "</div></section><section class=\"container\"> <div class=\"col-md-2\"><a href=\""
				+ previousLink
				+ "\"  title=\""
				+ previousTitle
				+ "\""
				+ ("".equals(previousTitle) ? "class=\"disabled\"" : "")
				+ "\">Previous<img src=\"/images/back.png\" style=\"border: none;\" /></a></div><div class=\"col-md-offset-10 col-md-2\"><a href=\""
				+ nextLink
				+ "\" title=\""
				+ nextTitle
				+ "\""
				+ ("".equals(nextTitle) ? "class=\"disabled\"" : "")
				+ "\"> Next<img src=\"/images/forward.png\"  style=\"border: none;\" /></a></div></section><%@include file=\"/bottom.jsp\" %>";
		return footer;
	}

	private String buildHeader(String title, String keywords,
			String description, String id, String previousTitle,
			String previousLink, String nextTitle, String nextLink) {
		String header = "<%String title=\""
				+ title
				+ "\";String keywords=\""
				+ keywords
				+ "\";String description=\""
				+ description
				+ "\";String id=\""
				+ id
				+ "\";%>"
				+ "<%@include file=\"/top.jsp\" %>"
				+ "<section class=\"container\"><div class=\"col-md-2\">Previous<a href=\""
				+ previousLink
				+ "\"  title=\""
				+ previousTitle
				+ "\""
				+ ("".equals(previousTitle) ? "class=\"disabled\"" : "")
				+ "> <img src=\"/images/back.png\" style=\"border: none;\" /></a></div>   <div class=\"col-md-8 tutorialHeader\">"
				+ title
				+ "</div><div class=\"col-md-2\"><a href=\""
				+ nextLink
				+ "\" title=\""
				+ nextTitle
				+ "\""
				+ ("".equals(nextTitle) ? "class=\"disabled\"" : "")
				+ ">Next <img src=\"/images/forward.png\"  style=\"border: none;\" /></a></div></section>"
				+ "<%@include file=\"toc.jsp\" %><section class=\"container\"><div><div class=\"lrec\" > <%@include file=\"/lrec.jsp\"%></div>";
		return header;
	}

	private String getPath(String token1, String token2, String token3) {

		String path = ((token1 != null) ? File.separator + token1 : "")
				+ ((token2 != null) ? File.separator + token2 : "")
				+ ((token3 != null) ? File.separator + token3 : "");
		return path;

	}

}
