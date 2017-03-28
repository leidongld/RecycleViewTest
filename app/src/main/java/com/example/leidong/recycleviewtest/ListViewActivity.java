package com.example.leidong.recycleviewtest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leidong on 2017/3/22.
 */

public class ListViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Integer> mDatas;
    private int[] pictures = {
            R.drawable.animal1, R.drawable.animal2, R.drawable.animal3,
            R.drawable.animal4, R.drawable.animal5, R.drawable.animal6,
            R.drawable.animal7, R.drawable.animal8, R.drawable.animal9,
            R.drawable.animal10,R.drawable.animal11,R.drawable.animal12,
            R.drawable.animal13,R.drawable.animal14,R.drawable.animal15,
            R.drawable.animal16,R.drawable.animal17,R.drawable.animal18,
            R.drawable.animal19,R.drawable.animal20,R.drawable.animal21,
            R.drawable.animal22,R.drawable.animal23,R.drawable.animal24,
            R.drawable.animal25,R.drawable.animal26,R.drawable.animal27,
            R.drawable.animal28,R.drawable.animal29,R.drawable.animal30,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        //初始化布局
        initView();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListViewActivity.MyLineAdapter());
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

    class MyLineAdapter extends RecyclerView.Adapter<MyLineAdapter.MyViewHolder>{
        @Override
        public MyLineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(
                    ListViewActivity.this).inflate(R.layout.listview_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyLineAdapter.MyViewHolder holder, int position) {
            holder.iv.setImageResource(mDatas.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ListViewActivity.this, "点击响应", Toast.LENGTH_LONG).show();
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity.this);
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