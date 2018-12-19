package com.example.sujith.graphical_password;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class new_password_screen extends AppCompatActivity {

    ArrayList<Bitmap> chunkedImag;

    ImageView img_v11p;
    ImageView img_v21p;
    ImageView img_v31p;
    ImageView img_v41p;
    ImageView img_v51p;
    ImageView img_v61p;
    ImageView img_v71p;
    ImageView img_v81p;
    ImageView img_v91p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password_screen);

        Bundle b=getIntent().getExtras();
        chunkedImag=b.getParcelableArrayList("image chunks");

        img_v11p=findViewById(R.id.img_v11);
        img_v21p=findViewById(R.id.img_v21);
        img_v31p=findViewById(R.id.img_v31);
        img_v41p=findViewById(R.id.img_v41);
        img_v51p=findViewById(R.id.img_v51);
        img_v61p=findViewById(R.id.img_v61);
        img_v71p=findViewById(R.id.img_v71);
        img_v81p=findViewById(R.id.img_v81);
        img_v91p=findViewById(R.id.img_v91);

        img_v11p.setImageBitmap(chunkedImag.get(0));
        img_v21p.setImageBitmap(chunkedImag.get(1));
        img_v31p.setImageBitmap(chunkedImag.get(2));
        img_v41p.setImageBitmap(chunkedImag.get(3));
        img_v51p.setImageBitmap(chunkedImag.get(4));
        img_v61p.setImageBitmap(chunkedImag.get(5));
        img_v71p.setImageBitmap(chunkedImag.get(6));
        img_v81p.setImageBitmap(chunkedImag.get(7));
        img_v91p.setImageBitmap(chunkedImag.get(8));




    }
}
