package com.example.leidong.recycleviewtest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leidong on 2017/3/28.
 */

public class StaggeredGridViewActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private List<Integer> mDatas;

    private int[] pictures = {
            R.drawable.plant1, R.drawable.plant2, R.drawable.plant3,
            R.drawable.plant4, R.drawable.plant5, R.drawable.plant6,
            R.drawable.plant7, R.drawable.plant8, R.drawable.plant9,
            R.drawable.plant10, R.drawable.plant11, R.drawable.plant12,
            R.drawable.plant13, R.drawable.plant14, R.drawable.plant15,
            R.drawable.plant16, R.drawable.plant17, R.drawable.plant18,
            R.drawable.plant19, R.drawable.plant20, R.drawable.plant21,
            R.drawable.plant22, R.drawable.plant23, R.drawable.plant24,
            R.drawable.plant25, R.drawable.plant26, R.drawable.plant27,
            R.drawable.plant28, R.drawable.plant29, R.drawable.plant30,
            R.drawable.plant31, R.drawable.plant32, R.drawable.plant33
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staggerdgridview_activity);

        //初始化布局
        initView();

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new StaggeredGridViewActivity.MyStaggeredGridAdapter());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 初始化布局
     */
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mDatas = new ArrayList<>();
        for(int i = 0; i < pictures.length; i++){
            mDatas.add(pictures[i]);
        }
    }

    class MyStaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridViewActivity.MyStaggeredGridAdapter.MyViewHolder>{
        @Override
        public StaggeredGridViewActivity.MyStaggeredGridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new StaggeredGridViewActivity.MyStaggeredGridAdapter.MyViewHolder(LayoutInflater.from(
                    StaggeredGridViewActivity.this).inflate(R.layout.staggeredgridview_item, parent,
                    false));
        }

        @Override
        public void onBindViewHolder(StaggeredGridViewActivity.MyStaggeredGridAdapter.MyViewHolder holder, int position) {
            holder.iv.setImageResource(mDatas.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(StaggeredGridViewActivity.this, "点击响应", Toast.LENGTH_LONG).show();
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(StaggeredGridViewActivity.this);
                    builder.setTitle("提示");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setMessage("长按点击响应");
                    builder.setPositiveButton("确定", null);
                    builder.setNegativeButton("取消", null);
                    builder.create().show();
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            MyViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.image);
            }
        }
    }
}
