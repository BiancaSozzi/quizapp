package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            listOf("Argentina", "Peru", "Brasil", "Mexico"),
            0
        )

        questionsList.add(que1)

        return questionsList
    }
}