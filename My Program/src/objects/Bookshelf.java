package objects;

import java.awt.Color;
import java.awt.Dimension;

import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;

import javax.swing.JFrame;



public class Bookshelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
			Person author1 = new Person();
			author1.setName("Arthur","Miller");
			
			Book book1 = new Book("The Crucible",200,author1);
			book1.setColor(Color.ORANGE);
			book1.setCheckedOut(false);
			book1.setCheckOutDate(0);
			book1.setDueDate(0);
			Book book2 = new Book("Death of a Salesman",215,author1);
			book2.setColor(Color.GREEN);
			Person author2 = new Person();
			author2.setName("L.","L","Stine");
			
			Book book3 = new Book("Eggs and green ham",141,author1);
			book3.setColor(Color.RED);
			Book book4 = new Book("Chinese Books",152,author2);
			book4.setColor(Color.CYAN);
			
			
			Person customer1 = new Person();
			customer1.setName("Ching", "Chong");
			customer1.setMale(true);
			customer1.setBalance(new Balance());
			Person customer2 = new Person();
			customer2.setName("Wing", "Wong");
			customer2.setMale(true);
			customer2.setBalance(new Balance());
			customer2.checkedOutBooks = new ArrayList<Book>();
			customer1.checkedOutBooks = new ArrayList<Book>();
			
			
			ArrayList<Person> people = new ArrayList<Person>();
			people.add(customer1);
			people.add(customer2);
			
			
			ArrayList<Book> books = new ArrayList<Book>();
			//<?> means "generic type" tells Java that the objects in this 
			// ArrayList can always be treated as "Books" without "casting"
			/**
			 * Adding objects to ArrayList
			 * for arrays
			 * bookArray[0] = book1
			 * 
			 */
			books.add(book1);
			books.add(book2);
			books.add(book3);
			books.add(book4);
			sortByPageNumber(false, books);
			sortByAuthor(true,books);
			sortByTitle(true,books);
			Library lib = new Library(books, people);//use "books" or "shelf" whatever your ArrayList is 

			lib.setSize(new Dimension(500,500));

			lib.setVisible(true);

			lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		private static void printAll1(ArrayList<Book> list){
			for(int i=0; i<list.size();i++){
				System.out.println(i+")"+list.get(i));
			}
		}
		public static void sortByPageNumber(final boolean ascending, ArrayList<Book> list){
			Collections.sort(list, new Comparator<Book>(){
				public int compare(Book a, Book b){
					if(ascending)return a.getNumberOfPages() - b.getNumberOfPages();
					return b.getNumberOfPages() - a.getNumberOfPages();
				}
			});
		}
		public static void sortByAuthor(final boolean ascending, ArrayList<Book> list){
			Collections.sort(list, new Comparator<Book>(){
				public int compare(Book a, Book b){
					if(ascending)return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
					return b.getAuthor().getLastName().compareTo(a.getAuthor().getLastName());
				}
			});
		}
		public static void sortByTitle(final boolean ascending, ArrayList<Book> list){
			Collections.sort(list, new Comparator<Book>(){
				public int compare(Book a, Book b){
					if(ascending)return a.getTitleIgnoreThe().compareTo(b.getTitleIgnoreThe());
					return b.getTitleIgnoreThe().compareTo(a.getTitleIgnoreThe());
				}
			});
		}
		public static void sortByHeight(final boolean ascending, ArrayList<Book> list){
			Collections.sort(list, new Comparator<Book>(){
				public int compare(Book a, Book b){
					if(ascending)return a.getHeight() - b.getHeight();
					return b.getHeight() - a.getHeight();
				}
			});
		}
	

}
