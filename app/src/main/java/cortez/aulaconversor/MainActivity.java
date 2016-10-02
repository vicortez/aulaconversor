package cortez.aulaconversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    public void finish(){
        super.finish();
    }

    private float toCel(float fah) {
        float cel = (fah - 32) * 5 / 9;
        return cel;
    }

    private float toFah(float cel) {
        float fah = (cel * 9 / 5) + 32;
        return fah;
    }

    private Button converter;
    private EditText temp;
    private RadioGroup radiogroup;
    private RadioButton cel;
    private RadioButton fah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //recebe algo de outra classe e trata
        Bundle extra = getIntent().getExtras();
        String m1 = extra.getString("mensagem1");

        if (m1 != null){
            setContentView(R.layout.activity_main);

        converter = (Button) findViewById(R.id.button1);
        temp = (EditText) findViewById(R.id.temptext);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        cel = (RadioButton) findViewById(R.id.radioButton);
        fah = (RadioButton) findViewById(R.id.radioButton2);
        }

    }

    public void onClick(View v){

        int op = v.getId();
        if (op == findViewById(R.id.button1).getId()) {
            System.out.println("heloo");

            if (temp.getText().length() == 0) {
                Toast t = Toast.makeText(this, "Entre com um numero valido",
                        Toast.LENGTH_LONG);
                t.show();
                return;
            }


            float value = Float.parseFloat(temp.getText().toString());
            float conv = 0.0f;
            String resul;
            if (cel.isChecked()) {
                conv = toFah(value);
                resul = String.valueOf(conv);
                temp.setText(resul);
                cel.setChecked(false);
                fah.setChecked(true);
            } else if (fah.isChecked()) {
                conv = toCel(value);
                resul = String.valueOf(conv);
                temp.setText(resul);
                fah.setChecked(false);
                cel.setChecked(true);
            } else {
                //cria uma telinha quadrada cinza que aparece no canto da tela, usado para dar avisos
                Toast t = Toast.makeText(this, "selecione um", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }


}
