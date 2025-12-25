package com.frank.customerservice;

import com.frank.customerservice.config.GlobalConfig;
import com.frank.customerservice.entities.Customer;
import com.frank.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .firstName("Jane")
                    .lastName("Doe")
                    .email("jane.doe@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .firstName("Jack")
                    .lastName("Doe")
                    .email("jack.doe@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .firstName("Jill")
                    .lastName("Doe")
                    .email("jill.doe@gmail.com")
                    .build());
        };
    }

}
