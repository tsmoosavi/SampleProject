package com.example.sampleproject

import androidx.lifecycle.ViewModel

class PatientInfoVM:ViewModel() {
    var doctorList = Hospital.doctorList
   fun getDoctor(id: Int):Doctor{
       for (doctor in doctorList){
           if (doctor.id == id){
               return doctor
           }
       }
       return Doctor(0,"",OnlineStatus.offline,"","")
   }
}