package br.com.gaid.bank.controllers;

import br.com.gaid.bank.dtos.PixDTO;
import br.com.gaid.bank.dtos.WithdrawDepositDTO;
import br.com.gaid.bank.models.Account;
import br.com.gaid.bank.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return ResponseEntity.ok(service.createAccount(account));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    @GetMapping("/id/{accountId}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable Long accountId) {
        return ResponseEntity.ok(service.getAccountById(accountId));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Optional<Account>> getAccountByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.getAccountByCpf(cpf));
    }

    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody WithdrawDepositDTO dto) {
        service.deposit(dto);
        return ResponseEntity.ok("Depósito realizado com sucesso!");
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawDepositDTO dto) {
        service.withdraw(dto);
        return ResponseEntity.ok("Saque realizado com sucesso!");
    }

    @PutMapping("/pix")
    public ResponseEntity<String> transfer(@RequestBody PixDTO dto) {
        service.transfer(dto);
        return ResponseEntity.ok("Transferência PIX realizada com sucesso!");
    }

    @PutMapping("/close/{accountId}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountId) {
        service.closeAccount(accountId);
        return ResponseEntity.ok("Conta encerrada com sucesso!");
    }
}
