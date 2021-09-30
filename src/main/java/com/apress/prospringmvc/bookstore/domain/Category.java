package com.apress.prospringmvc.bookstore.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SuppressWarnings("serial")
public class Category implements Serializable {

    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
