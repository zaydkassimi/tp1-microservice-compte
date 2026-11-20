package net.zayd.ebankservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = BankAccount.class)
public interface BankAccountProjection {
    String getId();

    Double getBalance();

    AccountType getType();
}
