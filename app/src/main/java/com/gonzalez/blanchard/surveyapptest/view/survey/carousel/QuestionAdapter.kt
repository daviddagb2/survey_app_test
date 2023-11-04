package com.gonzalez.blanchard.surveyapptest.view.survey.carousel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO
import com.gonzalez.blanchard.surveyapptest.R

class QuestionAdapter(
    private val querylist: List<QueryItemBO>,
    private val itemClickListener: (QueryItemBO) -> Unit,
) : RecyclerView.Adapter<QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_survey_question, parent, false)
        return QuestionViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val item = querylist[position]
        holder.bind(item, querylist.size)
    }

    override fun getItemCount(): Int {
        return querylist.size
    }
}
