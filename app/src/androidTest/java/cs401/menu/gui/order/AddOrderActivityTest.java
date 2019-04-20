package cs401.menu.gui.order;

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
public class AddOrderActivityTest {

    @Before
    public void setUp() {
        CustomerListStateManager.getInstance().clearList();
        Intent intent = new Intent();
        intent.putExtra("index", 0);
        activityRule.launchActivity(intent);
    }

    @Rule
    public ActivityTestRule<AddOrderActivity> activityRule = new ActivityTestRule<>(AddOrderActivity.class, false, false);

    @Test
    public void testAdd() {
        String name = "TestName", street = "TestStreet", city = "TestCity", state = "TestState";
        int id = 1234, zip = 94555;
        Customer customer = new Customer(name, Integer.toString(id), new Address(street, city, state, Integer.toString(zip)));
        String orderName = "TestOrderName", orderDescription = "TestOrderDescription";
        int quantity = 897, invoice = 654;
        double cost = 12.34;
        Order order = new Order(orderName, cost, quantity, invoice, orderDescription);
        CustomerListStateManager.getInstance().addCustomer(customer);
        onView(withId(R.id.add_order_name)).perform(typeText(orderName), closeSoftKeyboard());
        onView(withId(R.id.add_order_cost)).perform(typeText(Double.toString(cost)), closeSoftKeyboard());
        onView(withId(R.id.add_order_quantity)).perform(typeText(Integer.toString(quantity)), closeSoftKeyboard());
        onView(withId(R.id.add_order_invoice)).perform(typeText(Integer.toString(invoice)), closeSoftKeyboard());
        onView(withId(R.id.add_order_description)).perform(typeText(orderDescription), closeSoftKeyboard());
        onView(withId(R.id.menu_save)).perform(click());
        assertEquals(order, CustomerListStateManager.getInstance().getCustomer(0).getOrderList().getOrderByIndex(0));
    }
}
