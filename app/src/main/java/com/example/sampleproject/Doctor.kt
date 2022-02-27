package com.example.sampleproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object Hospital {
    var doctorList = arrayListOf<Doctor>()
    val consultancyList = arrayListOf(
        Consultancy(1 , 30 , 100000, CosultancyType.phone),
        Consultancy(2 , 60 , 250000,  CosultancyType.video),
        Consultancy(3 , 90 , 300000,  CosultancyType.phone)
    )
    fun setTestData(){
        doctorList.clear()
        doctorList.add(Doctor(1,"معصومه بهرامی",OnlineStatus.online,"مشاوره فردی، اضطراب، افسردگی، شغلی و تحصیلی، استعداد یابی..." ))
        doctorList.add(Doctor(2 , "پروانه نادری" , OnlineStatus.offline , "روانشناسی و مشاوره" ))
        doctorList.add(Doctor(2 , "ناهید صادقی" , OnlineStatus.online , "روانشناسی کودک، مشاور تحصیلی" ))
    }
}
@Parcelize
class Doctor(
    val id: Int,
    val name: String,
    var onlineStatus: OnlineStatus,
    var field : String,
    var  ImageId: Int? = null
):Parcelable{}
data class Consultancy(val id:Int,
                       val time: Int,
                       val price: Int,
                       var type : CosultancyType

)
enum class CosultancyType{
    phone,
    video
}
enum class OnlineStatus{
    online,
    offline
}

