package com.nendrasys.dao;

import com.nendrasys.model.BookModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class BookDaoImpl implements BookDao {
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int saveBookData(BookModel bookModel, Locale locale) {
        String query = "insert into bookinformation(bookId,bookName,bookDescription,bookAuthorName,inrPrice,usdPrice) values('"+bookModel.getBookId()+"'," +
                    "'"+bookModel.getBookName()+"','"+bookModel.getBookDescription()+"','"+bookModel.getBookAuthorName()+"','"+bookModel.getInrPrice()+"','"+bookModel.getUsdPrice()+"')";
        return template.update(query);
    }

    @Override
    public List<BookModel> getAllBooks() {
            List<BookModel> list = template.query("SELECT * FROM bookinformation", new RowMapper<BookModel>() {
                @Override
                public BookModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    BookModel bookModel = new BookModel();
                    bookModel.setBookId(resultSet.getInt("bookId"));
                    bookModel.setBookName(resultSet.getString("bookName"));
                    bookModel.setBookDescription(resultSet.getString("bookDescription"));
                    bookModel.setBookAuthorName(resultSet.getString("bookAuthorName"));
                    bookModel.setInrPrice(resultSet.getDouble("inrPrice"));
                    bookModel.setUsdPrice(resultSet.getDouble("usdPrice"));
                    return bookModel;
                }
            });
            return list;
    }

    @Override
    public BookModel getBookById(int bookId) {
        BookModel bookModel = (BookModel) template.queryForObject("SELECT * FROM bookinformation where bookId=?", new BeanPropertyRowMapper(BookModel.class), bookId);
        System.out.println(bookModel);
        return bookModel;
    }

    @Override
    public int getNextBookId() {
            String query = "SELECT count(bookId) FROM bookinformation";
            int count = template.queryForObject(query,Integer.class);
            if(count>0){
                return count;
            }
            return 0;
    }

    @Override
    public int updateBookData(BookModel bookModel) {
        String updateQuery = "update bookinformation set bookName='"+bookModel.getBookName()+"',bookDescription='"+bookModel.getBookDescription()+"',bookAuthorName='"+bookModel.getBookAuthorName()+"',inrPrice='"+bookModel.getInrPrice()+"',usdPrice='"+bookModel.getUsdPrice()+"' where bookId='"+bookModel.getBookId()+"'";
        return template.update(updateQuery);
    }

    @Override
    public int deleteBookData(int bookId) {
        String deleteQuery = "delete from bookinformation where bookId="+bookId+"";
        return template.update(deleteQuery);
    }

}
