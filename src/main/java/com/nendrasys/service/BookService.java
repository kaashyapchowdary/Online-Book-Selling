package com.nendrasys.service;

import com.nendrasys.model.BookModel;

import javax.xml.bind.JAXBException;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public interface BookService {
    public String saveBookData(BookModel bookModel, Locale locale);
    List<BookModel> getAllBooks();
    BookModel getBookById(int bookId);
    public String convertBookObjToXml() throws IOException;
    public String convertBookObjToXmlById(int bookId) throws IOException;
    public String updateBookData(BookModel bookModel);
    public String deleteBookData(int bookId);
}
