package tr.edu.yildiz.ce.seuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "tr.edu.yildiz.ce.se.base", "tr.edu.yildiz.ce.seuser" })
public class SeUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeUserApplication.class, args);
	}

}
