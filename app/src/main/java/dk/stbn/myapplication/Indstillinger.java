package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Indstillinger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indstillinger);
        String s = getIntent().getStringExtra("besked");
        System.out.println(s);
        //nyt intent
        // putExtra med nyt maximum
        // starte main

    }

}
