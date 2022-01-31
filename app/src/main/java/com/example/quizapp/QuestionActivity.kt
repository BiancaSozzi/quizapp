package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuestionActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null
    private var optionsRv: RecyclerView? = null
    private var questionsList: ArrayList<Question> = ArrayList()
    private var currentPosition = 0
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        userName = intent.getStringExtra(Constants.USER_NAME)

        questionsList = Constants.getQuestions()

        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        val btnNextquestion: Button = findViewById(R.id.btn_submit)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.iv_flag)
        optionsRv = findViewById(R.id.options_rv)

        setQuestion(btnNextquestion)

        btnNextquestion.setOnClickListener {
            when {
                currentPosition < questionsList.size -> {
                    setQuestion(btnNextquestion)
                }
                else -> {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    startActivity(intent)
                    finish()
                }
            }
        }

    }

    fun setQuestion(btnNextquestion: Button) {
        btnNextquestion.isEnabled = false
        val question: Question = questionsList[currentPosition]
        val recyclerAdapter = RecyclerAdapter(question.options, question.correctAnswer, btnNextquestion)
        optionsRv?.layoutManager = LinearLayoutManager(this)
        optionsRv?.adapter = recyclerAdapter
        progressBar?.progress = ++currentPosition
        tvImage?.setImageResource(question.image)
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        if (currentPosition == questionsList.size) {
            btnNextquestion.text = "FINISH"
        } else {
            btnNextquestion.text = this.getText(R.string.next_question)
        }
    }
}