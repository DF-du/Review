package com.csj.fxt.system.presenter;


import com.csj.fxt.bean.NaviBean;
import com.csj.fxt.system.NavigationCallBack;
import com.csj.fxt.system.model.NavigationModel;
import com.csj.fxt.system.view.NavigationView;

import java.util.List;

public class NavigationPresenter implements NavigationCallBack {
    private final NavigationModel navigationModel;
    private NavigationView navigationView;

    public NavigationPresenter(NavigationView navigationView) {
        this.navigationView = navigationView;
        navigationModel = new NavigationModel();
    }

    public void getData() {
        navigationModel.getData(this);
    }

    @Override
    public void onSuccess(List<NaviBean.DataBean> dataBeans) {
navigationView.setData(dataBeans);
    }

    @Override
    public void onFail(String str) {

    }
}
