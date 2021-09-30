package com.apress.prospringmvc.bookstore.repository;

import com.apress.prospringmvc.bookstore.domain.Account;
import com.apress.prospringmvc.bookstore.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    /**
     * Find the orders for the given {@link Account}.
     * @param account the account
     * @return list of orders for the account, never <code>null</code>
     */
    List<Orders> findByAccount(Account account);

}
