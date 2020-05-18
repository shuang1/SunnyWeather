package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {

    //创建了一个PlaceService接口的动态代理对象
//    private val palceService = ServiceCreator.create(PlaceService::class.java)
    private val palceService = ServiceCreator.create<PlaceService>()
    //suspend定义一个挂起函数
    suspend fun searchPlaces(query: String) = palceService.searchPlaces(query).await()
    //使用协程
    //使用suspendCoroutine函数处理请求结果回调 它也是个挂起函数，必须在协程作用域中或挂起函数中才能调用
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}