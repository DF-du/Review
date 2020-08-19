package com.csj.fxt.fragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.csj.fxt.BaseApp;
import com.csj.fxt.R;
import com.csj.fxt.adapter.HomeAdapter;
import com.csj.fxt.bean.DatasBean;
import com.csj.fxt.db.DatasBeanDao;
import com.csj.fxt.presenter.HomePresenter;
import com.csj.fxt.view.HomeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeView {
    private RecyclerView mRecycler;
    private int page = 294;
    private ArrayList<DatasBean> list;
    private HomeAdapter adapter;
    private SmartRefreshLayout mSmart;
    private HomePresenter homePresenter;
    private int mPosition;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_home, null);
        initView(inflate);
        homePresenter = new HomePresenter(this);
        homePresenter.getData(page);
        setHasOptionsMenu(true);


        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mSmart = (SmartRefreshLayout) itemView.findViewById(R.id.smart);
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);



        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                page++;
                homePresenter.getData(page++);
                mSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishRefresh();
            }


        });

        adapter.setOnClickListener(new HomeAdapter.onClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "11111111111111", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                mPosition = position;
                registerForContextMenu(mRecycler);
            }
        });
    }

    @Override
    public void setData(List<DatasBean> datasBeans) {
        list.addAll(datasBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.options, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options1:
                mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                break;
            case R.id.options2:
                mRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
                break;
            case R.id.options3:
                mRecycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context1:
                DatasBeanDao beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
                DatasBean datasBean = list.get(mPosition);
                beanDao.insertOrReplaceInTx(datasBean);
                break;
            case R.id.context2:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
