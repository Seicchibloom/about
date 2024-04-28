package com.pack.galabout

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        // Find the ImageView
        val accommodationsIcon = findViewById<ImageView>(R.id.accomodationsicon)

        // Set click listener for the accommodations icon
        accommodationsIcon.setOnClickListener {
            // Navigate to the AccommodationFragment
            findNavController(R.id.accomodationsicon).navigate(R.id.)
        }
    }
}
