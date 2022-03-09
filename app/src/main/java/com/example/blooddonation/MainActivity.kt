package com.example.blooddonation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val donateBtn = findViewById<Button>(R.id.donateBtn)
        val healthCheck = findViewById<CheckBox>(R.id.healthCheck)
        val ageTv = findViewById<EditText>(R.id.agetTF)
        val weightTv = findViewById<EditText>(R.id.weightTF)
        val sleepCheck = findViewById<CheckBox>(R.id.sleepCheck)

        var validCheck : Boolean = false

        donateBtn.setOnClickListener()
        {
            var age:Int = 0
            var weight = 0

            if (TextUtils.isEmpty(ageTv.text.toString())) {
                ageTv.error = "Age cannot Be Empty"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(weightTv.text.toString())) {
                weightTv.error = "Weight cannot Be Empty"
                return@setOnClickListener
            }

            if(!TextUtils.isEmpty(ageTv.text.toString()))
            {
                age = ageTv.text.toString().toInt()
            }
            if(!TextUtils.isEmpty(weightTv.text.toString()))
            {
                weight = weightTv.text.toString().toInt()
            }
            if(healthCheck.isChecked && sleepCheck.isChecked && (age in 18..60) && (weight >= 45))
            {
                validCheck = true
                Toast.makeText(applicationContext,"Valid Blood Donor",Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this,BloodResultActivity::class.java)
                intent.putExtra("DonorValidCheck",validCheck)
                intent.putExtra("DonorWeight",weight)
                startActivity(intent)
            }
            else
                Toast.makeText(applicationContext,"Invalid Blood Donor",Toast.LENGTH_SHORT).show()

        }

    }
}