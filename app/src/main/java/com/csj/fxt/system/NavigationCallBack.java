package com.csj.fxt.system;


import com.csj.fxt.bean.NaviBean;

import java.util.List;

public interface NavigationCallBack {
    void onSuccess(List<NaviBean.DataBean> dataBeans);
    void onFail(String str);
}
