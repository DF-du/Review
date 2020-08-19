package com.csj.fxt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.csj.fxt.R;
import com.csj.fxt.bean.DatasBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<DatasBean> list;
    private int VIEW_TYPE1 = 0;
    private int VIEW_TYPE2 = 1;

    public HomeAdapter(Context context, ArrayList<DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, parent, false);
            return new ViewHolder1(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = holder.getItemViewType();
        DatasBean datasBean = list.get(position);
        if (itemViewType == VIEW_TYPE1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(context).load(datasBean.getEnvelopePic()).apply(requestOptions).into(viewHolder1.mOneImg);
            viewHolder1.mOneTitle.setText(datasBean.getTitle());
        } else {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(context).load(datasBean.getEnvelopePic()).apply(requestOptions).into(viewHolder2.mTwoImg);
            viewHolder2.mTwoTitle.setText(datasBean.getTitle());
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onClickListener.onLongClick(position);
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return VIEW_TYPE1;
        } else {
            return VIEW_TYPE2;
        }
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView mOneImg;
        TextView mOneTitle;

        public ViewHolder1(View itemView) {
            super(itemView);
            mOneImg = (ImageView) itemView.findViewById(R.id.img_one);
            mOneTitle = (TextView) itemView.findViewById(R.id.title_one);
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView mTwoTitle;
        ImageView mTwoImg;

        public ViewHolder2(View itemView) {
            super(itemView);
            mTwoTitle = (TextView) itemView.findViewById(R.id.title_two);
            mTwoImg = (ImageView) itemView.findViewById(R.id.img_two);
        }
    }

    private onClickListener onClickListener;

    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface onClickListener {
        void onClick(int position);
        void onLongClick(int position);
    }
}
