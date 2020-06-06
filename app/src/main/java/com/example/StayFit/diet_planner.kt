package com.example.StayFit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_diet_planner.*

class diet_planner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_planner)



        textView11.visibility = View.INVISIBLE
        diet_next.setOnClickListener {

            var bmi: Double = bmi.text.toString().toDouble()
            var aclevel: String = activitylevel.text.toString().toUpperCase()
            textView11.visibility = View.VISIBLE
            textView11.text =Givetips(bmi,aclevel)

        }
    }

    fun Overweight(bmi: Double) = bmi > 24.9

    fun Underweight(bmi: Double) = bmi < 18.5

    fun Normal(bmi: Double) = bmi > 18.6 && bmi < 24.9

    fun ActivitylevelisHigh(aclevel: String) = aclevel == "YES"
    fun ActivitylevelisLow(aclevel: String) = aclevel == "NO"


    var x: String = ""

    fun Givetips(bmi: Double, aclevel: String):String {
        if (Overweight(bmi) && ActivitylevelisHigh(aclevel)) {
            x =
                "Follow our 5 day workout split.Restrict calorie intake and do resistance training." +
                        "20 mins cardio is a must if your goal is weight loss." + "Macros ratio should " +
                        "Switch to eating 5 portions of vegetable and fruits a day, to supply enough fibre ,water and carbs" +
                        "Keep in mind-calories out>calories in.Good luck and stay fit!"

        } else if (Overweight(bmi) && ActivitylevelisLow(aclevel)) {
            x =
                "You are overweight.Workout atleast 3 days a week.As your activity level is low right now, start slowly. Remember regular physical activity" +
                        "is important for good health.When losing weight ,more physical activity increases the number of calories" +
                        "your body uses for energy. The burning of calories through physical activity, combined with reducing the number of" +
                        "calories you eat ,creates a calorie deficit which will surely help you.Keep in mind-calories out>calories in.Good luck and" +
                        "stay fit!"

        } else if (Normal(bmi) && ActivitylevelisHigh(aclevel)) {
            x =
                "Glad to know that your weight is normal and lifestyle is active.You should focus on gaining muscle mass." +
                        "Here are some tips for you.Follow our 5 day workout split.Eat heavy breakfast and try to eat every three hours and include protein in" +
                        "each meal for helping you boost your muscle mass.Eat fruits and vegetables instead of junk food" +
                        "when you are hungry.Drink plenty of water to stay hydrated.Good luck and stay fit!"

        } else if (Normal(bmi) && ActivitylevelisLow(aclevel)) {
            x =
                "Your weight is normal.You need to increase your workout intensity.Workout atleast 3 days a week.As your activity level is low right now, start slowly." +
                        "You should focus on gaining muscle mass." + "Here are some tips for you.Eat heavy breakfast and try to eat every three hours and include protein in" +
                        "each meal for helping you boost your muscle mass.Eat fruits and vegetables instead of junk food" +
                        "when you are hungry.Drink plenty of water to stay hydrated.Good luck and stay fit!"

        } else if (Underweight(bmi) && ActivitylevelisLow(aclevel)) {
            x =
                "You are underweight and your activity level is low.You want to gain a balanced amount of muscle mass and subcutaneous fat" +
                        "rather than a lot of unhealthy belly fat.Workout atleast 3 days a week.As your activity level is low right now, start slowly." +
                        "You are better off focusing on nutrient- and calorie-rich foods like rice,avacados,legumes,whole grain products etc to gain weight" +
                        "Gradually increase portion size.Rely on Strength training and remember to track your calories.Good luck and stay fit!"

        } else if (Underweight(bmi) && ActivitylevelisHigh(aclevel)) {
            x =
                "You are underweight and your activity level is high.Follow our 5 day workout split.You want to gain a balanced amount of muscle mass and subcutaneous fat" +
                        "rather than a lot of unhealthy belly fat.Workout atleast 3 days a week.As your activity level is low right now, start slowly." +
                        "You are better off focusing on nutrient- and calorie-rich foods like rice,avacados,legumes,whole grain products etc to gain weight" +
                        "Gradually increase portion size.Rely on Strength training and remember to track your calories.Good luck and stay fit!"

        }
        return x

    }
}




