package com.example.hp.investosurestart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import static com.example.hp.investosurestart.R.drawable.back;


public class HomePage extends AppCompatActivity implements homepagecommu{

    ViewPager viewPager;
    ActionBar actionbar1;
    Toolbar toolbar1;


    BottomNavigationView bottomNavigationView;
    ImageView icon1;
    ImageView icon2;
    ImageView icon3;
    ImageView icon4;
    FragmentManager fragmentManager=getSupportFragmentManager();
    LinearLayout internet_checker;
    Home_fragment home_frag;
    Profile_Fragment p_frag;
    Profile_Fragment profile_frag=new Profile_Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Display display = getWindowManager().getDefaultDisplay();
        internet_checker=(LinearLayout)findViewById(R.id.internet_checker_layout);
       // Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width1 = size.x;
        Toast.makeText(HomePage.this,""+width1,Toast.LENGTH_SHORT).show();
        int height = size.y;


        //  viewPager = (ViewPager) findViewById(R.id.pager);
        // setupViewPager(viewPager);
     //   Home_fragment home_fragment=new Home_fragment();
        // viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
       // FragmentTransaction transaction2=fragmentManager.beginTransaction();
         //    transaction2.replace(R.id.home_layout_fragment,home_fragment,"homepage");

           //      transaction2.commit();

        Home_fragment f1=new Home_fragment();

        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.home_layout_fragment,f1,"homepage");

        transaction.commit();







        icon1 = (ImageView) findViewById(R.id.icon_1);


        icon2 = (ImageView) findViewById(R.id.icon_2);

        icon3 = (ImageView) findViewById(R.id.icon_3);


        icon4 = (ImageView) findViewById(R.id.icon_4);


        icon1.setImageResource(R.drawable.ic_home_orange_24dp);
        icon2.setImageResource(R.drawable.icon2_gray);
        icon3.setImageResource(R.drawable.icon3_gray);
        icon4.setImageResource(R.drawable.icon4_gray);}

























    public  void icon1_click(View v){
    icon1.setImageResource(R.drawable.ic_home_orange_24dp);
    icon2.setImageResource(R.drawable.icon2_gray);
    icon3.setImageResource(R.drawable.icon3_gray);
    icon4.setImageResource(R.drawable.icon4_gray);
  /*  Home_fragment home_fragment=new Home_fragment();
    FragmentTransaction transaction2=fragmentManager.beginTransaction();
    transaction2.replace(R.id.home_layout_fragment,home_fragment,"homepage");

    transaction2.commit();*/
 selectItem(0);

}



    public  void icon2_click(View v){
        icon1.setImageResource(R.drawable.ic_home_black_24dp);
        icon2.setImageResource(R.drawable.icon2);
        icon3.setImageResource(R.drawable.icon3_gray);
        icon4.setImageResource(R.drawable.icon4_gray);
        selectItem(1);
    }

    public  void icon3_click(View v){
        icon1.setImageResource(R.drawable.ic_home_black_24dp);
        icon2.setImageResource(R.drawable.icon2_gray);
        icon3.setImageResource(R.drawable.icon3);
        icon4.setImageResource(R.drawable.icon4_gray);
        selectItem(2);

    }
    public  void icon4_click(View v){


        icon1.setImageResource(R.drawable.ic_home_black_24dp);
        icon2.setImageResource(R.drawable.icon2_gray);
        icon3.setImageResource(R.drawable.icon3_gray);
        icon4.setImageResource(R.drawable.icon4);

        selectItem(3);

    }


    public void selectItem(int position) {
        // update the main content by replacing fragments
        switch (position){
            case 0:
            {   Home_fragment f2=(Home_fragment) fragmentManager.findFragmentByTag("homepage");
            FragmentTransaction transaction1=fragmentManager.beginTransaction();
                if(f2!=null){
                    transaction1.remove(f2);

                    transaction1.commit();
                    Toast.makeText(HomePage.this, "remove", Toast.LENGTH_SHORT).show();}
                    Home_fragment f_new=(Home_fragment) fragmentManager.findFragmentByTag("homepage");
                    if(f_new!=null){
                    FragmentTransaction transaction_new=fragmentManager.beginTransaction();
                    transaction_new.detach(f_new);
                        transaction_new.commit();
                        Toast.makeText(HomePage.this, "detach", Toast.LENGTH_SHORT).show();
                    }


                Home_fragment f1=new Home_fragment();

               FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.home_layout_fragment,f1,"homepage");

                transaction.commit();
                break;
            }
            case 1:
            {
                Profile_Fragment f1=new Profile_Fragment();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.home_layout_fragment,f1,"profile");

                transaction.commit();
                break;
            }
            case 2:
            {Learn_frag f1=new Learn_frag();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.home_layout_fragment,f1,"learn");

                transaction.commit();
                break;
            }
            case 3:
            {Notification_frag f1=new Notification_frag();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.home_layout_fragment,f1,"notification");

                transaction.commit();
                break;
            }





        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        if(isNetworkAvailable()) {
            //  Toast.makeText(HomePage.this,"newtwork availble",Toast.LENGTH_SHORT).show();
            ViewGroup.LayoutParams params=internet_checker.getLayoutParams();

            params.width=720;
            params.height=0;
            internet_checker.setLayoutParams(params);
        }
        else
        {
            //  Toast.makeText(HomePage.this,"newtwork not availble",Toast.LENGTH_SHORT).show();
            ViewGroup.LayoutParams params=internet_checker.getLayoutParams();
            params.width=720;
            params.height=50;
            internet_checker.setLayoutParams(params);
        }
    }
    @Override
    public void respond_homepage() {
        icon1.setImageResource(R.drawable.ic_home_orange_24dp);
        icon2.setImageResource(R.drawable.icon2_gray);
        icon3.setImageResource(R.drawable.icon3_gray);
        icon4.setImageResource(R.drawable.icon4_gray);
        Home_fragment f2=(Home_fragment) fragmentManager.findFragmentByTag("homepage");
        FragmentTransaction transaction1=fragmentManager.beginTransaction();
        if(f2!=null){
            transaction1.remove(f2);

            transaction1.commit();
            Toast.makeText(HomePage.this, "remove", Toast.LENGTH_SHORT).show();}
        Home_fragment f_new=(Home_fragment) fragmentManager.findFragmentByTag("homepage");
        if(f_new!=null){
            FragmentTransaction transaction_new=fragmentManager.beginTransaction();
            transaction_new.detach(f_new);
            transaction_new.commit();
            Toast.makeText(HomePage.this, "detach", Toast.LENGTH_SHORT).show();
        }


        Home_fragment f1=new Home_fragment();

        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.home_layout_fragment,f1,"homepage");

        transaction.commit();

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }


}





















