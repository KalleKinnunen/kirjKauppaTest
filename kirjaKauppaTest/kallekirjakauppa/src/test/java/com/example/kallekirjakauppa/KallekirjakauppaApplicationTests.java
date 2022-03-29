package com.example.kallekirjakauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.kallekirjakauppa.web.BookController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class KallekirjakauppaApplicationTests {
	
	@Autowired
	private BookController controller;
	
	
	@Test
	public void contextLoads() {
		 assertThat(controller).isNotNull();
	}


}
