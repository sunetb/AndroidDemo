
package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView velkomst;
    Button knap, knap2;
    EditText inputfelt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hejsa");

        velkomst = findViewById(R.id.sune);

        velkomst.setText("Ny tekst");

        knap = findViewById(R.id.knap);

        knap.setOnClickListener(this);
        knap2.setOnClickListener(this); //samme onclicklistener

        inputfelt = findViewById(R.id.editText);




    }

    @Override
    public void onClick(View view) { //view er det view som blev trykket på

        if(view == knap) {
            System.out.println("klikket på knap1");
            String navn = inputfelt.getText().toString();
            velkomst.setText("Hej " + navn);
        }
        else if (view == knap2){
            System.out.println("Der blev klikket på knap2");
        }

    }
}
