package br.com.gaid.bank.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String accountNumber;
    private String agency;
    private String holderName;
    private String holderCpf;
    private Double balance;
    private LocalDate openingDate;
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private boolean active;
}
