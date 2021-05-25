/**
 * 
 */
package bookstore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Aboubakar
 *
 */
public class ControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		
		bookDAO=new BookDAO(jdbcURL,jdbcUsername, jdbcPassword);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);
		try {
		switch(action) {
		
		case "/new":
            showNewForm(request, response);
            break;
        case "/insert":
            insertBook(request, response);
            break;
        case "/delete":
            deleteBook(request, response);
            break;
        case "/edit":
            showEditForm(request, response);
            break;
        case "/update":
            updateBook(request, response);
            break;
        default:
            listBook(request, response);
            break;
			
		}
		}catch (SQLException ex) {
            throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // Fin doGet method
	
	private void listBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		List<Book> listBook= bookDAO.listAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        
		int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
        
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
    }
	
	//Insert new book in the database
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Float price = Float.parseFloat(request.getParameter("price"));
		
		Book newBook = new Book(title,author,price);
		bookDAO.insertBook(newBook);
		
		response.sendRedirect("list");
	}
	
	// Edite book
	
private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Float price = Float.parseFloat(request.getParameter("price"));
		
		Book book = new Book(id, title,author,price);
		bookDAO.updateBook(book);
		
		response.sendRedirect("list");
	}

 	// Delete book :

private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
	
	int id= Integer.parseInt(request.getParameter("id"));
	
	Book book= new Book(id);
	
	bookDAO.deleteBook(book);
	
	response.sendRedirect("list");
}
}
