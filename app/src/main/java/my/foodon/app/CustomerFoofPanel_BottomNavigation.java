package my.foodon.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.foodon.app.customerFoodPanel.CustomerCartFragmnet;
import my.foodon.app.customerFoodPanel.CustomerHomeFragment;
import my.foodon.app.customerFoodPanel.CustomerOrdersFragment;
import my.foodon.app.customerFoodPanel.CustomerProfileFragment;

public class CustomerFoofPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int CUST_HOME_ID = R.id.cust_Home;
    private static final int CART_ID = R.id.cart;
    private static final int CUST_PROFILE_ID = R.id.cust_profile;
    private static final int CUST_ORDER_ID = R.id.Cust_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_foof_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == CUST_HOME_ID) {
            fragment = new CustomerHomeFragment();
        } else if (itemId == CART_ID) {
            fragment = new CustomerCartFragmnet();
        } else if (itemId == CUST_PROFILE_ID) {
            fragment = new CustomerProfileFragment();
        } else if (itemId == CUST_ORDER_ID) {
            fragment = new CustomerOrdersFragment();
        }
        return loadCustomerFragment(fragment);
    }

    private boolean loadCustomerFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }
}