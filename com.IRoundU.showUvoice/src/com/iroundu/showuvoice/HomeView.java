/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import java.util.HashMap;

import com.iroundu.showuvoice.MainView.MYVIEW;
import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;
import com.iroundu.util.NetConnection;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-15
 * @time 下午3:00:03
 *
 */
public class HomeView extends BaseView {
	
	private final String TAG = "SelfView";
	
	private TextView mUserImage;
	private TextView mUserEdit;
	private TextView mUserInfoNameText;
	private TextView mUserInfoNameV;
	private TextView mUserInfoLocalSex;
	private TextView mUserInfoLocalDetail;

	private RelativeLayout mButtonDetailLayout;
	private RelativeLayout mButtonAttentionLayout;
	private TextView mButtonAttentionUp;
	private RelativeLayout mButtonFanLayout;
	private TextView mButtonFanUp;
	private RelativeLayout mButtonChatLayout;
	
	private TextView mCount;
	
	private ListView mList;
	
	public HomeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.home, null);
		mUserImage = (TextView)mView.findViewById(R.id.home_user_image);
		mUserEdit = (TextView)mView.findViewById(R.id.home_user_edit);
		mUserInfoNameText = (TextView)mView.findViewById(R.id.home_user_info_name_text);
		mUserInfoNameV = (TextView)mView.findViewById(R.id.home_user_info_name_V);
		mUserInfoLocalSex = (TextView)mView.findViewById(R.id.home_user_info_local_sex);
		mUserInfoLocalDetail = (TextView)mView.findViewById(R.id.home_user_info_local_detail);
		mButtonDetailLayout = (RelativeLayout)mView.findViewById(R.id.home_button_detail);
		mButtonAttentionLayout = (RelativeLayout)mView.findViewById(R.id.home_button_attention);
		mButtonAttentionUp = (TextView)mView.findViewById(R.id.home_button_attention_up);
		mButtonFanLayout = (RelativeLayout)mView.findViewById(R.id.home_button_fan);
		mButtonFanUp = (TextView)mView.findViewById(R.id.home_button_fan_up);
		mButtonChatLayout = (RelativeLayout)mView.findViewById(R.id.home_button_chat);
		mCount = (TextView)mView.findViewById(R.id.home_count);
		mList = (ListView)mView.findViewById(R.id.home_list_info);
	}
	
	@TargetApi(16)
	public void initData() {
		HashMap<String, String> item = NetConnection.getInstance().getHomeInfo();
		String[] key = Configuration.getHOME();
		
		Drawable face = null;
		if (item.get(key[0]) != null) {
			face = NetConnection.getInstance().getDrawabe(item.get(key[0]));
		}
		if (face != null) {
			mUserImage.setBackground(face);
		}else {
			mUserImage.setBackgroundResource(R.drawable.user);
		}
		
		if (item.get(key[1]) != null) {
			mUserInfoNameText.setText(item.get(key[1]));
		}else {
			mUserInfoNameText.setText(R.string.default_name);
		}
		
		if ((item.get(key[2]) != null) && item.get(key[2]).equals("0")) {
			mUserInfoNameV.setVisibility(View.VISIBLE);
		}else {
			mUserInfoNameV.setVisibility(View.GONE);
		}
		
		if ((item.get(key[3]) != null) && item.get(key[3]).equals("1")) {
			mUserInfoLocalSex.setBackgroundResource(R.drawable.sex_girl);
		}else {
			mUserInfoLocalSex.setBackgroundResource(R.drawable.sex_boy);
		}
		
		if (item.get(key[4]) != null) {
			mUserInfoLocalDetail.setText(item.get(key[4]) + "km");
		}else {
			mUserInfoLocalDetail.setText(R.string.default_local + "km");
		}
		
		if (item.get(key[5]) != null) {
			mButtonAttentionUp.setText(item.get(key[5]));
		}else {
			mButtonAttentionUp.setText(R.string.default_attention);
		}
		
		if (item.get(key[6]) != null) {
			mButtonFanUp.setText(item.get(key[6]));
		}else {
			mButtonFanUp.setText(R.string.default_fan);
		}
		
		if (item.get(key[7]) != null) {
			mCount.setText("共有" + item.get(key[7]) + "条说说");
		}else {
			mCount.setText("共有" + R.string.default_count + "条说说");
		}
		
		mUserEdit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.EDIT.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mButtonDetailLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mButtonAttentionLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mButtonFanLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mButtonChatLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		NetConnection.getInstance().setHome(true);
        mList.setAdapter(new DynamicAdapter(mContext));
	}

}
