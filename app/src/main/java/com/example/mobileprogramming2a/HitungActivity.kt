package com.example.mobileprogramming2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HitungActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        //assigning state if not null
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }


        //listener registration
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0!!.id == R.id.btn_calculate) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            //validation data
            if (inputLength.isEmpty()) {
                edtLength.error = "Field is empty"
            }
            if (inputWidth.isEmpty()) {
                edtWidth.error = "Field is empty"
            }
            if (inputHeight.isEmpty()) {
                edtHeight.error = "Field is empty"
            }
            if (inputLength.isNotEmpty() && inputWidth.isNotEmpty() && inputHeight.isNotEmpty()) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }

    //adding state result parameter saver
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    //saving state when activity destroyed e.g. flip screen
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(STATE_RESULT, tvResult.text.toString())
        super.onSaveInstanceState(outState)
    }
}