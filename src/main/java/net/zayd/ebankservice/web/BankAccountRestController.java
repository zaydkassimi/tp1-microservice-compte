package net.zayd.ebankservice.web;

import lombok.AllArgsConstructor;
import net.zayd.ebankservice.dtos.BankAccountRequestDTO;
import net.zayd.ebankservice.dtos.BankAccountResponseDTO;
import net.zayd.ebankservice.entities.BankAccount;
import net.zayd.ebankservice.repositories.BankAccountRepository;
import net.zayd.ebankservice.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankAccountRestController {

    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountDTO) {
        return bankAccountService.addAccount(bankAccountDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        if (bankAccount.getCreatedAt() != null) account.setCreatedAt(bankAccount.getCreatedAt());
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
