package pt.ipbeja.pdm.intents.send;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import pt.ipbeja.pdm.intents.R;

public class SendDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        // Obter referências para as Views definidas no layout
        EditText dataInput = findViewById(R.id.instagram_handle);
        Button button = findViewById(R.id.send_data_btn);

        // Colocar um listener no botão
        button.setOnClickListener(view -> {
            // Quando o botão for pressionado, vamos buscar o text na EditText
            String data = dataInput.getText().toString();

            // Criamos um Intent com a class da Activity que queremos lançar
            Intent intent = new Intent(this, DataReceiverActivity.class);

            // Colocamos no Intent os dados a enviar nos extras com uma chave única (idealmente definida na class alvo)
            intent.putExtra(DataReceiverActivity.DATA_EXTRA_KEY, data);
            // Lançar a activity usando o intent
            startActivity(intent); // Ver DataReceiverActivity
        });
    }
}