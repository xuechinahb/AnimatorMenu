package com.clover.menu.main;

import com.clover.menu.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;

public class HomeActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;
	private LayoutInflater layoutInflater;
	private Class fragmentArray[] = { HomeFragment.class,
			HomeFragment.class, HomeFragment.class,
			};

	private int mImageViewArray[] = { R.drawable.home_icon,
			R.drawable.map_icon, R.drawable.my_icon };

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		setContentView(R.layout.main_tab_layout);

		initView();
	}

	private void initView() {
		layoutInflater = LayoutInflater.from(this);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		int count = fragmentArray.length;
		for (int i = 0; i < count; i++) {
			TabSpec tabSpec = mTabHost.newTabSpec("").setIndicator(
					getTabItemView(i));
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			mTabHost.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.drawable.selector_tab_background);
		}
	}

	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.main_tab_item_view, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		return view;
	}
}
