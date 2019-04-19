package cs401.menu.gui.customer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.menu.gui.CustomerListStateManager;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;

@RunWith(AndroidJUnit4.class)
public class DisplayCustomerActivityTest {

    @Before
    public void setUp() {
        CustomerListStateManager.getInstance().clearList();
        String name = "TestName", street = "TestStreet", city = "TestCity", state = "TestState";
        int id = 1234, zip = 94555;
        Customer customer = new Customer(name, Integer.toString(id), new Address(street, city, state, Integer.toString(zip)));
        CustomerListStateManager.getInstance().addCustomer(customer);
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    activityRule.getActivity().updateView(CustomerListStateManager.getInstance().getCustomerList());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Rule
    public ActivityTestRule<DisplayCustomerActivity> activityRule = new ActivityTestRule<>(DisplayCustomerActivity.class);

    @Test
    public void testDisplay() {
        onView(withText("TestName")).check(matches(isDisplayed()));
        onView(withText("ID: 1234")).check(matches(isDisplayed()));
        onView(withText("TestStreet TestCity, TestState 94555")).check(matches(isDisplayed()));
    }
}
