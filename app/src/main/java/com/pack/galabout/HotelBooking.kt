package com.pack.galabout

import androidx.appcompat.app.AppCompatActivity
import com.pack.galabout.RecyclerViewInterface
import com.pack.galabout.AminoAcidModel
import com.pack.galabout.R
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.pack.galabout.AA_RecyclerViewAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
import com.pack.galabout.HotelDetails
import java.util.ArrayList

class HotelBooking : AppCompatActivity(), RecyclerViewInterface {
    var aminoAcidModels = ArrayList<AminoAcidModel>()
    var aminoAcidImages = intArrayOf(
        R.drawable.texas,
        R.drawable.place2,
        R.drawable.place2,
        R.drawable.place2,
        R.drawable.place2,
        R.drawable.place2,
        R.drawable.place2,
        R.drawable.place2,
        R.drawable.place2
    )
    var imageWidth = 25 // Desired width
    var imageHeight = 25 // Desired height
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acommod_kotlin)
        val recyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        setUpAminoAcidModels()
        val adapter = AA_RecyclerViewAdapter(this, aminoAcidModels, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpAminoAcidModels() {
        val aminoAcidNames = resources.getStringArray(R.array.amino_acids_full_txt)
        val aminoAcidAbbreviation = resources.getStringArray(R.array.amino_acids_three_letter_txt)
        val aminoAcidAbbreviationSmall =
            resources.getStringArray(R.array.amino_acids_one_letter_txt)
        for (i in aminoAcidNames.indices) {
            aminoAcidModels.add(
                AminoAcidModel(
                    aminoAcidNames[i],
                    aminoAcidAbbreviation[i], aminoAcidAbbreviationSmall[i],
                    aminoAcidImages[i], imageWidth, imageHeight
                )
            )
        }
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, HotelDetails::class.java)
        intent.putExtra("NAME", aminoAcidModels[position].getAminoAcidName())
        intent.putExtra("ABBR_BIG", aminoAcidModels[position].getAminoAcidAbbreviation())
        intent.putExtra("ABBR_SMALL", aminoAcidModels[position].getAminoAcidAbbreviationSmall())
        intent.putExtra("IMAGE", aminoAcidModels[position].getImage())
        startActivity(intent)
    }
}