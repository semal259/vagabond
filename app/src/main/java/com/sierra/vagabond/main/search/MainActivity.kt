package com.sierra.vagabond.main.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sierra.vagabond.R
import com.sierra.vagabond.VagabondApplication
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.di.DaggerAppComponent
import com.sierra.vagabond.main.search.adapter.RecreationalAreaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainMvp.View, SearchView.OnQueryTextListener {

    private lateinit var presenter: MainMvp.Presenter
    private var errorSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.builder()
                .activity(this)
                .build()
        setContentView(R.layout.activity_main)
        initializeToolbarAndRecyclerView()
        presenter = MainPresenter(this, RecAreaRepository(this), this)

    }

    private fun initializeToolbarAndRecyclerView() {
        setSupportActionBar(main_app_toolbar)
        main_app_toolbar.setTitle(R.string.app_name)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        search_recycler_view.layoutManager = layoutManager
        search_recycler_view.setHasFixedSize(true)
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.INVISIBLE
    }

    override fun onResponseFailure() {
        errorSnackBar = Snackbar.make(layout_id, R.string.area_error, Snackbar.LENGTH_INDEFINITE)
        errorSnackBar?.show()
    }

    override fun setDataToRecyclerView(recAreasList: RecreationalAreaList) {
        val recreationalAreaAdapter = RecreationalAreaAdapter(recAreasList)
        search_recycler_view.adapter = recreationalAreaAdapter
        Log.d(MainActivity::class.java.simpleName, recAreasList.toString())
    }

    /*override fun provideContext(): Context {
        return this
    }*/

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu.findItem(R.id.app_bar_search)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = android.R.attr.maxWidth
        searchView.queryHint = getString(R.string.national_park_hint)
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(s: String): Boolean {
        presenter.onSearch(s)
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }


}
