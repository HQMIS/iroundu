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
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-22
 * @time ÏÂÎç3:44:51
 *
 */
public class SettingPwdBackView extends BaseView {

	private final String TAG = "SettingPwdBackView";
	
	private TextView mTitleBack;
	private EditText mContentEmail;
	private TextView mContentBtn;
	
	/**
	 * @param context
	 */
	public SettingPwdBackView(Context context) {
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
		mView = LayoutInflater.from(context).inflate(R.layout.setting_pwd_back, null);
		mTitleBack = (TextView)mView.findViewById(R.id.setting_pwd_back_title_back);
		mContentEmail = (EditText)mView.findViewById(R.id.setting_pwd_back_content_email);
		mContentBtn = (TextView)mView.findViewById(R.id.setting_pwd_back_content_btn);
		
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mContentEmail.setOnClickListener(new View.OnClickListener() {
			
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
