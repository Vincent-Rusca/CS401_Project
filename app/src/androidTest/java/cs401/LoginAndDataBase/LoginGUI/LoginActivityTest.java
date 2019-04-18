package cs401.LoginAndDataBase.LoginGUI;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cs401.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Before
    public void launchActivity(){
        ActivityScenario.launch(LoginActivity.class);
    }

    @Test
    public void validDisplay(){
        onView(withText("Login"));
        onView(withId(R.id.loginbtn));
    }

    @Test
    public void regButton(){
        onView(withId(R.id.registerbtn)).perform(click());
        onView(withText("Registration"));
        onView(withId(R.id.signupbtn));

    }


}