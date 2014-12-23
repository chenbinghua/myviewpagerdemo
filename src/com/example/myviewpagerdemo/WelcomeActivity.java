package com.example.myviewpagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class WelcomeActivity extends Activity {

	private boolean isFirstIn = false;
	private static final int TIME = 3000;
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;

			case GO_GUIDE:
				goGuide();
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		SharedPreferences sp = getSharedPreferences("ViewPager", MODE_PRIVATE);
		isFirstIn = sp.getBoolean("isFirstIn", true);
		if(!isFirstIn){
			handler.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else{
			handler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			Editor editor = sp.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}
	}

	public void goHome() {
		Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
		startActivity(i);
		finish();
	}

	public void goGuide() {
		Intent i = new Intent(WelcomeActivity.this, GuideActivity.class);
		startActivity(i);
		finish();
	}
}
