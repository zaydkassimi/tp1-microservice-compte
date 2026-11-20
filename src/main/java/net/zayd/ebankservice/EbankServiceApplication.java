package net.zayd.ebankservice;

import net.zayd.ebankservice.entities.AccountType;
import net.zayd.ebankservice.entities.BankAccount;
import net.zayd.ebankservice.entities.Customer;
import net.zayd.ebankservice.repositories.BankAccountRepository;
import net.zayd.ebankservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository,
                            CustomerRepository customerRepository) {
        return args -> {
            List<String> names = List.of("Mohamed", "Yasmine", "Hassan");
            names.forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .build();
                customerRepository.save(customer);
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .createdAt(new Date())
                            .balance(10000 + Math.random() * 90000)
                            .currency("MAD")
                            .type(Math.random() > 0.5 ? AccountType.CURRENT : AccountType.SAVING)
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }
}
