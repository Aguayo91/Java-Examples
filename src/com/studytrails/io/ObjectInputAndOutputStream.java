package com.studytrails.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectInputAndOutputStream {
	// TODO how to write and read java object from a file
	// The Data Input interface specifies methods to read bytes from a stream
	// and construct java objects out of it.
	// The Data output method converts a java object to a series of bytes that
	// can be written to a file.

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {

		// object output stream converts primitive types and java objects to
		// bytes and writes them to a file
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream("javaObjects.txt"));

		// write a date
		objectOutputStream.writeObject(new Date());
		// write a boolean
		objectOutputStream.writeBoolean(true);
		// write a float
		objectOutputStream.writeFloat(1.0f);
		// the other primitive types and objects can be saved as well

		// create two students objects and add them in a list. create a course
		// object and add the list of students to a list
		Student student1 = new Student();
		student1.setAge(30);
		student1.setName("Student1");

		Student student2 = new Student();
		student2.setAge(31);
		student2.setName("Student2");

		Course course = new Course();
		course.setName("Java IO");
		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		course.setStudents(students);

		// write the course object to the objectoutputstream. This writes the
		// object as well all objects that it referes to.
		// it writes only those objects that implement serializable

		objectOutputStream.writeObject(course);
		objectOutputStream.flush();
		objectOutputStream.close();

		// the object input stream reads the objects back from the file and
		// creates java objects out of them. It recreates all
		// references that were present when the objects were written
		ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream("javaObjects.txt"));

		// start getting the objects out in the order in which they were written
		Date date = (Date) objectInputStream.readObject();
		System.out.println(date);
		System.out.println(objectInputStream.readBoolean());
		System.out.println(objectInputStream.readFloat());
		// get the course object
		Course readCourse = (Course) objectInputStream.readObject();
		System.out.println(readCourse.getName());
		Student student1Read = readCourse.getStudents().get(0);
		System.out.println(student1Read.getAge());
		System.out.println(student1Read.getName());
		objectInputStream.close();

	}

	static class Student implements Serializable {
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	static class Course implements Serializable {
		String name;
		List<Student> students;

		public void setName(String name) {
			this.name = name;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}

		public String getName() {
			return name;
		}

		public List<Student> getStudents() {
			return students;
		}
	}
}
