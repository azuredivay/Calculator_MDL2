package com.codelads.calculator.Services;

import android.os.AsyncTask;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class OnlineHelper
{
    //private static Gson gson = new Gson();
    public static class GetJSONfromURL extends AsyncTask<String,Void,String>
    {
        StringBuilder toret = new StringBuilder("");
        @Override protected String doInBackground(String... url)
        {
            try
            {
                BufferedReader bin = new BufferedReader(new InputStreamReader(new URL("http://10.0.2.2/"+url[0].replace(" ","%20")).openStream()));
                String bfr = "";
                while((bfr=bin.readLine())!=null) //else it'll skip values by 2
                {
                    toret.append(bfr);
                }
            }
            catch (Exception ignore){}
            return toret.toString();
        }

        @Override protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
        }
    }

}
