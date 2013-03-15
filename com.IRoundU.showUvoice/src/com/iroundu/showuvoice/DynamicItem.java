/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import java.util.HashMap;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-17
 * @time 下午1:49:05
 *
 */
public class DynamicItem extends BaseView {

	private final String TAG = "DynamicItem";
	
	private RelativeLayout mUserLayout;
	private TextView mUserImage;
	private TextView mUserInfoNameText;
	private TextView mUserInfoNameV;
	private TextView mUserInfoNameTime;
	private TextView mUserInfoLocalSex;
	private TextView mUserInfoLocalDetail;
	
	private TextView mDescribeInfo;
	private TextView mDescribeTime;
	
	private RelativeLayout mInfoSelfLayout;
	private RelativeLayout mInfoSelfFormButtonLayout;
	private TextView mInfoSelfFormButtonInfoTime;
	private TextView mInfoSelfFormButtonInfoCount;
	private RelativeLayout mInfoSelfFormButtonButtonLayout;
	private TextView mInfoSelfFormButtonButtonTime;

	private RelativeLayout mInfoSelfFormDescribeLayout;
	private TextView mInfoSelfFormDescribeName;
	private TextView mInfoSelfFormDescribeV;
	private TextView mInfoSelfFormDescribeDescribe;
	
	private RelativeLayout mInfoSelfFormImageLayout;
	private TextView mInfoSelfFormImageInfoLike;
	private TextView mInfoSelfFormImageInfoComment;
	private TextView mInfoSelfFormImageInfoShare;
	private TextView mInfoSelfFormImageTone;
	
	private TextView mInfoSelfThumbOpen;

	private RelativeLayout mInfoSelfOtherDetailLayout;
	private RelativeLayout mInfoSelfOtherControlLayout;
	private TextView mInfoSelfOtherDetailLike;
	private TextView mInfoSelfOtherDetailComment;
	private TextView mInfoSelfOtherDetailTypeShare;
	private TextView mInfoSelfOtherDetailTypeTrash;
	private TextView mInfoSelfOtherControlInfoCount;
	private TextView mInfoSelfOtherControlInfoTime;
	private TextView mInfoSelfOtherControlOperatorBack;
	private TextView mInfoSelfOtherControlOperatorPlay;
	private TextView mInfoSelfOtherControlOperatorForward;
	
	private RelativeLayout mInfoLikeLayout;
	private TextView mInfoLikeInfoName;
	private TextView mInfoLikeInfoV;
	private TextView mInfoLikeInfoDescribe;
	private TextView mInfoLikeButtonInfoTime;
	private TextView mInfoLikeButtonInfoCount;
	private RelativeLayout mInfoLikeButtonLayout;
	private RelativeLayout mInfoLikeButtonButtonLayout;
	private TextView mInfoLikeButtonButtonTime;
	
	private String[] mKeys;
	private int mPosition;
	
