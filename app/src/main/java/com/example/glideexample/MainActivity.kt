package com.example.glideexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        imageView = findViewById(R.id.imageview)

        val retrofit = RetrofitObject.getInstance().create(RetrofitInterface::class.java)
        val dogData = retrofit.getRandomDogData()

        btn1.setOnClickListener {
            dogData.enqueue(object : Callback<DogDataClass> {
                override fun onResponse(call: Call<DogDataClass>, response: Response<DogDataClass>) {
                    Glide.with(this@MainActivity)
                        .load(response)
                        .into(imageView)
                }

                override fun onFailure(call: Call<DogDataClass>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }

        btn2.setOnClickListener {
            startActivity(Intent(this@MainActivity, Recyclerview::class.java))
        }


    }
}
