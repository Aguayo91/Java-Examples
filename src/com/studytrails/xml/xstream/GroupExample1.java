package com.studytrails.xml.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class GroupExample1 {
	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.alias("persons", Persons.class);
		xstream.alias("person", Person.class);
		xstream.alias("address", Address.class);
		xstream.addImplicitCollection(Persons.class, "personList");
		Persons persons = new Persons();
		Person person = new Person();
		person.name = "billy";
		Person person2 = new Person();
		person2.name = "bob";
		Address address = new Address();
		address.address1 = "West St.";
		Address address2 = new Address();
		address2.address1 = "East St.";
		Address address3 = new Address();
		address3.address1 = "West St.";
		Address address4 = new Address();
		address4.address1 = "East St.";
		person.addresses.add(address);
		person.addresses.add(address2);
		person2.addresses.add(address3);
		person2.addresses.add(address4);
		persons.personList.add(person);
		persons.personList.add(person2);
		System.out.println(xstream.toXML(persons));

	}

}

class Persons {
	List<Person> personList = new ArrayList<Person>();
}

class Person {
	String name;
	List<Address> addresses = new ArrayList<Address>();
}

class Address {
	String address1;

}