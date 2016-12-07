package com.holdetc.yhu.on;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by yangchengwei on 15/10/28.
 */
public class MeActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    public static final String EXTRA_NAME = "懒懒杨";
    private DrawerLayout mDrawerLayout;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_me);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_me);
        mImageView = (ImageView) findViewById(R.id.img_me);
        final AppBarLayout appbar_me = (AppBarLayout) findViewById(R.id.appbar_me);
        appbar_me.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("change", Math.abs(i) + "--->" + appBarLayout.getHeight() + "---->" + mToolbar.getHeight());

                //滑动范围=barlayout-toolbar
//                int max = appBarLayout.getHeight() - mToolbar.getHeight();
//                int j = Math.abs(i);
//                if (j < max / 3) {
//                    mImageView.setAlpha(1f);
//                }
//
//                if (j >= max / 4 && j < max / 3) {
//                    mImageView.setAlpha(0.8f);
//                }
//
//                if (j >= max / 2 && j < 1.7) {
//                    mImageView.setAlpha(0.5f);
//                }
//
//                if (j >= max / 1.7 && j < max / 1.5) {
//                    mImageView.setAlpha(0.3f);
//                }
//
//                if (j >= max / 1.3) {
//                    mImageView.setAlpha(0f);
//                }

            }
        });


        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_me);
        collapsingToolbar.setTitle(EXTRA_NAME);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_me_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_me_view);
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
                        Intent intent = new Intent(MeActivity.this, CameraActivity.class);
                        MeActivity.this.startActivity(intent);
                        MeActivity.this.finish();
                        break;
                    case R.id.nav_home:
                        Intent intent2 = new Intent(MeActivity.this, MainActivity.class);
                        MeActivity.this.startActivity(intent2);
                        MeActivity.this.finish();
                        break;
                    case R.id.nav_guide:
                        Intent intent3 = new Intent(MeActivity.this,GuideActivity.class);
                        MeActivity.this.startActivity(intent3);
                        MeActivity.this.finish();
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
