package com.example.sampleproject

import androidx.lifecycle.ViewModel

class HospitalFirstPageVM:ViewModel() {
    var doctorList  =  arrayListOf<Doctor>()
    init {
        Hospital.setTestData()
        doctorList = Hospital.doctorList
    }

}