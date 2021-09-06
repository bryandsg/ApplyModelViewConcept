package com.hashiradev.viewmodellifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var etCounter  : EditText
    lateinit var btnData    : Button
    lateinit var btnShow    : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initListenerClick()
    }

    private fun initListenerClick() {
        btnData.setOnClickListener {
            mainViewModel.counter()
        }

        btnShow.setOnClickListener {
            Toast.makeText(applicationContext,"Counter: ${mainViewModel.counter.value}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initData() {
        //instanciando a viewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        etCounter = findViewById(R.id.et_counter)
        btnData   = findViewById(R.id.btn_data)
        btnShow   = findViewById(R.id.btn_show)

        mainViewModel.counter.observe(this, Observer { value ->
            etCounter.setText(value)
        })
    }
}