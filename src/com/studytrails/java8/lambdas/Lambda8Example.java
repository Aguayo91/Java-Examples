package com.studytrails.java8.lambdas;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lambda8Example {

	public static void main(String[] args) {
		Button button = new Button();
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
                 System.out.println("Do Something");				
			}
		});
		button.addActionListener(event->System.out.println("Do Something"));
		
	}
}
