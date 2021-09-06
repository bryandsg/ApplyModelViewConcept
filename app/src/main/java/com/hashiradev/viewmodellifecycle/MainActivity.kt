package com.hashiradev.viewmodellifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etCounter  : EditText
    lateinit var btnData    : Button
    lateinit var btnShow    : Button

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initCounter()
        initListenerClick()
        validateCounter()
    }

    private fun validateCounter() {
        if(counter > 5 ) {
            counter = 0
        }
    }

    private fun initListenerClick() {
        btnData.setOnClickListener {
            counter++
            validateCounter()
            initCounter()
        }

        btnShow.setOnClickListener {
            Toast.makeText(this,"Counter: ${counter.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initCounter() {
        etCounter.setText(counter.toString())
    }

    private fun initData() {
        etCounter = findViewById(R.id.et_counter)
        btnData   = findViewById(R.id.btn_data)
        btnShow   = findViewById(R.id.btn_show)
    }
}