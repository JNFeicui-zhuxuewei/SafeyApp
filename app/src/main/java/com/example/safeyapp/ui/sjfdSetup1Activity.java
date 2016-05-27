package com.example.safeyapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.safeyapp.R;

public class sjfdSetup1Activity extends BaseSetupActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_sjfd_setup1);
    }


    protected  void nextActivity(){
        start(sjfdSetup2Activity.class);
    }
    protected  void  prevActivity(){

    }
}
