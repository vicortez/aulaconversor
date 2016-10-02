package cortez.aulaconversor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by victo on 20/09/2016.
 */
public class Tela extends AppCompatActivity {

    private Button botaoInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela);

        botaoInicial = (Button) findViewById(R.id.botaoinicial);

    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.botaoinicial:
                Intent com1 = new Intent(this, MainActivity.class);
                com1.putExtra("mensagem1", "Chamando a activity 1");
                com1.putExtra("mensagem2", "Chamando a activity 2");
                startActivity(com1);
                break;
        }
    }

}
