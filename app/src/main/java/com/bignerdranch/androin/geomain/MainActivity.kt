package com.bignerdranch.androin.geomain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public lateinit var trueButton : Button
    public lateinit var  falseButton : Button
    public  lateinit var  nextButton: Button
    public lateinit var questionTextView: TextView
    private  val questionBank = listOf(
        Question(R.string.quest_australia, true),
        Question(R.string.quest_ocean, true),
        Question(R.string.quest_mideast,false),
        Question(R.string.quest_africa, false),
        Question(R.string.quest_americas, true),
        Question(R.string.quest_asia,true))
    private  var currentIndex = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.button_true)
        falseButton = findViewById(R.id.button_false)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.textView)

        trueButton.setOnClickListener {
            Toast.makeText(this,R.string.True_Toast,Toast.LENGTH_SHORT).show()


        }
        falseButton.setOnClickListener {
            Toast.makeText(this,R.string.False_Toast,Toast.LENGTH_SHORT).show()
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            UpdateQuestion()
        }
        UpdateQuestion()
    }
    private fun UpdateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private  fun CheckAnswer(UserAnswer: Boolean)
}