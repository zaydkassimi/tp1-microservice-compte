package net.zayd.ebankservice.repositories;

import net.zayd.ebankservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
