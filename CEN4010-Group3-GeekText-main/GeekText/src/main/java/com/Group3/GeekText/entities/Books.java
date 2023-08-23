package com.Group3.GeekText.entities;

import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.*;


@Entity
@Table(name = "Books")

public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "BookID")
    public String bookID;
    @Column(name = "BookName")
    public String bookName;
    @Column(name = "BookDescription")
    public String bookDescription;
    @Column(name = "Author")
    public String bookAuthor;
    @Column(name = "Genre")
    public String bookGenre;
    @Column(name = "CopiesSold")
    public double bookSoldCopies;
    @Column(name = "Rating")
    public String bookRatings;
    @Column(name = "Publisher")
    public String bookPublisher;
    @Column(name = "Price")
    public double bookPrice;
    @Column(name = "ISBN")
    public String bookISBN;
    @Column(name = "MadeYear")
    public String bookPublishYear;

    @Column(name = "Comments")
    public String bookComments;

    //Create new Book Constructor
    public Books(String bookID, String bookName, String bookDescription, String bookAuthor, String bookGenre, double bookSoldCopies,
                 String bookRatings, String bookPublisher, double bookPrice, String bookISBN, String bookPublishYear, String bookComments) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookSoldCopies = bookSoldCopies;
        this.bookRatings = bookRatings;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookISBN = bookISBN;
        this.bookPublishYear = bookPublishYear;
        this.bookComments = bookComments;
    }
    //Required by JPA to have an empty constructor
    public Books() {
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public double getBookSoldCopies() {
        return bookSoldCopies;
    }

    public void setBookSoldCopies(double bookSoldCopies) {
        this.bookSoldCopies = bookSoldCopies;
    }

    public String  getBookRatings() {
        return bookRatings;
    }

    public void setBookRatings(String  bookRatings) {
        this.bookRatings = bookRatings;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(String bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public void setBookComments(String bookComments) {
        this.bookComments = bookComments;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookID='" + bookID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookSoldCopies='" + bookSoldCopies + '\'' +
                ", bookRatings='" + bookRatings + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", bookPublishYear='" + bookPublishYear + '\'' +
                ", bookComments='" + bookComments + '\'' +
                '}';
    }


}

