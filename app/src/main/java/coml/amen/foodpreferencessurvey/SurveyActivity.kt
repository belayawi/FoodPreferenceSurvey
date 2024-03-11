package coml.amen.foodpreferencessurvey

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.setPadding

class SurveyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        val surveyType = intent.getStringExtra("surveyType")
        val my_tile:TextView = findViewById(R.id.survey_title)
        my_tile.text = surveyType

        if(surveyType != null){
        generateSurvey(surveyType)
        }

        val submitButton = findViewById<Button>(R.id.button2)
        submitButton.setOnClickListener{

        }

    }
    private fun generateSurvey(surveyType:String){
        val surveyContainer= findViewById<LinearLayout>(R.id.surveyContainer)
        when(surveyType){
            "Food Preferences"->{
                val questions = listOf(
                    "What is your favorite cuisine?" to listOf("Chinese", "French", "Italian", "Indian", "Japanese", "Thai", "Turkish"),
                    "How often do you eat out?" to listOf("Never", "Rarely", "Sometimes", "Frequently"),
                    "Do you prefer spicy food?" to listOf("Yes", "No"),
                    "Do you prefer vegetarian food?" to listOf("Yes", "No"),
                    "Do you like seafood?" to listOf("Yes", "No"),
                )
                questions.forEach{(question,options)->
                    addQuestion(question,options)
                }
            }
            "Dietary Habits"->{
                val questions = listOf(

                    "Are you vegetarian? " to listOf("Yes", "No"),
                    "Do you prefer organic food?" to listOf("Yes", "No"),
                    "Do you consume dairy products? " to listOf("Yes", "No"),
                    "Do you eat fast food?" to listOf("Yes", "No"),
                    "Do you have any food allergies? " to listOf("Yes", "No"),
                )
                questions.forEach{(question,options)->
                    addQuestion( question,options)
                }
            }
        }
    }
    private fun addQuestion(question: String, choices: List<String>){
        val llQuestionsContainer = findViewById<LinearLayout>(R.id.surveyContainer)
        val questionTextView = TextView(this).apply {
            text = question
            textSize = 18f
            setTypeface(null, Typeface.BOLD)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = 16
            }
        }
        val radioGroup = RadioGroup(this).apply {
            orientation = RadioGroup.VERTICAL
        }
        choices.forEach { choice ->
            val radioButton = RadioButton(this).apply {
                text = choice
            }
            radioGroup.addView(radioButton)
        }
        llQuestionsContainer.addView(questionTextView)
        llQuestionsContainer.addView(radioGroup)
    }
}