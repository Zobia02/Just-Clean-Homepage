package com.example.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    CardView sofa,floor,roof,carpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav=(NavigationView) findViewById(R.id.nav);
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open_drawer,R.string.navigation_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(this);
        nav.bringToFront();
        nav.setCheckedItem(R.id.home);
        sofa=(CardView)findViewById(R.id.cardsofa);
        carpet=(CardView)findViewById(R.id.cardcarpet);
        floor=(CardView)findViewById(R.id.cardfloor);
        roof=(CardView)findViewById(R.id.cardroof);
        roof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Roof=getPackageManager().getLaunchIntentForPackage("com.example.justcleanroof");
                startActivity(Roof);
           }
        });
        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Floor=getPackageManager().getLaunchIntentForPackage("com.example.floor");
               startActivity(Floor);
            }
        });
        carpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Carpet=getPackageManager().getLaunchIntentForPackage("com.example.carpetcleaning");
                startActivity(Carpet);
            }
        });
        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sofa=getPackageManager().getLaunchIntentForPackage("com.example.sofa_cleaning");
                startActivity(Sofa);
            }
        });

}

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                break;
            case R.id.map:
                Intent intent=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.info:
                Intent intent1=new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent1);
                break;
            case R.id.Sofacleaning:
                Toast.makeText(this,"Redirecting to Sofa Cleaning Service",Toast.LENGTH_SHORT).show();
                Intent Isofa=getPackageManager().getLaunchIntentForPackage("com.example.sofa_cleaning");
                startActivity(Isofa);
                break;
            case R.id.CarpetCleaning:
                Toast.makeText(this,"Redirecting to Carpet Cleaning Service",Toast.LENGTH_SHORT).show();
                Intent Icarpet=getPackageManager().getLaunchIntentForPackage("com.example.carpetcleaning");
                startActivity(Icarpet);
                break;
            case R.id.FloorCleaning:
                Toast.makeText(this,"Redirecting to Floor Cleaning Service",Toast.LENGTH_SHORT).show();
                Intent Ifloor=getPackageManager().getLaunchIntentForPackage("com.example.floor");
                startActivity(Ifloor);
                break;
            case R.id.RoofCleaning:
                Toast.makeText(this,"Redirecting to Roof Cleaning Service",Toast.LENGTH_SHORT).show();
                Intent Iroof=getPackageManager().getLaunchIntentForPackage("com.example.justcleanroof");
                startActivity(Iroof);
                break;
            case R.id.star1:
                Toast.makeText(this,"Thank you for response",Toast.LENGTH_SHORT).show();
                break;
            case R.id.star3:
                Toast.makeText(this,"We highly appreciate your response",Toast.LENGTH_SHORT).show();
                break;
            case R.id.star5:
                Toast.makeText(this,"Thank you For rating Us 5 stars.",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}