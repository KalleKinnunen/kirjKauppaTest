package com.example.kallekirjakauppa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.kallekirjakauppa.domain.Book;
import com.example.kallekirjakauppa.domain.BookRepository;
import com.example.kallekirjakauppa.domain.Category;
import com.example.kallekirjakauppa.domain.CategoryRepository;
import com.example.kallekirjakauppa.domain.User;
import com.example.kallekirjakauppa.domain.UserRepository;

import org.assertj.core.api.AbstractIterableAssert;
import org.assertj.core.api.ListAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;


    
    @Test
    public void createNewUser() {
    	User user = new User("Kinnunen", "kissa1", "ADMIN");
    	repository.save(user);
    	assertThat(user.getUsername()).isNotNull();
    }    


}