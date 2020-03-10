
package dk.stbn.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView velkomst, status, point;
    Button knap, knap2;
    EditText inputfelt;
    GætTal spil = new GætTal();
    ImageView i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        System.out.println("hejsa");
        if (savedInstanceState != null)
            System.out.println("Velkommen tilbage fra skærmvendig");
        else System.out.println("Velkommen til ny frisk aktivitet");


        velkomst = findViewById(R.id.overskrift);
        status = findViewById(R.id.statusfelt);
        point = findViewById(R.id.pointtal);
        i = findViewById(R.id.imageView);



        knap = findViewById(R.id.knap);
        knap2 = findViewById(R.id.knap2);
        knap.setOnClickListener(this);
        knap2.setOnClickListener(this); //samme onclicklistener

        inputfelt = findViewById(R.id.editText);

        spil.nulstil();
        spil.setMax(1000);

        velkomst.setText("Velkommen til GÆT ET TAL! (1-"+spil.getMax()+")");


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        System.out.println("onSave..."+ velkomst.getText().toString());
        outState.putString("velkomst", velkomst.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ondestroy");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("OnRestore..." + savedInstanceState.getString("velkomst"));
    }

    @Override
    public void onClick(View view) { //view er det view som blev trykket på
        if(view == knap) {
            System.out.println("klikket på knap1");
            String tal = inputfelt.getText().toString();
            int gættal = Integer.parseInt(tal);

            spil.gæt(gættal);

            opdater();

        }
        else if (view == knap2){
            //i.setImageResource(R.drawable.ic_launcher_background);

            Intent hensigt = new Intent(this, Indstillinger.class);
            hensigt.putExtra("besked","Hej fra mainactivity" );

            startActivity(hensigt);

           // System.out.println("Der blev klikket på knap2");
        }

    }

    private void opdater() {
        velkomst.setText("Velkommen til GÆT ET TAL! (1-"+spil.getMax()+")");
        point.setText(spil.getScore() + " Antal gæt: "+spil.getAntalGæt());
        if(spil.gættetRigtigt())
            status.setText("Hurra! Godt gættet!");
        else if (spil.gættetVarForHøjt())
            status.setText("Du gættede for højt! Prøv igen");
        else
            status.setText("Du gættede for lavt! Prøv igen");

    }
}
