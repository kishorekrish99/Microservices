package com.kishore.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.kishore.accounts.dto.AccountsContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableConfigurationProperties(value= {AccountsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
					title = "Accounts MicroService Rest Documentation",
					description = "Banking Application Accounts MicroService REST API Documentation",
					version = "Version-1",
					contact = @Contact(
							name="Kishore Uputoori",
							email="kishoreuputoori@gmail.com",
							url="www.kishoreuputoori.com"
					),
					license = @License(
							name = "Apache 2.0",
							url = "www.kishoreuputoori.com"
					)
				),
		externalDocs = @ExternalDocumentation(
				description = "Banking Application Accounts MicroService REST API Documentation",
				url = "http://www.kishoreuputoori.com"
				)
		
)
				
		
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
