package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

     val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    inline fun <reified T> create(): T = retrofit.create(T::class.java)//内联函数加泛型实例
//    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}
