package com.example.assignment_3nabinkhanal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import Adapter.ViewPagerAdapter;
import Fragments.Login;
import Fragments.Register;

public class ViewPageractivity extends AppCompatActivity {

        private ViewPager viewPager;
        private TabLayout tabLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_pageractivity);

            viewPager = findViewById(R.id.viewPager);
            tabLayout = findViewById(R.id.tabId);

            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

            viewPagerAdapter.addFragment(new Login(),"Login");
            viewPagerAdapter.addFragment(new Register(),"Register");

            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);


        }



}
