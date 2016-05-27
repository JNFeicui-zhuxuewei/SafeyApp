package com.example.safeyapp.engine;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import com.example.safeyapp.bean.Appbean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 似水流年 on 2016/5/11.
 */
public class RjglProvider {


    /**
     * 自定义一个方法 拿到需要的应用信息
     */

    public static List<Appbean> getAppInfo(Context context) {
        //上下文拿到PackageManager的对象
        PackageManager pm = context.getPackageManager();
        //通过对象拿到集合
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        // 定义一个数据集合
        List<Appbean> mData = new ArrayList<>();
        // 遍历PM的集合 拿到里面的数据
        for (PackageInfo info : packages) {
            //拿到图标
            Drawable icon = info.applicationInfo.loadIcon(pm);
            // 拿到应用程序的名称
            String name = info.applicationInfo.loadLabel(pm).toString();
            String packageName = info.applicationInfo.packageName;
            Appbean bean = new Appbean();
            bean.name = name;
            bean.icon = icon;
            bean.packageName = packageName;

            mData.add(bean);
        }
        return mData;
    }
}
