package cs401.LoginAndDataBase.LoginGUI;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cs401.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginTest(){
        String user = "user", pass = "password";
        onView(withText("Login")).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(isDisplayed()));
        onView(withId(R.id.password)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).perform(typeText(user), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(pass), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.loginbtn)).perform(click());
        onView(withId(R.id.loginbtn)).check(matches(withText("Customer List")));

    }

    @Test
    public void registerTest(){
        onView(withId(R.id.registerbtn)).perform(click());
        String user = "user", reg = "password";
        onView(withText("Registration")).check(matches(isDisplayed()));
        onView(withId(R.id.regusername)).check(matches(isDisplayed()));
        onView(withId(R.id.regpassword)).check(matches(isDisplayed()));
        onView(withId(R.id.regpassword2)).check(matches(isDisplayed()));
        onView(withId(R.id.regusername)).perform(typeText(user), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.regpassword)).perform(typeText(reg), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.regpassword2)).perform(typeText(reg), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signupbtn)).perform(click());

    }


}