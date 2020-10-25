package pt.ipbeja.pdm.intents.receive;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pt.ipbeja.pdm.intents.R;

public class RequestActivity extends AppCompatActivity {

    private static final int DATA_REQUEST_CODE = 1000;

    private TextView dataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        // Neste exemplo esta Activity vai pedir à ResponseActivity que lhe devolva um resultado.

        // Obter as referências para as Views que precisamos
        this.dataTextView = findViewById(R.id.data_text);
        Button button = findViewById(R.id.request_data_btn);

        // Colocar um listener no botão
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, ResponseActivity.class);

            // Desta vez vamos passar um request code e utilizar o método startActivityForResult
            // O request code vai identificar o pedido (desta Activity)
            startActivityForResult(intent, DATA_REQUEST_CODE); // Ver ResponseActivity
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data/* Aqui vêm os dados devolvidos pela 2a activity*/) {
        // Quando a ResponseActivity for terminada, este método será invocado.

        // Primeiro, precisamos de filtrar o pedido utilizando o request code definido
        if(requestCode == DATA_REQUEST_CODE) {
            // Se o utilizador terminou a operação correctamente..
            if(resultCode == RESULT_OK) {
                // Podemos obter a String presente nos extras do Intent
                String dataString = data.getStringExtra(ResponseActivity.DATA_EXTRA_KEY);
                // E colocá-la numa TextView
                this.dataTextView.setText(dataString);
            }
            else {
                // Caso o utilizador tenha cancelado a acção (voltando atrás), podemos mostrar uma mensagem utilizando um Toast.
                Toast.makeText(this, "Action cancelled by user", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            // Se não for nenhum dos request codes que estamos interessados em tratar, devemos invocar o super
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}