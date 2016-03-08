package com.studytrails.xml.xstream;

import com.thoughtworks.xstream.XStream;

public class ReferencingObjectsExample {

	public static void main(String[] args) {
		Artist artist = new Artist();
		Top10Album album = new Top10Album();
		artist.setAlbum(album);
		XStream xStream = new XStream();
		xStream.alias("artist", Artist.class);
		xStream.alias("anotherAlbum", Top10Album.class);
//		xStream.setMode(XStream.ID_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.NO_REFERENCES);
//
//		System.out.println(xStream.toXML(artist));

//		xStream.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//
//		xStream.setMode(XStream.SINGLE_NODE_XPATH_RELATIVE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//
		xStream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
		System.out.println(xStream.toXML(artist));
//		artist.setSimilarArtist(artist);
//		xStream.setMode(XStream.ID_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.NO_REFERENCES);
//		// System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.SINGLE_NODE_XPATH_RELATIVE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
//		xStream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
//		System.out.println(xStream.toXML(artist));
	}


}

class Artist {
	Top10Album album;
	Album album2;
	Artist similarArtist;

	public void setSimilarArtist(Artist similarArtist) {
		this.similarArtist = similarArtist;
	}
	
	public void setAlbum(Top10Album album) {
		this.album = album;
		album2 = (Top10Album) this.album;
	}
}

class Album {
}

class Top10Album extends Album {
}
