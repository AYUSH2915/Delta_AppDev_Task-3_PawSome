package com.example.pawsome;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView1;
    TextView textView,textView2;
    private String url,name,height,weight,temperament,country,breed_type,bred_for,lifespan;

    Context context1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context1=MainActivity2.this;

        setContentView(R.layout.activity_main2);
        imageView1=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        getData();
        setData();

    }
    private void getData() {
        if (getIntent().hasExtra("url") && getIntent().hasExtra("name")) {
            url = getIntent().getStringExtra("url");
            name = getIntent().getStringExtra("name");
            height=getIntent().getStringExtra("height");
            weight=getIntent().getStringExtra("weight");
            lifespan=getIntent().getStringExtra("lifespan");
            temperament=getIntent().getStringExtra("temperament");
            country=getIntent().getStringExtra("country");
            breed_type=getIntent().getStringExtra("breed_type");
            bred_for=getIntent().getStringExtra("bred_for");









        } else {
            Toast.makeText(this, "Error Occured", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        textView.setText(name);
        textView2.setText("⭕️Height(cms) : "+height+",   ⭕️Weight(kgs) : "+weight+",   ⭕️Lifespan(years) : "+lifespan+",   ⭕️Temperament : "+temperament+",   ⭕️Breed Type : "+breed_type+",   ⭕️Breeding Pourpose: "+bred_for+",   ⭕️Country Of Origin : "+country);
        Glide.with(context1).load(url).into(imageView1);

    }

}