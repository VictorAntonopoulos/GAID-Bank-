package br.com.gaid.bank.dtos;

import lombok.Data;

@Data
public class PixDTO {
    private Long accountId;
    private Long pixAccountId;
    private Double amount;
}
