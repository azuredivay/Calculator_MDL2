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
    String StackOperator = "";

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

    public void NumberHandler(View v)
    {
        try
        {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter));
            String outputText = outputWin.getText().toString();
            String ButtonText = ((Button) v).getText().toString();
            if(StackNumber==0) StackNumber = Double.parseDouble(outputText);
            switch (v.getTag().toString())
            {
                case "dot":
                    if (outputText.matches("^.+?\\d$")) //change this to contains after 2nd part of operator regex
                        if(StackOperator.isEmpty() && !outputText.contains(".")) outputWin.setText(String.format("%s%s", outputText, "."));
                        else if(!StackOperator.isEmpty() && !outputText.split(String.format("%s%s","\\",StackOperator),2)[1].contains(".")) outputWin.setText(String.format("%s%s", outputText, "."));
                    break;
                case "digit":
                    if (!outputText.equals("0"))
                        outputWin.setText(String.format("%s%s", outputText, ButtonText));
                    else outputWin.setText(ButtonText);
                    break;  //
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void OperatorHandler(View v)
    {
        //if a stack operator is present, process it by getting 2nd number, if not and /check no operator in OPW, put stackoperator on top
        try
        {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_popup_enter));
            String outputText = outputWin.getText().toString();

            try
            {
                if(!StackOperator.isEmpty())
                {
                    String secondNum;
                    if(StackOperator.equals("+"))
                    {
                        secondNum = outputText.split("\\+",2)[1];
                        StackNumber = ArithmeticHelper.Add(StackNumber,secondNum);
                        StackOperator = "";
                        outputWin.setText(String.format("%s", StackNumber));
                    }
                    else if(StackOperator.equals("-"))
                    {
                        if(outputText.startsWith("-")) secondNum = outputText.split("\\-")[2];
                        else secondNum = outputText.split("\\-",2)[1]; //handle for negative number
                        StackNumber = ArithmeticHelper.Subtract(StackNumber,secondNum);
                        StackOperator = "";
                        outputWin.setText(String.format("%s", StackNumber));
                    }
                }
            }
            catch (Exception i)
            {
                i.printStackTrace();
            }

            outputText = outputWin.getText().toString();
            switch (v.getTag().toString())
            {
                case "add":
                    StackOperator = "+";
                    if(outputText.matches("^.+?\\d$"))
                    {
                        StackNumber = Double.parseDouble(outputText);
                        outputWin.setText(String.format("%s%s", outputText, "+"));
                    }
                    else outputWin.setText(String.format("%s%s", outputText.substring(0,outputText.length()-1), "+"));
                    break;
                case "subtract":
                    StackOperator = "-";
                    if(outputText.matches("^.+?\\d$"))
                    {
                        StackNumber = Double.parseDouble(outputText);
                        outputWin.setText(String.format("%s%s", outputText, "-"));
                    }
                    else outputWin.setText(String.format("%s%s", outputText.substring(0,outputText.length()-1), "-"));
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
