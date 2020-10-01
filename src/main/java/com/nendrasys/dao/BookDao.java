package com.nendrasys.dao;

import com.nendrasys.model.BookModel;
import java.util.List;
import java.util.Locale;

public interface BookDao {
    public int saveBookData(BookModel bookModel, Locale locale);
    List<BookModel> getAllBooks();
    BookModel getBookById(int bookId);
    public int getNextBookId();
    public int updateBookData(BookModel bookModel);
    public int deleteBookData(int bookId);
}
