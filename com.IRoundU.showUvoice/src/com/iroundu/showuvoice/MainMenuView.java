/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.showuvoice.ContentView.MYVIEW;
import com.iroundu.util.MyHandler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-15
 * @time ÏÂÎç8:21:41
 *
 */
public class MainMenuView extends BaseView implements OnClickListener {
	
	private final String TAG = "MainMenuView";

	private RelativeLayout mDynamicLayout;
	private TextView mDynamicImage;
	private RelativeLayout mSearchLayout;
	private TextView mSearchImage;
	private RelativeLayout mSpeakLayout;
	private TextView mSpeakImage;
	private RelativeLayout mHomeLayout;
	private TextView mHomeImage;
	private RelativeLayout mSettingLayout;
	private TextView mSettingImage;
	private ContentView mContentView;
	
	public MainMenuView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.main, null);
		mDynamicLayout = (RelativeLayout)mView.findViewById(R.id.main_menu_dynamic);
		mDynamicImage = (TextView)mView.findViewById(R.id.main_menu_dynamic_image);
		mSearchLayout = (RelativeLayout)mView.findViewById(R.id.main_menu_search);
		mSearchImage = (TextView)mView.findViewById(R.id.main_menu_search_image);
		mSpeakLayout = (RelativeLayout)mView.findViewById(R.id.main_menu_speak);
		mSpeakImage = (TextView)mView.findViewById(R.id.main_menu_speak_image);
		mHomeLayout = (RelativeLayout)mView.findViewById(R.id.main_menu_home);
		mHomeImage = (TextView)mView.findViewById(R.id.main_menu_home_image);
		mSettingLayout = (RelativeLayout)mView.findViewById(R.id.main_menu_setting);
		mSettingImage = (TextView)mView.findViewById(R.id.main_menu_setting_image);
		mContentView = (ContentView)mView.findViewById(R.id.main_ContentView);
		MyHandler.getInstance().setmContentView(mContentView);
		
		mDynamicLayout.setOnClickListener(this);
		mSearchLayout.setOnClickListener(this);
		mSpeakLayout.setOnClickListener(this);
		mHomeLayout.setOnClickListener(this);
		mSettingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.main_menu_dynamic:
			dynamicClick();
			break;
			
		case R.id.main_menu_search:
			searchClick();
			break;
			
		case R.id.main_menu_speak:
			speakClick();
			break;
			
		case R.id.main_menu_home:
			homeClick();
			break;
			
		case R.id.main_menu_setting:
			settingClick();
			break;

		default:
			break;
		}
	}
	
	private void dynamicClick() {
		mContentView.move(MYVIEW.DYNAMIC);
		mDynamicImage.setBackgroundResource(R.drawable.menu_trends_after);
		mSearchImage.setBackgroundResource(R.drawable.menu_explore_before);
		mSpeakImage.setBackgroundResource(R.drawable.menu_speak_icon);
		mHomeImage.setBackgroundResource(R.drawable.menu_home_before);
		mSettingImage.setBackgroundResource(R.drawable.menu_setting_before);
	}
	
	private void searchClick() {
		mContentView.move(MYVIEW.SEARCH);
		mDynamicImage.setBackgroundResource(R.drawable.menu_trends_before);
		mSearchImage.setBackgroundResource(R.drawable.menu_explore_after);
		mSpeakImage.setBackgroundResource(R.drawable.menu_speak_icon);
		mHomeImage.setBackgroundResource(R.drawable.menu_home_before);
		mSettingImage.setBackgroundResource(R.drawable.menu_setting_before);
	}
	
	private void speakClick() {
		mContentView.move(MYVIEW.SPEAK);
		mDynamicImage.setBackgroundResource(R.drawable.menu_trends_before);
		mSearchImage.setBackgroundResource(R.drawable.menu_explore_before);
		mSpeakImage.setBackgroundResource(R.drawable.menu_speak_icon);
		mHomeImage.setBackgroundResource(R.drawable.menu_home_before);
		mSettingImage.setBackgroundResource(R.drawable.menu_setting_before);
	}
	
	private void homeClick() {
		mContentView.move(MYVIEW.HOME);
		mDynamicImage.setBackgroundResource(R.drawable.menu_trends_before);
		mSearchImage.setBackgroundResource(R.drawable.menu_explore_before);
		mSpeakImage.setBackgroundResource(R.drawable.menu_speak_icon);
		mHomeImage.setBackgroundResource(R.drawable.menu_home_after);
		mSettingImage.setBackgroundResource(R.drawable.menu_setting_before);
	}
	
	private void settingClick() {
		mContentView.move(MYVIEW.SETTING);
		mDynamicImage.setBackgroundResource(R.drawable.menu_trends_before);
		mSearchImage.setBackgroundResource(R.drawable.menu_explore_before);
		mSpeakImage.setBackgroundResource(R.drawable.menu_speak_icon);
		mHomeImage.setBackgroundResource(R.drawable.menu_home_before);
		mSettingImage.setBackgroundResource(R.drawable.menu_setting_after);
	}
	
}
