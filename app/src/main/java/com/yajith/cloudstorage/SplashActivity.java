package com.yajith.cloudstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO,Manifest.permission.MANAGE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 100:
                if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            SplashActivity.this.finish();
                            startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        }
                    },1000);
                }
                else
                {
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},100);
                }break;
        }
    }
}