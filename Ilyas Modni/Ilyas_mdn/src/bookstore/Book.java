/**
 * 
 */
package bookstore;

/**
 * @author Aboubakar
 *
 * Dans cette clsse nous créons un bean qui représente l'objet à manipuler c'est à dire
 * un 'book'. Ceci constituera une table dans la base de données et les propriétés (varibles) 
 * sont les colonnes de la table 'book'.
 *
 */
public class Book {

	private int id;
	private String title;
	private String author;
	private float price;
	/**
	 * @param id
	 */
	public Book(int id) {
		super();
		this.id = id;
	}
	/**
	 * @param title
	 * @param author
	 * @param price
	 */
	public Book(String title, String author, float price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param price
	 */
	public Book(int id, String title, String author, float price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param autor the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
