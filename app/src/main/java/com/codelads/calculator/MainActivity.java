package com.codelads.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;

import com.codelads.calculator.Services.OfflineHelper;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity
{

    @Override protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.maintheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MainClickHandler(View v)
    {
        try
        {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter));
            switch (v.getTag().toString())
            {
                case "history":
                    OfflineHelper.handlePopup(v, LayoutInflater.from(this).inflate(R.layout.historypopup,null),1,this);
                    break;
                case "account":
                    OfflineHelper.handlePopup(v, LayoutInflater.from(this).inflate(R.layout.historypopup,null),5,this);
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
