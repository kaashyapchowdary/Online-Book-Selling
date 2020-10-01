package com.nendrasys.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nendrasys.dao.BookDao;
import com.nendrasys.model.BookModel;
import com.nendrasys.service.BookService;
import com.nendrasys.validations.BookDataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller("BookController")
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookDataValidation bookDataValidation;

    @Autowired
    private BookDao bookDao;

    /***
     * for book form validation
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(bookDataValidation);
    }

    /***
     * get the book form
     * @param model
     * @return
     */
    @RequestMapping(value = "/addBook",method = RequestMethod.GET)
    public String bookDataForm(Model model){
        BookModel bookModel = new BookModel();
        //set id in add book form getting from database
        int count = bookDao.getNextBookId();
        bookModel.setBookId(count+1);
        model.addAttribute("book", bookModel);
        return "addBookForm";
    }


    /***
     * Book data adding success
     * @param bookModel
     * @param result
     * @param model
     * @param locale
     * @return
     */
    @RequestMapping(value = "/booksAdding",method = RequestMethod.POST)
    public String booksAdding(@ModelAttribute("book") @Validated BookModel bookModel, BindingResult result,
                              Model model, Locale locale){
        int idCount = bookDao.getNextBookId();
        if((bookModel.getBookId()<idCount+1)&&(bookModel.getBookId()>0)){
            result.rejectValue("bookId","bookModel.bookId.invalid");
        }
        if(bookModel.getBookId()>idCount+1){
            result.rejectValue("bookId","bookModel.bookId.invalid1");
        }

        System.out.println(result);
        if(result.hasErrors()){
            return "addBookForm";
        }
        String resultMsg = null;
        resultMsg = bookService.saveBookData(bookModel,locale);
        model.addAttribute("result",resultMsg);
        return "bookAddedSuccess";
    }

    /***
     * for getting all book details
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllBooks")
    public String showAllBooks(Model model){
        List<BookModel> books = bookService.getAllBooks();
        model.addAttribute("listOfBooks",books);
        return "displayAllBooks";
    }

    /***
     * update or delete book data form
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateDelete")
    public String updateDeleteBook(Model model){
        List<BookModel> books = bookService.getAllBooks();
        model.addAttribute("listOfBooks",books);
        return "updateDeleteForm";
    }

    /***
     * for getting all book details in xml format
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getAllBooksXml",produces = "application/xml")
    @ResponseBody
    public String getAllBookDetailsInXml() throws IOException {
        /*System.out.println("from controller::"+bookService.convertBookObjToXml());*/
        return bookService.convertBookObjToXml();
    }

    /***
     * for getting all book details in json format
     * @param map
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/displayAllBooksJson",produces = {"application/json"})
    public String displayAllBooks(Map<String, Object> map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(bookService.getAllBooks());
    }

    /***
     * for getting book details by using bookId
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/getBookByIdXmlFormat/{bookId}")
    public ResponseEntity<BookModel> getBookById (@PathVariable("bookId") int bookId)
    {
        if (bookId != 0) {
            BookModel bookModel = bookService.getBookById(bookId);
            return new ResponseEntity<BookModel>(bookModel, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /***
     *get book data for particular bookId
     * @param model
     * @param bookId
     * @return
     */
    @RequestMapping("/getBookById/{bookId}")
    public String getBookById(Model model, @PathVariable(value = "bookId") int bookId){
        model.addAttribute("getBook",bookService.getBookById(bookId));
        return "displayBookById";
    }

    /***
     * for getting update form
     * @param model
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/updateBook/{bookId}",method = RequestMethod.GET)
    public String updateData(Model model,@PathVariable(value = "bookId") int bookId){
        BookModel bookModel = bookService.getBookById(bookId);
        model.addAttribute("update",bookModel);
        model.addAttribute("update",bookService.getBookById(bookId));
        return "updateBookDetails";
    }

    /***
     * updating book details success
     * @param bookModel
     * @param model
     * @return
     */
    @RequestMapping(value="/updateBookData", method = RequestMethod.POST)
    public String updateBookData(@ModelAttribute("update") BookModel bookModel, Model model){
        model.addAttribute("result",bookService.updateBookData(bookModel));
        return "updateSuccess";
    }

    /***
     * for delete the book details
     * @param model
     * @param bookId
     * @return
     */
    @RequestMapping("/deleteBookData/{bookId}")
    public String deleteBookById(Model model, @PathVariable(value = "bookId") int bookId){
        model.addAttribute("result",bookService.deleteBookData(bookId));
        return "deleteSuccess";
    }

}
