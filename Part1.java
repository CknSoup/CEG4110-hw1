package com.example.andrewsjoberg.sjoberg_hw_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Part1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        final TextView text;
        text = findViewById(R.id.part1TextField);
        Button colorButton = findViewById(R.id.part1Button);
        colorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                java.util.Random random = new java.util.Random();
                int red = random.nextInt(255);
                int blue = random.nextInt(255);
                int green = random.nextInt(255);
                String[] colorCode = {Integer.toHexString(red), Integer.toHexString(green), Integer.toHexString(blue)};
                // Makes a single hex digit represented with two characters
                for (int i = 0; i < colorCode.length; i++) {
                    if (colorCode[i].length() == 1) {
                        colorCode[i] = "0" + colorCode[i];
                    }
                }
                String hexColor = "#" + colorCode[0] + colorCode[1] + colorCode[2];
                Log.d("Creation", colorCode[0] + " " + colorCode[1] + " " + colorCode[2] + " " + hexColor);
                text.setText("COLOR: " + red + "r, " + green + "g, " + blue + "b, " + hexColor);
                text.setTextColor(Color.parseColor(hexColor));

            }
        });

        Button part2Button = findViewById(R.id.toPart2Button);
        part2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Part2.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
