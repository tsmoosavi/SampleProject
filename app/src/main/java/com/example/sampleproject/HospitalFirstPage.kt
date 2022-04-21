package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.databinding.ActivityHospitalFirstPageBinding


class HospitalFirstPage : AppCompatActivity() {
    val doctorListVM: HospitalFirstPageVM by viewModels()
    lateinit var binding: ActivityHospitalFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Hospital.setTestData()
       var adapter = DoctorListRecyclerViewAdapter{
           goToDoctorActivity(it)
       }
        binding.recyclerView.adapter = adapter
//        adapter.notifyDataSetChanged()
        adapter.submitList(Hospital.doctorList)





//        var doctor1 = Hospital.doctorList[0]
//        var doctor2 = Hospital.doctorList[1]
//        var doctor3 = Hospital.doctorList[2]

        val buttonsList= arrayListOf(binding.button,binding.button2,binding.button3)

        binding.button.text = doctorListVM.doctorList[0].name
        binding.button2.text = doctorListVM.doctorList[1].name
        binding.button3.text = doctorListVM.doctorList[2].name

        for(i in 0 until buttonsList.size){
            buttonsList[i].setOnClickListener{
                goToDoctorActivity(doctorListVM.doctorList[i])
            }
        }






    }
    fun goToDoctorActivity(doctor: Doctor){
        var intent = Intent(this , DoctorActivity::class.java)
        intent.putExtra("doctor",doctor)
        startActivity(intent)

    }

}


