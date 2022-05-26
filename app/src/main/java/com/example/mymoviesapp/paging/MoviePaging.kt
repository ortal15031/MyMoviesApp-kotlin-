package com.example.mymoviesapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mymoviesapp.api.Api
import com.example.mymoviesapp.constants.Constants
import com.example.mymoviesapp.models.Movies
import com.example.mymoviesapp.resources.Resource

class MoviePaging(val api: Api) : PagingSource<Int, Movies>() {
override fun getRefreshKey(state: PagingState<Int, Movies>): Int? {
return state.anchorPosition?.let {
val anchorPage=state?.closestPageToPosition(it)
anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
}
}
override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movies> {
val page= params.key?:1
return try{
val data=api.getMovies(api_key = Constants.API_KEY,
start_year = Constants.START_YEAR,
end_year = Constants.END_YEAR,
page_number = page)
LoadResult.Page(
data= data.body()!!.results,
prevKey = if(page==1) null
else  page-1,
nextKey = if (data?.body()?.results?.isEmpty()!!) null
else if(page<Constants.LAST_PAGE_RES) page+1
else null,
itemsBefore = 0,
itemsAfter = 0
)
}catch (e:Exception){
LoadResult.Error(e)
}
}
}