package com.studytrails.gitToGist;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class SpringFileToGist {

	String workspace = "/home/mithil/java/workspace/";
	String gistDirectory = "/home/mithil/java/st/spring/23b05d629e12d5c9583e0d6d3405586b/";

	public static void main(String[] args) throws IOException {
		SpringFileToGist gister = new SpringFileToGist();
		gister.gist();
	}

	private void gist() throws IOException {

		// iterate over workspace and get all folders that begin with spring
		File file = new File(workspace);
		File[] a = file.listFiles();
		for (File file2 : a) {
			if (file2.getName().startsWith("spring")) {
				parseSpringDirectory(file2, file2.getName());
			}
		}

	}

	private void parseSpringDirectory(File dir, String prefix) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				parseSpringDirectory(file, prefix + "-" + file.getName().substring(0, 1));
			}
			if (file.getName().endsWith("java") || file.getName().endsWith("xml")) {
				FileUtils.copyFile(file, new File(gistDirectory + prefix + "-" + file.getName()));
			}

		}
	}
}
