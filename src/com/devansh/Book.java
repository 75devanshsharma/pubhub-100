package com.devansh;

import java.sql.*;

public class Book {
	public void insert(String bookID, String bookName, String bookAuthor) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://139.59.29.57:3306/vels_db", "vels_user",
					"Vels_pass_123$");
			PreparedStatement st = con.prepareStatement("insert into book (bookID,bookName,bookAuthor) values(?,?,?)");
			st.setString(1, bookID);
			st.setString(2, bookName);
			st.setString(3, bookAuthor);

			int rows = st.executeUpdate();
			System.out.println("No. of rows inserted:" + rows);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void update(String bookAuthor, String bookID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://139.59.29.57:3306/vels_db", "vels_user",
					"Vels_pass_123$");
			PreparedStatement st = con.prepareStatement("Update book set bookAuthor=? where bookId = ?");
			st.setString(1, bookAuthor);
			st.setString(2, bookID );

			int rows = st.executeUpdate();
			System.out.println("No. of rows updated:" + rows);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void select(String bookID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://139.59.29.57:3306/vels_db", "vels_user",
					"Vels_pass_123$");
			PreparedStatement st = con.prepareStatement("select * from book where bookId = ?");
			st.setString(1, bookID);

			ResultSet rs = st.executeQuery();
//			if (rs.next()) {
//				System.out.println(rs.getString(1));
//			} else {
//				System.out.println("Not found");
//			}
		while(rs.next())
		{
			String id=rs.getString("bookID");
			String name=rs.getString("bookName");
			String author=rs.getString("bookAuthor");
			System.out.println(id+""+name+""+author);
		}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String bookID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://139.59.29.57:3306/vels_db", "vels_user",
					"Vels_pass_123$");
			PreparedStatement st = con.prepareStatement("delete from book where bookId=?");
			st.setString(1, bookID);
			int rows = st.executeUpdate();
			System.out.println("No. of rows deleted:" + rows);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Book b = new Book();
		b.insert("dev123", "Chemistry", "Devansh");
		b.insert("rohan55", "Biology", "Rohan");
		b.insert("varun66", "Maths", "Varun");
		b.select("rohan55");
		b.update("Rohan","rohan55");
		b.delete("varun66");

	}
}
