package ma.azehaf.customerservice;

import ma.azehaf.customerservice.entities.Customer;
import ma.azehaf.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Issam").email("issam.azf@gmail.com").build(),
                    Customer.builder().name("elhoucine").email("elhoucine.azf@gmail.com").build(),
                    Customer.builder().name("Anouar").email("anouar.test@gmail.com").build()
                    ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
