package com.studytrails.xml.xstream;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

public class CreateXMLFromMusicArtistObjectAnnotated {

	public static void main(String[] args) throws MalformedURLException {
		CreateXMLFromMusicArtistObjectAnnotated marshaller = 
				new CreateXMLFromMusicArtistObjectAnnotated();
		marshaller.createXMlFromObject();
	}

	private void createXMlFromObject() throws MalformedURLException {
		JazzArtist2 artist2 = new JazzArtist2("Benny Goodman", 
				false, new URL("http://www.bennygoodman.com/"));
		Album2 album3 = new Album2("In Stockholm", 5, 1959,"swing");
		Album2 album4 = new Album2("A Jazz Holiday", 3, 1928,"swing");
		artist2.addAlbum(album3);
		artist2.addAlbum(album4);
		XStream xStream2 = new XStream();
		xStream2.processAnnotations(JazzArtist2.class);
		System.out.println(xStream2.toXML(artist2));
	}
}

@XStreamAlias("artist")
class JazzArtist2 {
	public String name;
	@XStreamConverter(value = BooleanConverter.class,
			booleans = { true }/*is case sensitive*/,
			strings = { "Yes", "No" })
	public boolean isAlive;
	public URL url;
	@XStreamImplicit
	public List<Album2> albums = new ArrayList<Album2>();

	public JazzArtist2(String name, boolean isAlive, URL url) {
		this.name = name;
		this.isAlive = isAlive;
		this.url = url;
	}

	public void addAlbum(Album2 album) {
		albums.add(album);
	}

}

@XStreamAlias("album")
class Album2 {
	public String title;
	@XStreamOmitField
	public int noOfrecords;
	public int year;
	@XStreamAsAttribute
	public String genre;

	public Album2(String title, int noOfrecords, int year,String genre) {
		this.title = title;
		this.noOfrecords = noOfrecords;
		this.year = year;
		this.genre = genre;
	}
}
