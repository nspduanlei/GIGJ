package com.app.gigj.injector.modules;

import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.domin.usecase.AppSelectUseCase;
import com.app.gigj.domin.usecase.LoginUseCase;
import com.app.gigj.domin.usecase.SendCodeUseCase;
import com.app.gigj.injector.Activity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by duanlei on 16/9/27.
 */
@Module
public class UserModule {

//    @Provides
//    @Activity
//    LoginUseCase provideLoginUseCase(
//            GoodsRepository repository,
//            @Named("ui_thread") Scheduler uiThread,
//            @Named("executor_thread") Scheduler executorThread,
//            @Named("gson") Gson gson) {
//        return new LoginUseCase(repository, uiThread, executorThread, gson);
//    }

    @Provides
    @Activity
    AppSelectUseCase provideAppSelectUseCase(
            RequestEnvelope requestEnvelope,
            Repository repository,
            @Named("ui_thread") Scheduler uiThread,
            @Named("executor_thread") Scheduler executorThread) {
        return new AppSelectUseCase(repository, uiThread, executorThread, requestEnvelope);
    }

    @Provides
    @Activity
    SendCodeUseCase provideSendCodeUseCase(
            RequestEnvelope requestEnvelope,
            Repository repository,
            @Named("ui_thread") Scheduler uiThread,
            @Named("executor_thread") Scheduler executorThread) {
        return new SendCodeUseCase(repository, uiThread, executorThread, requestEnvelope);
    }

    @Provides
    @Activity
    LoginUseCase provideLoginUseCase(
            RequestEnvelope requestEnvelope,
            Repository repository,
            @Named("ui_thread") Scheduler uiThread,
            @Named("executor_thread") Scheduler executorThread) {
        return new LoginUseCase(repository, uiThread, executorThread, requestEnvelope);
    }
}
