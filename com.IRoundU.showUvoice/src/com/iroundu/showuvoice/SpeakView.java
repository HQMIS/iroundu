package com.iroundu.showuvoice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SpeakView extends BaseView {
	
	private final String TAG = "SpeakView";
	
	private TextView mContentBtn;

	public SpeakView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.speak, null);
		//mContentBtn = (TextView)mView.findViewById(R.id.speak_content_btn);
		
		//mContentBtn.setOnClickListener(new View.OnClickListener() {
			
		//	@Override
		//	public void onClick(View v) {
		//		// TODO Auto-generated method stub
				
		//	}
		//});
	}
	
}
