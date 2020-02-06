package com.sierra.vagabond.data

import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.api.SierraApiService
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.data.local.RecAreaDao
import com.sierra.vagabond.di.AreasAPI
import com.sierra.vagabond.di.SierraAPI
import com.sierra.vagabond.utils.CAMPING
import com.sierra.vagabond.utils.BY_NAME
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RecAreaRepository @Inject constructor(private val recAreaDao: RecAreaDao, @AreasAPI private val service: AreasApiService, @SierraAPI private val sierraAPI: SierraApiService) {

    fun getRecAreasList(query: String): Observable<RecreationalAreaList> {
        sierraAPI.getWatches("", true, "")
        return service.getRecreationalAreaData(query, full = true, activity = CAMPING, by = BY_NAME).also {
            it.map { areaList ->
                recAreaDao.saveAll(areaList.areasList)
            }
        }
    }

    fun getSingleArea(recAreaId: String): Flowable<RecreationalArea> {
        return recAreaDao.getAreaDistinct(recAreaId)
    }

    fun createWatch(watch: WatchRequest) {
        sierraAPI.createWatch(watch)
    }

    fun insert(recreationalArea: RecreationalArea) {
        recAreaDao.save(recreationalArea)
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun clearAll() {
        recAreaDao.deleteAll()
    }
}
