package fr.b3.c1.tvshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
public class TvshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvshowApplication.class, args);
	}

}
