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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author frank
 * @date 2013-1-15
 * @time ÏÂÎç3:00:14
 *
 */
public class SettingView extends BaseView {
	
	private final String TAG = "SettingView";

	private RelativeLayout mContentAccountInfoLayout;
	private RelativeLayout mContentFindInfoLayout;
	private RelativeLayout mContentHideInfoLayout;
	
	private ToggleButton mContentSyncInfoSinaBtn;
	private ToggleButton mContentSyncInfoTencentBtn;
	private ToggleButton mContentSyncInfoRenrenBtn;
	private ToggleButton mContentSyncInfoWeixinBtn;
	
	private ToggleButton mContentChatInfoEveryoneBtn;
	private ToggleButton mContentChatInfoAttentionBtn;
	
	private ToggleButton mContentOtherInfoPushBtn;
	private ToggleButton mContentOtherInfoPhoneBtn;
	private RelativeLayout mContentOtherInfoAboutLayout;
	private RelativeLayout mContentOtherInfoVoteLayout;
	private RelativeLayout mContentOtherInfoAdviseLayout;
	
	private TextView mContentExit;
	
	public SettingView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init()");
		mView = LayoutInflater.from(context).inflate(R.layout.setting, null);
		mContentAccountInfoLayout = (RelativeLayout)mView.findViewById(R.id.setting_content_account_info);
		mContentFindInfoLayout = (RelativeLayout)mView.findViewById(R.id.setting_content_find_info);
		mContentHideInfoLayout = (RelativeLayout)mView.findViewById(R.id.setting_content_hide_info);
		mContentSyncInfoSinaBtn = (ToggleButton)mView.findViewById(R.id.setting_content_sync_info_sina_btn);
		mContentSyncInfoTencentBtn = (ToggleButton)mView.findViewById(R.id.setting_content_sync_info_tencent_btn);
		mContentSyncInfoRenrenBtn = (ToggleButton)mView.findViewById(R.id.setting_content_sync_info_renren_btn);
		mContentSyncInfoWeixinBtn = (ToggleButton)mView.findViewById(R.id.setting_content_sync_info_weixin_btn);
		mContentChatInfoEveryoneBtn = (ToggleButton)mView.findViewById(R.id.setting_content_chat_info_everyone_btn);
		mContentChatInfoAttentionBtn = (ToggleButton)mView.findViewById(R.id.setting_content_chat_info_attention_btn);
		mContentOtherInfoPushBtn = (ToggleButton)mView.findViewById(R.id.setting_content_other_info_push_btn);
		mContentOtherInfoPhoneBtn = (ToggleButton)mView.findViewById(R.id.setting_content_other_info_phone_btn);
		mContentOtherInfoAboutLayout = (RelativeLayout)mView.findViewById(R.id.setting_content_other_info_about);
		mContentOtherInfoVoteLayout = (RelativeLayout)mView.findViewById(R.id.setting_content_other_info_vote);;
		mContentOtherInfoAdviseLayout = (RelativeLayout)mView.findViewById(R.id.setting_content_other_info_advise);;
		mContentExit = (TextView)mView.findViewById(R.id.setting_content_exit);
		
		mContentAccountInfoLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.SETTING_PWD.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentFindInfoLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.FIND.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentHideInfoLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.SETTING_HIDE.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentSyncInfoSinaBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSyncInfoTencentBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSyncInfoRenrenBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSyncInfoWeixinBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentChatInfoEveryoneBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentChatInfoAttentionBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentOtherInfoPushBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentOtherInfoPhoneBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentOtherInfoAboutLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.SETTING_ABOUT.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentOtherInfoVoteLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentOtherInfoAdviseLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.SETTING_ADVISE.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentExit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
