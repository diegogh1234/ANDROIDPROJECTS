package com.example.persistenciasharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnsave= findViewById<Button>(R.id.btnSave)
        val btnretrieve= findViewById<Button>(R.id.btnRetrieve)
        val etName= findViewById<TextView>(R.id.etName)
        val tvretrieve= findViewById<TextView>(R.id.tvRetrieve)
        val sharedPreference= SharedPreference(this)

        btnsave.setOnClickListener{
            val name=etName.text.toString()

            sharedPreference.save("name",name)

            Toast.makeText(this,"Data stored",Toast.LENGTH_LONG).show()
        }

        btnretrieve.setOnClickListener{
            if(sharedPreference.getValue("name")!=null)
            {
                tvretrieve.setText(sharedPreference.getValue("name"))
            }
        }
    }
}