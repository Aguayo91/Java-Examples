package com.studytrails.json.gson;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(DatasetTypeAdapter.class)
public class Dataset {
	private String album_id;
	private String album_title;

	public String getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_title() {
		return album_title;
	}

	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}

}