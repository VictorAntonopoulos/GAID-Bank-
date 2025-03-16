package br.com.gaid.bank.services;

import br.com.gaid.bank.dtos.PixDTO;
import br.com.gaid.bank.dtos.WithdrawDepositDTO;
import br.com.gaid.bank.models.Account;
import br.com.gaid.bank.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return repository.findById(id);
    }

    public Optional<Account> getAccountByCpf(String cpf) {
        return repository.findByHolderCpf(cpf);
    }

    @Transactional
    public void deposit(WithdrawDepositDTO dto) {
        Account account = repository.findById(dto.getAccountId()).orElseThrow(
                () -> new RuntimeException("Conta não encontrada!")
        );
        account.setBalance(account.getBalance() + dto.getAmount());
        repository.save(account);
    }

    @Transactional
    public void withdraw(WithdrawDepositDTO dto) {
        Account account = repository.findById(dto.getAccountId()).orElseThrow(
                () -> new RuntimeException("Conta não encontrada!")
        );
        if (account.getBalance() < dto.getAmount()) {
            throw new RuntimeException("Saldo insuficiente!");
        }
        account.setBalance(account.getBalance() - dto.getAmount());
        repository.save(account);
    }

    @Transactional
    public void transfer(PixDTO dto) {
        Account sender = repository.findById(dto.getAccountId()).orElseThrow(
                () -> new RuntimeException("Conta de origem não encontrada!")
        );
        Account receiver = repository.findById(dto.getPixAccountId()).orElseThrow(
                () -> new RuntimeException("Conta de destino não encontrada!")
        );

        if (sender.getBalance() < dto.getAmount()) {
            throw new RuntimeException("Saldo insuficiente para transferência!");
        }

        sender.setBalance(sender.getBalance() - dto.getAmount());
        receiver.setBalance(receiver.getBalance() + dto.getAmount());

        repository.save(sender);
        repository.save(receiver);
    }
    
}
