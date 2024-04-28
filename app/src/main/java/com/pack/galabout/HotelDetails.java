package com.pack.galabout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HotelDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acommod_details);

        String name = getIntent().getStringExtra("NAME");
        String abbrBig = getIntent().getStringExtra("ABBR_BIG");
        String abbrSmall = getIntent().getStringExtra("ABBR_SMALL");
        int image = getIntent().getIntExtra("IMAGE", 0);


        TextView nameTextView  = findViewById(R.id.AA_Title);
        TextView AA3LettersTextView = findViewById(R.id.AA_Title_3_Letters);
        TextView AA1LetterTextView = findViewById(R.id.AA_Title_1_Letter);
        ImageView AA_Image = findViewById(R.id.AA_Image);


        nameTextView.setText(name);
        AA3LettersTextView.setText(abbrBig);
        AA1LetterTextView.setText(abbrSmall);
        AA_Image.setImageResource(image);
    }
}
