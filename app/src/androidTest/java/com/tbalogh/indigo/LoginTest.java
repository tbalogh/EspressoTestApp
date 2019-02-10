package com.tbalogh.indigo;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class LoginTest {

    public static final String VALID_EMAIL = "test@logmein.com";
    public static final String VALID_PASSWORD = "password";
    private final static String INVALID_EMAIL = "invalid@gmail.com";
    private final static String INVALID_PASSWORD = "invalid_password";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /* 1.1
     *  Verify that the error message shown if no email and password was given
     * */
    @Test
    public void login_withEmptyEmailAndPassword_errorMessagesShown() throws InterruptedException {
        // Click the button login

        // Assert that the email field and the password field has the error text: "Must be not empty!"
    }

    /* 1.2
     *  Verify that the error message shown if wrong email and password was given
     * */
    @Test
    public void login_withInvalidEmailAndPassword_errorMessagesShown() throws InterruptedException {
        // Type the invalid credentials (use INVALID_EMAIL and INVALID PASSWORD variable)

        // Click the button login

        // Assert that the email field and the password field has the error text: "Invalid credentials!" and "Invalid credentials!"
    }

    /* 1.3
     *  Verify that the login was successful with valid credentials
     * */
    @Test
    public void login_withValidEmailAndPassword_openedTheAppPage() throws InterruptedException {
        // Type the valid credentials (use VALID_EMAIL and VALID PASSWORD variable)

        // Click the button login

        // Assert that the "Welcome to the app!" message is displayed.
    }
}
