package pt.ipbeja.pdm.intents.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import pt.ipbeja.pdm.intents.R;

public class BrowserAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_app);

        Button btn = findViewById(R.id.launch_btn);
        EditText instagramInput = findViewById(R.id.instagram_handle);

        btn.setOnClickListener(v -> {

            String ig = instagramInput.getText().toString();
            goToInstagramProfile(ig);


        });
    }

    private void goToInstagramProfile(String igUser) {
        Uri uri;
        try {
            // Se a linha abaixo não resultar num erro (a aplicação existe neste dispositivo)...
            ApplicationInfo info = getPackageManager().getApplicationInfo("com.instagram.android", 0);
            // Vamos usar o url da aplicação para criar um URI
            uri = Uri.parse("https://instagram.com/_u/" + igUser);
        } catch (PackageManager.NameNotFoundException e) {
            // Caso contrário, teremos de lançar o browser para ver o perfil do utilizador
            uri = Uri.parse("https://instagram.com/" + igUser);
        }

        // Neste caso, também vamos lançar um intent implicito com a acção ACTION_VIEW e o URI definido
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}