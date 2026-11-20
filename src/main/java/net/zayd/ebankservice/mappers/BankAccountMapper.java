package net.zayd.ebankservice.mappers;

import net.zayd.ebankservice.dtos.BankAccountRequestDTO;
import net.zayd.ebankservice.dtos.BankAccountResponseDTO;
import net.zayd.ebankservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountDTO(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDTO, bankAccount);
        return bankAccount;
    }
}
