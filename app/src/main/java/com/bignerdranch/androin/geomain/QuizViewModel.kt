package com.bignerdranch.androin.geomain

import android.util.Log
import androidx.lifecycle.ViewModel
import java.nio.file.attribute.PosixFileAttributeView

private const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {
    private val questionBank = listOf(
        Question(R.string.quest_australia, true),
        Question(R.string.quest_ocean, true),
        Question(R.string.quest_mideast,false),
        Question(R.string.quest_africa, false),
        Question(R.string.quest_americas, true),
        Question(R.string.quest_asia,true))
    var currentIndex = 0
    var currentTrue = 0
    var currentAnswer = 0
    var QuestSize = questionBank.size

    val currentQuestionAnswer: Boolean get() = questionBank[currentIndex].answer
    val currentQuestionText: Int get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex+1) % questionBank.size
    }
    fun moveToBack(){
        currentIndex = (currentIndex+1) % questionBank.size
    }
}