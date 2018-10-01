package com.example.kukuh.aplikasibiodata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button telepon,alamat,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telepon=(Button)findViewById(R.id.Telepon);
        alamat=(Button)findViewById(R.id.Alamat);
        email=(Button)findViewById(R.id.Email);
    }

    public void openPhone(View v){
        String phone = "+6289682497450";

        Uri uri = Uri.parse("tel:"+phone);
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
    }

    public void openAddress(View v){
        Uri uri = Uri.parse("geo:-6.9846182,110.3228179,3a,75y,93.06h,94.81t="+Uri.encode("Perumahan Beringin Asri"));
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        it.setPackage("com.google.android.apps.maps");
        startActivity(it);
    }

    public void openEmail(View v){
        Intent it = new Intent(Intent.ACTION_SEND);
        //startActivity(it);
        it.setType("text/plain");
        it.putExtra(Intent.EXTRA_EMAIL, new String[]{"knugroho4@gmail.com"});
        it.putExtra(Intent.EXTRA_SUBJECT, "Send Email");

        try {
            startActivity(Intent.createChooser(it, "Sending E-mail ?"));
        } catch (android.content.ActivityNotFoundException ex) {

        }

    }

}
