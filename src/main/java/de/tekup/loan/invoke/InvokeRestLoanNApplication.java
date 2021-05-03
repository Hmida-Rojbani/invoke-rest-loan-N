package de.tekup.loan.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InvokeRestLoanNApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokeRestLoanNApplication.class, args);
	}

}
