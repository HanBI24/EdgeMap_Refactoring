package com.example.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.common.Constants.ITEM_PER_PAGE
import com.example.common.Constants.PREV_NEXT_ITEM_PAGE
import com.example.data.mapper.Mapper.toTourInfoItem
import com.example.data.remote.api.TourInfoApi
import com.example.domain.model.TourInfoItem
import com.example.domain.repository.TourInfoRepository
import javax.inject.Inject

class TourInfoPagingSource @Inject constructor(
//    private val tourInfoRepository: TourInfoRepository
    private val tourInfoApi: TourInfoApi
) : PagingSource<Int, TourInfoItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TourInfoItem> {
        return try {
            Log.d("args", "paging success")
            val pageNo = params.key ?: 1
//            val tourInfoResponse = tourInfoRepository.getTourInfo(ITEM_PER_PAGE, pageNo)
            val tourInfoResponse = tourInfoApi.getTourInfo(ITEM_PER_PAGE, pageNo)
                .response.body.items.item.map { it.toTourInfoItem() }

            LoadResult.Page(
                data = tourInfoResponse,
                prevKey = if (pageNo == 1) null else pageNo.minus(PREV_NEXT_ITEM_PAGE),
                nextKey = pageNo.plus(PREV_NEXT_ITEM_PAGE)
            )
        } catch (e: Exception) {
            Log.d("args", "paging failed $e")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TourInfoItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}