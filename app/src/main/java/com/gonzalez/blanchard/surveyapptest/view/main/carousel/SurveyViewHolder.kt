package com.gonzalez.blanchard.surveyapptest.view.main.carousel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.surveyapptest.databinding.ItemSurveyBinding
import com.squareup.picasso.Picasso

class SurveyViewHolder(view: View, private val onClickListener: (SurveyBO) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSurveyBinding.bind(view)

    fun bind(surveyItem: SurveyBO) {
        binding.titleText.text = surveyItem.attributes.title
        binding.subText.text = surveyItem.attributes.description
        Picasso.get().load(surveyItem.attributes.coverImageUrl).into(binding.surveybackground)
        binding.arrowIcon.setOnClickListener {
            onClickListener(surveyItem)
        }
    }
}
