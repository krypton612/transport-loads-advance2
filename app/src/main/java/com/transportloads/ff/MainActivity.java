package com.transportloads.ff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ActivityOptions;
import android.app.backup.BackupManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        LinearLayout layout = findViewById(R.id.splash);
        ImageView imglight = findViewById(R.id.logoimageView);

        int nightModeFlags = getApplicationContext().getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {

            case Configuration.UI_MODE_NIGHT_YES:
                setContentView(R.layout.activity_main);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                setTheme(R.style.ThemeSegundaActivity);
                setContentView(R.layout.activity_main_light);
                break;
        }



        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        // agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animation_rotacion = AnimationUtils.loadAnimation(this, R.anim.rotacion);

        TextView textCorto = findViewById(R.id.logoResumentextView3);
        TextView textLong = findViewById(R.id.logotitletextView2);
        ImageView logo = findViewById(R.id.logoimageView);



        textCorto.setAnimation(animacion2);
        textLong.setAnimation(animacion2);




        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }


        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos

            Thread.sleep(5*1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        logo.setAnimation(animacion1);
        //logo.setAnimation(animation_rotacion);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(logo, "logoImageTrans");
                //pairs[1] = new Pair<View, String>(textLong, "textTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());

                }
                else {
                    startActivity(intent);
                    finish();
                }
            }
        }, 4000);
    }


    public void setDayNight(int mode){
        if (mode == 0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}