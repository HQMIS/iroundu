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
 * @date 2013-1-21
 * @time ÏÂÎç2:16:42
 *
 */
public class CertificateView extends BaseView {
	
	private final String TAG = "CertificateView";
	
	private TextView mTitleBack;

	/**
	 * @param context
	 */
	public CertificateView(Context context) {
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
		mView = LayoutInflater.from(context).inflate(R.layout.certificate, null);
		mTitleBack = (TextView)mView.findViewById(R.id.certificate_title_back);
		
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
	}

}
