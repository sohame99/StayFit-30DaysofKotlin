package com.example.StayFit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            val intent = Intent(this, activity2::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, activity3::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, activity4::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, activity5::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this, activity6::class.java)
            startActivity(intent)
        }
        bmi_button.setOnClickListener {
            val intent = Intent(this, activity7::class.java)
            startActivity(intent)
        }
        button_step.setOnClickListener {
            val intent = Intent(this, step_counter_activity::class.java)
            startActivity(intent)
        }
        button_diet.setOnClickListener {
            val intent = Intent(this, diet_planner::class.java)
            startActivity(intent)
        }


    }
}
