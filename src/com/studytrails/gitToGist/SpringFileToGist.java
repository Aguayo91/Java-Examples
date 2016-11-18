package com.studytrails.gitToGist;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class SpringFileToGist {

	Map<String, String> gitToGistMap = new HashMap<>();
	String workspaceHome = "/home/mithil/git/Spring-Examples/";
	String gistDirectoryHome = "/home/mithil/studytrails/gist/";

	public static void main(String[] args) throws IOException {
		SpringFileToGist gister = new SpringFileToGist();
		gister.readGitGistMapping();
		gister.gist();
	}

	private void readGitGistMapping() throws IOException {
		List<String> entries = FileUtils.readLines(new File("GitToGistName"));
		for (String entry : entries) {
			String[] tokens = entry.split(",");
			gitToGistMap.put(tokens[0], tokens[1]);
		}

	}

	private void gist() throws IOException {
		for (String workspace : gitToGistMap.keySet()) {
			System.out.println("processing " + workspace);
			String gist = gitToGistMap.get(workspace);
			// iterate over workspace and get all folders that begin with spring
			File file = new File(workspaceHome + workspace);
			File[] a = file.listFiles();
			for (File file2 : a) {
				if (file2.getName().startsWith("spring")) {
					parseSpringDirectory(file2, file2.getName(), gist);
				}
			}
		}
	}

	private void parseSpringDirectory(File dir, String prefix, String gist) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				parseSpringDirectory(file, prefix + "-" + file.getName().substring(0, 1), gist);
			}
			if (file.getName().endsWith("java") || file.getName().endsWith("xml")) {
				FileUtils.copyFile(file, new File(gistDirectoryHome + gist + prefix + "-" + file.getName()));
			}

		}
	}
}
