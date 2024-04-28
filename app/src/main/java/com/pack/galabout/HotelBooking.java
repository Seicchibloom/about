package com.pack.galabout;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelBooking extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<AminoAcidModel> aminoAcidModels = new ArrayList<>();
    int[] aminoAcidImages = {R.drawable.texas,R.drawable.place2,R.drawable.place2,R.drawable.place2,R.drawable.place2,R.drawable.place2,
            R.drawable.place2,R.drawable.place2,R.drawable.place2};
    int imageWidth = 25; // Desired width
    int imageHeight = 25; // Desired height

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acommod_kotlin);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpAminoAcidModels();
        AA_RecyclerViewAdapter adapter = new AA_RecyclerViewAdapter(this,aminoAcidModels,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void setUpAminoAcidModels(){
        String[] aminoAcidNames = getResources().getStringArray(R.array.amino_acids_full_txt);
        String[] aminoAcidAbbreviation = getResources().getStringArray(R.array.amino_acids_three_letter_txt);
        String[] aminoAcidAbbreviationSmall = getResources().getStringArray(R.array.amino_acids_one_letter_txt);

        for (int i = 0; i < aminoAcidNames.length; i++) {
            aminoAcidModels.add(new AminoAcidModel(aminoAcidNames[i],
                    aminoAcidAbbreviation[i], aminoAcidAbbreviationSmall[i],
                    aminoAcidImages[i], imageWidth, imageHeight));
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, HotelDetails.class);

        intent.putExtra("NAME",aminoAcidModels.get(position).getAminoAcidName());
        intent.putExtra("ABBR_BIG",aminoAcidModels.get(position).getAminoAcidAbbreviation());
        intent.putExtra("ABBR_SMALL",aminoAcidModels.get(position).getAminoAcidAbbreviationSmall());
        intent.putExtra("IMAGE",aminoAcidModels.get(position).getImage());

        startActivity(intent);

    }
}
