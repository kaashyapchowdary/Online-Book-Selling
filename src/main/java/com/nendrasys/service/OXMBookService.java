package com.nendrasys.service;

import com.nendrasys.dao.BookDao;
import com.nendrasys.model.BookModel;
import com.nendrasys.model.BookModelList;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;

import java.io.IOException;
import java.io.StringWriter;

public class OXMBookService {
    private Marshaller marshaller;
    @Autowired
    BookDao bookDao;

        public Marshaller getMarshaller() {
            return marshaller;
        }

        public void setMarshaller(Marshaller marshaller) {
            this.marshaller = marshaller;
        }

        //convert obj format data to xml format
        public String convertBookObjectToXml(BookModelList bookModelList) throws IOException {
            StringWriter stringWriter = new StringWriter();
            getMarshaller().marshal(bookModelList,new StreamResult(stringWriter));
            System.out.println("obj to xml::"+stringWriter);
            return stringWriter.toString();
        }

         //convert obj format data to xml format by bookId
        public String convertBookObjToXmlById(BookModel bookModel) throws IOException {
            StringWriter stringWriter=new StringWriter();
            getMarshaller().marshal(bookModel,new StreamResult(stringWriter));
            System.out.println("obj to xml by id::"+stringWriter);
            return stringWriter.toString();
        }

}
