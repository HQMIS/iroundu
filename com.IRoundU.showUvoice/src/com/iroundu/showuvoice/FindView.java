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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-18
 * @time ÏÂÎç2:17:56
 *
 */
public class FindView extends BaseView {
	
	private final String TAG = "FindView";
	
	private TextView mTitleBack;
	private TextView mSearchButton;
	private EditText mSearchText;
	private TextView mSina;
	private TextView mQQ;
	private ListView mList;

	private void setHot(boolean hot) {
		NetConnection.getInstance().setHot(hot);
	}
	
	/**
	 * @param context
	 */
	public FindView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iroundu.showuvoice.BaseView#init(android.content.Context)
	 */
	@Override
	protected void init(Context context) {
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.find, null);
		mTitleBack = (TextView)mView.findViewById(R.id.find_title_back);
		mSearchButton = (TextView)mView.findViewById(R.id.find_search_button);
		mSearchText = (EditText)mView.findViewById(R.id.find_search_text);
		mSina = (TextView)mView.findViewById(R.id.find_sina);
		mQQ = (TextView)mView.findViewById(R.id.find_qq);
		mList = (ListView)mView.findViewById(R.id.find_list_info);
		setHot(true);
		
		mTitleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mSearchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mSina.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mQQ.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
        mList.setAdapter(new UserAdapter(context));
	}

}
