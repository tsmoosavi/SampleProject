package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViwes()

    }
    fun initViwes(){
        Hospital.setTestData()
        var myDoctor = Hospital.doctorList[0]
        binding.nameBox.text = myDoctor.name
        binding.statusView.text = myDoctor.onlineStatus.toString()
        binding.MedicalSpeciality.text = myDoctor.field
        var consult1 = Hospital.consultancyList[0]
        binding.tenMin.text = "مشاوره تلفنی ${consult1.time} دقیقه ای "
        binding.tenPrice.text = consult1.price.toString()

    }
}