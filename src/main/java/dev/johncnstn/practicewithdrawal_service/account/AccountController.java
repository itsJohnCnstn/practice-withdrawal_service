package dev.johncnstn.practicewithdrawal_service.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
class AccountController {

    private final AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/{id}")
    ResponseEntity<AccountDTO> getAccountService(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

}
