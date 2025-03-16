package br.com.gaid.bank.repositories;

import br.com.gaid.bank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByHolderCpf(String cpf);
}
