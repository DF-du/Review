package com.csj.fxt.view;

import com.csj.fxt.bean.DatasBean;

import java.util.List;

public interface HomeView {
    void setData(List<DatasBean> datasBeans);

    void showToast(String str);
}
