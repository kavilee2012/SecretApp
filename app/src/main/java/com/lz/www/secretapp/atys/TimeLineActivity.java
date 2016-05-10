package com.lz.www.secretapp.atys;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

import com.lz.www.secretapp.R;

/**
 * Created by Administrator on 2016-05-10.
 */
public class TimeLineActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_layout);
    }
}
