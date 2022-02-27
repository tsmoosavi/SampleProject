package com.example.sampleproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sampleproject.databinding.ActivityPatientInfoBinding

class PatientInfo : AppCompatActivity() {
    lateinit var binding: ActivityPatientInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        collectPatientData()

    }

    private fun initViews() {
        var bundle = intent.getBundleExtra("bundle")
        var id = bundle!!.getInt("id")
        var name = bundle?.getString("name")
        var myDoctor = Hospital.getDoctor(id)
        binding.myDoctorMassage.text = "دکتر ${myDoctor?.name} با شما تماس خواهد گرفت. "


        binding.submit.isEnabled = myDoctor?.onlineStatus == OnlineStatus.online
        if (!saveName().isNullOrBlank()){
            binding.patientName.visibility = View.GONE
        }
        if (!savePhone().isNullOrBlank()){
            binding.patientPhone.visibility =View.GONE
        }
    }

    private fun collectPatientData() {
        binding.submit.setOnClickListener{
            var userName = binding.patientName.text.toString()
            var userPhone = binding.patientPhone.text.toString()
            var dataCollection : SharedPreferences = getSharedPreferences("kotlinStorage", Context.MODE_PRIVATE)
            var editor = dataCollection.edit()
            editor.putString("name",userName)
            editor.putString("Phone",userPhone)
            editor.apply()
            var name = dataCollection.getString("name","")
            Toast.makeText(this, "$name عزیز، اطلاعات شما ثبت شد.", Toast.LENGTH_SHORT).show()
    }
    }
    fun saveName():String?{
        var dataCollection : SharedPreferences = getSharedPreferences("kotlinStorage", Context.MODE_PRIVATE)
        var name =  dataCollection.getString("name","")
        return name
    }
    fun savePhone():String?{
        var dataCollection : SharedPreferences = getSharedPreferences("kotlinStorage", Context.MODE_PRIVATE)
        var phone =  dataCollection.getString("Phone","")
        return phone
    }
}