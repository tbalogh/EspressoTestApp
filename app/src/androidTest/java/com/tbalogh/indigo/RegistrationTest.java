package com.tbalogh.indigo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegistrationTest {

    public static String SHORT_PASSWORD = "1234567";

    public static String VALID_EMAIL = "test@logmein.com";
    public static String VALID_PASSWORD = "password";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        // Navigate to the Registration view
    }

    /* 2.1
     *  Verify that the error message shown if no field was filled
     * */
    @Test
    public void register_noFieldWasFilled_errorMessageShown() {
        // Click the button register

        // Assert that fields has the error text: "Must be not empty!"
    }

    /* 2.2
     *  Verify that the error message shown if email has wrong format
     * */
    @Test
    public void register_emailHasWrongFormat_errorMessageShown() {
        // Fill the email field with wrong format

        // Click the button register

        // Assert that fields has the error text: "Invalid email address!"
    }

    /* 2.3
     *  Verify that the error message shown if password is too short
     * */
    @Test
    public void register_passwordIsTooShort_errorMessageShown() {
        // Fill the password fields with passwords with SHORT_PASSWORD

        // Click the button register

        // Assert that fields has the error text: "Password must be at least 8 character!"
    }

    /* 2.4
     *  Verify that the error message shown if password does not match
     * */
    @Test
    public void register_passwordsDoesNotMatch_errorMessageShown() {
        // Fill the password fields with different values

        // Click the button register

        // Assert that fields has the error text: "Passwords does not match!"
    }


    /* 2.5
     *  Verify that the registration was successful with valid data
     * */
    @Test
    public void register_validData_registrationSucceeded() {
        // Fill the email and password fields with the valid values

        // Click the button register

        // Assert that the "Registratiton was successful!" message appeared.
    }

}
