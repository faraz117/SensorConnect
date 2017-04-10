package com.electronicjunkies.sensorconnect.sensorconnect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager manager = getSupportFragmentManager();
        if (id == R.id.nav_sensors) {
            SensorFragment sensorFragment = new SensorFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment, sensorFragment).commit();
        } else if (id == R.id.nav_controller){
            ControllerFragment controllerFragment = new ControllerFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment , controllerFragment).commit();
        } else if (id == R.id.nav_medium) {
            MediumFragment mediumFragment = new MediumFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment , mediumFragment).commit();
        } else if (id == R.id.nav_protocol) { // problem here
            ProtocolFragment protocolFragment = new ProtocolFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment , protocolFragment).commit();
        } else if (id == R.id.nav_intelligence) {
            IntelligenceFragment intelligenceFragment = new IntelligenceFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment , intelligenceFragment).commit();
        } else if (id == R.id.nav_share) { // problem
            ShareFragment shareFragment = new ShareFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment , shareFragment).commit();

        } else if (id == R.id.nav_support) { // problem
            SupportFragment supportFragment = new SupportFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment , supportFragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
