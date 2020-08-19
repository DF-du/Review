package com.csj.fxt.net;

import com.csj.fxt.bean.DatasBean;

import java.util.List;

public interface HomeCallBack {
    void onSuccess(List<DatasBean> datasBeans);

    void onFail(String str);
}
