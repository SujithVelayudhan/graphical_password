package com.example.sujith.graphical_password;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class page1 extends AppCompatActivity {

    //Getting the source image to split
    ImageView image;
    Button butt_logp,set_passp;

    int lock=0,combination=1593;

    ArrayList<Bitmap> chunkedImages;


    int chunkNumbers=9;
    ImageView img_v1p;
    ImageView img_v2p;
    ImageView img_v3p;
    ImageView img_v4p;
    ImageView img_v5p;
    ImageView img_v6p;
    ImageView img_v7p;
    ImageView img_v8p;
    ImageView img_v9p;



    //invoking method to split the source image


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);



        ImageView image = (ImageView) findViewById(R.id.img_v);
        set_passp=findViewById(R.id.set_pass);

        img_v1p=findViewById(R.id.img_v11);
        img_v2p=findViewById(R.id.img_v21);
        img_v3p=findViewById(R.id.img_v31);
        img_v4p=findViewById(R.id.img_v41);
        img_v5p=findViewById(R.id.img_v51);
        img_v6p=findViewById(R.id.img_v61);
        img_v7p=findViewById(R.id.img_v71);
        img_v8p=findViewById(R.id.img_v81);
        img_v9p=findViewById(R.id.img_v91);

        butt_logp=findViewById(R.id.butt_log);







        int rows,cols;

        //For height and width of the small image chunks
        int chunkHeight,chunkWidth;

        //To store all the small image chunks in bitmap format in this list
        chunkedImages = new ArrayList<Bitmap>();


        //Getting the scaled bitmap of the source image
        BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = (int) Math.sqrt(chunkNumbers);
        chunkHeight = bitmap.getHeight()/rows;
        chunkWidth = bitmap.getWidth()/cols;

        //xCoord and yCoord are the pixel positions of the image chunks

        int yCoord = 0;
        for(int x=0; x<rows; x++){
            int xCoord = 0;
            for(int y=0; y<cols; y++){
                chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));


                xCoord += chunkWidth;

            }
            yCoord += chunkHeight;
        }



            img_v1p.setImageBitmap(chunkedImages.get(0));
            img_v2p.setImageBitmap(chunkedImages.get(1));
            img_v3p.setImageBitmap(chunkedImages.get(2));
            img_v4p.setImageBitmap(chunkedImages.get(3));
            img_v5p.setImageBitmap(chunkedImages.get(4));
            img_v6p.setImageBitmap(chunkedImages.get(5));
            img_v7p.setImageBitmap(chunkedImages.get(6));
            img_v8p.setImageBitmap(chunkedImages.get(7));
            img_v9p.setImageBitmap(chunkedImages.get(8));

            img_v1p.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    lock=lock*10+1;

                }
            });
            img_v2p.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    lock=lock*10+2;

                }
            });

        img_v3p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+3;

            }
        });
        img_v4p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+4;

            }
        });
        img_v5p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+5;

            }
        });
        img_v6p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+6;

            }
        });
        img_v7p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+7;

            }
        });
        img_v8p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+8;

            }
        });
        img_v9p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                lock=lock*10+9;

            }
        });

        butt_logp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (lock==combination)
                {
                    Toast.makeText(page1.this, "Login Success",
                            Toast.LENGTH_SHORT).show();
                    lock=0;

                    Intent in=new Intent(page1.this,page2.class);
                    startActivity(in);

                }
                else
                {
                    Toast.makeText(page1.this, "Wrong Pattern",
                            Toast.LENGTH_SHORT).show();
                    lock=0;
                }
            }
        });


        set_passp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent top=new Intent(page1.this,new_password_screen.class);
                top.putParcelableArrayListExtra("image chunks", chunkedImages);
                startActivity(top);



            }
        });








    }


}



