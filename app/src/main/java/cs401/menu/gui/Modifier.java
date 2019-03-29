package cs401.menu.gui;

import android.view.View;

/**
 * interface common to all classes that add or modify the customer list
 */
public interface Modifier {
    /**
     * modify the global customer list
     * @param view view
     */
    void save(View view);
}
