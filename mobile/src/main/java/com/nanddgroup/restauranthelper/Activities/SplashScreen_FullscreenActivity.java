package com.nanddgroup.restauranthelper.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nanddgroup.restauranthelper.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen_FullscreenActivity extends AppCompatActivity {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen__fullscreen);

        mContentView = findViewById(R.id.fullscreen_content);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        new Timer().schedule(new MyTimerTask(), 3000);
    }





    class MyTimerTask extends TimerTask {
        MyTimerTask() {
        }

        public void run() {
            SplashScreen_FullscreenActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    SplashScreen_FullscreenActivity.this
                            .startActivity(new Intent(SplashScreen_FullscreenActivity
                                    .this.getApplicationContext(), MainActivity.class));
                    SplashScreen_FullscreenActivity.this.finish();
                }
            });
        }
    }
}
