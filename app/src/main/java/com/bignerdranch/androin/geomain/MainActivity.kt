package com.bignerdranch.androin.geomain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public lateinit var trueButton : Button
    public lateinit var  falseButton : Button
    public  lateinit var  nextButton: ImageButton
    public  lateinit var  backButton: ImageButton
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
        backButton = findViewById(R.id.back_button)
        questionTextView = findViewById(R.id.textView)

        trueButton.setOnClickListener {
            CheckAnswer(true)
        }
        falseButton.setOnClickListener {
            CheckAnswer(false)
        }
        questionTextView.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            UpdateQuestion()
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            UpdateQuestion()
        }
        backButton.setOnClickListener {
            currentIndex = (currentIndex - 1) % questionBank.size
            UpdateQuestion()
        }
        UpdateQuestion()
    }
    private fun UpdateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private  fun CheckAnswer(UserAnswer: Boolean) {
        val correctAnwser = questionBank[currentIndex].answer
        val messageResId = if (UserAnswer == correctAnwser) {
            R.string.True_Toast
        }
        else {
            R.string.False_Toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}