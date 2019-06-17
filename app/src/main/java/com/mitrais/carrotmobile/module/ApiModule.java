package com.mitrais.carrotmobile.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mitrais.carrotmobile.Configuration;
import com.mitrais.carrotmobile.data.ApiHelper;
import com.mitrais.carrotmobile.data.PreferencesHelper;
import com.mitrais.carrotmobile.model.ApplicationScope;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = PreferencesModule.class)
public class ApiModule {
    @Provides
    public ApiHelper apiService(Retrofit retrofit){
        return retrofit.create(ApiHelper.class);
    }

    @ApplicationScope
    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory,RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient){
        return new Retrofit
                .Builder()
                .baseUrl(Configuration.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    public OkHttpClient okHttpClient(PreferencesHelper preferencesHelper){
        return new OkHttpClient
                .Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5,TimeUnit.MINUTES)
                .readTimeout(5,TimeUnit.MINUTES)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(
                        new Interceptor() {
                            @NotNull
                            @Override
                            public Response intercept(@NotNull Chain chain) throws IOException {
                                Request request=chain.request().newBuilder().addHeader("Authorization","Bearer "+preferencesHelper.getPreference("token")).build();
                                return chain.proceed(request);
                            }
                        }
                ).build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    public RxJava2CallAdapterFactory rxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }

    @ApplicationScope
    @Provides
    public CompositeDisposable compositeDisposable(){
        return  new CompositeDisposable();
    }
}
