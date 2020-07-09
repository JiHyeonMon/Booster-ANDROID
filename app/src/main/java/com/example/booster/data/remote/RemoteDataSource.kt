package com.example.booster.data.remote

import com.example.booster.data.datasource.model.OrderListData
import com.example.booster.data.datasource.model.StoreDetailData
import com.example.booster.data.datasource.model.StoreFavData
import io.reactivex.Observable

interface RemoteDataSource {
    fun getStoreDetail(storeIdx : Int) : Observable<StoreDetailData>
    fun putStoreFav(storeIdx: Int) : Observable<StoreFavData>
    fun getOrderList() : Observable<OrderListData>
}