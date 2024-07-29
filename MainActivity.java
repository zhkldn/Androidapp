package com.example.ektuarticles;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                String title = "";

                int id = item.getItemId();

                if (id == R.id.home) {
                    selectedFragment = new HomeFragment();
                    title = getString(R.string.bottom_home);
                } else if (id == R.id.author) {
                    selectedFragment = new AuthorFragment();
                    title = getString(R.string.bottom_author);
                } else if (id == R.id.search) {
                    // selectedFragment = new SearchFragment(); // Создайте SearchFragment
                    // title = getString(R.string.bottom_search);
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragme_layout, selectedFragment)
                            .commit();
                    getSupportActionBar().setTitle(title);
                }
                return true;
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragme_layout, new HomeFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.bottom_home));
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        String title = "";

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            selectedFragment = new HomeFragment();
            title = getString(R.string.nav_home);
        } else if (id == R.id.nav_author) {
            selectedFragment = new AuthorFragment();
            title = getString(R.string.nav_author);
        } else if (id == R.id.nav_settings) {
            // selectedFragment = new SettingsFragment(); // Создайте SettingsFragment
            // title = getString(R.string.nav_settings);
        } else if (id == R.id.nav_share) {
            // selectedFragment = new ShareFragment(); // Создайте ShareFragment
            // title = getString(R.string.nav_share);
        } else if (id == R.id.nav_about) {
            // selectedFragment = new AboutFragment(); // Создайте AboutFragment
            // title = getString(R.string.nav_about);
        } else if (id == R.id.nav_logout) {
            // Обработайте выход из системы
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragme_layout, selectedFragment)
                    .commit();
            getSupportActionBar().setTitle(title);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}



