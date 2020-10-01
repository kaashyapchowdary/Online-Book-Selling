package com.nendrasys.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookModel {
    private int bookId;
    private String bookName;
    private String bookDescription;
    private String bookAuthorName;
    private double inrPrice;
    private double usdPrice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public double getInrPrice() {
        return inrPrice;
    }

    public void setInrPrice(double inrPrice) {
        this.inrPrice = inrPrice;
    }

    public double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        this.usdPrice = usdPrice;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                ", inrPrice='" + inrPrice + '\'' +
                ", usdPrice='" + usdPrice + '\'' +
                '}';
    }
}
