package cs401.menu.gui.order.modify;

import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Orders.Order;
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
public class ModifyOrderNameActivityTest {

    @Before
    public void setUp() {
        CustomerListStateManager.getInstance().clearList();
        String name = "TestName", street = "TestStreet", city = "TestCity", state = "TestState";
        int id = 1234, zip = 94555;
        Customer customer = new Customer(name, Integer.toString(id), new Address(street, city, state, Integer.toString(zip)));
        Order order = new Order("TestOrder", 12.34, 11, 22, "A Test Order");
        customer.addToOrderList(order);
        CustomerListStateManager.getInstance().addCustomer(customer);
        Intent intent = new Intent();
        intent.putExtra("customerIndex", 0);
        intent.putExtra("orderIndex", 0);
        activityRule.launchActivity(intent);
    }

    @Rule
    public ActivityTestRule<ModifyOrderNameActivity> activityRule = new ActivityTestRule<>(ModifyOrderNameActivity.class, false, false);

    @Test
    public void testRemove() {
        onView(withId(R.id.modify_order_name)).perform(typeText("NewTestOrderName"), closeSoftKeyboard());
        onView(withId(R.id.order_name)).perform(click());
        assertEquals("NewTestOrderName", CustomerListStateManager.getInstance().getCustomer(0).getOrderList().getOrderByIndex(0).getItemName());
    }
}
