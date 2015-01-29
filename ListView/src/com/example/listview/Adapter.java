package com.example.listview;
//@copyright vivek.pal
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
	
	private String[] year;
	private Context context;
	
	public Adapter(Context context, String[] strings) {
		this.year=strings;
		this.context=context;
	}

	@Override
	public int getCount() {
		return year.length;
	}

	@Override
	public Object getItem(int position) {
		return year[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row=null;
		if (convertView==null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(R.layout.custom_row, parent, false);
			
		}else {
			row=convertView;
		}
		row.setId(position);
		Log.e("vivek", year[position]);
		TextView textView=(TextView) row.findViewById(R.id.text_view);
		
		textView.setText(" "+year[position]);
		return row;
	}

}
