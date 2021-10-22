package timika.papua.navigasi_action;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mengganti actionbar dengan toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //memanggil drawer_layout dari activity_main.xml
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =
                findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //membuat hamburger icon pada toolbar dan animasinya
        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //membuat default navigation menu select
        if (savedInstanceState == null) {

            Bundle ent_container;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new wifi()).commit();
            navigationView.setCheckedItem(R.id.nav_wifi);
        }
    }

    //drawer menu fragment handler
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_wifi:

                Bundle ent_container;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new wifi()).commit();
                break;
            case R.id.nav_wifilock:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new wifi_lock()).commit();
                break;
            case R.id.nav_wifioff:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new wifi_off()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //on back press behavior
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }
}