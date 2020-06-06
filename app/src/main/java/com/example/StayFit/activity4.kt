package com.example.StayFit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView


class activity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity4)

        val listView=findViewById<ListView>(R.id.listview)

        listView.adapter=MyCustomAdapter(this)
    }
    private class MyCustomAdapter(context: Context): BaseAdapter(){
        private val mContext:Context

        private val exercises= arrayListOf<String>(
            "Chest-Pull-Ups","Chest-Push-ups","Chest-Incline Chest-Press","Chest-Decline Chest-Press",
            "Chest-Dumbbell Pullover","Chest-Dips","Chest-Pec deck","Triceps-Diamond-Pushups",
            "Triceps-Close-grip pull ups","Triceps-Pushdown", "Triceps-Bench Dip","Triceps-One-Arm Overhead Extension",
            "Triceps-Lying Extension","Triceps-45 degree Incline press","Biceps-Push ups", "Biceps-Zottman curl", "Biceps-EZ bar curl",
            "Biceps-Wide-grip barbell curl","Biceps-Dumbbell curl","Biceps-Incline inner-curl","Biceps-Preacher Curl",
            "Legs- Leg Press", "Legs-Step-Up","Legs-Pistol Squat","Legs-Walking Lunge","Legs-Hack Squat",
            "Legs-Glute-Ham raise","Abs-Bent Leg V-Up","Abs-Alternating Toe Reach", "Abs-Russian-Twist", "Abs-Leg-Raise",
            "Abs-Side Plank dips", "Abs-Crunches", "Abs-Ball Crunch"
        )
        private var bicepworkout=exercises.filter {it[0] == 'B'}
        init{
            mContext=context
        }
        override fun getCount():Int{
            return bicepworkout.size
        }
        override fun getItemId(position:Int):Long{
            return position.toLong()

        }
        override fun getItem(position:Int):Any{
            return "TEST STRING"

        }
        override fun getView(position:Int, convertView: View?, viewGroup: ViewGroup?):View{
            val layoutInflater=LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main,viewGroup,false)
            val exerciseTextView=rowMain.findViewById<TextView>(R.id.exercise_textView)
            exerciseTextView.text="Exercise ${(position.toInt()+1)}" +"- "+ bicepworkout.get(position)

            val positionTextView=rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text="Repetitions: 3 X 10"
            return rowMain

        }
    }

}
