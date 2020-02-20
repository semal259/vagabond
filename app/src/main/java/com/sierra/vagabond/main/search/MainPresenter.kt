package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor (private val view: MainController.View, private val recAreaRepository: RecAreaRepository) : MainController.ViewModel {

    private val compositeDisposable = CompositeDisposable()
    private var isDataStored: Boolean = false

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onSearch(query: String) {
       /* view.showProgress()
        compositeDisposable.add(recAreaRepository
                .getRecAreasList(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ areas ->
                    isDataStored = true
                    handleSuccess(areas)
                    areas.areasList.forEach { area ->
                        recAreaRepository.insert(area)
                    }
                },
                { error -> handleError(error) }))*/
    }

    private fun handleSuccess(result: RecreationalAreaList) {
        view.hideProgress()
        if (result.areasList.isEmpty()) {
            view.onResponseFailure()
        } else {
//            view.setDataToRecyclerView(result)
        }
    }

    private fun handleError(error: Throwable) {
        view.hideProgress()
        view.onResponseFailure()
        error.stackTrace
    }


    /*private fun clearDb() {
        if (isDataStored) {
            Completable.fromAction {
                areaRepository.clearAll()
            }
                    .subscribeOn(Schedulers.single())
                    .subscribe { isDataStored = false }
                    .dispose()

        }
    }*/
}
