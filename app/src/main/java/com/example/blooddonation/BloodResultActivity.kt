package com.example.blooddonation

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BloodResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_result)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            val actionbar = supportActionBar

            actionbar!!.title = "Blood Donation Result"
            actionbar!!.setDisplayHomeAsUpEnabled(true)

        }
        val validDonor = intent.getBooleanExtra("DonorValidCheck",false)
        val weight = intent.getIntExtra("DonorWeight" ,0)
        val resultTv = findViewById<TextView>(R.id.resultTv)
        val bloodTv = findViewById<TextView>(R.id.bloodTakenTv)

        if(validDonor)
        {
            resultTv.text = "Qualified"
            if(weight > 50)
            {
                bloodTv.text = "450ml"
            }
            else if(weight in 44..51)
            {
                bloodTv.text = "350ml"
            }
            else
            {
                bloodTv.text = "No blood taken"
            }

        }
        else
        {
            resultTv.text = "Unqualified"
            bloodTv.text = "No blood taken"
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
