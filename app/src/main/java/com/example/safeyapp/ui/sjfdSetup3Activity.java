package com.example.safeyapp.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.safeyapp.R;

public class sjfdSetup3Activity extends BaseSetupActivity {


    // 声明文本框
    private EditText et_mobile;
    //声明姓名，电话
    private String username,usernumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifd_setup3);

    }

    @Override
    protected void initView() {
        // 根据ID获得文本框
        et_mobile = (EditText) this.findViewById(R.id.mobileTel);


    }


    protected void  getTelClick(View v){
        startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),0);

    }

    protected  void  onActivityReault(int requestCode, int resultCode, Intent data){
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == Activity.RESULT_OK){
            // ContentProvider 展示数据类似一个单个数据库表
            // Contentresolver 实力带的方法可实现可找到指定的ContentProvider并获取到ContentProvider的数据
            ContentResolver reContentResolver = getContentResolver();
            // URI , 每个ContentProvider定义一个唯一的公开的URI,用于指定到它的数据集
            Uri contactData = data.getData();
            // 查询就是输入URI等参数，其中URI是必须的，其他是可选择的，如果系统能找到URI对应的ContentProvider将返回一个Cursor对象
            Cursor cursor =managedQuery(contactData,null,null,null,null);
            cursor.moveToFirst();
            // 获得DATA表中的名字
            username = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            // 条件为联系人ID
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            // 获得DATA表中的电话号码， 条件为联系人ID，因为   手机号码可能会有多个
            Cursor phone = reContentResolver.query(
                      ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                      ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "="+
                              contactId,null,null);
            while (phone.moveToNext()){
                usernumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                et_mobile.setText(usernumber + "(" + username+")");
            }
        }


    }


    protected  void nextActivity(){

        start(sjfdSetup4Activity.class);
    }
    protected  void  prevActivity(){
        start(sjfdSetup2Activity.class);

    }
}
