package dev.johncnstn.practicewithdrawal_service.account;

class AccountNotFoundException extends RuntimeException {

    AccountNotFoundException(String message) {
        super(message);
    }

}
