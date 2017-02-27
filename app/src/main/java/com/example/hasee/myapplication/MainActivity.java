package com.example.hasee.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hasee.myapplication.fragment.NO1Fragment;
import com.example.hasee.myapplication.fragment.NO2Fragment;
import com.example.hasee.myapplication.fragment.NO3Fragment;
import com.example.hasee.myapplication.fragment.NO4Fragment;

public class MainActivity extends AppCompatActivity {

    //private Fragment[] fragments=new Fragment[]{new NO1Fragment(),new NO2Fragment(),new NO3Fragment(), new NO4Fragment()};

    private LinearLayout container;

    private FragmentManager fragmentManager;

    private int[][] menuPictureResources = {{R.mipmap.ic_launcher, R.mipmap.ic_launcher},
            {R.mipmap.ic_launcher, R.mipmap.ic_launcher},
            {R.mipmap.ic_launcher, R.mipmap.ic_launcher},
            {R.mipmap.ic_launcher, R.mipmap.ic_launcher}};

    private Fragment[] fragments = new Fragment[]{new NO1Fragment(),
            new NO2Fragment(), new NO3Fragment(), new NO4Fragment()};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        fragmentManager = getFragmentManager();
        container = (LinearLayout) findViewById(R.id.menu_container);
        setTabseection(0);
    }

    /**
     * 大苏打实打实的撒
     * @param view
     */
    public void next(View view) {
        int index = Integer.parseInt(view.getTag().toString());
        setTabseection(index);
    }

   /* private void setTabseection(int index) {
        clearSelection(index);
        if (!fragments[index].isAdded()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragments[index]);
            transaction.commit();
        }
    }*/

    private void setTabseection (int index){
        clearSelection(index);
        if (!fragments[index].isAdded()) {
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.content,fragments[index]);
            transaction.commit();
        }
    }

    private void clearSelection(int index) {
        try {
            for (int i = 0; i < container.getChildCount(); i++) {
                RelativeLayout rv = (RelativeLayout) container.getChildAt(i);
                LinearLayout layout = (LinearLayout) rv.getChildAt(0);
                ImageView iv = (ImageView) layout.getChildAt(0);
                TextView tv = (TextView) layout.getChildAt(1);
                if (i != index) {
                    iv.setImageDrawable(getResources().getDrawable(
                            menuPictureResources[i][1]));
                    tv.setTextColor(Color.parseColor("#929292"));
                } else {
                    iv.setImageDrawable(getResources().getDrawable(
                            menuPictureResources[i][0]));
                    tv.setTextColor(Color.parseColor("#52A36A"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
