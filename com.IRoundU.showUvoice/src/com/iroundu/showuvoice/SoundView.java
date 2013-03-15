/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;
import com.iroundu.util.NetConnection;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-17
 * @time ÏÂÎç7:03:40
 *
 */
public class SoundView extends BaseView {

	private final String TAG = "SoundView";
	
	private TextView mTitleBack;
	private TextView mTitleText;
	private TextView mTitleButton;
	private RelativeLayout mLayout;
	private DynamicItem mDynamicItem;
	
	/**
	 * @param context
	 */
	public SoundView(Context context) {
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
		mView = LayoutInflater.from(context).inflate(R.layout.sound, null);
		mTitleBack = (TextView)mView.findViewById(R.id.sound_title_back);
		mTitleText = (TextView)mView.findViewById(R.id.sound_title_text);
		mTitleButton = (TextView)mView.findViewById(R.id.sound_title_button);
		mLayout = (RelativeLayout)mView.findViewById(R.id.sound_Layout);
		mDynamicItem = new DynamicItem(context);
		
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mTitleButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void init(int position) {
		NetConnection.getInstance().setSound(true);
		mDynamicItem.init(position);		
		mTitleText.setText(NetConnection.getInstance().getInfo().get(position).get(Configuration.getDYNAMIC()[1]));
		mLayout.addView(mDynamicItem.getView());
	}
	
	public void removeView() {
		NetConnection.getInstance().setSound(false);
		mLayout.removeAllViews();
	}

}
