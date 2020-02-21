package com.sierra.vagabond.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecreationalArea

class RecreationalAreaAdapter(recreationalAreaList: Sequence<RecreationalArea>) : RecyclerView.Adapter<AreaHolder>() {

    private val areaAdapterPresenter: AreaAdapterPresenter = AreaAdapterPresenter(recreationalAreaList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaHolder {
        return AreaHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false))
    }

    override fun onBindViewHolder(holder: AreaHolder, position: Int) {
        areaAdapterPresenter.onBindDataToAdapter(holder, position)
    }

    override fun getItemCount(): Int {
        return areaAdapterPresenter.areaCount
    }
}
