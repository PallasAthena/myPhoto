package com.example.sevice;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.Photo;
import com.example.domain.Photos;
import com.example.service.PhotoService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TUMyServiceTest {
    private final static Logger LOGGER = Logger.getLogger(TUMyServiceTest.class);
    @Autowired
    private PhotoService bookService;

    @Test
    public void testGetAndSave() {
        final Photo result = bookService.getBook(1L);
        if (result == null) {
            final Photo newBook = new Photo("Java Restful Web Service实战");
            final Photo result0 = bookService.saveBook(newBook);
            TUMyServiceTest.LOGGER.debug(result0);
            Assert.assertNotNull(result0.getBookId());
        } else {
            TUMyServiceTest.LOGGER.debug(result);
            Assert.assertNotNull(result.getBookId());
        }
    }

    @Test
    public void testFindAll() {
        final Photos result0 = bookService.getBooks();
        final List<Photo> bookList = result0.getBookList();
        if (bookList != null) {
            for (final Photo book : bookList) {
                TUMyServiceTest.LOGGER.debug(book);
                Assert.assertNotNull(book.getBookId());
            }
        }
    }
}
