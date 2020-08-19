package com.csj.fxt.system;


import com.csj.fxt.bean.NaviBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface NavigationService {
    String sWanUrl = "https://wanandroid.com/";

    //公众号tab
    //导航
    @GET("navi/json")
    Flowable<NaviBean> getNavi();
}
