package com.nendrasys.service;

import com.nendrasys.dao.BookDao;
import com.nendrasys.model.BookModel;
import com.nendrasys.model.BookModelList;
import org.springframework.beans.factory.annotation.Autowired;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private OXMBookService oxmBookService;

    public OXMBookService getOxmBookService() {
        return oxmBookService;
    }

    public void setOxmBookService(OXMBookService oxmBookService) {
        this.oxmBookService = oxmBookService;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public String saveBookData(BookModel bookModel, Locale locale) {
        int count=0;
        count=bookDao.saveBookData(bookModel,locale);
        if(count==1){
            return "Book Data added Successfully";
        }
        else{
            return "Book Data is not added";
        }
    }

    @Override
    public List<BookModel> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public BookModel getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public String convertBookObjToXml() throws IOException {
        BookModelList bookModelList=new BookModelList() ;
        bookModelList.setBookModelList(bookDao.getAllBooks());
        /*System.out.println("in service:"+ oxmBookService.convertBookObjectToXml(bookModelList));*/
        return oxmBookService.convertBookObjectToXml(bookModelList);
    }

    @Override
    public String convertBookObjToXmlById(int bookId) throws IOException {
        BookModel bookModel= bookDao.getBookById(bookId);
        return oxmBookService.convertBookObjToXmlById(bookModel);
    }


    @Override
    public String updateBookData(BookModel bookModel) {
        int count=0;
        count=bookDao.updateBookData(bookModel);
        if(count==1){
            return "Book Data is Updated Successfully";
        }
        else{
            return "Book Data is not Updated";
        }
    }

    @Override
    public String deleteBookData(int bookId) {
        int count=0;
        count=bookDao.deleteBookData(bookId);
        if(count==1){
            return "Book Data is deleted Successfully";
        }
        else{
            return "Book Data is not deleted";
        }
    }
}
