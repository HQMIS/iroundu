package com.iroundu.showuvoice;

import com.iroundu.util.NetConnection;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class SearchView extends BaseView {
	
	private final String TAG = "SearchView";
	
	private TextView mTitleButton;
	private ListView mContentInfo;

	public SearchView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.search, null);
		mTitleButton = (TextView)mView.findViewById(R.id.search_title_button);
		mContentInfo = (ListView)mView.findViewById(R.id.search_content_info);
		
		mTitleButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	public void initData() {
		NetConnection.getInstance().setSearch(true);
		mContentInfo.setAdapter(new DynamicAdapter(mContext));
	}
	
}
