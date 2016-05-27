package com.example.safeyapp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.safeyapp.R;
import com.example.safeyapp.utils.Constants;
import com.example.safeyapp.utils.SpUtils;

public class sjfdSetup2Activity extends BaseSetupActivity {
    Button mBtnBindSim;
    ImageView mIvIsBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    protected void  initView(){
        setContentView(R.layout.activity_sjfd_setup2);
        mBtnBindSim = (Button) findViewById(R.id.btn_bind_sim);
        mIvIsBind = (ImageView) findViewById(R.id.iv_lock);

        if (TextUtils.isEmpty(SpUtils.getString(getApplicationContext(),Constants.SIM))){
            // 如果是未绑定
            mIvIsBind.setImageResource(R.mipmap.ic_launcher);

        }else {
            mIvIsBind.setImageResource(R.mipmap.ic_launcher);
        }

    }

    public void  initEvent(){
        mBtnBindSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击按钮以后要绑定/解绑SIM卡
                // 需要判断 当前状态是 绑定 还是 未绑定 写在SP里
                if (TextUtils.isEmpty(SpUtils.getString(getApplicationContext(), Constants.SIM))) {
                    // 说明没有绑定SIM卡
                    // 执行绑定SIM卡的方法
                    TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    String simSerialNumber = tm.getSimSerialNumber(); //SIM卡里的唯一ID
                    //把SIM卡的ID保存起来
                    SpUtils.putString(getApplicationContext(), Constants.SIM, simSerialNumber);
                    Toast.makeText(sjfdSetup2Activity.this, "绑定了SIM卡", Toast.LENGTH_SHORT).show();
                    mIvIsBind.setImageResource(R.mipmap.ic_launcher);
                } else {
                    // 已经绑定过SIM卡
                    SpUtils.putString(getApplicationContext(), Constants.SIM, "");
                    Toast.makeText(sjfdSetup2Activity.this, "解绑SIM卡", Toast.LENGTH_SHORT).show();
                    mIvIsBind.setImageResource(R.mipmap.ic_launcher);
                }


            }
        });
          super.initEvent();
    }


    protected  void nextActivity(){
        // 判断是否绑定了SIM卡
        if (TextUtils.isEmpty(SpUtils.getString(getApplicationContext(),Constants.SIM))){
            Toast.makeText(sjfdSetup2Activity.this, "请先绑定SIM卡再继续", Toast.LENGTH_SHORT).show();
            return;
        }

        start(sjfdSetup3Activity.class);
    }
    protected  void  prevActivity(){
        start(sjfdSetup1Activity.class);

    }
}
