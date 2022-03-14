package com.example.sampleproject

import androidx.lifecycle.ViewModel

class DoctorVM: ViewModel() {
    lateinit var doctor:Doctor
    var consultationTypeList = Hospital.consultancyList
}