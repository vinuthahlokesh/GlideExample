package com.example.glideexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Recyclerview : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = RetrofitObject.getInstance().create(RetrofitInterface::class.java)
        val dogData = retrofit.getRandomDogList()

            dogData.enqueue(object : Callback<DogDataForList> {
                override fun onResponse(call: Call<DogDataForList>, response: Response<DogDataForList>) {
                    val dataList: DogDataForList = response.body()
                    val something : List<String> = dataList.message
                    recyclerView.adapter = RecyclerAdapter(this@Recyclerview,something)
                }

                override fun onFailure(call: Call<DogDataForList>, t: Throwable) {
                    Toast.makeText(this@Recyclerview, t.toString(), Toast.LENGTH_LONG).show()
                }

            })
        }
    }
