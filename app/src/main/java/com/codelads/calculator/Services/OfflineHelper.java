package com.codelads.calculator.Services;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class OfflineHelper
{
    public static PopupWindow handlePopup(View v, View pp, int type, Context c) //give preinflated pp view, 0 is center, 1 is right
    {
        PopupWindow pw = null;

        float dim = 0.8f;
        switch (type) //0 is mid, 1 is side
        {
            case 0:
                pw = new PopupWindow(pp, LinearLayout.LayoutParams.MATCH_PARENT, 700, true);
                pw.showAtLocation(v, Gravity.CENTER, 0, 0);
                break;
            case 1:
                pw = new PopupWindow(pp, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
                pw.showAtLocation(v, Gravity.RIGHT, 0, 0);
                dim = 0.5f;
                break;
            case 2:
                pw = new PopupWindow(pp, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
                pw.showAtLocation(v, Gravity.CENTER, 0, 0);
                break;
            case 3:
                pw = new PopupWindow(pp, ((int) ((c.getResources().getDisplayMetrics().widthPixels * 0.8))), LinearLayout.LayoutParams.MATCH_PARENT, true);
                pw.showAtLocation(v, Gravity.CENTER, 0, 0);
                break;
            case 4:
                pw = new PopupWindow(pp, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                pw.showAtLocation(v, Gravity.CENTER, 0, 0);
                break;
            case 5:
                pw = new PopupWindow(pp, LinearLayout.LayoutParams.MATCH_PARENT, ((int) ((c.getResources().getDisplayMetrics().heightPixels * 0.8))), true);
                pw.showAtLocation(v, Gravity.CENTER, 0, 0);
                break;
            case 6:
                pw = new PopupWindow(pp, LinearLayout.LayoutParams.MATCH_PARENT, ((int) ((c.getResources().getDisplayMetrics().heightPixels * 0.8))), true);
                pw.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                break;
        }
        View container = pw.getContentView().getRootView();
        WindowManager wm = (WindowManager) pw.getContentView().getContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = dim; //dim enough?
        if (wm != null) wm.updateViewLayout(container, p);
        PopupWindow finalPw = pw;
        pp.setOnTouchListener((v2, event) ->
        {
            v2.performClick();
            //v.setBackgroundColor(Color.RED);
            finalPw.dismiss();
            return true;
        });
        return pw;
    }

}
