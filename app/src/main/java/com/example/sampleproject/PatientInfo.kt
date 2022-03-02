package com.example.sampleproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sampleproject.databinding.ActivityPatientInfoBinding

class PatientInfo : AppCompatActivity() {
    lateinit var binding: ActivityPatientInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState!= null){
            binding.patientName.setText(savedInstanceState.getString("name"))
            binding.patientPhone.setText(savedInstanceState.getString("Phone"))
            binding.myDoctorMassage.text = savedInstanceState.getString("message")
        }
        initViews()
        collectPatientData()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Phone",binding.patientPhone.text.toString())
        outState.putString("name",binding.patientName.text.toString())
        outState.putString("message",binding.myDoctorMassage.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun gotoPatientDetail() {
        var sentIntent = Intent(this ,CheckPatientReady::class.java)
        startForResult.launch(sentIntent)

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
        binding.submit.setOnClickListener{
            collectPatientData()
            var dataCollection : SharedPreferences = getSharedPreferences("kotlinStorage", Context.MODE_PRIVATE)
            gotoPatientDetail()
            var name =  dataCollection.getString("name","")
            Toast.makeText(this, "$name عزیز، اطلاعات شما ثبت شد.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun collectPatientData() {
//        binding.submit.setOnClickListener{
            var userName = binding.patientName.text.toString()
            var userPhone = binding.patientPhone.text.toString()
            var dataCollection : SharedPreferences = getSharedPreferences("kotlinStorage", Context.MODE_PRIVATE)
            var editor = dataCollection.edit()
            editor.putString("name",userName)
            editor.putString("Phone",userPhone)
            editor.apply()
//            var name = dataCollection.getString("name","")
//            Toast.makeText(this, "$name عزیز، اطلاعات شما ثبت شد.", Toast.LENGTH_SHORT).show()
//    }
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
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            val receivData = result.data
            val beingOk = intent.getBooleanExtra("ok",false)
            if (beingOk){
                Toast.makeText(this, "شما آماده تماس هستید.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "شما آماده تماس  نیستید.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}