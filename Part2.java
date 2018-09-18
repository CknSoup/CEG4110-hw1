package com.example.andrewsjoberg.sjoberg_hw_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.icu.util.UniversalTimeScale;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.raodevs.touchdraw.TouchDrawView;
import com.rtugeek.android.colorseekbar.ColorSeekBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

public class Part2 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        Button part1Button = findViewById(R.id.toPart1Button);
        part1Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                // setContentView(R.layout.activity_part1);
            }

        });

        // Drawing Canvas

        final TouchDrawView canvas = findViewById(R.id.canvas);
        // Can't set background color for some reason
        // canvas.setBGColor(400);
        ColorSeekBar color = findViewById(R.id.colorSlider);
        color.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int colorBarPosition, int alphaBarPosition, int color) {
                canvas.setPaintColor(color);
                //colorSeekBar.getAlphaValue();
            }
        });

        Button clear = findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                canvas.clear();
            }
        });

        Button jpeg = findViewById(R.id.saveJPEGButton);
        jpeg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveFile("jpeg", canvas);
            }
        });

        Button png = findViewById(R.id.savePNGButton);
        png.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveFile("png", canvas);
            }
        });
    }

    private void saveFile(String type, TouchDrawView canvas){
        Bitmap bitmap = canvas.getFile();
        String filename = "sjoberghw1_" + Calendar.getInstance().getTimeInMillis() + "." + type;
        try {
            File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera");
            File file = new File(storageDir, filename);
            file.getParentFile().mkdirs();
            file.createNewFile();
            OutputStream stream = new FileOutputStream(file);
            if (type.matches("jpeg")){
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
