package br.com.gaid.bank.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotBlank(message = "O número da conta não pode estar em branco")
    private String accountNumber;

    @NotBlank(message = "A agência não pode estar em branco")
    private String agency;

    @NotBlank(message = "O nome do titular é obrigatório")
    private String holderName;

    @NotBlank(message = "O CPF do titular é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
    private String holderCpf;

    @NotNull(message = "O saldo inicial não pode ser nulo")
    @PositiveOrZero(message = "O saldo inicial deve ser positivo ou zero")
    private Double balance;

    @NotNull(message = "A data de abertura não pode ser nula")
    @PastOrPresent(message = "A data de abertura não pode estar no futuro")
    private LocalDate openingDate;

    @NotNull(message = "O tipo de conta é obrigatório")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private boolean active = true; // Sempre inicia como ativa

    public boolean isActive() {  // Getter correto
        return active;
    }

    public void setActive(boolean active) { // Setter correto
        this.active = active;
    }
}
