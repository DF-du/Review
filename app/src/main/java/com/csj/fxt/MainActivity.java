package com.csj.fxt;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.csj.fxt.adapter.MainAdapter;
import com.csj.fxt.fragment.CollectFragment;
import com.csj.fxt.fragment.HomeFragment;
import com.csj.fxt.fragment.MineFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTitles;
    private Toolbar mToolBar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private LinearLayout mLinear;
    private NavigationView mNavigation;
    private DrawerLayout mDrawer;
    private ImageView viewById;
    private ArrayList<String> mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar();
        initFragment();
        initTabLayout();
        initNavigation();
        initPres();
    }

    private void initView() {
        mTitles = (TextView) findViewById(R.id.titles);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mLinear = (LinearLayout) findViewById(R.id.linear);
        mNavigation = (NavigationView) findViewById(R.id.navigation);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
    }

    private void initToolBar() {
        mTitles.setText("首页");
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolBar, R.string.app_name, R.string.app_name);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                mLinear.setX(drawerView.getWidth() * slideOffset);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
    private void initFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MineFragment());
        fragments.add(new CollectFragment());
        mTitle = new ArrayList<>();
        mTitle.add("首页");
        mTitle.add("收藏");
        mTitle.add("我的");
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), fragments,mTitle);
        mViewPager.setAdapter(mainAdapter);
    }
    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
    }
    private void initNavigation() {

        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        startActivity(new Intent(MainActivity.this, DownloadActivity.class));
                        break;
                    case R.id.item2:
                        startActivity(new Intent(MainActivity.this, NavigationActivity.class));
                        break;
                    case R.id.item3:

                        break;
                }
                return false;
            }
        });
        viewById = mNavigation.getHeaderView(0).findViewById(R.id.img_header);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_OK);
            }
        });
    }
    private void initPres() {
        String[] pers = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        };
        ActivityCompat.requestPermissions(this, pers, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null&&resultCode == RESULT_OK){
            Uri data1 = data.getData();
            viewById.setImageURI(data1);
        }
    }
}
