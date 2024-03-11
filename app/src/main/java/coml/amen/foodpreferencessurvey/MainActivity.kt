package coml.amen.foodpreferencessurvey

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodPreference: Button = findViewById(R.id.food_preference)
        val dietaryHabits:Button = findViewById(R.id.dietary_habits)
        val radioGroup:RadioGroup = findViewById(R.id.radioGroup3)
        foodPreference.setOnClickListener{
            startSurveyActivity("Food Preferences")
        }
        dietaryHabits.setOnClickListener{
            startSurveyActivity("Dietary Habits")
        }
    }

    private fun startSurveyActivity(surveyType: String){

            val intent = Intent(this,SurveyActivity::class.java)
            intent.putExtra("surveyType", surveyType)
            startActivity(intent)
        }


    }
