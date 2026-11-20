package net.zayd.ebankservice.services;

import net.zayd.ebankservice.dtos.BankAccountRequestDTO;
import net.zayd.ebankservice.dtos.BankAccountResponseDTO;

public interface BankAccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
