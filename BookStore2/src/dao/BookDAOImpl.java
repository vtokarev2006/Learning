package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		List<Book> books = new ArrayList<>();
		
		String authorSql="select * from author where book_id=?";
		String bookSql="select * from book";
		


		Connection con = null ;
		
		try {
			
			con = getConnection();
			
			PreparedStatement authorStat = con.prepareStatement(authorSql);
			PreparedStatement bookStat = con.prepareStatement(bookSql);
			
			 ResultSet bookRes = bookStat.executeQuery();
			 
			 while (bookRes.next()) {
				 
				Book book  = new Book();
				 
				book.setId(bookRes.getLong("ID"));
				book.setCategoryId(bookRes.getLong("CATEGORY_ID"));
				book.setPublisheName(bookRes.getString("PUBLISHER"));
				book.setBookTitle(bookRes.getString("BOOK_TITLE"));
				 
				List<Author> authors = new ArrayList<>();
				
				
				authorStat.clearParameters();
				authorStat.setLong(1, book.getId());
				ResultSet authorRes = authorStat.executeQuery();
				
				while(authorRes.next()){
					Author author = new Author();
					author.setId(authorRes.getLong("ID"));
					author.setBookID(book.getId());
					author.setFirstName(authorRes.getString("FIRST_NAME"));
					author.setLastName(authorRes.getString("LAST_NAME"));
					authors.add(author);
				}
				
				book.setAuthors(authors);
				books.add(book);
				 
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			closeConnection(con);			
			
		}
		
		return books;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyWord) {
		List<Book> books = new ArrayList<>();
		
		String authorSql="select * from author where book_id=?";
		String bookSql="select * from book where book_title like ?";
		


		Connection con = null ;
		
		try {
			
			con = getConnection();
			
			PreparedStatement authorStat = con.prepareStatement(authorSql);
			PreparedStatement bookStat = con.prepareStatement(bookSql);
			
			bookStat.setString(1, "%"+keyWord+"%"); 
			ResultSet bookRes = bookStat.executeQuery();
			 
			 while (bookRes.next()) {
				 
				Book book  = new Book();
				 
				book.setId(bookRes.getLong("ID"));
				book.setCategoryId(bookRes.getLong("CATEGORY_ID"));
				book.setPublisheName(bookRes.getString("PUBLISHER"));
				book.setBookTitle(bookRes.getString("BOOK_TITLE"));
				 
				List<Author> authors = new ArrayList<>();
				
				
				authorStat.setLong(1, book.getId());
				ResultSet authorRes = authorStat.executeQuery();
				
				while(authorRes.next()){
					Author author = new Author();
					author.setId(authorRes.getLong("ID"));
					author.setBookID(book.getId());
					author.setFirstName(authorRes.getString("FIRST_NAME"));
					author.setLastName(authorRes.getString("LAST_NAME"));
					authors.add(author);
				}
				
				book.setAuthors(authors);
				books.add(book);
				 
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			
			closeConnection(con);			
			
		}
		
		return books;
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> categories = new ArrayList<>();
		
		String categorySql="select * from Category";
		


		Connection con = null ;
		
		try {
			
			con = getConnection();
			
			PreparedStatement categoryStat = con.prepareStatement(categorySql);
			
			ResultSet categoryRes = categoryStat.executeQuery();
			 
			 while (categoryRes.next()) {
				 
				Category category  = new Category();
				 
				category.setId(categoryRes.getLong("ID"));
				category.setCategoryDescription(categoryRes.getString("CATEGORY_DESCRIPTION"));
				
				categories.add(category);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			
			closeConnection(con);			
			
		}
		
		return categories;
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
