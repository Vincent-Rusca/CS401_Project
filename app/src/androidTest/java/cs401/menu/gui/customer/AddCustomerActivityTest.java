package cs401.menu.gui.customer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddCustomerActivityTest {

    @Before
    public void setUp() {
        CustomerListStateManager.getInstance().clearList();
    }

    @Rule
    public ActivityTestRule<AddCustomerActivity> activityRule = new ActivityTestRule<>(AddCustomerActivity.class);

    @Test
    public void testAdd() {
        String name = "TestName", street = "TestStreet", city = "TestCity", state = "TestState";
        int id = 1234, zip = 94555;
        Customer customer = new Customer(name, Integer.toString(id), new Address(street, city, state, Integer.toString(zip)));
        onView(withId(R.id.add_customer_name)).perform(typeText(name), closeSoftKeyboard());
        onView(withId(R.id.add_customer_id)).perform(typeText(Integer.toString(id)), closeSoftKeyboard());
        onView(withId(R.id.add_customer_street)).perform(typeText(street), closeSoftKeyboard());
        onView(withId(R.id.add_customer_city)).perform(typeText(city), closeSoftKeyboard());
        onView(withId(R.id.add_customer_state)).perform(typeText(state), closeSoftKeyboard());
        onView(withId(R.id.add_customer_zip)).perform(typeText(Integer.toString(zip)), closeSoftKeyboard());
        onView(withId(R.id.menu_save)).perform(click());
        assertEquals(customer, CustomerListStateManager.getInstance().getCustomer(0));
    }
}
