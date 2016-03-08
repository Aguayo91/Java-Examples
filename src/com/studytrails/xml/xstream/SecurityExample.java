package com.studytrails.xml.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

public class SecurityExample {

	public static void main(String[] args) {
		SecurityExample securityExample = new SecurityExample();
		securityExample.showcaseseurity();
	}

	private void showcaseseurity() {
		MusicCatalog catalog = new MusicCatalog("Catalog A");
		Artist5 artist = new Artist5("Artist A");
		Album5 album = new Album5("Album_1 A");
		Track5 track = new Track5("Track A");
		catalog.setAlbum(album);
		catalog.setTrack(track);
		catalog.setArtist(artist);

		XStream xStream = new XStream();
		String xml = xStream.toXML(catalog);
		System.out.println(xml);

		xStream.addPermission(NoTypePermission.NONE);
		xStream.allowTypes(new Class[] { MusicCatalog.class });
		MusicCatalog catalogB = (MusicCatalog) xStream.fromXML(xml);
		System.out.println(catalogB);
	}
}

class MusicCatalog {
	private Artist5 artist;
	private Album5 album;
	private Track5 track;
	String name;

	public MusicCatalog(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MusicCatalog [artist=" + artist + ", album=" + album + ", track=" + track + ", name=" + name + "]";
	}

	public void setAlbum(Album5 album) {
		this.album = album;
	}

	public void setTrack(Track5 track) {
		this.track = track;
	}

	public void setArtist(Artist5 artist) {
		this.artist = artist;
	}

}

class Artist5 {
	String name;

	public Artist5(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist5 [name=" + name + "]";
	}

}

class Album5 {
	String name;

	public Album5(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Album5 [name=" + name + "]";
	}

}

class Track5 {
	String name;

	public Track5(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Track5 [name=" + name + "]";
	}

}
