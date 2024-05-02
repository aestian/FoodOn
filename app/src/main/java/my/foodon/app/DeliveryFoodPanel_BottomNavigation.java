package my.foodon.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.foodon.app.deliveryFoodPanel.DeliveryPendingOrderFragment;
import my.foodon.app.deliveryFoodPanel.DeliveryShipOrderFragment;

public class DeliveryFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int SHIP_ORDERS_ID = R.id.shiporders;
    private static final int PENDING_ORDERS_ID = R.id.pendingorders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == SHIP_ORDERS_ID) {
            fragment = new DeliveryShipOrderFragment();
        } else if (itemId == PENDING_ORDERS_ID) {
            fragment = new DeliveryPendingOrderFragment();
        }
        return loadDeliveryFragment(fragment);
    }

    private boolean loadDeliveryFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }
}