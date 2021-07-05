package com.example.cs401groupwork2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cs401groupwork2.orders.Order;
import com.example.cs401groupwork2.orders.OrderList;

/* rename file later */
public class OrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //int i = 0;
        setContentView(R.layout.activity_orders);     // << might need a name change

//        // Layout
//        RelativeLayout myLayout = new RelativeLayout(this);
//        myLayout.setBackgroundColor(Color.WHITE);
//
//        // text for Menu
//        TextView orderMenuText = new TextView(this);
//        orderMenuText.setText("ORDER MENU");
//        orderMenuText.setTextColor(Color.BLACK);
//        orderMenuText.setId(i++);
//
//        // add orders button
//        Button addOrderButton = new Button(this);
//        addOrderButton.setBackgroundColor(Color.LTGRAY);
//        addOrderButton.setText("Add Order");
//        addOrderButton.setId(i++);
//
//        // set up positioning of each widget
//        RelativeLayout.LayoutParams menuTextDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        RelativeLayout.LayoutParams addOrderDetails = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        // give rules to position widgets
//        menuTextDetails.addRule(RelativeLayout.ABOVE, addOrderButton.getId());
//        menuTextDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        menuTextDetails.setMargins(0,0,0,50);
//
//        addOrderDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        addOrderDetails.addRule(RelativeLayout.CENTER_VERTICAL);
//
//
//        myLayout.addView(orderMenuText, menuTextDetails);
//        myLayout.addView(addOrderButton, addOrderDetails);
//
//        setContentView(myLayout);
    }

    public void goToOrderActivity(View view){
        Intent intent = new Intent(this, OrderActivity.class);

        Order banana = new Order("banana", 1.26, 63, 15987, "Curved yellow thing");
        Order apple = new Order("apple", 2.12, 47, 15467, "red ball thing");
        Order melon = new Order("melon", 4.69, 21, 41587, "a melone not inside a watermelone");

        OrderList orderList = new OrderList("fruits list");
        orderList.addOrder(banana);
        orderList.addOrder(apple);
        orderList.addOrder(melon);

        intent.putExtra("orderList", orderList);
        startActivity(intent);
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
