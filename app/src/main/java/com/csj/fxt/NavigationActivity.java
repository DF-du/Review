package com.csj.fxt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.fxt.adapter.SystemAdapter;
import com.csj.fxt.bean.NaviBean;
import com.csj.fxt.system.presenter.NavigationPresenter;
import com.csj.fxt.system.view.NavigationView;

import java.util.ArrayList;
import java.util.List;

import qdx.stickyheaderdecoration.NormalDecoration;


public class NavigationActivity extends AppCompatActivity implements NavigationView {

    private RecyclerView mRecycler;
    private ArrayList<NaviBean.DataBean> list;
    private SystemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initView();
        NavigationPresenter navigationPresenter = new NavigationPresenter(this);
        navigationPresenter.getData();
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new SystemAdapter(this, list);
        mRecycler.setAdapter(adapter);
        NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return list.get(i).getName();
            }
        };
        mRecycler.addItemDecoration(decoration);
    }

    @Override
    public void setData(List<NaviBean.DataBean> dataBeans) {
        list.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }
}
