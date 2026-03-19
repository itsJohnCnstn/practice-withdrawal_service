package dev.johncnstn.practicewithdrawal_service.account;

import org.springframework.stereotype.Service;

import static dev.johncnstn.practicewithdrawal_service.account.AccountExceptionSupplier.accountNotFoundExceptionSupplier;

@Service
class AccountService {

    private final AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    AccountDTO getAccount(Long accountId) {
        var accountEntity = accountRepository.findAccountById(accountId)
                .orElseThrow(accountNotFoundExceptionSupplier(accountId));
        return new AccountDTO(accountEntity.getId(), accountEntity.getAmount());
    }

}
