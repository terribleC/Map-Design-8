package objects;

import java.awt.Color; //abstract window toolkit

public class Book {

	
/**
	 
	private String title;
	private int numberOfPages;
	private Person author;//custom class in package
	private Color jacketColor;
	private boolean litOnFire;
	private int height;
	private int thickness;
	
	public Book(String title,int numPages, Person author){
		this.title = title;
		this.numberOfPages = numPages;
		this.author = author;
		jacketColor = Color.gray;
		litOnFire = false;
		height = (int)(Math.random()*100+150);
		thickness = numPages/10;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	public String toString(){
		return "\""+title+"\",by "+author+", "+numberOfPages+" pages";
	}
	public String getTitle(){
		return title;
	}
	public int getNumberOfPages(){
		return numberOfPages;
	}
	public Person getAuthor() {
		if(litOnFire){ 
			return author;
		}
		else{
			return author;
		}
	}
	public Color getJacketColor() {
		return jacketColor;
	}
	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}
	public void setOnFire(){
		jacketColor = Color.black;
		title = "The title of this book is too charred to make out.";
		litOnFire = true;
		numberOfPages = 666;
	}
*/
	

	private String title;
	private int numberOfPages;
	private Person author;
	private int thickness;
	private int height;
	private Color color;
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate;
	String description;
	int accumulatedUse;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getThickness() {
		return thickness;
	}
	public int getHeight() {
		return height;
	}
	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	public long getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public long getDueDate() {
		return dueDate;
	}
	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
	public Book(String title, int numberOfPages, Person author){
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.author = author;
		height = (int)(Math.random()*100)+250;
		thickness = numberOfPages/5;
		color = Color.GRAY;
		this.description = conditions[0];
		this.accumulatedUse = 0;
	}
	public String getBookInfo(){
		return description;
	}
	public String toString(){
		return title +" by " + author + " Pages:" + numberOfPages; 
	}
	public String getTitle(){
		return title;
	}
	public int getNumberOfPages(){
		return numberOfPages;
	}
	public Person getAuthor(){
		return author;
	}
	public String getTitleIgnoreThe(){
		if(title.toLowerCase().indexOf("the")>-1) return title.substring(3, title.length()-1);
		return title;
	}
	public long getSecondsRemaining(){
		return (dueDate - System.currentTimeMillis() )/1000;
	}
	public void updateCondition(long timeOfReturn){
		accumulatedUse += (timeOfReturn-checkOutDate);
		if (accumulatedUse>30) description = conditions[1];
		if (accumulatedUse>50) description = conditions[2];
		if (accumulatedUse>60) description = conditions[3];
	}
	static public String[] conditions = {"This apears to be a brand new book! How lucky!",
		"This book is very gently used",
		"This book is a bit worn out",
		"This book is pretty old"};
}	

