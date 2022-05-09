package it.rocha.plain.orders.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
		scanBasePackages = {
				"it.rocha.plain.orders.domain",
				"it.rocha.plain.orders.usecase",
				"it.rocha.plain.orders.app",
		})
@EnableTransactionManagement
@EntityScan("it.rocha.plain.orders.app.persistence.model")
public class PlainOrdersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlainOrdersAppApplication.class, args);
	}

}
