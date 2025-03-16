package br.com.gaid.bank.dtos;

import lombok.Data;

@Data
public class WithdrawDepositDTO {
    private Long accountId;
    private Double amount;
}
