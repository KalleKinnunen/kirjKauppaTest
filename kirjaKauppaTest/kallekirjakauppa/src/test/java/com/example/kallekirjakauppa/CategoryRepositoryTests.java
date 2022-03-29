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

import org.junit.jupiter.api.Test;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByLastnameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Thriller");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Thriller");
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Horror");
    	repository.save(category);
    	assertThat(category.getName()).isNotNull();
    }    
    @Test
    public void deleteNewCategory() {
		List<Category> categories = repository.findByName("Thriller");
		Category category = categories.get(0);
		repository.delete(category);
		List<Category> newCategories = repository.findByName("Thriller");
		assertThat(newCategories).hasSize(0);
     }

}