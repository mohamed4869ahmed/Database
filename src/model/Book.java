package model;
import java.sql.SQLException;
import java.util.*;

import controller.Controller;
public class Book {
  
  private int ISBN ;
  private String title ;
  private String publisherName ;
  private ArrayList<String> authors;
  private String year ;
  private double price ;
  private int numberOfCopies ;
  private int threshold ;
  private String category ;

  public Book(){
    this.price = 20;
    this.numberOfCopies = 0;
    this.threshold = 0;


  }
  public int getISBN() {
    return ISBN;
  }
  public void setISBN(int iSBN) {
    ISBN = iSBN;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getPublisherName() {
    return publisherName;
  }
  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }
  public ArrayList<String> getAuthors() {
    return authors;
  }
  public void setAuthors(ArrayList<String> authors) {
    this.authors = authors;
  }
  public String getYear() {
    return year;
  }
  public void setYear(String year) {
    this.year = year;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public int getNumber_of_copies() {
    return numberOfCopies;
  }
  public void setNumber_of_copies(int number_of_copies) {
    this.numberOfCopies = number_of_copies;
  }
  public int getThreshold() {
    return threshold;
  }
  public void setThreshold(int threshold) {
    this.threshold = threshold;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public void addToDatabase() throws SQLException {
    String query ;
    query = "Insert into Book (ISBN,title,publisher_name,category"
          + ",number_of_copies,selling_price,threshold)"
          + " values ( " + this.ISBN + " , " 
        +this.title + " , " 
        +this.publisherName + " , " 
        +this.category + " , " 
        +this.numberOfCopies + " , " 
        +this.price + " , " 
        +this.threshold + " ) "; 
    if(this.year != null){
      this.modify();
    }
    Controller.stmt.executeUpdate(query);  
    
  }
  public void modify() throws SQLException{
    String query = "Update book SET title = " + this.title + " ,"
        +" SET  publisher_name = " + this.publisherName + " ,"
        +" SET  category = " + this.category + " ,"
        +" SET  number_of_copies = " + this.numberOfCopies + " ,"
        +" SET  selling_price = " + this.price + " ,"
        +" SET threshold = " + this.threshold ;        
    if(this.year != null){
      query += " , SET publication_year = " + this.year ;
    }
    query  += " WHERE ISBN =  " + this.ISBN;
    Controller.stmt.executeUpdate(query); 
  }
 
}