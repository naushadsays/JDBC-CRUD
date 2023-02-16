package com.jsp.controller;

import java.util.Scanner;

import com.jsp.emp.StudentService;

public class StudentMain {
	public static void main(String[] args) throws Exception {
		StudentService ss = new StudentService();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("PRESS 1 TO ADD Student");
			System.out.println();
			System.out.println("PRESS 2 TO UPDATE Student");
			System.out.println();
			System.out.println("PRESS 3 TO DELETE Student");
			System.out.println();
			System.out.println("PRESS 4 TO READ A STUDENT");
			System.out.println();
			System.out.println("PRESS 5 TO READ ALL THE STUDENTS");
			System.out.println();
			System.out.println("PRESS 6 TO EXIT THE APP");

			String s = sc.next();
			int i = Integer.parseInt(s);

			if (i==1) {
				 ss.create();
			} else if (i==2) {
				 ss.update();
			}else if (i==3) {
				 ss.delete();
			}else if (i==4) {
				 ss.read();
			}else if (i==5) {
				 ss.readAll();
			}else if (i==6) {
				break;
			}else {
				System.out.println("Enter A Valid Number");
			}	
		}
	}

}
