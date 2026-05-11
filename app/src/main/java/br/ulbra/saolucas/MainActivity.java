package br.ulbra.saolucas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editPeso = findViewById(R.id.editPeso);
        EditText editConsumido = findViewById(R.id.editConsumido);
        RadioGroup rgAtividade = findViewById(R.id.rgAtividade);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        TextView txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strPeso = editPeso.getText().toString();
                String strConsumo = editConsumido.getText().toString();

                if (!strPeso.isEmpty() && !strConsumo.isEmpty()) {
                    double peso = Double.parseDouble(strPeso);
                    int jaBebido = Integer.parseInt(strConsumo);
                    int extra = 0;


                    int selecionado = rgAtividade.getCheckedRadioButtonId();
                    if (selecionado == R.id.rbModerado) {
                        extra = 300;
                    } else if (selecionado == R.id.rbIntenso) {
                        extra = 600;
                    }


                    int consumoTotal = (int) (peso * 35) + extra;
                    int restante = consumoTotal - jaBebido;


                    if (restante < 0) restante = 0;


                    txtResultado.setText(String.format("Meta Diária: %d ml\nFaltam: %d ml para o objetivo.",
                            consumoTotal, restante));
                } else {
                    txtResultado.setText("Por favor, preencha todos os campos.");
                }
            }
        });
    }
}