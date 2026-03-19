package dev.johncnstn.practicewithdrawal_service.account;

import java.math.BigDecimal;

public class AccountEntity {
    private Long id;
    private BigDecimal amount;

    public AccountEntity(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
