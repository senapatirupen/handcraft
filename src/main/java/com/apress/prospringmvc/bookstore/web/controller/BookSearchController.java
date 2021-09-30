package com.apress.prospringmvc.bookstore.web.controller;

import com.apress.prospringmvc.bookstore.domain.Book;
import com.apress.prospringmvc.bookstore.domain.BookSearchCriteria;
import com.apress.prospringmvc.bookstore.domain.Category;
import com.apress.prospringmvc.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class BookSearchController {

    @Autowired
    private BookstoreService bookstoreService;

    @ModelAttribute
    public BookSearchCriteria criteria() {
        return new BookSearchCriteria();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return (List<Category>) this.bookstoreService.findAllCategories();
    }

    /**
     * This method searches our database for books based on the given {@link BookSearchCriteria}. 
     * Only books matching the criteria are returned.
     * 
     * @param criteria the criteria used for searching
     * @return the found books
     * 
     * @see BookstoreService#findBooks(BookSearchCriteria)
     */
    @GetMapping(value = "/book/search")
    public Collection<Book> list(@ModelAttribute("bookSearchCriteria") BookSearchCriteria criteria) {
        return this.bookstoreService.findBooks(criteria);
    }

    /**
     * This method searches our database for books based on the given {@link BookSearchCriteria}. 
     * Only books matching the criteria are returned.
     * 
     * @param criteria the criteria used for searching
     * @return the found books
     * 
     * @see BookstoreService#findBooks(BookSearchCriteria)
     */
    @PostMapping(value = "/book/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Collection<Book> listJSON(@RequestBody BookSearchCriteria criteria) {
    	  Category category = this.bookstoreService.findCategory(criteria.getCategory().getId());
    	  criteria.setCategory(category);
    	  List<Book> res = this.bookstoreService.findBooks(criteria);
        return res;
    }

}
