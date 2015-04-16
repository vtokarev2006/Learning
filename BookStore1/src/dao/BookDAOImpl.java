package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Author;
import model.Book;
import model.Category;

public class BookDAOImpl implements BookDAO {

	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Qwerty12");
	}
	
	private void closeConnection(Connection connection){
		if(connection==null) return;
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public List<Book> findAllBooks() {
		List<Author> authors = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		String authorSql="select * from author";
		String bookSql="select * from book";
		
		
		try {
			Connection con = getConnection();
			
			Statement authorStat = con.createStatement();
			
			ResultSet rs;
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return books;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long bookId) {
		// TODO Auto-generated method stub

	}

}