	/**
	 * @param context
	 */
	public DynamicItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iroundu.showuvoice.BaseView#init(android.content.Context)
	 */
	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		mView = LayoutInflater.from(context).inflate(R.layout.item_dynamic, null);
		mUserLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_user);
		mUserImage = (TextView)mView.findViewById(R.id.item_dynamic_user_image);
		mUserInfoNameText = (TextView)mView.findViewById(R.id.item_dynamic_user_info_name_text);
		mUserInfoNameV = (TextView)mView.findViewById(R.id.item_dynamic_user_info_name_V);
		mUserInfoNameTime = (TextView)mView.findViewById(R.id.item_dynamic_user_info_name_time);
		mUserInfoLocalSex = (TextView)mView.findViewById(R.id.item_dynamic_user_info_local_sex);
		mUserInfoLocalDetail = (TextView)mView.findViewById(R.id.item_dynamic_user_info_local_detail);
		mDescribeInfo = (TextView)mView.findViewById(R.id.item_dynamic_describe_info);
		mDescribeTime = (TextView)mView.findViewById(R.id.item_dynamic_describe_time);
		mInfoSelfLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self);
		mInfoSelfFormButtonLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self_form_button);
		mInfoSelfFormButtonInfoTime = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_button_info_time);
		mInfoSelfFormButtonInfoCount = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_button_info_count);
		mInfoSelfFormButtonButtonLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self_form_button_button);
		mInfoSelfFormButtonButtonTime = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_button_button_time);
		mInfoSelfFormDescribeLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self_form_describe);
		mInfoSelfFormDescribeName = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_describe_name);
		mInfoSelfFormDescribeV = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_describe_V);
		mInfoSelfFormDescribeDescribe = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_describe_describe);
		mInfoSelfFormImageLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self_form_image);
		mInfoSelfFormImageInfoLike = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_image_info_like);
		mInfoSelfFormImageInfoComment = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_image_info_comment);
		mInfoSelfFormImageInfoShare = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_image_info_share);
		mInfoSelfFormImageTone = (TextView)mView.findViewById(R.id.item_dynamic_info_self_form_image_tone);
		mInfoSelfThumbOpen = (TextView)mView.findViewById(R.id.item_dynamic_info_self_thumb_open);
		mInfoSelfOtherDetailLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self_other_detail);
		mInfoSelfOtherControlLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_self_other_control);
		mInfoSelfOtherDetailLike = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_detail_like);
		mInfoSelfOtherDetailComment = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_detail_comment);
		mInfoSelfOtherDetailTypeShare = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_detail_type_share);
		mInfoSelfOtherDetailTypeTrash = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_detail_type_trash);
		mInfoSelfOtherControlInfoCount = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_control_info_count);
		mInfoSelfOtherControlInfoTime = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_control_info_time);
		mInfoSelfOtherControlOperatorBack = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_control_operator_back);
		mInfoSelfOtherControlOperatorPlay = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_control_operator_play);
		mInfoSelfOtherControlOperatorForward = (TextView)mView.findViewById(R.id.item_dynamic_info_self_other_control_operator_forward);
		mInfoLikeLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_like);
		mInfoLikeInfoName = (TextView)mView.findViewById(R.id.item_dynamic_info_like_info_name);
		mInfoLikeInfoV = (TextView)mView.findViewById(R.id.item_dynamic_info_like_info_V);
		mInfoLikeInfoDescribe = (TextView)mView.findViewById(R.id.item_dynamic_info_like_info_describe);
		mInfoLikeButtonInfoTime = (TextView)mView.findViewById(R.id.item_dynamic_info_like_button_info_time);
		mInfoLikeButtonInfoCount = (TextView)mView.findViewById(R.id.item_dynamic_info_like_button_info_count);
		mInfoLikeButtonLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_like_button);
		mInfoLikeButtonButtonLayout = (RelativeLayout)mView.findViewById(R.id.item_dynamic_info_like_button_button);
		mInfoLikeButtonButtonTime = (TextView)mView.findViewById(R.id.item_dynamic_info_like_button_button_time);
		mKeys = Configuration.getDYNAMIC();
		mPosition = 0;
	}

	public void init(int position) {
		mPosition = position;
		HashMap<String, String> item = new HashMap<String, String>();
		HashMap<String, String> data = NetConnection.getInstance().getInfo().get(position);
		String key;
		for (int i = 0; i < data.size(); i++) {
			key = Configuration.getDYNAMIC()[i];
			item.put(key, data.get(key));
		}
		
		if (NetConnection.getInstance().getSound()) {
			item.put(Configuration.getDYNAMIC()[16], "0");
			item.put(Configuration.getDYNAMIC()[17], "1");
			item.put(Configuration.getDYNAMIC()[18], "1");
			item.put(Configuration.getDYNAMIC()[19], "0");
			
		}else if (NetConnection.getInstance().getDynamic()) {
			item.put(Configuration.getDYNAMIC()[17], "0");
			item.put(Configuration.getDYNAMIC()[18], "1");
			item.put(Configuration.getDYNAMIC()[19], "0");
			
		}else if (NetConnection.getInstance().getSearch()) {
			item.put(Configuration.getDYNAMIC()[17], "0");
			item.put(Configuration.getDYNAMIC()[18], "1");
			item.put(Configuration.getDYNAMIC()[19], "0");
			
		}else if (NetConnection.getInstance().getHome()) {
			item.put(Configuration.getDYNAMIC()[17], "0");
			item.put(Configuration.getDYNAMIC()[18], "0");
			item.put(Configuration.getDYNAMIC()[19], "1");
			
		}
		
		init(item);
	}
	
	@TargetApi(16)
	private void init(HashMap<String, String> item) {
		Log.i(TAG, "init(HashMap<String, Object>)");
		mInfoSelfFormButtonInfoTime.setVisibility(View.INVISIBLE);
		mInfoLikeButtonInfoTime.setVisibility(View.INVISIBLE);
		
		if ((item.get(mKeys[18]) != null) && item.get(mKeys[18]).equals("0")) {
			mDescribeTime.setVisibility(View.VISIBLE);
			mUserLayout.setVisibility(View.GONE);
		
			if (item.get(mKeys[3]) != null) {
				mDescribeTime.setText(item.get(mKeys[3]));
			}else {
				mDescribeTime.setText(R.string.default_user_time);
			}
			
			if ((item.get(mKeys[19]) != null) && item.get(mKeys[19]).equals("1")) {
				mInfoSelfOtherDetailTypeTrash.setVisibility(View.VISIBLE);
				mInfoSelfOtherDetailTypeShare.setVisibility(View.INVISIBLE);
				
				mInfoSelfOtherDetailTypeTrash.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}else {
				mInfoSelfOtherDetailTypeShare.setVisibility(View.VISIBLE);
				mInfoSelfOtherDetailTypeTrash.setVisibility(View.INVISIBLE);
			}
			
		}else {
			mUserLayout.setVisibility(View.VISIBLE);
			mDescribeTime.setVisibility(View.GONE);
			
			Drawable face = null;
			if (item.get(mKeys[0]) != null) {
				face = NetConnection.getInstance().getDrawabe(item.get(mKeys[0]));
			}
			if (face != null) {
				mUserImage.setBackground(face);
			}else {
				mUserImage.setBackgroundResource(R.drawable.user);
			}
			
			if (item.get(mKeys[1]) != null) {
				mUserInfoNameText.setText(item.get(mKeys[1]));
			}else {
				mUserInfoNameText.setText(R.string.default_name);
			}
			
			if ((item.get(mKeys[2]) != null) && item.get(mKeys[2]).equals("0")) {
				mUserInfoNameV.setVisibility(View.VISIBLE);
			}else {
				mUserInfoNameV.setVisibility(View.GONE);
			}
			
			if (item.get(mKeys[3]) != null) {
				mUserInfoNameTime.setText(item.get(mKeys[3]));
			}else {
				mUserInfoNameTime.setText(R.string.default_user_time);
			}
			
			if (item.get(mKeys[4]) != null && item.get(mKeys[4]).equals("1")) {
				mUserInfoLocalSex.setBackgroundResource(R.drawable.sex_girl);
			}else {
				mUserInfoLocalSex.setBackgroundResource(R.drawable.sex_boy);
			}
			
			if (item.get(mKeys[5]) != null) {
				mUserInfoLocalDetail.setText(item.get(mKeys[5]) + "km");
			}else {
				mUserInfoLocalDetail.setText(R.string.default_local + "km");
			}
			
			mUserImage.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		mDescribeInfo.setText(item.get(mKeys[6]));
		
		if ((item.get(mKeys[16]) != null) && item.get(mKeys[16]).equals("1")) {
			mInfoLikeLayout.setVisibility(View.VISIBLE);
			mInfoSelfLayout.setVisibility(View.GONE);
			
			if (item.get(mKeys[11]) != null) {
				mInfoLikeInfoName.setText(item.get(mKeys[11]));
			}else {
				mInfoLikeInfoName.setText(R.string.default_name);
			}
			
			if ((item.get(mKeys[12]) != null) && item.get(mKeys[12]).equals("0")) {
				mInfoLikeInfoV.setVisibility(View.VISIBLE);
			}else {
				mInfoLikeInfoV.setVisibility(View.GONE);
			}
			
			mInfoLikeInfoDescribe.setText(": " + item.get(mKeys[13]));
			
			if (item.get(mKeys[7]) != null) {
				mInfoLikeButtonInfoCount.setText("播放:" + item.get(mKeys[7]) + "次");
			}else {
				mInfoLikeButtonInfoCount.setText("播放:" + R.string.default_sound_playtimes + "次");
			}
			
			if (item.get(mKeys[8]) != null) {
				mInfoLikeButtonButtonTime.setText(item.get(mKeys[8]) + "'");
			}else {
				mInfoLikeButtonButtonTime.setText(R.string.default_sound_time + "'");
			}
			
			mInfoLikeLayout.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Message msg = new Message();
					msg.arg1 = MainView.MYVIEW.SOUND.ordinal();
					msg.arg2 = mPosition;
					msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
					MyHandler.getInstance().sendMessage(msg);
				}
			});
			
			mInfoLikeButtonLayout.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Message msg = new Message();
					msg.arg1 = MainView.MYVIEW.SOUND.ordinal();
					msg.arg2 = mPosition;
					msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
					MyHandler.getInstance().sendMessage(msg);
				}
			});
			
			mInfoLikeButtonButtonLayout.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}else {
			mInfoSelfLayout.setVisibility(View.VISIBLE);
			mInfoLikeLayout.setVisibility(View.GONE);
			
			if ((item.get(mKeys[17]) != null) && item.get(mKeys[17]).equals("1")) {
				mInfoSelfFormDescribeLayout.setVisibility(View.GONE);
				mInfoSelfFormImageLayout.setVisibility(View.VISIBLE);
				mInfoSelfOtherControlLayout.setVisibility(View.VISIBLE);
				mInfoSelfFormButtonLayout.setVisibility(View.GONE);
				mInfoSelfOtherDetailLayout.setVisibility(View.GONE);
				
				if ((item.get(mKeys[11]) != null) || (item.get(mKeys[12]) != null) || (item.get(mKeys[13]) != null)) {
					
					mInfoSelfFormDescribeLayout.setVisibility(View.VISIBLE);
					
					if (item.get(mKeys[11]) != null) {
						mInfoSelfFormDescribeName.setText(item.get(mKeys[11]));
					}else {
						mInfoSelfFormDescribeName.setText(R.string.default_name);
					}
					
					if ((item.get(mKeys[12]) != null) && item.get(mKeys[12]).equals("0")) {
						mInfoSelfFormDescribeV.setVisibility(View.VISIBLE);
					}else {
						mInfoSelfFormDescribeV.setVisibility(View.GONE);
					}
					
					mInfoSelfFormDescribeDescribe.setText(": " + item.get(mKeys[13]));
				}
				
				if (item.get(mKeys[9]) != null) {
					mInfoSelfFormImageInfoLike.setText(item.get(mKeys[9]));
				}else {
					mInfoSelfFormImageInfoLike.setText(R.string.default_like);
				}
				
				if (item.get(mKeys[10]) != null) {
					mInfoSelfFormImageInfoComment.setText(item.get(mKeys[10]));
				}else {
					mInfoSelfFormImageInfoComment.setText(R.string.default_comment);
				}
				
				if (item.get(mKeys[7]) != null) {
					mInfoSelfOtherControlInfoCount.setText("播放:" + item.get(mKeys[7]) + "次");
				}else {
					mInfoSelfOtherControlInfoCount.setText("播放:" + R.string.default_sound_playtimes + "次");
				}
				
				if (item.get(mKeys[15]) != null) {
					mInfoSelfOtherControlInfoTime.setText((String)item.get(mKeys[15]));
				}else {
					mInfoSelfOtherControlInfoTime.setText(R.string.default_duration);
				}
				
				mInfoSelfFormImageInfoLike.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfFormImageInfoComment.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfFormImageInfoShare.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfOtherControlOperatorBack.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfOtherControlOperatorPlay.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfOtherControlOperatorForward.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}else {
				mInfoSelfFormButtonLayout.setVisibility(View.VISIBLE);
				mInfoSelfOtherDetailLayout.setVisibility(View.VISIBLE);
				mInfoSelfFormDescribeLayout.setVisibility(View.GONE);
				mInfoSelfFormImageLayout.setVisibility(View.GONE);
				mInfoSelfOtherControlLayout.setVisibility(View.GONE);
				
				if (item.get(mKeys[7]) != null) {
					mInfoSelfFormButtonInfoCount.setText(item.get(mKeys[7]) + "次播放");
				}else {
					mInfoSelfFormButtonInfoCount.setText(R.string.default_sound_playtimes + "次播放");
				}
				
				if (item.get(mKeys[8]) != null) {
					mInfoSelfFormButtonButtonTime.setText(item.get(mKeys[8]) + "'");
				}else {
					mInfoSelfFormButtonButtonTime.setText(R.string.default_sound_time + "'");
				}
				
				if (item.get(mKeys[9]) != null) {
					mInfoSelfOtherDetailLike.setText(item.get(mKeys[9]));
				}else {
					mInfoSelfOtherDetailLike.setText(R.string.default_like);
				}
				
				if (item.get(mKeys[10]) != null) {
					mInfoSelfOtherDetailComment.setText(item.get(mKeys[10]));
				}else {
					mInfoSelfOtherDetailComment.setText(R.string.default_comment);
				}
				
				mInfoSelfFormButtonLayout.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Message msg = new Message();
						msg.arg1 = MainView.MYVIEW.SOUND.ordinal();
						msg.arg2 = mPosition;
						msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
						MyHandler.getInstance().sendMessage(msg);
					}
				});
				
				mInfoSelfFormButtonButtonLayout.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						mInfoSelfFormButtonButtonTime.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.playstate, 0);
					}
				});
				
				mInfoSelfOtherDetailLike.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfOtherDetailComment.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
				mInfoSelfOtherDetailTypeShare.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
			
			mInfoSelfThumbOpen.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
	}

}
