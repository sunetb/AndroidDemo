
package dk.stbn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hejsa");

        TextView velkomst = findViewById(R.id.sune);

        velkomst.setText("Ny tekst");

        Button knap = findViewById(R.id.knap);

        knap.setOnClickListener(this);
        MitObj o = new MitObj();

        velkomst.setText("Tallet er "+o.getTal());




    }

    @Override
    public void onClick(View view) {
        System.out.println("klikket på knappen");
        EditText inputfelt = findViewById(R.id.editText);
        String navn = inputfelt.getText().toString();
        TextView velkomst = findViewById(R.id.sune);
        velkomst.setText("Hej "+navn);


    }
}
