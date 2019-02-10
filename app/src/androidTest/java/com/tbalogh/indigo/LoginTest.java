package com.tbalogh.indigo;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;


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
        onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click());

        // Assert that the email field and the password field has the error text: "Must be not empty!"
        onView(ViewMatchers.withId(R.id.emailField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Must be not empty!")));
        onView(ViewMatchers.withId(R.id.passwordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Must be not empty!")));
    }

    /* 1.2
     *  Verify that the error message shown if wrong email and password was given
     * */
    @Test
    public void login_withInvalidCredentials_errorMessagesShown() throws InterruptedException {
        // Type the invalid credentials (use INVALID_EMAIL and INVALID PASSWORD variable)
        onView(ViewMatchers.withId(R.id.emailField))
                .perform(ViewActions.typeText(INVALID_EMAIL));
        onView(ViewMatchers.withId(R.id.passwordField))
                .perform(ViewActions.typeText(INVALID_PASSWORD));

        // Click the button login
        onView(ViewMatchers.withId(R.id.loginButton))
                .perform(ViewActions.click());

        // Assert that the email field and the password field has the error text: "Invalid credentials!" and "Invalid credentials!"
        onView(ViewMatchers.withId(R.id.emailField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Invalid credentials!")));
        onView(ViewMatchers.withId(R.id.passwordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Invalid credentials!")));
    }

    /* 1.3
     *  Verify that the login was successful with valid credentials
     * */
    @Test
    public void login_withValidEmailAndPassword_openedTheAppPage() throws InterruptedException {
        // Type the valid credentials (use VALID_EMAIL and VALID PASSWORD variable)
        onView(ViewMatchers.withId(R.id.emailField))
                .perform(ViewActions.typeText(VALID_EMAIL));
        onView(ViewMatchers.withId(R.id.passwordField))
                .perform(ViewActions.typeText(VALID_PASSWORD));

        // Click the button login
        onView(ViewMatchers.withId(R.id.loginButton))
                .perform(ViewActions.click());

        // Assert that the "Welcome to the app!" message is displayed.
        onView(ViewMatchers.withId(R.id.welcomeText))
                .check(ViewAssertions.matches(ViewMatchers.withText("Welcome to the app!")));
    }
}
