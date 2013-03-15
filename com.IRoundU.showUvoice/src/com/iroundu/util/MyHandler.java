package com.iroundu.util;

import com.iroundu.showuvoice.ContentView;
import com.iroundu.showuvoice.MainActivity;
import com.iroundu.showuvoice.MainView;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MyHandler extends Handler {
	
	private static MyHandler instance = new MyHandler();
	
	private final String TAG = "MyHandler";

	private MainActivity mMainActivity;
	private MainView mMainView;
	private ContentView mContentView;

	public void setmMainActivity(MainActivity mMainActivity) {
		this.mMainActivity = mMainActivity;
	}

	public void setmMainView(MainView mMainView) {
		this.mMainView = mMainView;
	}

	public void setmContentView(ContentView mContentView) {
		this.mContentView = mContentView;
	}

	private MyHandler() {}
	
	public static MyHandler getInstance() {
		return instance;
	}
	
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		Log.i(TAG, "handleMessage");
		switch (msg.what) {
		case Configuration.MESSAGE_MAIN_VIEW_DRAW:
			mMainView.draw();
			break;
		
		case Configuration.MESSAGE_MAIN_VIEW_MOVE:
			mMainView.move(msg);
			break;
			
		case Configuration.MESSAGE_MAIN_VIEW_BACK:
			mMainView.back();
			break;
			
		case Configuration.MESSAGE_MAIN_VIEW_CHACK:
			mMainView.check();
			mMainView.draw();
			break;
			
		case Configuration.MESSAGE_MAIN_VIEW_INFO:
			mMainView.setInfoTitle(msg.arg1);
			break;
			
		case Configuration.MESSAGE_CONTENT_VIEW_DRAW:
			mContentView.draw();
			break;
			
		case Configuration.MESSAGE_CONTENT_VIEW_INIT:
			mContentView.init();
			break;
			
		case Configuration.MESSAGE_EXIT:
			mMainActivity.finish();
			break;
			
		default:
			break;
		}
		super.handleMessage(msg);
	}
	
}
