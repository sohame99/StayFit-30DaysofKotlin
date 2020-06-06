package com.example.StayFit

import android.content.Context
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_step_counter_activity.*

class step_counter_activity : AppCompatActivity(),SensorEventListener {

    var running=false
    var sensorManager:SensorManager?=null
    var previousTotalsteps=0f
    var TotalSteps=0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_counter_activity)
        loadData()
        resetSteps()

        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        running=true
        var stepSensor=sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor==null){
            Toast.makeText(this,"No Step Counter Sensor!",Toast.LENGTH_SHORT).show()
        }
        else{
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        running=false
        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        if(running){
            TotalSteps=event!!.values[0]
            val CurrentSteps:Int=TotalSteps.toInt()-previousTotalsteps.toInt()
            nofsteps.text=("$CurrentSteps")
            //nofsteps.setText("" +event.values[0])
        }

    }
    fun resetSteps(){
        nofsteps.setOnClickListener{
            Toast.makeText(this,"Long tap to reset steps",Toast.LENGTH_SHORT).show()
        }
        nofsteps.setOnLongClickListener{
            previousTotalsteps=TotalSteps
            nofsteps.text=0.toString()
            saveData()
            true
        }
    }
    private fun saveData(){
        val sharedPreferences:SharedPreferences= getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? =sharedPreferences.edit()
        if (editor != null) {
            editor.putFloat("key1",previousTotalsteps)
        }
        if (editor != null) {
            editor.apply()
        }
    }
    private fun loadData(){
        val sharedPreferences:SharedPreferences=getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val savedNumber:Float=sharedPreferences.getFloat("key1",0f)
        previousTotalsteps=savedNumber
    }
}