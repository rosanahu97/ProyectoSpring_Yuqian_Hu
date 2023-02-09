package es.rf.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages ="es.rf.tienda")//exclude = {DataSourceAutoConfiguration.class})

public class S4TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S4TiendaSpringApplication.class, args);
	}

}
