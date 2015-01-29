package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import org.lucasr.twowayview.TwoWayView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TwoWayView twoWayView, days;
	// private TextView textView;
	private String[] year;
	private Adapter1 adapter1;
	private LinearLayout mContainer;
	private TextView name, password, day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_list_view);

		twoWayView = (TwoWayView) findViewById(R.id.lvItems);
		days = (TwoWayView) findViewById(R.id.no_of_days);
		year = getResources().getStringArray(R.array.year);
		mContainer=(LinearLayout) findViewById(R.id.container);
		name=(TextView) findViewById(R.id.name);
		password=(TextView) findViewById(R.id.pass);
		day=(TextView) findViewById(R.id.date);

		Adapter adapter = new Adapter(this, year);

		twoWayView.setAdapter(adapter);

		twoWayView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//view.setEnabled(true);
				//view.setFocusable(true);
				//view.setSelected(true);
				Toast.makeText(getApplicationContext(), year[position],
						Toast.LENGTH_SHORT).show();
				days.setVisibility(View.VISIBLE);
				mContainer.setVisibility(View.VISIBLE); 
				if ((gettingCode(year[position]) % 2 == 0)
						&& !(year[position].equals("feb"))) {

					List<String> list = new ArrayList<String>();

					for (int i = 1; i < 31; i++) {
						list.add("" + i);
					}

					adapter1 = new Adapter1(list, getApplicationContext());
					days.setAdapter(adapter1);
					Message.toast(getApplicationContext(), "even");

				} else if ((gettingCode(year[position]) % 2 != 0)
						&& !(year[position].equals("feb"))) {
					List<String> list = new ArrayList<String>();
					for (int i = 1; i < 32; i++) {
						list.add("" + i);
					}
					adapter1 = new Adapter1(list, getApplicationContext());
					days.setAdapter(adapter1);
					Message.toast(getApplicationContext(), "odd");

				} else {
					List<String> list = new ArrayList<String>();

					for (int i = 1; i < 30; i++) {
						list.add("" + i);
					}
					adapter1 = new Adapter1(list, getApplicationContext());
					days.setAdapter(adapter1);
					Message.toast(getApplicationContext(), "feb");
				}
			}
		});
		
		days.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ViewHolder holder=(ViewHolder) view.getTag();
				day.setText(holder.day.getText());
				name.setText("vivek");
				password.setText("pass"); 
			}
		});

	}

	private int gettingCode(String string) {
		if (string.equals("jan")) {
			return Constants.jan;
		} else if (string.equals("feb")) {
			return Constants.feb;
		} else if (string.equals("mar")) {
			return Constants.mar;
		} else if (string.equals("apr")) {
			return Constants.apr;
		} else if (string.equals("may")) {
			return Constants.may;
		} else if (string.equals("june")) {
			return Constants.june;
		} else if (string.equals("july")) {
			return Constants.july;
		} else if (string.equals("aug")) {
			return Constants.aug;
		} else if (string.equals("sept")) {
			return Constants.sept;
		} else if (string.equals("oct")) {
			return Constants.oct;
		} else if (string.equals("nov")) {
			return Constants.nov;
		} else if (string.equals("dec")) {
			return Constants.dec;
		}
		return 0;

	}
}
