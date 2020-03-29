package com.example.lr_4_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(manager));

        TabLayout tab = findViewById(R.id.tabs);
        tab.setupWithViewPager(pager);
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "FRAGMENT " + position;
        }

        @Override
        public Fragment getItem(int i) {
            return FragmentActivity.newInstance(String.valueOf(i));
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}