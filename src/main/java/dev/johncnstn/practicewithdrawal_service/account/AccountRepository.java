package dev.johncnstn.practicewithdrawal_service.account;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Repository
class AccountRepository {

    private static Map<Long, AccountEntity> accounts = Map.of(1L, new AccountEntity(1L, new BigDecimal(1000)));

    Optional<AccountEntity> findAccountById(Long accountId) {
        return Optional.ofNullable(accounts.get(accountId));
    }

}
