package com.example.neerja_modi_school;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout=(DrawerLayout)getLayoutInflater().inflate(R.layout.activity_base,null);
        FrameLayout container=drawerLayout.findViewById(R.id.activity_container);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar=drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView=drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId()==R.id.navabout) {
            startActivity(new Intent(this, MainActivity2.class));
            overridePendingTransition(0,0);
        }
        else if(item.getItemId()== R.id.navhome) {
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(0,0);
        }

        else if (item.getItemId()==R.id.navcont) {
            startActivity(new Intent(this, Contact_page_java.class));
            overridePendingTransition(0,0);
        }
        else if (item.getItemId()==R.id.navcontList) {
            startActivity(new Intent(this,Cont_DB.class));
            overridePendingTransition(0,0);
        }
        else if (item.getItemId()==R.id.navfees) {
            startActivity(new Intent(this, FeesActivity.class));
            overridePendingTransition(0,0);
        }
        return false;
    }
    protected void allocateActivityTitle(String titleString)
    { if (getSupportActionBar() !=null)
        getSupportActionBar().setTitle(titleString);

    }
}