package com.example.bmicalcudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.text.font.FontWeight
import androidx.core.content.ContextCompat
import com.example.bmicalcudemo.databinding.ActivityDemoBinding

class Demo : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpClickListener()
    }

    private fun setUpClickListener(){
        binding.btnCal.setOnClickListener {
            val weight = binding.edtWeight.text.toString()
            val height = binding.edtHeight.text.toString()

            if (validateInput(weight, height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                val bmi2Digits = String.format("%.2f", bmi).toFloat()

                displayResult(bmi2Digits)

            }
        }
    }

    private fun validateInput(weight: String?,height : String?):Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }

            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            else ->
                return true
        }

    }
    

    private fun displayResult(bmi : Float){
        binding.tvIndex.text = bmi.toString()
        binding.tvInfo.text = "(Normal range is 18.5 - 24.9)"

        var resultText = ""
        var color =0

        when {
            bmi < 18.50 -> {
                resultText = "Underweight"
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 -> {
                resultText = "Healthy"
                color = R.color.normal
            }
            bmi in 25.00..29.99 -> {
                resultText = "Overweight"
                color = R.color.over_weight
            }
            bmi > 29.99 -> {
            resultText = "Obese"
            color = R.color.obese
        }
        }

        binding.tvResult.setTextColor(ContextCompat.getColor(this,color))
        binding.tvResult.text = resultText

    }
}