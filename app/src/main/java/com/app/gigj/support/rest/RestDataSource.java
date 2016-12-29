package com.app.gigj.support.rest;

import android.content.Context;

import com.app.gigj.config.Constants;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.support.rest.interceptors.CacheInterceptor;
import com.app.gigj.support.rest.interceptors.HeaderInterceptor;
import com.app.gigj.support.rest.interceptors.LoggingInterceptor;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestDataSource implements Repository {

    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;
    public static String END_POINT = Constants.TEST_BASE_URL;
    private final Api mCrmApi;

    @Inject
    public RestDataSource(Context context) {

        //开启响应数据缓存到文件系统功能
        final File cacheDir = new File(context.getCacheDir(), "httpResponseCache");

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)

                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)

                .addInterceptor(new LoggingInterceptor(context))
                .addInterceptor(new CacheInterceptor(context))

                //用json文件模拟数据
                //.addInterceptor(new MockInterceptor(context))

                .addNetworkInterceptor(new HeaderInterceptor(context))
                .addNetworkInterceptor(new StethoInterceptor()) //debug
                .cache(new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE))
                .build();


        Retrofit crmApiAdapter = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        mCrmApi = crmApiAdapter.create(Api.class);
    }


//    @Override
//    public Observable<Result<User>> login(RequestBody jsonString) {
//        return mCrmApi.login(jsonString);
//    }

}
