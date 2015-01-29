package com.example.listview;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter1 extends BaseAdapter {

	private List<String> days;
	private Context context;
	
	public Adapter1(List<String> days, Context context) {
		this.days=days;
		this.context=context;
	}

	@Override
	public int getCount() {
		return days.size();
	}

	@Override
	public Object getItem(int position) {
		return days.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row=convertView;
		ViewHolder holder=null;
		
		if (row==null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(R.layout.custom_layout_1, parent, false);
			holder=new ViewHolder(row);
			row.setTag(holder);
		}else {
			holder=(ViewHolder) row.getTag();
		}
		
		if (holder==null) {
			Log.d("vivek", "holder is null");
		}
		holder.day.setText(" "+days.get(position));
		
		return row;
	}

}

class ViewHolder{
	TextView day;
	public ViewHolder(View view) {
		day=(TextView) view.findViewById(R.id.textView1);
	}
} 


