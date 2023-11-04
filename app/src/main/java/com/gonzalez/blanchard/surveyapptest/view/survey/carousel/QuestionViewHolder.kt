package com.gonzalez.blanchard.surveyapptest.view.survey.carousel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO
import com.gonzalez.blanchard.surveyapptest.databinding.ItemSurveyQuestionBinding

class QuestionViewHolder(view: View, private val onClickListener: (QueryItemBO) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSurveyQuestionBinding.bind(view)

    fun bind(queryItem: QueryItemBO, totalElements: Int) {
        binding.titleText.text = queryItem.attributes.text
        binding.numQuestionText.text = "${queryItem.attributes.displayOrder}/$totalElements"
        binding.arrowIcon.setOnClickListener {
            onClickListener(queryItem)
        }
    }
}
