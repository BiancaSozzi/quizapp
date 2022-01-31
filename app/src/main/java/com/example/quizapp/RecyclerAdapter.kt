package com.example.quizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private val dataSet: List<String>, private val correctAnswer: Int, private val next: Button): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    var selectedItemPos = -1
    var lastItemSelectedPos = -1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val option: TextView

        init {
            // Define click listener for the ViewHolder's View.
            option = view.findViewById(R.id.option_text)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.option_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.option.text = dataSet[position]

        viewHolder.itemView.setOnClickListener {
            selectedItemPos = position

            if(lastItemSelectedPos == -1)
                lastItemSelectedPos = selectedItemPos
            else {
                notifyItemChanged(lastItemSelectedPos)
                lastItemSelectedPos = selectedItemPos
            }

            notifyItemChanged(selectedItemPos)
        }

        if (position == selectedItemPos) {
            if (position == correctAnswer) {
                viewHolder.option.background = ResourcesCompat.getDrawable(
                    viewHolder.itemView.context.resources, R.drawable.correct_option_border, viewHolder.itemView.context.theme)
                next.isEnabled = true
            } else {
                viewHolder.option.background = ResourcesCompat.getDrawable(
                    viewHolder.itemView.context.resources, R.drawable.incorrect_option_border, viewHolder.itemView.context.theme)
                next.isEnabled = false
            }
        } else {
            viewHolder.option.background = ResourcesCompat.getDrawable(
                viewHolder.itemView.context.resources, R.drawable.default_option_border, viewHolder.itemView.context.theme)
        }
    }

    override fun getItemCount() = dataSet.size

}