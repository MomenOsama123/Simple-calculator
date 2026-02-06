package com.simplecalculator

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FirstActivity :AppCompatActivity() {
    lateinit var number1ET: EditText
    lateinit var number2ET: EditText
    lateinit var calculate: Button
    lateinit var result: TextView
    lateinit var operation: AutoCompleteTextView
    val TAG = "FirstActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        number1ET = findViewById(R.id.number1_et)
        number2ET = findViewById(R.id.number2_et)
        calculate = findViewById(R.id.calculate)
        result = findViewById(R.id.resuilt)



        calculate.setOnClickListener{
            val num1 = number1ET.text.toString().toDouble()
            val num2 = number2ET.text.toString().toDouble()
            val sum = num1 + num2
            result.text = sum.toString()
            Log.d(TAG, "FirtstNum: : $num1 SecondNum: : $num2 Sum: : $sum")

        }

    }
}