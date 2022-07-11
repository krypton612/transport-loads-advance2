package com.transportloads.ff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;

public class TermsCondActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_cond);

        Button aceptar = findViewById(R.id.aceptar_term);


        TextView showTermsAndConditions = findViewById(R.id.terms_conditions_link);
        TextView showTermsAndConditions2 = findViewById(R.id.terms_conditions_link2);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(TermsCondActivity.this, LoginAllActivity.class);
                startActivity(inten);
                finish();
            }
        });

        showTermsAndConditions2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(TermsCondActivity.this)
                        .popupAnimation(PopupAnimation.ScaleAlphaFromCenter)
                        .asCustom(new BasePopupView(TermsCondActivity.this) {
                            @Override
                            protected int getInnerLayoutId() {
                                return R.layout.activity_popup_conditions;
                            }
                        })
                        .show();
            }
        });

        showTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(TermsCondActivity.this)
                        .popupAnimation(PopupAnimation.ScaleAlphaFromCenter)
                        .asCustom(new BasePopupView(TermsCondActivity.this) {
                            @Override
                            protected int getInnerLayoutId() {
                                return R.layout.activity_popup_conditions;
                            }
                        })
                        .show();
            }
        });



    }
    @Override
    public void onBackPressed(){

        Intent intent = new Intent(TermsCondActivity.this, LoginActivity.class);
        startActivity(intent);

    }
}