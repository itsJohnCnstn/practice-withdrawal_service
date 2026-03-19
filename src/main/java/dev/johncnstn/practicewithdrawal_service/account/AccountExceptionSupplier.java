package dev.johncnstn.practicewithdrawal_service.account;

import java.util.function.Supplier;

abstract class AccountExceptionSupplier {

    private AccountExceptionSupplier() {
    }

    static Supplier<AccountNotFoundException> accountNotFoundExceptionSupplier(Long accountId) {
        return () -> new AccountNotFoundException(accountId);
    }

}
