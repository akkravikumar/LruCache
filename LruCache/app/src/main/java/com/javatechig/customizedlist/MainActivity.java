package com.javatechig.customizedlist;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.customizedlist.R;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListItem> listData = getListData();

        final ListView listView = (ListView) findViewById(R.id.custom_list);
        listView.setAdapter(new CustomListAdapter(this, listData));
        /*listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();

                PackageManager packageManager = getPackageManager();
                List<ApplicationInfo> infoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
                for (ApplicationInfo info : infoList) {
                    try {
                        Context context = createPackageContext(info.packageName, CONTEXT_IGNORE_SECURITY);
                        File cachedDirectory = context.getCacheDir();
                        long size = 0;
                        File[] files = cachedDirectory.listFiles();
                        for (File f : files) {
                            size = size + f.length();
                        }
                        Log.i("Filesize", "File = " + size);
                        Intent in = new Intent(MainActivity.this, PicassoClass.class);
                        startActivity(in);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/

    }

    private ArrayList<ListItem> getListData() {
        ArrayList<ListItem> listMockData = new ArrayList<ListItem>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] headlines = getResources().getStringArray(R.array.headline_array);

        for (int i = 0; i < images.length; i++) {
            ListItem natureData = new ListItem();
            natureData.setUrl(images[i]);
            natureData.setHeadline(headlines[i]);
            natureData.setReporterName("Ravi Kumar");
            natureData.setDate("July 14, 2016, 12.45");
            listMockData.add(natureData);
        }
        return listMockData;
    }
}
