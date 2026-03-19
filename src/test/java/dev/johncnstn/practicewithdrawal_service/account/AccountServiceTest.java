package dev.johncnstn.practicewithdrawal_service.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static dev.johncnstn.practicewithdrawal_service.account.AccountNotFoundException.NO_ACCOUNT_WITH_SUCH_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void getAccountByAccountId_WhenAccountExists() {
        //GIVEN
        Long accountId = 1L;
        //WHEN
        when(accountRepository.findAccountById(accountId)).thenReturn(Optional.of(new AccountEntity(accountId, any())));
        AccountDTO account = accountService.getAccount(accountId);
        //THEN
        assertThat(account.id()).isEqualTo(accountId);
        verify(accountRepository, times(1)).findAccountById(accountId);
    }

    @Test
    void throwAccountNotFoundException_WhenNoAccountWithSuchId() {
        //GIVEN
        Long accountId = 2L;
        //WHEN
        when(accountRepository.findAccountById(accountId)).thenReturn(Optional.empty());
        //THEN
        assertThatThrownBy(() -> accountService.getAccount(accountId))
                .isInstanceOf(AccountNotFoundException.class).hasMessageContaining(NO_ACCOUNT_WITH_SUCH_ID);
        verify(accountRepository, times(1)).findAccountById(accountId);
    }

}