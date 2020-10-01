package com.nendrasys.validations;

import com.mysql.cj.util.StringUtils;
import com.nendrasys.model.BookModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class BookDataValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BookModel.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        /*ValidationUtils.rejectIfEmpty(errors, "bookId", "bookModel.bookId.empty");*/
        ValidationUtils.rejectIfEmpty(errors, "bookName", "bookModel.bookName.empty");
        ValidationUtils.rejectIfEmpty(errors, "bookDescription", "bookModel.bookDescription.empty");
        ValidationUtils.rejectIfEmpty(errors, "bookAuthorName", "bookModel.bookAuthorName.empty");
        ValidationUtils.rejectIfEmpty(errors, "inrPrice", "bookModel.inrPrice.empty");
        ValidationUtils.rejectIfEmpty(errors, "usdPrice", "bookModel.usdPrice.empty");

        BookModel bookModel = (BookModel) obj;


        //check the book id is positive or not
        if(bookModel.getBookId()<0){
            errors.rejectValue("bookId","bookModel.bookId.negative");
        }
        if(bookModel.getBookId()==0){
            errors.rejectValue("bookId","bookModel.bookId.zero");
        }

        //check length of book name
        if(bookModel.getBookName().length()>40){
            errors.rejectValue("bookName","bookModel.bookName.length");
        }

        //check length of book description
        if(bookModel.getBookDescription().length()>80){
            errors.rejectValue("bookDescription","bookModel.bookDescription.length");
        }

        //check length of book author name
        if(bookModel.getBookAuthorName().length()>30){
            errors.rejectValue("bookAuthorName","bookModel.bookAuthorName.length");
        }

        //check negative of india price
        if(bookModel.getInrPrice()<0){
            errors.rejectValue("inrPrice","bookModel.inrPrice.negative");
        }

        //check negative of us price
        if(bookModel.getUsdPrice()<0){
            errors.rejectValue("usdPrice","bookModel.usdPrice.negative");
        }

        if(bookModel.getInrPrice()==0){
            errors.rejectValue("inrPrice","bookModel.inrPrice.zero");
        }

        if(bookModel.getUsdPrice()==0){
            errors.rejectValue("usdPrice","bookModel.usdPrice.zero");
        }
    }

}
