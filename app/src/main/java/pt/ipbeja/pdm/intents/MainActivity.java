package pt.ipbeja.pdm.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import pt.ipbeja.pdm.intents.browser.BrowserAppActivity;
import pt.ipbeja.pdm.intents.camera.TakePhotoActivity;
import pt.ipbeja.pdm.intents.receive.RequestActivity;
import pt.ipbeja.pdm.intents.send.SendDataActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Intent intent = null;
        if(view.getId() == R.id.send_data_btn) {
            intent = new Intent(this, SendDataActivity.class);
        }
        else if(view.getId() == R.id.receive_data_btn) {
            intent = new Intent(this, RequestActivity.class);
        }
        else if(view.getId() == R.id.take_photo_btn) {
            intent = new Intent(this, TakePhotoActivity.class);
        }
        else if(view.getId() == R.id.open_browser_btn) {
            intent = new Intent(this, BrowserAppActivity.class);
        }

        startActivity(intent);
    }
}