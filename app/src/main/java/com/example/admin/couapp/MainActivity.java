package com.example.admin.couapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button butIn, butEx, butRead, butDel;
    ImageView img2;
    TextView tex;
    private int Ex_Permis=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butIn=this.findViewById(R.id.butIn);
        butEx=this.findViewById(R.id.butEx);
        butRead=this.findViewById(R.id.butRead);
        butDel=this.findViewById(R.id.butDel);
        img2=this.findViewById(R.id.img);
        tex=this.findViewById(R.id.tex);
        butIn.setOnClickListener(this);
        butEx.setOnClickListener(this);
        butRead.setOnClickListener(this);
        butDel.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butIn :{
                read.ewFile2(MainActivity.this,"rw");
            }
            case R.id.butEx:{
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},Ex_Permis);
                    }
                }

                Bitmap img = BitmapFactory.decodeResource(this.getResources(),R.drawable.fb);
                read.ewFile(MainActivity.this,img,"ew");
                break;


            }
            case R.id.butRead:{
                Bitmap img=read.fb(MainActivity.this,"ew");
                img2.setImageBitmap(img);

                String str = read.tx(MainActivity.this,"rw");
                tex.setText(str);
                break;
            }
            case R.id.butDel:{
                read.Del(MainActivity.this,"iw");
                Toast.makeText(MainActivity.this,"bro",Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults[0]!=PackageManager.PERMISSION_GRANTED||grantResults[1]!=PackageManager.PERMISSION_GRANTED){
            return;
        }
    }
}