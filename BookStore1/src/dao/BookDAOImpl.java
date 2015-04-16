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
	
	public static void main(String[] args){
		BookDAO bookDAO = new BookDAOImpl();
		
		Long current = System.currentTimeMillis();
		List<Book> allBooks = bookDAO.findAllBooks();
		
		
		
		for(Book b:allBooks) {
			System.out.println(b);
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				System.out.println("          ---- "+a);
			}
		}
		System.out.println();
		System.out.println("Done in " + (System.currentTimeMillis() - current) + " milliseconds");
		
		
		
		
	}
	
	
	
	
	

}
