package com.example.ezhealth_mobile.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.ezhealth_mobile.R;

public class Camera_Activity extends AppCompatActivity {

    public static int REQUEST_FOTO = 1;
    private ImageView imageFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_);

        verificarPermissãoCamera();

        imageFoto = (ImageView) findViewById(R.id.imageFoto);

    }

    private void verificarPermissãoCamera() {
        //Verificar se a aplicação possui permissão para utilizar câmera
        //Se a permissão não tiver sido concedida, pedir ao usuário permissão
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    public void tirarFoto(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // Abrir câmera
        startActivityForResult(intent, REQUEST_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_FOTO && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap foto = (Bitmap) bundle.get("data");
            imageFoto.setImageBitmap(foto);
        }
    }
}