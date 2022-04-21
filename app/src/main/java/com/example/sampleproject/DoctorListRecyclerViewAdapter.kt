package com.example.sampleproject

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 typealias clickHandler = (Doctor) -> Unit
class DoctorListRecyclerViewAdapter(val dataSet: List<Doctor>,var clickHandler:clickHandler):
    RecyclerView.Adapter<DoctorListRecyclerViewAdapter.ViewHolder>()  {
    class  ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var doctorId:TextView
        var doctorName:TextView
        var doctorField:TextView
        init {
            // Define click listener for the ViewHolder's View.
            doctorId = view.findViewById<TextView>(R.id.doctorId)
             doctorName = view.findViewById<TextView>(R.id.doctorName)
             doctorField = view.findViewById<TextView>(R.id.doctorField)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclere_veiw_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.doctorId.text = dataSet[position].id.toString()
        holder.doctorName.text = dataSet[position].name
        holder.doctorField.text = dataSet[position].field
        holder.doctorName.setOnClickListener{
            clickHandler?.invoke(dataSet[position])
        }
    }
    override fun getItemCount(): Int = dataSet.size
}