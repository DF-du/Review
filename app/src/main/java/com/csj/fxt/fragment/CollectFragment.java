package com.csj.fxt.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.fxt.BaseApp;
import com.csj.fxt.R;
import com.csj.fxt.adapter.HomeAdapter;
import com.csj.fxt.bean.DatasBean;
import com.csj.fxt.db.DatasBeanDao;

import java.util.ArrayList;
import java.util.List;

public class CollectFragment extends Fragment {
    private RecyclerView mRecycler;
    private HomeAdapter adapter;
    private ArrayList<DatasBean> list;
    private DatasBeanDao datasBeanDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_collect, null);
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            list.clear();
            initData();
        }
    }

    private void initData() {
        datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        List<DatasBean> datasBeans = datasBeanDao.loadAll();
        list.addAll(datasBeans);
        adapter.notifyDataSetChanged();

    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);

        adapter.setOnClickListener(new HomeAdapter.onClickListener() {
            @Override
            public void onClick(final int position) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null, false);
                inflate.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatasBean datasBean = list.get(position);
                        list.remove(datasBean);
                        datasBeanDao.deleteInTx(datasBean);
                        adapter.notifyDataSetChanged();
                    }
                });
                final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
            }

            @Override
            public void onLongClick(int position) {

            }
        });
    }
}
