package com.vananh.mathutil.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @ParameterizedTest
    @CsvFileSource(resources = "/register_test_data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean actual = accountService.registerAccount(username, password, email);

        assertEquals(expected, actual,
                String.format("Failed at: %s, %s, %s", username, password, email));
    }
}
