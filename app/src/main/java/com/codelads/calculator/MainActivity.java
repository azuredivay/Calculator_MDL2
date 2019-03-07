package com.codelads.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.codelads.calclibrary.ArithmeticHelper;
import com.codelads.calculator.Services.OfflineHelper;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity
{
    TextView outputWin = null;
    double StackNumber = 0;
    @Override protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.maintheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputWin = findViewById(R.id.outputwindow);
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

    public void MathsClickHandler(View v) {
        try {
            String outputText = outputWin.getText().toString();
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter));
            String ButtonText = ((Button) v).getText().toString();
            switch (v.getTag().toString()) {
                case "add":
                    if (StackNumber == 0) StackNumber = Double.parseDouble(outputText);
                    else StackNumber = ArithmeticHelper.Add(StackNumber, outputText);
                    if (!outputText.endsWith("+"))
                        outputWin.setText(String.format("%s%s", outputText, "+"));
                    break;
                case "subtract":
                    break;
                case "dot":
                    if (!outputText.contains("."))
                        outputWin.setText(String.format("%s%s", outputText, "."));
                    break;
                case "digit":
                    if (!outputText.equalsIgnoreCase("0"))
                        outputWin.setText(String.format("%s%s", outputText, ButtonText));
                    else outputWin.setText(ButtonText);
                    break;  //
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
