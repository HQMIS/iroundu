/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.showuvoice.MainView.MYVIEW;
import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-22
 * @time ÏÂÎç3:21:37
 *
 */
public class SettingPwdView extends BaseView {

	private final String TAG = "SettingPwdView";
	
	private TextView mTitleBack;
	private EditText mContentOld;
	private EditText mContentNew;
	private EditText mContentNew2;
	private TextView mContentBtn;
	private TextView mContentLostBtn;
	
	/**
	 * @param context
	 */
	public SettingPwdView(Context context) {
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
		mView = LayoutInflater.from(context).inflate(R.layout.setting_pwd, null);
		mTitleBack = (TextView)mView.findViewById(R.id.setting_pwd_title_back);
		mContentOld = (EditText)mView.findViewById(R.id.setting_pwd_content_old);
		mContentNew = (EditText)mView.findViewById(R.id.setting_pwd_content_new);
		mContentNew2 = (EditText)mView.findViewById(R.id.setting_pwd_content_new2);
		mContentBtn = (TextView)mView.findViewById(R.id.setting_pwd_content_btn);
		mContentLostBtn = (TextView)mView.findViewById(R.id.setting_pwd_content_lost_btn);
	
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mContentOld.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentNew.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentNew2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mContentLostBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.SETTING_PWD_BACK.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
	}

}
