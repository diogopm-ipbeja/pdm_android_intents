package pt.ipbeja.pdm.intents.send;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pt.ipbeja.pdm.intents.R;

public class DataReceiverActivity extends AppCompatActivity {

    public static final String DATA_EXTRA_KEY = "text_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_receiver);

        TextView textView = findViewById(R.id.textView);

        // Deste lado, vamos obter o Intent criado na SendDataActivity e usar a chave para obter o valor colocado nos Extras.
        String data = getIntent().getStringExtra(DATA_EXTRA_KEY);
        // E podemos colocar a String numa TextView
        textView.setText(data);

    }
}