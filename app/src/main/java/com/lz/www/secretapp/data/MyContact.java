package com.lz.www.secretapp.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-05-10.
 */
public class MyContact {
    public static String getContractJsonString(Context context){
        Cursor c = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        String phoneNum;
        while (c.moveToNext()){
            phoneNum =c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            System.out.print(phoneNum);

        }
        return null;
    }
}
