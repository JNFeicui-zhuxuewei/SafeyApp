package com.example.safeyapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safeyapp.R;
import com.example.safeyapp.bean.Appbean;
import com.example.safeyapp.engine.RjglProvider;

import java.util.List;

public class RjglActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView mlvAppList;
    List<Appbean> mData;
    private static final String TAG = "RjglActivity";
    private RjglAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rjgl);

        mlvAppList = (ListView) findViewById(R.id.rigl_lv_app);
        // for (int i = 0; i < 50; i++) {
        //    Appbean bean =new Appbean();
        //  bean.name = "app" + 1;

        //  mData.add(bean);
        // }

        mAdapter = new RjglAdapter();
        mlvAppList.setOnItemClickListener(this);


    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: start");

    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: start");
        mlvAppList.removeAllViewsInLayout();
        //调用自己写的方法 拿到需要的数据 赋值给list对象
        mData = RjglProvider.getAppInfo(RjglActivity.this);

        mlvAppList.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Appbean appBean = mData.get(position);
                 String  packageName = appBean.packageName;
                 Intent intent = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + packageName));
                 startActivity(intent);


    }

    private class RjglAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if (mData != null) {
                return mData.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mData != null) {
                return mData.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.item_rigl_list, null);

                holder.ivIcon = (ImageView) convertView.findViewById(R.id.item_rigl_iv_icon);
                holder.tvName = (TextView) convertView.findViewById(R.id.item_rigl_tv_name);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();

            }
            Appbean bean = (Appbean) getItem(position);
            holder.ivIcon.setImageDrawable(bean.icon);
            holder.tvName.setText(bean.name);
            return convertView;


        }
    }

    private class ViewHolder {
        ImageView ivIcon;
        TextView tvName;
    }


}
