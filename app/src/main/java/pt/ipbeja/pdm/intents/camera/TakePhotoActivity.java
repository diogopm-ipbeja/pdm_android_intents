package pt.ipbeja.pdm.intents.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import pt.ipbeja.pdm.intents.R;

public class TakePhotoActivity extends AppCompatActivity {

    private static final int TAKE_PHOTO_REQUEST_CODE = 2000;

    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        this.photo = findViewById(R.id.imageView);
    }

    public void onTakePhoto(View view) {
        // Aqui vamos lançar um Intent implícito. Vamos indicar a acção que queremos tomar e não qual a Activity a lançar.
        // Neste caso, queremos pedir ao sistema operativo que nos disponibilize uma forma de tirar uma fotografia

        // Para isso criamos um Intent com a acção
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // E lançamos o Intent à espera de um resultado e com o código de pedido
        startActivityForResult(intent, TAKE_PHOTO_REQUEST_CODE);

        // [Importante] Se a sua aplicação estiver a crashar quando tenta tirar uma fotografia, veja o ficheiro AndroidManifest.xml deste projeto
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == TAKE_PHOTO_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                // Se for o código que estamos à espera e tiver sido bem sucedido
                // Vamos obter a fotografia (na verdade, apenas o thumbnail), da seguinte forma
                Bitmap bitmap = data.getParcelableExtra("data");
                // Obtido o bitmap do thumbnail, podemos colocá-lo numa ImageView
                this.photo.setImageBitmap(bitmap);
            }
            else {
                Toast.makeText(this, "Action cancelled by user.", Toast.LENGTH_SHORT).show();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}