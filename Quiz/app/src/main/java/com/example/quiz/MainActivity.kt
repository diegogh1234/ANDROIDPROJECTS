package com.example.quiz

import android.R.bool
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

val CAMERA_REQUEST_CODE=0

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0
    val hello="hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btcamera= findViewById<Button>(R.id.camera)

        btcamera.setOnClickListener {
            checkCameraPermission()
        }


    }

    private fun checkCameraPermission() {
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)
        !=PackageManager.PERMISSION_GRANTED)
        {
            requestCameraPermisiion()
        }
        else
        {
            Toast.makeText(this,"Ya se tiene el permiso de la camara",Toast.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermisiion() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CAMERA))
        {
            Toast.makeText(this,"Rechazo el permiso antes. Habilitelo!!",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"Debe aceptar el permiso",Toast.LENGTH_SHORT).show()
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode)
        {
            CAMERA_REQUEST_CODE ->{
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"Se acepto el permiso de la CAMARA",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this,"Permiso negado",Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }

    private fun localQuestion() {
        questions = ArrayList()
        var question = Question("¿Es lima capital de Peru?", true)
        questions.add(question)
        questions.add(Question("¿Es lima capital de Chile?", false))
        questions.add(Question("¿Es Tumbbes capital de Chile?", false))
        questions.add(Question("¿Es Buenos Aires capital de Argentina?", true))
        questions.add(Question("¿Es Bogota capital de Colombia?", true))
        questions.add(Question("¿Es Mexico capital de Chile?", false))
    }



    fun setupViews() {
        val btTrue = findViewById<Button>(R.id.True)
        val btfalse = findViewById<Button>(R.id.False)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val bt=findViewById<Button>(R.id.avance)
        var rpta = questions[position].answer


        tvQuestion.text = questions[position].sentence

        btTrue.setOnClickListener {

            if (questions[position].answer) {
                val toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT)
                toast.show()
                position++
                tvQuestion.text = questions[position].sentence

            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }

        }

        btfalse.setOnClickListener {

            if (!questions[position].answer) {
                val toast = Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT)
                toast.show()
                questions[position].answer==true

            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }


        }
        bt.setOnClickListener{
            position+=1
            tvQuestion.text = questions[position].sentence
        }


    }



}