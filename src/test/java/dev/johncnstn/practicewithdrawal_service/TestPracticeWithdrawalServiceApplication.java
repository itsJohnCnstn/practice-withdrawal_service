package dev.johncnstn.practicewithdrawal_service;

import org.springframework.boot.SpringApplication;

public class TestPracticeWithdrawalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(PracticeWithdrawalServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
