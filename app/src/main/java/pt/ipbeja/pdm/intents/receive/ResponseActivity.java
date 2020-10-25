package pt.ipbeja.pdm.intents.receive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import pt.ipbeja.pdm.intents.R;

public class ResponseActivity extends AppCompatActivity {

    public static final String DATA_EXTRA_KEY = "response_data";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        Button button = findViewById(R.id.return_data_btn);
        EditText input = findViewById(R.id.instagram_handle);

        button.setOnClickListener(v -> {
            // Vamos obter o texto inserido pelo utilizador na EditText
            String data = input.getText().toString();

            // Vamos criar um Intent vazio (servirá apenas para passar dados, não tem um "alvo")
            Intent intent = new Intent();

            // Colocamos os dados nos extras
            intent.putExtra(DATA_EXTRA_KEY, data);

            // Indicamos que a Activity irá terminar com sucesso e passamos o Intent
            setResult(RESULT_OK, intent);
            // Por fim, terminamos esta Activity e voltamos à anterior
            finish();
        });
    }
}