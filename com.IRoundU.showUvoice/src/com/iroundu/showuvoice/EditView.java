/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.showuvoice.MainView.MYVIEW;
import com.iroundu.showuvoice.InfoView.TYPE;
import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author frank
 * @date 2013-1-21
 * @time ÏÂÎç12:13:51
 *
 */
public class EditView extends BaseView {

	private final String TAG = "EditView";
	
	private TextView mTitleSave;
	private TextView mTitleCancel;
	
	private TextView mContentPhotoImage;
	
	private RelativeLayout mContentNameLayout;
	private TextView mContentNameDownInfo;
	
	private RelativeLayout mContentInfoJobLayout;
	private TextView mContentInfoJobDownInfo;
	private RelativeLayout mContentInfoCompanyLayout;
	private TextView mContentInfoCompanyDownInfo;
	private RelativeLayout mContentInfoSchoolLayout;
	private TextView mContentInfoSchoolDownInfo;
	
	private RelativeLayout mContentDescribeLayout;
	private TextView mContentDescribeDownInfo;
	
	private RelativeLayout mContentSNSTypeSinaLayout;
	private RelativeLayout mContentSNSTypeTencentLayout;
	private RelativeLayout mContentSNSTypeRenrenLayout;
	private RelativeLayout mContentSNSTypeWeixinLayout;
	private RelativeLayout mContentSNSTypeDoubanLayout;
	
	private RelativeLayout mContentCertificateLayout;
	
	/**
	 * @param context
	 */
	public EditView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iroundu.showuvoice.BaseView#init(android.content.Context)
	 */
	@Override
	protected void init(Context context) {
		// TODO Auto-generated method stub
		Log.i(TAG, "init");
		mView = LayoutInflater.from(context).inflate(R.layout.edit, null);
		mTitleSave = (TextView)mView.findViewById(R.id.edit_title_save);
		mTitleCancel = (TextView)mView.findViewById(R.id.edit_title_cancel);
		mContentPhotoImage = (TextView)mView.findViewById(R.id.edit_content_photo_image);
		mContentNameLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_name);
		mContentNameDownInfo = (TextView)mView.findViewById(R.id.edit_content_name_down_info);
		mContentInfoJobLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_info_job);
		mContentInfoJobDownInfo = (TextView)mView.findViewById(R.id.edit_content_info_job_down_info);
		mContentInfoCompanyLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_info_company);
		mContentInfoCompanyDownInfo = (TextView)mView.findViewById(R.id.edit_content_info_company_down_info);
		mContentInfoSchoolLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_info_school);
		mContentInfoSchoolDownInfo = (TextView)mView.findViewById(R.id.edit_content_info_school_down_info);
		mContentDescribeLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_describe);
		mContentDescribeDownInfo = (TextView)mView.findViewById(R.id.edit_content_describe_down_info);
		mContentSNSTypeSinaLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_sns_type_sina);
		mContentSNSTypeTencentLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_sns_type_tencent);
		mContentSNSTypeRenrenLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_sns_type_renren);
		mContentSNSTypeWeixinLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_sns_type_weixin);
		mContentSNSTypeDoubanLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_sns_type_douban);
		mContentCertificateLayout = (RelativeLayout)mView.findViewById(R.id.edit_content_certificate);
		
		mTitleSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mTitleCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_BACK);
			}
		});
		
		mContentPhotoImage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentNameLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message title = new Message();
				title.arg1 = TYPE.NAME.ordinal();
				title.what = Configuration.MESSAGE_MAIN_VIEW_INFO;
				MyHandler.getInstance().sendMessage(title);
				
				Message msg = new Message();
				msg.arg1 = MYVIEW.INFO.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentInfoJobLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message title = new Message();
				title.arg1 = TYPE.JOB.ordinal();
				title.what = Configuration.MESSAGE_MAIN_VIEW_INFO;
				MyHandler.getInstance().sendMessage(title);
				
				Message msg = new Message();
				msg.arg1 = MYVIEW.INFO.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentInfoCompanyLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message title = new Message();
				title.arg1 = TYPE.COMPANY.ordinal();
				title.what = Configuration.MESSAGE_MAIN_VIEW_INFO;
				MyHandler.getInstance().sendMessage(title);
				
				Message msg = new Message();
				msg.arg1 = MYVIEW.INFO.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentInfoSchoolLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message title = new Message();
				title.arg1 = TYPE.SCHOOL.ordinal();
				title.what = Configuration.MESSAGE_MAIN_VIEW_INFO;
				MyHandler.getInstance().sendMessage(title);
				
				Message msg = new Message();
				msg.arg1 = MYVIEW.INFO.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentDescribeLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message title = new Message();
				title.arg1 = TYPE.DESCRIBE.ordinal();
				title.what = Configuration.MESSAGE_MAIN_VIEW_INFO;
				MyHandler.getInstance().sendMessage(title);
				
				Message msg = new Message();
				msg.arg1 = MYVIEW.INFO.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
		
		mContentSNSTypeSinaLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSNSTypeTencentLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSNSTypeRenrenLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSNSTypeWeixinLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentSNSTypeDoubanLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mContentCertificateLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.arg1 = MYVIEW.CERTIFICATE.ordinal();
				msg.what = Configuration.MESSAGE_MAIN_VIEW_MOVE;
				MyHandler.getInstance().sendMessage(msg);
			}
		});
	}

}
