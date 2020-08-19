package com.csj.fxt.net;

import com.csj.fxt.bean.JavaBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //    https://www.wanandroid.com/article/list/0/json?cid=60
//    https://www.wanandroid.com/project/list/1/json?cid=294
    String sUrl = "https://www.wanandroid.com/";

    @GET("project/list/1/json")
    Flowable<JavaBean> getData(@Query("cid") int cid);
}
