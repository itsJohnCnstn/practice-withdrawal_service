package dev.johncnstn.practicewithdrawal_service.account;

import org.springframework.stereotype.Service;

@Service
class AccountService {

    private final AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    AccountDTO getAccount(Long accountId) {
        var accountEntity = accountRepository.findAccountById(accountId).orElseThrow(() -> new AccountNotFoundException("No account with such id: " + accountId));
        return new AccountDTO(accountEntity.getId(), accountEntity.getAmount());
    }

}
