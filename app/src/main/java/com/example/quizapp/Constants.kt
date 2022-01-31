package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        questionsList.addAll(arrayListOf(
            Question(1, "Which country does this flag belong to?", R.drawable.ic_flag_of_argentina, listOf("Argentina", "Peru", "Brazil", "Mexico"), 0),
            Question(2, "Which country does this flag belong to?", R.drawable.ic_flag_of_belgium, listOf("Germany", "Belgium", "Brasil", "Mexico"), 1),
            Question(3, "Which country does this flag belong to?", R.drawable.ic_flag_of_brazil, listOf("Argentina", "Portugal", "Brazil", "Mexico"), 2),
            Question(4, "Which country does this flag belong to?", R.drawable.ic_flag_of_denmark, listOf("Norway", "Denmark", "Switzerland", "Russia"), 1),
            Question(5, "Which country does this flag belong to?", R.drawable.ic_flag_of_fiji, listOf("Fiji", "China", "Japan", "Thailand"), 0),
            Question(6, "Which country does this flag belong to?", R.drawable.ic_flag_of_germany, listOf("Spain", "France", "Germany"), 2),
            Question(7, "Which country does this flag belong to?", R.drawable.ic_flag_of_india, listOf("Turkey", "India", "Morocco"), 1),
            Question(8, "Which country does this flag belong to?", R.drawable.ic_flag_of_kuwait, listOf("Argentina", "Peru", "Brasil", "Kuwait"), 3),
            Question(9, "Which country does this flag belong to?", R.drawable.ic_flag_of_new_zealand, listOf("New Zealand", "Australia", "China", "Kuwait"), 0),
        ))

        return questionsList
    }
}