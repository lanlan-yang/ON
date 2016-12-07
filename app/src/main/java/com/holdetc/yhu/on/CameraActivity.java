package com.holdetc.yhu.on;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.holdetc.yhu.on.fragment.CameraHistroyFragment;
import com.holdetc.yhu.on.fragment.CameraInfoFragment;
import com.holdetc.yhu.on.fragment.CameraWonderfulFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangchengwei on 15/10/28.
 */
public class CameraActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        initView();
    }

    private void initView() {


        mToolbar = (Toolbar) findViewById(R.id.toolbar_camera);
        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Watch");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_camera);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_camera);
        if (navigationView != null) {
            //注册事件
            setupDrawerContent(navigationView);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_camera);
        tabLayout.addTab(tabLayout.newTab().setText("Preview"));
        tabLayout.addTab(tabLayout.newTab().setText("Exciting"));
        tabLayout.addTab(tabLayout.newTab().setText("History"));

        List<String> titles = new ArrayList<String>();
        List<Fragment> fragments = new ArrayList<Fragment>();

        Fragment histroy = new CameraHistroyFragment();
        Fragment info = new CameraInfoFragment();
        Fragment wonder = new CameraWonderfulFragment();


        fragments.add(info);
        fragments.add(wonder);
        fragments.add(histroy);


        titles.add("Preview");
        titles.add("Exciting");
        titles.add("History");

        ViewPager mViewPage = (ViewPager) findViewById(R.id.viewpager_camera);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, fragments);
        mViewPage.setAdapter(adapter);

        tabLayout.setupWithViewPager(mViewPage);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(CameraActivity.this, MainActivity.class);
                        CameraActivity.this.startActivity(intent);
                        CameraActivity.this.finish();
                        break;
                    case R.id.nav_me:
                        Intent intent2 = new Intent(CameraActivity.this,MeActivity.class);
                        CameraActivity.this.startActivity(intent2);
                        CameraActivity.this.finish();
                        break;
                    case R.id.nav_guide:
                        Intent intent3 = new Intent(CameraActivity.this,GuideActivity.class);
                        CameraActivity.this.startActivity(intent3);
                        CameraActivity.this.finish();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_room, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                //打开侧滑
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
