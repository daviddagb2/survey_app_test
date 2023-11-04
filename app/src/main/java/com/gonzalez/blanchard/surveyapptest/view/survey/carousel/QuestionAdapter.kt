package com.gonzalez.blanchard.surveyapptest.view.survey.carousel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO
import com.gonzalez.blanchard.surveyapptest.R

class QuestionAdapter(
    private val queryList: List<QueryItemBO>,
    private val itemClickListener: (QueryItemBO) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val queryItem = queryList[position]
        return when (queryItem.attributes.displayType) {
            "intro" -> VIEW_TYPE_START_TEST
            "default" -> VIEW_TYPE_TEXT
            "star" -> VIEW_TYPE_MULTIPLE_CHOICE
            "yes_no" -> VIEW_TYPE_YES_NO
            "outro" -> VIEW_TYPE_OUTRO
            else -> VIEW_TYPE_DEFAULT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_START_TEST -> {
                val view = layoutInflater.inflate(R.layout.item_question_start_test, parent, false)
                QuestionStartSurveyViewHolder(view, itemClickListener)
            }
            VIEW_TYPE_TEXT -> {
                val view = layoutInflater.inflate(R.layout.item_question_text, parent, false)
                QuestionTextViewHolder(view, itemClickListener)
            }
            VIEW_TYPE_MULTIPLE_CHOICE -> {
                val view = layoutInflater.inflate(R.layout.item_question_multi_choice, parent, false)
                QuestionMultipleChoiceViewHolder(view, itemClickListener)
            }
            VIEW_TYPE_YES_NO -> {
                val view = layoutInflater.inflate(R.layout.item_question_yes_no, parent, false)
                QuestionYesNoViewHolder(view, itemClickListener)
            }
            VIEW_TYPE_DEFAULT -> {
                val view = layoutInflater.inflate(R.layout.item_survey_question, parent, false)
                QuestionViewHolder(view, itemClickListener)
            }
            VIEW_TYPE_OUTRO -> {
                val view = layoutInflater.inflate(R.layout.layout_question_finish, parent, false)
                QuestionFinishViewHolder(view, itemClickListener)
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.item_survey_question, parent, false)
                QuestionViewHolder(view, itemClickListener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = queryList[position]
        when (holder) {
            is QuestionStartSurveyViewHolder -> holder.bind(item)
            is QuestionTextViewHolder -> holder.bind(item, queryList.size)
            is QuestionMultipleChoiceViewHolder -> holder.bind(item, queryList.size)
            is QuestionYesNoViewHolder -> holder.bind(item, queryList.size)
            is QuestionViewHolder -> holder.bind(item, queryList.size)
            is QuestionFinishViewHolder -> holder.bind(item)
        }
    }

    override fun getItemCount(): Int = queryList.size

    companion object {
        private const val VIEW_TYPE_START_TEST = 1
        private const val VIEW_TYPE_TEXT = 2
        private const val VIEW_TYPE_MULTIPLE_CHOICE = 3
        private const val VIEW_TYPE_YES_NO = 4
        private const val VIEW_TYPE_DEFAULT = 5
        private const val VIEW_TYPE_OUTRO = 6
    }
}
