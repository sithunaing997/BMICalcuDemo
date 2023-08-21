package com.example.bmicalcudemo.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalcudemo.R
import com.example.bmicalcudemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}