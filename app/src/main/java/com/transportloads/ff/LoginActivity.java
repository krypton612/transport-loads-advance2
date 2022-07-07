package com.transportloads.ff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button facebook_login = findViewById(R.id.facebook);


        Button showLoginOptions = findViewById(R.id.conemail);
        showLoginOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        LoginActivity.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.popup_selector_login,
                                (LinearLayout)findViewById(R.id.login_selector)
                        );
                bottomSheetView.findViewById(R.id.login_telefono).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, TermsCondActivity.class);
                        startActivity(intent);
                        bottomSheetDialog.dismiss();
                        finish();
                    }
                });
                bottomSheetView.findViewById(R.id.login_email).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, TermsCondActivity.class);
                        startActivity(intent);
                        bottomSheetDialog.dismiss();
                        finish();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

    }
    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    @Override
    public void onBackPressed(){

        LoginActivity.this.finishAffinity ();

    }



    public void event(TextView label){
        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // login facebook

                Toast.makeText(LoginActivity.this, "Remplazar por tu codigo", Toast.LENGTH_LONG).show();


            }
        });
    }
}