package com.jsp.emp;

import java.sql.*;


import java.util.*;

import com.jsp.dto.Student;
import com.jsp.helper.ConnectPro;

public class StudentService {
	Student s = new Student();
	// Connection
	Connection con = ConnectPro.conCreate();

	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

	// CRUD Operations

	public void create() {

		try {
			String sql = "INSERT INTO STUDENTS VALUES(?,?)";
			PreparedStatement statement = con.prepareStatement(sql);

			System.out.println("Enter SID to Insert : ");
			String id1 = sc.nextLine();
			Integer id = Integer.parseInt(id1);
			if (id <= 0)
				throw new InvalidSIDException();

			s.setSid(id);
			statement.setInt(1, s.getSid());

			System.out.println("Enter SName to Insert : ");
			String name = sc1.nextLine();
			char[] c = name.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (!(c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A' && c[i] <= 'Z' || c[i] == ' ')) {
					throw new InvalidNameException();
				}
			}

			s.setName(name);
			statement.setString(2, s.getName());

			statement.execute();
			
			System.out.println("CREATE OPERATION EXECUTED");

		} catch (InvalidSIDException e) {
			System.out.println("Plz Enter a Valid SID");

		} catch (InvalidNameException e) {
			System.out.println("Plz Enter a Valid NAME");
		} catch (NumberFormatException e) {
			System.out.println("Not a number... Plz Enter a Number");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("This SID is already present, Duplicate SID Not Allowed");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		try {
			String sql = "UPDATE STUDENTS SET SNAME=? WHERE idstudents =?";
			PreparedStatement statement = con.prepareStatement(sql);

			System.out.println("Enter SID : ");

			String sid1 = sc.nextLine();
			int sid = Integer.parseInt(sid1);
			if (sid <= 0)
				throw new InvalidSIDException();

			s.setSid(sid);

			System.out.println("Enter Updated SName : ");
			String name = sc1.nextLine();
			char[] c = name.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (!(c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A' && c[i] <= 'Z' || c[i] == ' ')) {
					throw new InvalidNameException();
				}
			}
			s.setName(name);

			statement.setString(1, s.getName());
			statement.setInt(2, s.getSid());

			int i = statement.executeUpdate();
//			System.out.println(i);

			if (i == 0)
				System.out.println("ID is not present in database");
			else {
				
				System.out.println("UPDATE OPERATION EXECUTED");
			}
		} catch (InvalidSIDException e) {
			System.out.println("Plz Enter a Valid SID");
		} catch (InvalidNameException e) {
			System.out.println("Plz Enter a Valid NAME");
		} catch (NumberFormatException e) {
			System.out.println("Not a number Plz Enter a Number");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Duplicate SID Not Allowed");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		// delete query

		try {
			String sql = "delete from STUDENTS where idSTUDENTS=?";
			PreparedStatement statement = con.prepareStatement(sql);

			System.out.println("Enter ID To Delete : ");
			String id1 = sc.nextLine();
			int id = Integer.parseInt(id1);
			if (id <= 0)
				throw new InvalidSIDException();

			s.setSid(id);
			statement.setInt(1, s.getSid());

			int i = statement.executeUpdate();
//			System.out.println(i);

			if (i == 0)
				System.out.println("ID is not present in database");
			else {
			
				System.out.println("DELETE OPERATION EXECUTED");
			}
		} catch (InvalidSIDException e) {
			System.out.println("Plz Enter a Valid SID");
		} catch (NumberFormatException e) {
			System.out.println("Not a number Plz Enter a Number");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void read() {
		// read query

		try {
			String sql = "select * from STUDENTS WHERE IDSTUDENTS = ?";
			System.out.println("Enter SID to display the record : ");
			String id1 = sc.nextLine();
			int id = Integer.parseInt(id1);
			if (id <= 0)
				throw new InvalidSIDException();

			s.setSid(id);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, s.getSid());
			ResultSet rs;

			rs = statement.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("ID is not present in database");

			} else {
				while (rs.next()) {
					int eid = rs.getInt(1);
					String name = rs.getString(2);

					System.out.println("eid : " + eid);
					System.out.println("name : " + name);

					System.out.println("+++++++++++++++++++++++++++++++++++++++++");

				}
				
			}

		} catch (InvalidSIDException e) {
			System.out.println("Plz Enter a Valid SID");
		} catch (NumberFormatException e) {
			System.out.println("Not a number Plz Enter a Number");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void readAll() {
		// read query

		try {
			String sql = "select * from STUDENTS";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs;
			rs = statement.executeQuery();
			System.out.println();
			while (rs.next()) {
				int eid = rs.getInt(1);
				String name = rs.getString(2);

				System.out.println("eid : " + eid);
				System.out.println("name : " + name);

				System.out.println("+++++++++++++++++++++++++++++++++++++++++");

			}
			System.out.println();
			System.out.println("READ ALL OPERATION EXECUTED");

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
//"delete from STUDENTS where idSTUDENTS=1 OR 1=1" ---- SQL INJECTION EXAMPLE
