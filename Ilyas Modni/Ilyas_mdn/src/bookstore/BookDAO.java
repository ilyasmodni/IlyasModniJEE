/**
 * 
 */
package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aboubakar
 * 
 * Dans cette classe nous définisons les varibles de connection à la base de données.
 * Nous définisons les méthodes d'accès à la base de données
 * Ainsi que les méthodes pour manipuler la table 'book' (Inserer, Lister, Supprimer, Modifier)
 *
 */
public class BookDAO {

	 private String jdbcURL;
	 private String jdbcUsername;
	 private String jdbcPassword;
	 private Connection jdbcConnection;
	/**
	 * @param jdbcURL
	 * @param jdbcUsername
	 * @param jdbcPassword
	 */
	public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	 
	 public void connect() throws SQLException, ClassNotFoundException {
		 if(jdbcConnection==null||jdbcConnection.isClosed()) {
			 
			 Class.forName("com.mysql.jdbc.Driver");
		 }
		 
		 jdbcConnection=(Connection) DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		 
		 System.out.println("Hello database");
	 }
	 
	 public void disconnect() throws SQLException {
		 if(jdbcConnection!=null && !jdbcConnection.isClosed()) {
			 jdbcConnection.close();
			 
		 }
		 
	 }
	 
	 
	 /*
	  * CRUD OPERATION ON THE DATABASE
	  */
	    
	    public boolean insertBook(Book book) throws ClassNotFoundException, SQLException {
	    	
	    	String sql= "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
	    	connect();
	    	
	    	PreparedStatement statement= jdbcConnection.prepareStatement(sql);
	    	statement.setString(1, book.getTitle());
	    	statement.setString(2, book.getAuthor());
	    	statement.setFloat(3, book.getPrice());
	    	
	    	boolean rowInserted = statement.executeUpdate()>0;
	    	
	    	statement.close();
	    	disconnect();
	    	return rowInserted;
	    }
	    	
	    	
	    	// List all book in stored in the database
	    	
	    	public List<Book> listAllBooks() throws ClassNotFoundException, SQLException{
	    		
	    		List<Book> listBook=new ArrayList<>();
	    		
	    		String sql = "SELECT * FROM book";
	    		
	    		connect();
	    		
	    		PreparedStatement statement = (PreparedStatement) jdbcConnection.prepareStatement(sql);
	    		ResultSet resultSet = statement.executeQuery();
	    		
	    		while(resultSet.next()){
	    			int id = resultSet.getInt("book_id");
	    			String title = resultSet.getString("title");
	    			String author = resultSet.getString("author");
	    			float price = resultSet.getFloat("price");
	    			
		    		Book book = new Book(id, title,author, price);
		    		listBook.add(book);

	    		}
	    		
	    		resultSet.close();
	    		statement.close();
	    		disconnect();
	    		return listBook;
	    	}
	    	
	    	// Delete book from database
	    	
	    	public boolean deleteBook(Book book) throws ClassNotFoundException, SQLException {
	    		
	    		String sql = "DELETE FROM book WHERE book_id = ?";
	    		
	    		connect(); 
	    		
	    		PreparedStatement statement = (PreparedStatement) jdbcConnection.prepareStatement(sql);
				statement.setInt(1, book.getId());
				
				boolean rowDeleted = statement.executeUpdate()>0;
				
				statement.close();
				disconnect();
				
				return rowDeleted;
					    		
	    	}
	    	
	    	// Edite book 
	    	
	    	public boolean updateBook(Book book) throws ClassNotFoundException, SQLException {
	    		
	    		String sql = "UPDATE book SET title = ?, author= ?, price = ?";
	    		sql += " WHERE book_id = ? ";
	    		connect();
	    		
	    		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    		statement.setString(1, book.getTitle());
	    		statement.setString(2, book.getAuthor());
	    		statement.setFloat(3,book.getPrice());
	    		statement.setInt(4, book.getId());
	    		
	    		boolean updatedRow = statement.executeUpdate()>0;
	    		statement.close();
	    		disconnect();
	    		
	    		return updatedRow;
	    	}
	    	
	    	// Get one book by id
	    	
	    	public Book getBook(int id) throws SQLException, ClassNotFoundException {
	    		
	    		Book book=null;
	    		String sql = "SELECT * FROM book WHERE book_id=?";
	    		
	    		connect();
	    		
	    		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    		statement.setInt(1, id);
	    		
	    		ResultSet resultSet = statement.executeQuery();
	    		
	    		if(resultSet.next()) {
	    			String title = resultSet.getString("title");
	    			String author = resultSet.getString("author");
	    			Float price =resultSet.getFloat("price");
	    			
	    			book = new Book(id, title, author, price);
	    		}
	    		
	    		resultSet.close();
	    		statement.close();
	    		
	    		return book;
	    	}
	    }
	    
