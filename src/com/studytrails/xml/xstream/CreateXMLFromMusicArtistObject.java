package com.studytrails.xml.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class CreateXMLFromMusicArtistObject {

	public static void main(String[] args) {
		CreateXMLFromMusicArtistObject marshaller = new CreateXMLFromMusicArtistObject();
		marshaller.createXMlFromObject();
		marshaller.createXMLFromObjectUsingAlias();
		marshaller.createXMLFromObjectUsingAliasAndImplicitCollection();
	}

	private void createXMlFromObject() {
		JazzArtist artist = new JazzArtist("Bix Beiderbecke", false, null);
		Album_1 album1 = new Album_1("Bix Beiderbecke with the Paul Whiteman Orchestra", 5, 1928);
		Album_1 album2 = new Album_1("Bix Beiderbecke and His Gang", 6, 1927);
		artist.addAlbum(album1);
		artist.addAlbum(album2);
		XStream xStream = new XStream();
		System.out.println(xStream.toXML(artist));

	}

	private void createXMLFromObjectUsingAliasAndImplicitCollection() {
		JazzArtist artist2 = new JazzArtist("Benny Goodman", false, null);
		Album_1 album3 = new Album_1("In Stockholm", 5, 1959);
		Album_1 album4 = new Album_1("A Jazz Holiday", 3, 1928);
		artist2.addAlbum(album3);
		artist2.addAlbum(album4);
		XStream xStream2 = new XStream();
		xStream2.alias("artist", JazzArtist.class);
		xStream2.alias("album", Album_1.class);
		xStream2.addImplicitCollection(JazzArtist.class, "albums");
		System.out.println(xStream2.toXML(artist2));
	}

	private void createXMLFromObjectUsingAlias() {
		JazzArtist artist2 = new JazzArtist("Benny Goodman", false, null);
		Album_1 album3 = new Album_1("In Stockholm", 5, 1959);
		Album_1 album4 = new Album_1("A Jazz Holiday", 3, 1928);
		artist2.addAlbum(album3);
		artist2.addAlbum(album4);
		XStream xStream2 = new XStream();
		xStream2.alias("artist", JazzArtist.class);
		xStream2.alias("album", Album_1.class);
		System.out.println(xStream2.toXML(artist2));
	}

}

class JazzArtist {
	public String name;
	public boolean isAlive;
	public String url;
	public List<Album_1> albums = new ArrayList<Album_1>();

	public JazzArtist(String name, boolean isAlive, String url) {
		this.name = name;
		this.isAlive = isAlive;
		this.url = url;
	}

	public void addAlbum(Album_1 album) {
		albums.add(album);
	}

}

class Album_1 {
	public String title;
	public int noOfrecords;
	public int year;

	public Album_1(String title, int noOfrecords, int year) {
		this.title = title;
		this.noOfrecords = noOfrecords;
		this.year = year;
	}
}
