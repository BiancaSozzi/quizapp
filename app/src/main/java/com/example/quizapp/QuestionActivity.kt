package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionsList = Constants.getQuestions()

    }
}