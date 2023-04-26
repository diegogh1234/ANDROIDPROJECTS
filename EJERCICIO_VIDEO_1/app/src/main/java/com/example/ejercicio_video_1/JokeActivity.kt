package com.example.ejercicio_video_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        val btnjoke= findViewById<Button>(R.id.btnJoke)


        btnjoke.setOnClickListener{
            loadJoke()
        }


    }

    private fun loadJoke() {
        val tvbroma= findViewById<TextView>(R.id.tvBroma)
        val retrofit=Retrofit.Builder().baseUrl("https://geek-jokes.sameerkumar.website/").
        addConverterFactory(GsonConverterFactory.create()).build()

        val jokeservice:JokeService
        jokeservice=retrofit.create(JokeService::class.java)

        val request=jokeservice.getJoke("json")

        request.enqueue(object : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if(response.isSuccessful){
                    tvbroma.text=response.body()!!.joke
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.d("jokeActivity",t.toString())
            }

        })

        //tvbroma.text="BROMA"
    }
}