/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import java.util.HashMap;

import com.iroundu.util.Configuration;
import com.iroundu.util.NetConnection;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-18
 * @time ÏÂÎç1:35:53
 *
 */
public class UserItem extends BaseView {

	private final String TAG = "UserItem";
	
	private TextView mContentImage;
	private TextView mContentTypeButton;
	private TextView mContentTypeArrow;
	private TextView mContentInfoUpName;
	private TextView mContentInfoUpV;
	private TextView mContentInfoDownSex;
	private TextView mContentInfoDownTypeFan;
	private TextView mContentInfoDownTypeLocal;
	
	private String[] mKeys;
	private int mPosition;
	
	/**
	 * @param context
	 */
	public UserItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iroundu.showuvoice.BaseView#init(android.content.Context)
	 */
	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		mView = LayoutInflater.from(context).inflate(R.layout.item_user, null);
		mContentImage = (TextView)mView.findViewById(R.id.item_user_content_image);
		mContentTypeButton = (TextView)mView.findViewById(R.id.item_user_content_type_button);
		mContentTypeArrow = (TextView)mView.findViewById(R.id.item_user_content_type_arrow);
		mContentInfoUpName = (TextView)mView.findViewById(R.id.item_user_content_info_up_name);
		mContentInfoUpV = (TextView)mView.findViewById(R.id.item_user_content_info_up_V);
		mContentInfoDownSex = (TextView)mView.findViewById(R.id.item_user_content_info_down_sex);
		mContentInfoDownTypeFan = (TextView)mView.findViewById(R.id.item_user_content_info_down_type_fan);
		mContentInfoDownTypeLocal = (TextView)mView.findViewById(R.id.item_user_content_info_down_type_local);
		mKeys = Configuration.getUSER();
		mPosition = 0;
	}
	
	public void init(int position) {
		mPosition = position;
		init(NetConnection.getInstance().getUserInfo().get(position));
	}
	
	@TargetApi(16)
	public void init(HashMap<String, String> item) {
		Log.i(TAG, "init(HashMap<String, Object>)");
		
		Drawable face = null;
		if (item.get(mKeys[0]) != null) {
			face = NetConnection.getInstance().getDrawabe(item.get(mKeys[0]));
		}
		if (face != null) {
			mContentImage.setBackground(face);
		}else {
			mContentImage.setBackgroundResource(R.drawable.user);
		}
		
		if (item.get(mKeys[1]) != null) {
			mContentInfoUpName.setText(item.get(mKeys[1]));
		}else {
			mContentInfoUpName.setText(R.string.default_name);
		}
		
		if ((item.get(mKeys[2]) != null) && item.get(mKeys[2]).equals("0")) {
			mContentInfoUpV.setVisibility(View.VISIBLE);
		}else {
			mContentInfoUpV.setVisibility(View.GONE);
		}
		
		if ((item.get(mKeys[3]) != null) && item.get(mKeys[3]).equals("1")) {
			mContentInfoDownSex.setBackgroundResource(R.drawable.sex_girl);
		}else {
			mContentInfoDownSex.setBackgroundResource(R.drawable.sex_boy);
		}
		
		mContentImage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		if ((item.get(mKeys[6]) != null) && item.get(mKeys[6]).equals("0")) {
			mContentTypeButton.setVisibility(View.VISIBLE);
			mContentInfoDownTypeFan.setVisibility(View.VISIBLE);
			mContentTypeArrow.setVisibility(View.GONE);
			mContentInfoDownTypeLocal.setVisibility(View.GONE);
			
			if (item.get(mKeys[4]) != null) {
				mContentInfoDownTypeFan.setText("·ÛË¿: " + item.get(mKeys[4]));
			}else {
				mContentInfoDownTypeFan.setText("·ÛË¿: " + R.string.default_fan);
			}
			
			mContentTypeButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}else {
			mContentTypeArrow.setVisibility(View.VISIBLE);
			mContentInfoDownTypeLocal.setVisibility(View.VISIBLE);
			mContentTypeButton.setVisibility(View.GONE);
			mContentInfoDownTypeFan.setVisibility(View.GONE);
			
			if (item.get(mKeys[5]) != null) {
				mContentInfoDownTypeLocal.setText(item.get(mKeys[5]) + "km");
			}else {
				mContentInfoDownTypeLocal.setText(R.string.default_local + "km");
			}
			
			mContentTypeArrow.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
	}
}
