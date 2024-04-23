package com.pack.galabout

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class AcommodationFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acommodations)

        val checkInButton = findViewById<TextView>(R.id.checkInButton)
        val checkOutButton = findViewById<TextView>(R.id.checkOutButton)

        checkInButton.setOnClickListener {
            showDatePickerDialog(checkInButton)
        }

        checkOutButton.setOnClickListener {
            showDatePickerDialog(checkOutButton)
        }
    }

    private fun showDatePickerDialog(textView: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                if (textView.id == R.id.checkOutButton) {
                    val checkInButton = findViewById<TextView>(R.id.checkInButton)
                    val checkInDate = checkInButton.text.toString()
                    if (checkInDate.isNotEmpty()) {
                        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
                        val checkIn = sdf.parse(checkInDate)
                        if (selectedDate.before(checkIn)) {
                            val checkOutError = findViewById<TextView>(R.id.checkOutError)
                            checkOutError.visibility = View.VISIBLE // Show the error message
                            return@OnDateSetListener
                        }
                    }
                }

                val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
                val formattedDate = sdf.format(selectedDate.time)
                textView.text = formattedDate

                // If you want to hide the error message when a valid date is selected for checkout
                val checkOutError = findViewById<TextView>(R.id.checkOutError)
                checkOutError.visibility = View.GONE
            },
            year,
            month,
            dayOfMonth
        )

        datePickerDialog.show()
    }
}

