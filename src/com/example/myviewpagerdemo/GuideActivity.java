package com.example.myviewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends Activity {

	private ViewPager vp;
	private PagerAdapter adapter;
	private List<View> views;
	private ImageView[] dots;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		
		initView();
		initDots();
	}


	private void initView() {
		// TODO Auto-generated method stub
		LayoutInflater li = LayoutInflater.from(this);
		views = new ArrayList<View>();
		views.add(li.inflate(R.layout.one, null));
		views.add(li.inflate(R.layout.two, null));
		views.add(li.inflate(R.layout.three, null));
		
		vp = (ViewPager) findViewById(R.id.viewpager);
		adapter = new MyAdapter(views, this);
		vp.setAdapter(adapter);
		vp.setOnPageChangeListener(mOnPageChangeListener);
		
		Button start = (Button) views.get(2).findViewById(R.id.start_btn);
		
		start.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(GuideActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	private void initDots() {
		// TODO Auto-generated method stub
		dots = new ImageView[views.size()];
		dots[0] = (ImageView) findViewById(R.id.image1);
		dots[1] = (ImageView) findViewById(R.id.image2);
		dots[2] = (ImageView) findViewById(R.id.image3);
	}
	
	private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			for (int i = 0; i < dots.length; i++) {
				if(arg0 == i){
					dots[i].setImageResource(R.drawable.login_point_selected);
				}else{
					dots[i].setImageResource(R.drawable.login_point);
				}
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
}
