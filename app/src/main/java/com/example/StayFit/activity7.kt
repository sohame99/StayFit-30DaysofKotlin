package com.example.StayFit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_activity7.*

class activity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity7)

        textView4.visibility = View.INVISIBLE

        bmicalc.setOnClickListener {


              var weight:Double=weight.text.toString().toDouble()
              var height:Double=height.text.toString().toDouble()
              val bmical={ a:Double,b:Double -> (a*703)/(b*b)}
              val bmi:Double=bmical(weight,height)

              val bmiresult:String=calcbmi(bmi)
              textView4.visibility=View.VISIBLE
              textView4.text="BMI is ${String.format("%.2f",bmi)} you are $bmiresult"
        }
    }
    val calcbmi= { a: Double ->
        when (a) {
            in 0.0..18.5 -> "Underweight"
            in 18.6..24.9 -> "in Normal weight category"
            in 25.0..29.0 -> "Overweight"
            else -> "Obese"
        }

    }


}