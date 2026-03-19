package dev.johncnstn.practicewithdrawal_service.account;

class AccountNotFoundException extends RuntimeException {

    static final String NO_ACCOUNT_WITH_SUCH_ID = "No account with such id: ";

    AccountNotFoundException(Long accountId) {
        super(NO_ACCOUNT_WITH_SUCH_ID + accountId);
    }

}
