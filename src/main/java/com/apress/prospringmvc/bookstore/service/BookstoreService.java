package com.apress.prospringmvc.bookstore.service;

import com.apress.prospringmvc.bookstore.domain.*;

import java.util.List;
import java.util.Optional;

/**
 * Main entry point for the bookstore.
 * 
 * @author Marten Deinum
 *
 */
public interface BookstoreService {

    List<Book> findBooksByCategory(Category category);

    Book findBook(long id);

    Optional<Orders> findOrder(long id);

    List<Book> findRandomBooks();

    /**
     * Find the {@link Orders}s for a given {@link Account}.
     * 
     * @param account the customer
     * @return the list of orders (never <code>null</code>).
     */
    List<Orders> findOrdersForAccount(Account account);

    /**
     * Persist or update the given {@link Orders} in the database.
     * 
     * @param order the order to store.
     * @return the persisted order.
     */
    Orders store(Orders order);

    /**
     * Search for {@link Book}s that meet the given {@link BookSearchCriteria}.
     * 
     * @param bookSearchCriteria the search criteria.
     * @return list of books (never <code>null</code>).
     */
    List<Book> findBooks(BookSearchCriteria bookSearchCriteria);

    /**
     * Create an actual {@link Orders} for the given {@link Account} based on the content of their {@link Cart}.
     * 
     * @param cart the cart
     * @param account the customer
     * @return an {@link Orders}
     */
    Orders createOrder(Cart cart, Account account);

    /**
     * Find all the categories available.
     * 
     * @return list with all the categories
     */
    Iterable<Category> findAllCategories();

    Category findCategory(long id);

    /**
     * Store a book in the repository.
     * 
     * @param book the book to store.
     */
    void addBook(Book book);
}
