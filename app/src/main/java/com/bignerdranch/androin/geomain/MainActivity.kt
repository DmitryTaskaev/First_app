package com.bignerdranch.androin.geomain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    public lateinit var trueButton : Button
    public lateinit var  falseButton : Button
    public  lateinit var  nextButton: ImageButton
    public  lateinit var  backButton: ImageButton
    public lateinit var questionTextView: TextView
    public lateinit var ResultButton: Button
    private  val questionBank = listOf(
        Question(R.string.quest_australia, true),
        Question(R.string.quest_ocean, true),
        Question(R.string.quest_mideast,false),
        Question(R.string.quest_africa, false),
        Question(R.string.quest_americas, true),
        Question(R.string.quest_asia,true))
    private  var currentIndex = 0
    private  var currentTrue = 0
    private  var currentAnswer = 0


    //Activity "onCreate"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate(Bundle?) called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.button_true)
        falseButton = findViewById(R.id.button_false)
        nextButton = findViewById(R.id.next_button)
        backButton = findViewById(R.id.back_button)
        questionTextView = findViewById(R.id.textView)
        ResultButton = findViewById(R.id.button_result)

        ResultButton.isVisible = false
        trueButton.setOnClickListener {
            CheckAnswer(true)
            currentAnswer = currentAnswer + 1
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            CheckCurr()

        }
        falseButton.setOnClickListener {
            CheckAnswer(false)
            currentAnswer = currentAnswer + 1
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            CheckCurr()
        }
        questionTextView.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            UpdateQuestion()
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            UpdateQuestion()
            CheckCurr()
        }
        backButton.setOnClickListener {
            currentIndex = (currentIndex - 1) % questionBank.size
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            UpdateQuestion()
            CheckCurr()
        }
        ResultButton.setOnClickListener {
            Toast.makeText(this, "Кол-во привильны ответов $currentTrue" , Toast.LENGTH_SHORT).show()
        }
        UpdateQuestion()
    }
    //Activity "OnStart"
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called")
    }
    //Activity "onResume"
    override fun onResume(){
        super.onResume()
        Log.d(TAG,"onResume() called")
    }
    //Activity "onPause"
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() called")
    }
    //Activity "onStop"
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")
    }
    //Activity "onDestroy"
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }
    private fun UpdateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private  fun CheckAnswer(UserAnswer: Boolean) {
        val correctAnwser = questionBank[currentIndex].answer
        val messageResId = if (UserAnswer == correctAnwser) {
            currentTrue = currentTrue+1
            R.string.True_Toast

        }
        else {
            R.string.False_Toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
    private fun CheckCurr(){
        if(currentAnswer == questionBank.size){
            ResultButton.isVisible = true
            backButton.isEnabled = false
            nextButton.isEnabled = false
        }
    }
}