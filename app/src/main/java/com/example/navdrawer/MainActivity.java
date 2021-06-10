package com.example.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.NavigationView);
        drawerLayout= findViewById(R.id.drawer);

        toggle= new  ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Closing, R.string.Opening);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.nav_home:
                    {
                        Toast.makeText(MainActivity.this, "Home nav item is clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START,true);
                        break;
                    }
                    case R.id.nav_search:
                    {
                        Intent intent= new Intent(MainActivity.this, SearchStudent.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Search Student item is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_subject:
                    {
                        Intent intent= new Intent(MainActivity.this, Subjects.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Subject item is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();  Commented To prevent stop of activty
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START, true);
            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_SHORT).show();
        }
    }


}