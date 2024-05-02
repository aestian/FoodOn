package my.foodon.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.foodon.app.chefFoodPanel.ChefHomeFragment;
import my.foodon.app.chefFoodPanel.ChefOrderFragment;
import my.foodon.app.chefFoodPanel.ChefPendingOrderFragment;
import my.foodon.app.chefFoodPanel.ChefProfileFragment;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int CHEF_HOME_ID = R.id.chefHome;
    private static final int PENDING_ORDERS_ID = R.id.PendingOrders;
    private static final int ORDERS_ID = R.id.Orders;
    private static final int CHEF_PROFILE_ID = R.id.chefProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == CHEF_HOME_ID) {
            fragment = new ChefHomeFragment();
        } else if (itemId == PENDING_ORDERS_ID) {
            fragment = new ChefPendingOrderFragment();
        } else if (itemId == ORDERS_ID) {
            fragment = new ChefOrderFragment();
        } else if (itemId == CHEF_PROFILE_ID) {
            fragment = new ChefProfileFragment();
        }
        return loadChefFragment(fragment);
    }

    private boolean loadChefFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            return true;
        }
        return false;
    }
}