package com.example.leidong.recycleviewtest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class GridViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Integer> mDatas;

    private int[] pictures = {
            R.drawable.landscape1, R.drawable.landscape2, R.drawable.landscape3,
            R.drawable.landscape4, R.drawable.landscape5,R.drawable.landscape6,
            R.drawable.landscape7, R.drawable.landscape8,R.drawable.landscape9,
            R.drawable.landscape10,R.drawable.landscape11,R.drawable.landscape12,
            R.drawable.landscape13,R.drawable.landscape14,R.drawable.landscape15,
            R.drawable.landscape16,R.drawable.landscape17,R.drawable.landscape18,
            R.drawable.landscape19,R.drawable.landscape20,R.drawable.landscape21,
            R.drawable.landscape22,R.drawable.landscape23,R.drawable.landscape24,
            R.drawable.landscape25,R.drawable.landscape26,R.drawable.landscape27,
            R.drawable.landscape28,R.drawable.landscape29,R.drawable.landscape30
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_activity);

        //初始化布局
        initView();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new GridViewActivity.MyGridAdapter());
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

    class MyGridAdapter extends RecyclerView.Adapter<GridViewActivity.MyGridAdapter.MyViewHolder>{
        @Override
        public GridViewActivity.MyGridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new GridViewActivity.MyGridAdapter.MyViewHolder(LayoutInflater.from(
                    GridViewActivity.this).inflate(R.layout.gridview_item, parent,
                    false));
        }

        @Override
        public void onBindViewHolder(GridViewActivity.MyGridAdapter.MyViewHolder holder, int position) {
            holder.iv.setImageResource(mDatas.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(GridViewActivity.this, "点击响应", Toast.LENGTH_LONG).show();
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(GridViewActivity.this);
                    builder.setTitle("提示");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setMessage("长按点击响应");
                    builder.setNegativeButton("取消", null);
                    builder.setPositiveButton("确定", null);
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
