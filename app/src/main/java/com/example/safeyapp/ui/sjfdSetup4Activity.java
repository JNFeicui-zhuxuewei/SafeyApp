package com.example.safeyapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.safeyapp.R;

public class sjfdSetup4Activity extends BaseSetupActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjfd_setup4);
    }

    @Override
    protected void initView() {

    }

    protected  void nextActivity(){
        Toast.makeText(sjfdSetup4Activity.this, "设置完毕", Toast.LENGTH_SHORT).show();
    }
    protected  void  prevActivity(){
        start(sjfdSetup3Activity.class);

    }
}
