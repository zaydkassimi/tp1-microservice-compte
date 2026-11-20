package net.zayd.ebankservice.services;

import lombok.AllArgsConstructor;
import net.zayd.ebankservice.dtos.BankAccountRequestDTO;
import net.zayd.ebankservice.dtos.BankAccountResponseDTO;
import net.zayd.ebankservice.entities.BankAccount;
import net.zayd.ebankservice.mappers.BankAccountMapper;
import net.zayd.ebankservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;
    private BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.fromBankAccount(savedBankAccount);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        if (bankAccountDTO.getBalance() != null) bankAccount.setBalance(bankAccountDTO.getBalance());
        if (bankAccountDTO.getCurrency() != null) bankAccount.setCurrency(bankAccountDTO.getCurrency());
        if (bankAccountDTO.getType() != null) bankAccount.setType(bankAccountDTO.getType());
        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.fromBankAccount(updatedBankAccount);
    }
}
