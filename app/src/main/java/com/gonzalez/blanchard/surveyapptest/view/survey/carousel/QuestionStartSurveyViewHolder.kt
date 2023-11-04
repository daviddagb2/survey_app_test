package com.gonzalez.blanchard.surveyapptest.view.survey.carousel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO
import com.gonzalez.blanchard.surveyapptest.databinding.ItemQuestionStartTestBinding

class QuestionStartSurveyViewHolder(view: View, private val onClickListener: (QueryItemBO) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = ItemQuestionStartTestBinding.bind(view)

    fun bind(queryItem: QueryItemBO) {
        binding.titleText.text = queryItem.attributes.shortText
        binding.txtSubTitle.text = queryItem.attributes.text
        binding.btnStartSurvey.setOnClickListener {
            onClickListener(queryItem)
        }
    }
}
