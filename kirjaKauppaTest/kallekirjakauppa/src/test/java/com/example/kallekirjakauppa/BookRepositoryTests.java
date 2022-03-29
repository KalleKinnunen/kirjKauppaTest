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

import org.junit.jupiter.api.Test;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnBook() {
        List<Book> books = repository.findByIsbn("1122233");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Batman");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Kalle Kinnunen", "Ironman", "116944", 1995, new Category("Horror"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    @Test
    public void deleteNewBook() {
		List<Book> books = repository.findByIsbn("1122233");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByIsbn("1122233");
		assertThat(newBooks).hasSize(0);
     }

}