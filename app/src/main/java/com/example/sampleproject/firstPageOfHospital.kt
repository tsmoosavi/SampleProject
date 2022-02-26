package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityFirstPageOfHospitalBinding

class firstPageOfHospital : AppCompatActivity() {
    lateinit var binding: ActivityFirstPageOfHospitalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageOfHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}