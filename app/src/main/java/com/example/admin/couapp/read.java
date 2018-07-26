package com.example.admin.couapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class read {
    public static final String path = "/Demo/ew";
    public static void iwFile(Context context,Bitmap img, String filename){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(filename,Context.MODE_PRIVATE);

            img.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.flush();
            String str ="Hello java";
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap fb(Context context,String filename){

        /*try {
            FileInputStream fileInputStream= context.openFileInput(filename);
            Bitmap img = BitmapFactory.decodeStream(fileInputStream);
            return img;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        Bitmap img=null;
        String fullpath=Environment.getExternalStorageDirectory()+path+"/"+filename;
        img = BitmapFactory.decodeFile(fullpath);
        return img;


    }

    public static String tx(Context context,String filename){
        /*File file= context.getFileStreamPath(filename);
        try {
            FileInputStream fileInputStream=context.openFileInput(filename);
            String line="";
            StringBuilder builder= new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((line=bufferedReader.readLine())!=null){
                builder.append(line);

            }return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;*/
        try {
            File file = new File(Environment.getDataDirectory()+"/Demo/rw"+filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            String line="";
            StringBuilder builder= new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((line=bufferedReader.readLine())!=null){
                builder.append(line);
            }
            Toast.makeText(context,"true",Toast.LENGTH_SHORT).show();
            return builder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Del(Context context,String filename){
        context.deleteFile(filename);

    }

    public static void ewFile(Context context,Bitmap img,String filename){


        String fullpath = Environment.getExternalStorageDirectory().getAbsolutePath() + path;
        File dirs = new File(fullpath);
        if(!dirs.exists()){
            dirs.mkdirs();
        }

        File sto = new File(fullpath,filename);
        if(!sto.exists()){
            try {
                sto.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOutputStream= new FileOutputStream(sto);
            img.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(context,"true",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ewFile2(Context context,String filename){
        String fullpath = Environment.getExternalStorageDirectory() +"/Demo/"+filename;
        File file = new File(fullpath,filename);
        File dirs = new File(fullpath);
        dirs.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            String str ="Hello java";
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
