package cs401.menu.gui;

import cs401.Customers.CustomerList;

public interface ViewUpdate {

    // this is a lazy hack to work around issues with testing and the singleton pattern
    void updateView(CustomerList customerList);
}
