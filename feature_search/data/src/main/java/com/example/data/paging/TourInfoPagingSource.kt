package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.common.Constants.ITEM_PER_PAGE
import com.example.common.Constants.PREV_NEXT_ITEM_PAGE
import com.example.domain.model.remote.TourInfoItem
import com.example.domain.repository.remote.TourInfoRepository

class TourInfoPagingSource constructor(
    private val tourInfoRepository: TourInfoRepository
) : PagingSource<Int, TourInfoItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TourInfoItem> {
        return try {
            val pageNo = params.key ?: 1
            val pageSize = tourInfoRepository.getTourInfoSize(ITEM_PER_PAGE, pageNo) / ITEM_PER_PAGE
            val pageList = (1..pageSize).shuffled()
            val tourInfoResponse = tourInfoRepository.getTourInfo(ITEM_PER_PAGE, pageList[pageNo])

            LoadResult.Page(
                data = tourInfoResponse,
                prevKey = if (pageNo == 1) null else pageNo.minus(PREV_NEXT_ITEM_PAGE),
                nextKey = pageNo.plus(PREV_NEXT_ITEM_PAGE)
            )
        } catch (e: Exception) {
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