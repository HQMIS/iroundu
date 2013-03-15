/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-22
 * @time ÏÂÎç4:39:07
 *
 */
public class SettingHideView extends BaseView {

	private final String TAG = "SettingHideView";
	
	private TextView mTitleBack;
	private TextView mContentEveryone;
	private TextView mContentAttention;
	private TextView mContentHide;
	private TextView mContentBtn;
	
	/**
	 * @param context
	 */
	public SettingHideView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iroundu.showuvoice.BaseView#init(android.content.Context)
	 */
	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.setting_hide, null);
		mTitleBack = (TextView)mView.findViewById(R.id.setting_hide_title_back);
		mContentEveryone = (TextView)mView.findViewById(R.id.setting_hide_content_everyone);
		mContentAttention = (TextView)mView.findViewById(R.id.setting_hide_content_attention);
		mContentHide = (TextView)mView.findViewById(R.id.setting_hide_content_hide);
		mContentBtn = (TextView)mView.findViewById(R.id.setting_hide_content_btn);
	
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mContentEveryone.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentAttention.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentHide.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
