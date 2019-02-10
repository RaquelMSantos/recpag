package br.com.rmso.recpag.view;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import br.com.rmso.recpag.R;

public class ReceiveActivity extends AppCompatActivity {

    Button qrcodeButton;
    EditText valueEditText;
    ImageView qrcodeImageView;

    String input;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        qrcodeButton = findViewById(R.id.btn_qrCode);
        valueEditText = findViewById(R.id.et_value);
        qrcodeImageView = findViewById(R.id.img_qrCode);

        qrcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = valueEditText.getText().toString().trim();

                QRGEncoder qrgEncoder = new QRGEncoder(input, null,
                        QRGContents.Type.TEXT, 100);

                try {
                    bitmap = qrgEncoder.encodeAsBitmap();
                    qrcodeImageView.setImageBitmap(bitmap);
                } catch (WriterException e) {

                }
            }
        });
    }
}
