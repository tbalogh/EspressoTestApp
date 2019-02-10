package com.tbalogh.indigo;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4.class)
public class RegistrationTest {

    public static String SHORT_PASSWORD = "1234567";

    public static String WRONG_FORMAT_EMAIL = "testlogmein.com";

    public static String DIFFERENT_PASSWORD_1 = "password1";
    public static String DIFFERENT_PASSWORD_2 = "password2";

    public static String VALID_EMAIL = "test@logmein.com";
    public static String VALID_PASSWORD = "password";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        // Navigate to the Registration view
        onView(ViewMatchers.withId(R.id.openRegistrationButton))
                .perform(ViewActions.click());
    }

    /* 2.1
     *  Verify that the error message shown if no field was filled
     * */
    @Test
    public void register_noFieldWasFilled_errorMessageShown() {
        // Click the button register
        onView(ViewMatchers.withId(R.id.registerButton))
                .perform(ViewActions.click());

        // Assert that fields has the error text: "Must be not empty!"
        onView(ViewMatchers.withId(R.id.emailField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Must be not empty!")));
        onView(ViewMatchers.withId(R.id.passwordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Must be not empty!")));
        onView(ViewMatchers.withId(R.id.confirmPasswordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Must be not empty!")));
    }

    /* 2.2
     *  Verify that the error message shown if email has wrong format
     * */
    @Test
    public void register_emailHasWrongFormat_errorMessageShown() {
        // Fill the email field with wrong format (use WRONG_FORMAT_EMAIL field)
        onView(ViewMatchers.withId(R.id.emailField))
                .perform(ViewActions.typeText(WRONG_FORMAT_EMAIL));

        // Click the button register
        onView(ViewMatchers.withId(R.id.registerButton))
                .perform(ViewActions.click());

        // Assert that fields has the error text: "Invalid email format!"
        onView(ViewMatchers.withId(R.id.emailField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Invalid email format!")));
    }

    /* 2.3
     *  Verify that the error message shown if password is too short
     * */
    @Test
    public void register_passwordIsTooShort_errorMessageShown() {
        // Fill the password and confirmPassword fields with passwords with SHORT_PASSWORD
        onView(ViewMatchers.withId(R.id.passwordField))
                .perform(ViewActions.typeText(SHORT_PASSWORD));
        onView(ViewMatchers.withId(R.id.confirmPasswordField))
                .perform(ViewActions.typeText(SHORT_PASSWORD));

        // Click the button register
        onView(ViewMatchers.withId(R.id.registerButton))
                .perform(ViewActions.click());

        // Assert that fields has the error text: "Password must be at least 8 character!"
        onView(ViewMatchers.withId(R.id.passwordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Password must be at least 8 character!")));
        onView(ViewMatchers.withId(R.id.confirmPasswordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Password must be at least 8 character!")));
    }

    /* 2.4
     *  Verify that the error message shown if password does not match
     * */
    @Test
    public void register_passwordsDoesNotMatch_errorMessageShown() {
        // Fill the password fields with different values. Use DIFFERENT_PASSWORD_1 and DIFFERENT_PASSWORD_2 fields.
        onView(ViewMatchers.withId(R.id.passwordField))
                .perform(ViewActions.typeText(DIFFERENT_PASSWORD_1));
        onView(ViewMatchers.withId(R.id.confirmPasswordField))
                .perform(ViewActions.typeText(DIFFERENT_PASSWORD_2));

        // Click the button register
        onView(ViewMatchers.withId(R.id.registerButton))
                .perform(ViewActions.click());

        // Assert that fields has the error text: "Passwords does not match!"
        onView(ViewMatchers.withId(R.id.passwordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Passwords does not match!")));
        onView(ViewMatchers.withId(R.id.confirmPasswordField))
                .check(ViewAssertions.matches(ViewMatchers.hasErrorText("Passwords does not match!")));
    }


    /* 2.5
     *  Verify that the registration was successful with valid data
     * */
    @Test
    public void register_validData_registrationSucceeded() {
        // Fill the email and password fields with the valid values
        onView(ViewMatchers.withId(R.id.emailField))
                .perform(ViewActions.typeText(VALID_EMAIL));
        onView(ViewMatchers.withId(R.id.passwordField))
                .perform(ViewActions.typeText(VALID_PASSWORD));
        onView(ViewMatchers.withId(R.id.confirmPasswordField))
                .perform(ViewActions.typeText(VALID_PASSWORD));

        // Click the button register
        onView(ViewMatchers.withId(R.id.registerButton))
                .perform(ViewActions.click());

        // Assert that the registrationSucceededView appeared.
        onView(ViewMatchers.withId(R.id.registrationSucceededView))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

}
