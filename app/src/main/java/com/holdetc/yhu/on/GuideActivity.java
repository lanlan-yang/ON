package com.holdetc.yhu.on;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by yangchengwei on 15/10/28.
 */
public class GuideActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    public static final String EXTRA_NAME = "我的发现";
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_appbar_guide);

        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_appbar_guide);
        collapsingToolbar.setTitle(EXTRA_NAME);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_guide);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_guide);
        if (navigationView != null) {
            //注册事件
            setupDrawerContent(navigationView);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.nav_camera:
                        Intent intent = new Intent(GuideActivity.this, CameraActivity.class);
                        GuideActivity.this.startActivity(intent);
                        GuideActivity.this.finish();
                        break;
                    case R.id.nav_home:
                        Intent intent2 = new Intent(GuideActivity.this, MainActivity.class);
                        GuideActivity.this.startActivity(intent2);
                        GuideActivity.this.finish();
                        break;
                    case R.id.nav_me:
                        Intent intent3 = new Intent(GuideActivity.this, MeActivity.class);
                        GuideActivity.this.startActivity(intent3);
                        GuideActivity.this.finish();
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
