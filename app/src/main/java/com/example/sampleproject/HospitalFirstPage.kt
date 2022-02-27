package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityHospitalFirstPageBinding

const val DOCTOR = "doctor"
class HospitalFirstPage : AppCompatActivity() {

    lateinit var binding: ActivityHospitalFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Hospital.setTestData()
        var doctor1 = Hospital.doctorList[0]
        var doctor2 = Hospital.doctorList[1]
        var doctor3 = Hospital.doctorList[2]

        val buttonsList= arrayListOf(binding.button,binding.button2,binding.button3)

        binding.button.text = doctor1.name
        binding.button2.text = doctor2.name
        binding.button3.text = doctor3.name

        for(i in 0 until buttonsList.size){
            buttonsList[i].setOnClickListener{
                goToDoctorActivity(Hospital.doctorList[i])
            }
        }






    }
    fun goToDoctorActivity(doctor: Doctor){
        var intent = Intent(this , DoctorActivity::class.java)
        intent.putExtra( DOCTOR,doctor)
        startActivity(intent)

    }

}


