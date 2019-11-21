package com.example.hp.investosurestart;


import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements commu_login{
 // FragmentManager Manager_text=getFragmentManager();
  //  FragmentManager manager_button=getFragmentManager();
FragmentManager fragmentManager=getFragmentManager();
    TextView textView;
    CardView cardView_login;
    CardView cardview_sinup;
    float twelveDp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
     //for text over ther. login and sinup button
         twelveDp = TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 5,
                this.getResources().getDisplayMetrics() );
cardView_login=(CardView)findViewById(R.id.login_button);

        cardview_sinup=(CardView)findViewById(R.id.sinup_button);

      // for sinup and login button

cardView_login.setBackgroundColor(getResources().getColor(R.color.colororange));
       Login_Frag login_frag=new Login_Frag();
        FragmentTransaction transaction_login=fragmentManager.beginTransaction();
        transaction_login.replace(R.id.login_frag_layout,login_frag,"login");

        transaction_login.commit();

        Signup_Frag signup_frag =new Signup_Frag();
        FragmentTransaction transaction_sinup=fragmentManager.beginTransaction();
        transaction_sinup.replace(R.id.login_frag_layout, signup_frag,"sinup");
      //  Threads t=new Threads(Login_Activity.this);
        //t.run();
    }







    public void button_login(View v){
        cardview_sinup.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        cardView_login.setBackgroundColor(getResources().getColor(R.color.colororange));

        Login_Frag f1;
        f1=(Login_Frag) fragmentManager.findFragmentByTag("login");
        if(f1!=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.login_frag_layout,f1,"login");

            transaction.commit();

        }
       else {
            f1 = new Login_Frag();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.login_frag_layout, f1, "login");

            transaction.commit();
        }


    }
    public void button_sinup(View v){
        Signup_Frag f2;
        cardview_sinup.setBackgroundColor(getResources().getColor(R.color.colororange));
        cardView_login.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        f2=(Signup_Frag) fragmentManager.findFragmentByTag("sinup");
        if(f2!=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.login_frag_layout,f2,"sinup");

            transaction.commit();
            Toast.makeText(Login_Activity.this, "exict", Toast.LENGTH_SHORT).show();

        }
        else{
        Signup_Frag f1=new Signup_Frag();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.login_frag_layout,f1,"sinup");

        transaction.commit();}
    }


    @Override
    public void respond_login() {

    }
    public  void skip_login(View v){

        Intent i=new Intent(Login_Activity.this,HomePage.class);
        startActivity(i);



    }
}
