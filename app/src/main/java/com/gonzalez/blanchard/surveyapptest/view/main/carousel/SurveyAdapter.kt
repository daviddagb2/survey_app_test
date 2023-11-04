package com.gonzalez.blanchard.surveyapptest.view.main.carousel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.surveyapptest.R

class SurveyAdapter(
    private val surveys: List<SurveyBO>,
    private val itemClickListener: (SurveyBO) -> Unit,
    ) : RecyclerView.Adapter<SurveyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_survey, parent, false)
        return SurveyViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        val survey = surveys[position]
        holder.bind(survey)
    }

    override fun getItemCount(): Int {
        return surveys.size
    }
}
