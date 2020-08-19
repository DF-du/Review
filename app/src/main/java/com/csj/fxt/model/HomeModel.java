package com.csj.fxt.model;

import com.csj.fxt.bean.JavaBean;
import com.csj.fxt.net.ApiService;
import com.csj.fxt.net.HomeCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel {
    public void getData(final HomeCallBack callBack, int page) {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<JavaBean>() {
                    @Override
                    public void onNext(JavaBean javaBean) {
                        callBack.onSuccess(javaBean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFail(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
