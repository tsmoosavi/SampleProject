package com.example.sampleproject

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
 typealias clickHandler = (Doctor) -> Unit
class DoctorListRecyclerViewAdapter(var clickHandler:clickHandler):
    ListAdapter<Doctor, DoctorListRecyclerViewAdapter.ViewHolder>(DoctorDiffCallback) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var doctorId = view.findViewById<TextView>(R.id.doctorId)
        var doctorName = view.findViewById<TextView>(R.id.doctorName)
        var doctorField = view.findViewById<TextView>(R.id.doctorField)

        //        init {
//            // Define click listener for the ViewHolder's View.
//            doctorId = view.findViewById<TextView>(R.id.doctorId)
//             doctorName = view.findViewById<TextView>(R.id.doctorName)
//             doctorField = view.findViewById<TextView>(R.id.doctorField)
//
//        }
        fun bind(doctor: Doctor, clickHandler: clickHandler?) {
            doctorId.text = doctor.id.toString()
            doctorName.text = doctor.name
            doctorField.text = doctor.field
            doctorName.setOnClickListener {
                clickHandler?.invoke(doctor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclere_veiw_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.doctorId.text = dataSet[position].id.toString()
//        holder.doctorName.text = dataSet[position].name
//        holder.doctorField.text = dataSet[position].field
//        holder.doctorName.setOnClickListener{
//            clickHandler?.invoke(dataSet[position])
//        }
        holder.bind(getItem(position), clickHandler)
    }

    object DoctorDiffCallback : DiffUtil.ItemCallback<Doctor>() {
        override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
            return oldItem.name == newItem.name
            // this is true when you show all variable of doctor     return oldItem == newItem
        }
    }
}