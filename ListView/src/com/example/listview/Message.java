package com.example.listview;

import android.content.Context;
import android.widget.Toast;

public class Message {
	
	public static void toast(Context context,String string) {
		Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
	}

}
