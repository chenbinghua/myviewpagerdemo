package com.example.myviewpagerdemo;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyAdapter extends PagerAdapter {

	private List<View> views;
	private Context context;
	
	
	public MyAdapter(List<View> views, Context context) {
		this.views = views;
		this.context = context;
	}
	
	//当不需要时删除view
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));//删除页卡  
	}
	
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position));
		return views.get(position);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

}
