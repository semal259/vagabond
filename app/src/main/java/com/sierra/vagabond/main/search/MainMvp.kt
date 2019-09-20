package com.sierra.vagabond.main.search

import android.content.Context
import com.sierra.vagabond.data.entities.RecreationalAreaList

interface MainMvp {

    interface Presenter {

        fun onDestroy()

        fun onSearch(query: String)
    }

    interface View {

        fun showProgress()

        fun hideProgress()

        fun setDataToRecyclerView(recAreasList: RecreationalAreaList)

        fun onResponseFailure()

//        fun provideContext(): Context
    }
}
