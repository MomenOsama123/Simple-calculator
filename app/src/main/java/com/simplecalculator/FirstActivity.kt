package com.simplecalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var number1ET: EditText
    private lateinit var number2ET: EditText
    private lateinit var calculate: Button
    private lateinit var resultTV: TextView
    private lateinit var operationACTV: AutoCompleteTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        number1ET = findViewById(R.id.number1_et)
        number2ET = findViewById(R.id.number2_et)
        calculate = findViewById(R.id.calculate)
        resultTV = findViewById(R.id.result_tv)
        operationACTV = findViewById(R.id.operation_actv)

        val operations = listOf("Addition", "Subtraction", "Multiplication", "Division")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, operations)
        operationACTV.setAdapter(adapter)
        calculate.setOnClickListener {
            val num1Str = number1ET.text.toString()
            val num2Str = number2ET.text.toString()
            val operation = operationACTV.text.toString()

            if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()
                var result = 0.0

                when (operation) {
                    "Addition" -> result = num1 + num2
                    "Subtraction" -> result = num1 - num2
                    "Multiplication" -> result = num1 * num2
                    "Division" -> {
                        if (num2 != 0.0) {
                            result = num1 / num2
                        } else {
                            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }
                    else -> {
                        Toast.makeText(this, "Please select an operation", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                resultTV.text = result.toString()
            } else {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
