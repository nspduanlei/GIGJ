package com.app.gigj.support.wsdl;

import android.content.Context;

import com.app.gigj.config.Constants;
import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.model.response.sendver.SendCodeResponseEnvelope;
import com.app.gigj.domin.repository.Repository;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Observable;

public class WsdlDataSource implements Repository {

    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;
    private final GIGJApi mApi;

    @Inject
    public WsdlDataSource(Context context) {

        //开启响应数据缓存到文件系统功能
        final File cacheDir = new File(context.getCacheDir(), "httpResponseCache");

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)

                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)

//                .addInterceptor(new LoggingInterceptor(context))
//                .addInterceptor(new CacheInterceptor(context))
//                //用json文件模拟数据
//                //.addInterceptor(new MockInterceptor(context))
//                .addNetworkInterceptor(new HeaderInterceptor(context))
                .addNetworkInterceptor(new StethoInterceptor()) //debug
//                .cache(new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE))
                .addInterceptor(chain -> {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Content-Type", "text/xml;charset=UTF-8")//添加请求头
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                })

                .build();


        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);

        Retrofit crmApiAdapter = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .client(client)
                .build();

        mApi = crmApiAdapter.create(GIGJApi.class);
    }

    @Override
    public Observable<AppSelectResponseEnvelope> appSelect(RequestEnvelope requestEnvelope) {
        return mApi.appselect(requestEnvelope);
    }

    @Override
    public Observable<SendCodeResponseEnvelope> sendCode(RequestEnvelope requestEnvelope) {
        return mApi.sendVerifacation(requestEnvelope);
    }

    @Override
    public Observable<LoginResponseEnvelope> login(RequestEnvelope requestEnvelope) {
        return mApi.login(requestEnvelope);
    }


}
