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
 * @date 2013-1-21
 * @time ÏÂÎç1:35:01
 *
 */
public class InfoView extends BaseView {

	private final String TAG = "InfoView";
	
	public static enum TYPE {NAME, JOB, COMPANY, SCHOOL, DESCRIBE};
	private int[] type = {R.string._home_edit_name, R.string._home_edit_job, R.string._home_edit_company, R.string._home_edit_school, R.string._home_edit_describe};
	
	private TextView mTitleBack;
	private TextView mTitleName;
	private EditText mContentEdit;
	private TextView mContentButtonCancelButton;
	private TextView mContentButtonSureButton;
	
	/**
	 * @param context
	 */
	public InfoView(Context context) {
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
		mView = LayoutInflater.from(context).inflate(R.layout.info, null);
		mTitleBack = (TextView)mView.findViewById(R.id.info_title_back);
		mTitleName = (TextView)mView.findViewById(R.id.info_title_name);
		mContentEdit = (EditText)mView.findViewById(R.id.info_content_edit);
		mContentButtonCancelButton = (TextView)mView.findViewById(R.id.info_content_button_cancel_button);
		mContentButtonSureButton = (TextView)mView.findViewById(R.id.info_content_button_sure_button);
		
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mContentButtonCancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentButtonSureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setTitle(int title) {
		mTitleName.setText(type[title]);
	}

}
