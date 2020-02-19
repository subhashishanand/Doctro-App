package com.example.compilingprojects;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {



    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageUrls2 = new ArrayList<>();
    CircleImageView consult;
    CircleImageView subscription;
    CircleImageView appointment;
    ImageView referButton;
   // AutoCompleteTextView city;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
//        This is the trail for github
//        ArrayAdapter<String> locationadapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cityHint);
//        city.setAdapter(locationadapter);
//        city.setThreshold(1);





        //Location
        //
        //
        //        //Location Ends

        consult = (CircleImageView) findViewById(R.id.consult);
        subscription = (CircleImageView) findViewById(R.id.subscription) ;
        appointment = (CircleImageView) findViewById(R.id.appointment);
        referButton = (ImageView) findViewById(R.id.referButton);
        referButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, shareActivity.class);
                startActivity(intent);

            }
        });

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, consultActivity.class);
                startActivity(intent);

            }
        });
        subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        getImages2();
        getImages();




    }

    //Auto Complete Text View location code

   // public static final String[] cityHint = new String[]{"Hamirpur,India","Lucknow,India"};

    private void getImages(){

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3Dx20Ba5OGL6BnwU7F%2F9U9s6FcMCHQVg%2BkKQiyfA6RVx4ThmDr8jLcApkKzIhW?alt=media&token=57a802b4-7e49-4295-9f7e-6e01e23db16f");
        mNames.add("Nueral");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DMaV8rKEZPCmBj%2BQ1K6xFkGXsqpUR96ZUNjqF3%2BRpWnkS777x7FXgUYZ5hQEB?alt=media&token=09b33036-7484-4483-a2a1-1f17770284ad");
        mNames.add("Brain");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DGuAXr%2F6MLuoPmdrYh6fPfiti91InT1gzJuer%2FUtCTiK2VSM2k8LmvOQnSBCn?alt=media&token=81b3c2cb-7809-4301-b13d-2cf679e9ae6c");
        mNames.add("Eye Care");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3D839%2FO5z5qGPKXkFh88fhpqtbuon7ffX%2Fucf703uEQ%2B6wr7PzWDKaFxBo1V%2B%2B?alt=media&token=688cc1ca-d28e-418c-a92a-465c1a22b933");
        mNames.add("Baby");


        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3Dun7Kd2vzhgsjABpMdbG205qISn2pHcuBVg%2BYM9Wu9hOHNv%2FY5Eyn8lh%2FXkyo?alt=media&token=188e7e8c-726c-4943-86f4-6b99ca65aba8");
        mNames.add("Feet Care");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DeAIn1zab3TVcvdC60MNQUTmeST1YtsUyJs2pVlpEBa7r9DwbL9YAkdvS2WXg?alt=media&token=a2b7923a-5af7-4117-b03f-0075298eb6d8");
        mNames.add("Psychatrist");


        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DT2CFtqjfI3Tfb0syQmC%2BLpBXIBRlKG39rksJw6Q9oBx77Bl%2B%2BCNqTCu4jqsL?alt=media&token=fddcd819-5cc0-47e0-be84-4748fbb66383");
        mNames.add("Surgeon");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DwYG0GRnuOtFyM%2B4ZbHb4MQgwBdVWh%2B6uGm5EJFamRfSIW%2FukQUVxeJq%2Bs25s?alt=media&token=0b579175-824d-4979-b187-5f9a4c1fe27f");
        mNames.add("Weight");

        mImageUrls.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DZmZJMGYk99swcXEXR4UrmaahU4FXULbUHmNJ4A9DhgBC7mjSAqLTujHt7gWA?alt=media&token=a2816145-366f-40ca-ab51-b916912b4126");
        mNames.add("Pregnancy");

        initRecyclerView();

    }
    private void getImages2(){

        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DDM88%2BmAjtrbvObO3SQUDxPCd4FBVf7haH2bv7pAVb5TZB%2Bs1GA6cjnbM%2FiFk?alt=media&token=20afd38e-fcbf-4b35-b384-b7a805bbc142");

        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3D%2BljbNEEVxdnTbMbGpFOTpv8%2BlomslxfnU6u2jw2j1qp2rWFBInvBqvkNJu2E?alt=media&token=5ba4bfed-68df-4b7d-bf38-92e76622994f");

        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DRsZKn7jfU2UPBXhHFZwtaj8tJ%2FcuKxnB4Dr60ZW0hqjBwDllT8YWjxBBYdwl?alt=media&token=07580a3f-49fa-42b3-a599-1356dc6bb665");

        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DknQHHu%2Ba6U2hx4me9GAhpb0MMBhnRXsjDSWP87mdMm3EnEy8AXJASULlTcnd?alt=media&token=390e8833-282d-4db1-aab9-e64a6b38e3d0");



        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3D%2F9VDXPP6vr6nO7%2FIxdiIshZrPe%2BY%2FKBuKrFPNaWN8VFC5H%2Fw939O%2F8OsUDR?alt=media&token=95994578-be15-43a8-a829-9a004a7ff156");


        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DzEO6Ae3YtYegfQ3ZBycZ%2FRUOjG%2BYy1ucm3WIaYywWT3XbRaFQnRTxAo3Xiw5?alt=media&token=7632c254-4528-4234-a242-b8aba4fcbb66");
        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DU0mYTuMQhJH5su17SbEjvFbgu%2BNwGkRXC1TMj8u4wrS%2B%2B3AHeTaPEU9Bqa13?alt=media&token=6d20d36a-68b7-4504-bc3a-04ca03c35584");
        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3DcW1lIQiqKsphN5UV2mqoEwi6OG1%2B9ztBydltfW3LsjoyThpyO6wUWGTFHhM0?alt=media&token=3dfb0440-d8b5-41b8-aeb3-b8376183d808");
        mImageUrls2.add("https://firebasestorage.googleapis.com/v0/b/docsreg-79b8d.appspot.com/o/Docs%20images%2Facc%3D1%3Bdoc%3Dencoded%3D7%2Bk06AbGYhFALVPKAHNNZMHM7Z3V5oK9WzlcYVExpYUe%2FwPIVA%2BRtFKn%2FfFS?alt=media&token=ed5fc387-bd71-4618-8ac3-f5c9c6e1176c");





        initRecyclerView2();

    }


    private void initRecyclerView(){


        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }
    private void initRecyclerView2(){


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(layoutManager);


        RecyclerViewAdapter2 adaptersec = new RecyclerViewAdapter2(this, mImageUrls2);
        recyclerView.setAdapter(adaptersec);
    }

    //Location Function



}
