package com.example.hzdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.HashMap

class MainActivity: AppCompatActivity() {

    private lateinit var buttonLoadUser: Button
    private lateinit var textViewJson: TextView
    private lateinit var apiWorker: ApiWorker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var url = "https://jsonplaceholder.typicode.com/posts"

        apiWorker = ApiWorker(applicationContext)

        textViewJson = findViewById(R.id.textViewJson)

        buttonLoadUser = findViewById(R.id.buttonLoadUser)
        buttonLoadUser.setOnClickListener {
            apiWorker.makeGetRequest(url,::updateTextViewJson)
        }
    }

    fun updateTextViewJson(data: String){
        textViewJson.text = data
    }
}