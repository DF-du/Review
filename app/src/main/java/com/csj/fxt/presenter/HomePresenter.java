package com.csj.fxt.presenter;

import com.csj.fxt.bean.DatasBean;
import com.csj.fxt.model.HomeModel;
import com.csj.fxt.net.HomeCallBack;
import com.csj.fxt.view.HomeView;

import java.util.List;

public class HomePresenter implements HomeCallBack {
    private final HomeModel homeModel;
    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }

    public void getData(int page) {
        homeModel.getData(this,page);
    }

    @Override
    public void onSuccess(List<DatasBean> datasBeans) {
        homeView.setData(datasBeans);
    }

    @Override
    public void onFail(String str) {
        homeView.showToast(str);
    }
}
