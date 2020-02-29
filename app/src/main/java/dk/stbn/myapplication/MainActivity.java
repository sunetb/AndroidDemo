
package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView velkomst;
    Button knap;
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





    }

    @Override
    public void onClick(View view) {
        System.out.println("klikket på knappen");
        inputfelt = findViewById(R.id.editText);
        String navn = inputfelt.getText().toString();
        velkomst.setText("Hej "+navn);


    }
}
