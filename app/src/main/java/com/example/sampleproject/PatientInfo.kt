package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleproject.databinding.ActivityPatientInfoBinding

class PatientInfo : AppCompatActivity() {
    lateinit var binding: ActivityPatientInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {
        var bundle = intent.getBundleExtra("bundle")
        var id = bundle!!.getInt("id")
        var name = bundle?.getString("name")
        var myDoctor = Hospital.getDoctor(id)
        binding.myDoctorMassage.text = "دکتر ${myDoctor?.name} با شما تماس خواهد گرفت. "
        binding.submit.isEnabled = myDoctor?.onlineStatus == OnlineStatus.online
        binding.submit.setOnClickListener{
            Toast.makeText(this, "اطلاعات شما ثبت شد.", Toast.LENGTH_SHORT).show()
        }


    }
}