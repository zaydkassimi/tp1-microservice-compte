package net.zayd.ebankservice.web;

import lombok.AllArgsConstructor;
import net.zayd.ebankservice.dtos.BankAccountRequestDTO;
import net.zayd.ebankservice.dtos.BankAccountResponseDTO;
import net.zayd.ebankservice.entities.BankAccount;
import net.zayd.ebankservice.entities.Customer;
import net.zayd.ebankservice.repositories.BankAccountRepository;
import net.zayd.ebankservice.repositories.CustomerRepository;
import net.zayd.ebankservice.services.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {

    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @QueryMapping
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,
                                                @Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }
}
