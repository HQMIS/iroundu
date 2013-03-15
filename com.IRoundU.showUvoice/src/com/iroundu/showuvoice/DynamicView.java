package com.iroundu.showuvoice;

import com.iroundu.showuvoice.MainView.MYVIEW;
import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;
import com.iroundu.util.NetConnection;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DynamicView extends BaseView implements OnClickListener{

	private final String TAG = "DynamicView";
	
	private TextView mTitleTypeNear;
	private TextView mTitleTypeAttention;
	private TextView mTitleButton;
	private RelativeLayout mContentAttentionLayout;
	private TextView mContentAttentionButton;
	private ListView mContentInfo;
	
	private void setNear(boolean near) {
		NetConnection.getInstance().setNear(near);
		if (near) {
			mContentAttentionLayout.setVisibility(View.GONE);
		}else {
			mContentAttentionLayout.setVisibility(View.VISIBLE);
		}
	}
	
	/**
	 * @param context
	 */
	public DynamicView(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
	}

	protected void init(Context context) {
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.dynamic, null);
		mTitleTypeNear = (TextView)mView.findViewById(R.id.dynamic_title_type_near);
		mTitleTypeAttention = (TextView)mView.findViewById(R.id.dynamic_title_type_attention);
		mTitleButton = (TextView)mView.findViewById(R.id.dynamic_title_button);
		mContentAttentionLayout = (RelativeLayout)mView.findViewById(R.id.dynamic_content_attention);
		mContentAttentionButton = (TextView)mView.findViewById(R.id.dynamic_content_attention_button);
		mContentInfo = (ListView)mView.findViewById(R.id.dynamic_content_info);
		setNear(true);
		
		mTitleTypeNear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setNear(true);
			}
		});
		
		mTitleTypeAttention.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setNear(false);
			}
		});
		
		mTitleButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentAttentionButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.FIND.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
	}

	public void initData() {
		NetConnection.getInstance().setDynamic(true);
        mContentInfo.setAdapter(new DynamicAdapter(mContext));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
