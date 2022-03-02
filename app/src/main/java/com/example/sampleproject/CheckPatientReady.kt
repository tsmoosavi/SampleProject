package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityCheckPatientReadyBinding

class CheckPatientReady : AppCompatActivity() {
    lateinit var binding:ActivityCheckPatientReadyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckPatientReadyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.readyOk.setOnClickListener{
            var ok = binding.readyBox.isChecked
            returnResult(ok)
        }
    }

    private fun returnResult(isOk: Boolean) {
        val resultIntent = Intent()
        resultIntent.putExtra("ok" , isOk)
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}