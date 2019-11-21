package com.example.hp.investosurestart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView=(TextView)findViewById(R.id.data);

        String s=getIntent().getStringExtra("data").toString();
        textView.setText(s);
    }
}
