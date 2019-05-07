package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etAmt;
    EditText etPax;
    ToggleButton tbGST;
    TextView tvTotal;
    TextView tvAmtPax;
    Button btnCalc;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmt = findViewById(R.id.etAmt);
        etPax = findViewById(R.id.etPax);
        tbGST = findViewById(R.id.tbGST);
        tvTotal = findViewById(R.id.tvTotal);
        tvAmtPax = findViewById(R.id.tvAmtPax);
        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);

        tbGST.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                // Add your code for the action
            if (tbGST.isChecked()) {
                tbGST.setEnabled(true);
            }
            else {
                tbGST.setEnabled(true);
            }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                Double amt = Double.parseDouble(etAmt.getText().toString());
                Integer pax = Integer.parseInt(etPax.getText().toString());

                if (tbGST.isChecked()) {
                  Double totalAmt = (amt * 1.07) * 1.10;
                  Double amtPax = totalAmt / pax;

                    String valAmt = String.format("%.2f",totalAmt);
                    String valPax = String.format("%.2f", amtPax);

                    tvTotal.setText(valAmt);
                    tvAmtPax.setText(valPax);

                } else {
                    Double totalAmt = amt;
                    Double amtPax = amt / pax;

                    String valAmt = String.format("%.2f",totalAmt);
                    String valPax = String.format("%.2f", amtPax);

                    tvTotal.setText(valAmt);
                    tvAmtPax.setText(valPax);
                }
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                tvTotal.setText("");
                tvAmtPax.setText("");
                etAmt.setText("");
                etPax.setText("");
            }
        });

    }
}
