package com.gonzalez.blanchard.surveyapptest.view.survey.carousel

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO
import com.gonzalez.blanchard.surveyapptest.databinding.LayoutQuestionFinishBinding

class QuestionFinishViewHolder(view: View, private val onClickListener: (QueryItemBO) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = LayoutQuestionFinishBinding.bind(view)

    fun bind(queryItem: QueryItemBO) {
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            onClickListener(queryItem)
        }
        handler.postDelayed(runnable, 3000)
    }
}
