/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import java.util.Vector;

import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;
import com.iroundu.util.Configuration.TYPE_DIALOG;
import com.iroundu.util.DialogFactory;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;

/**
 * @author frank
 * @date 2013-1-15
 * @time ÏÂÎç2:55:50
 *
 */
public class MainView extends ViewGroup implements Runnable {
	
	private final String TAG = "MainView";
	
	public enum MYVIEW {MENUVIEW, SOUND, FIND, EDIT, INFO, CERTIFICATE, SETTING_PWD, SETTING_PWD_BACK, SETTING_ABOUT, SETTING_ADVISE, SETTING_HIDE}
	
	private MainMenuView mMainMenuView;
	private SoundView mSoundView;
	private FindView mFindView;
	private EditView mEditView;
	private InfoView mInfoView;
	private CertificateView mCertificateView;
	private SettingPwdView mSettingPwdView;
	private SettingPwdBackView mSettingPwdBackView;
	private SettingAboutView mSettingAboutView;
	private SettingAdviseView mSettingAdviseView;
	private SettingHideView mSettingHideView;
	
	private Vector<MYVIEW> mList;
	private MYVIEW mView;
	private int[] mStartLeft;
	private int mStep;
	
	/**
	 * @param context
	 */
	public MainView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public MainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public MainView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}

	private void init(Context context) {
		mList = new Vector<MainView.MYVIEW>();
		mList.add(MYVIEW.MENUVIEW);
		
		mView = mList.lastElement();
		mStartLeft = new int[]{0, Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH(), Configuration.getSCREEN_WIDTH()};
		mStep = 0;
		
		mMainMenuView = new MainMenuView(context);
		this.addView(mMainMenuView.getView());
		
		mSoundView = new SoundView(context);
		this.addView(mSoundView.getView());
		
		mFindView = new FindView(context);
		this.addView(mFindView.getView());
		
		mEditView = new EditView(context);
		this.addView(mEditView.getView());
		
		mInfoView = new InfoView(context);
		this.addView(mInfoView.getView());
		
		mCertificateView = new CertificateView(context);
		this.addView(mCertificateView.getView());
		
		mSettingPwdView = new SettingPwdView(context);
		this.addView(mSettingPwdView.getView());
		
		mSettingPwdBackView = new SettingPwdBackView(context);
		this.addView(mSettingPwdBackView.getView());
		
		mSettingAboutView = new SettingAboutView(context);
		this.addView(mSettingAboutView.getView());
		
		mSettingAdviseView = new SettingAdviseView(context);
		this.addView(mSettingAdviseView.getView());
		
		mSettingHideView = new SettingHideView(context);
		this.addView(mSettingHideView.getView());
		
		this.setFocusableInTouchMode(true);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
		for (int i = 0; i < getChildCount(); i++) {
			getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	/* (non-Javadoc)
	 * @see android.view.ViewGroup#onLayout(boolean, int, int, int, int)
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		draw();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			back();
			break;

		default:
			break;
		}
		super.onKeyDown(keyCode, event);
		return true;
	}
	
	public void back() {
		switch (mView) {
		case MENUVIEW:
			DialogFactory.getInstance().getDialog(TYPE_DIALOG.EXIT).show();
			break;

		case SOUND:
			move(MYVIEW.SOUND);
			break;
			
		case FIND:
			move(MYVIEW.FIND);
			break;
			
		case EDIT:
			move(MYVIEW.EDIT);
			break;
			
		case INFO:
			move(MYVIEW.INFO);
			break;
			
		case CERTIFICATE:
			move(MYVIEW.CERTIFICATE);
			break;
			
		case SETTING_PWD:
			move(MYVIEW.SETTING_PWD);
			break;
			
		case SETTING_PWD_BACK:
			move(MYVIEW.SETTING_PWD_BACK);
			break;
			
		case SETTING_ABOUT:
			move(MYVIEW.SETTING_ABOUT);
			break;
			
		case SETTING_ADVISE:
			move(MYVIEW.SETTING_ADVISE);
			break;
			
		case SETTING_HIDE:
			move(MYVIEW.SETTING_HIDE);
			break;
			
		default:
			move(mView);
			break;
		}
	}
	
	public void move(Message msg) {
		switch (msg.arg1) {
		case 1:
			mSoundView.init(msg.arg2);
			move(MYVIEW.SOUND);
			break;
			
		case 2:
			move(MYVIEW.FIND);
			break;

		case 3:
			move(MYVIEW.EDIT);
			break;
			
		case 4:
			move(MYVIEW.INFO);
			break;
			
		case 5:
			move(MYVIEW.CERTIFICATE);
			break;
			
		case 6:
			move(MYVIEW.SETTING_PWD);
			break;
			
		case 7:
			move(MYVIEW.SETTING_PWD_BACK);
			break;
			
		case 8:
			move(MYVIEW.SETTING_ABOUT);
			break;
			
		case 9:
			move(MYVIEW.SETTING_ADVISE);
			break;
			
		case 10:
			move(MYVIEW.SETTING_HIDE);
			break;
			
		default:
			move(MYVIEW.values()[msg.arg1]);
			break;
		}
	}
	
	public void move(MYVIEW view) {
		if (mStartLeft[view.ordinal()] == 0) {
			mStep = Configuration.getSCREEN_WIDTH() / Configuration.getMOVE_COUNT();
			mList.removeElementAt(mList.size() - 1);
		}else {
			mStep = -Configuration.getSCREEN_WIDTH() / Configuration.getMOVE_COUNT();
			mList.add(view);
			mView = view;
		}
		Log.i(TAG, mView.toString());
		new Thread(this).start();
	}
	
	private void move() {
		mStartLeft[mView.ordinal()] += mStep;
	}
	
	public void check() {
		if (mStep > 0) {
			mStartLeft[mView.ordinal()] = Configuration.getSCREEN_WIDTH();
			if (mView == MYVIEW.SOUND) {
				mSoundView.removeView();
			}
			mView = mList.lastElement();
		}else {
			mStartLeft[mView.ordinal()] = 0;
		}
	}
	
	public void draw() {
		Log.i(TAG, "draw");
		for (int i = 0; i < getChildCount(); i++) {
			getChildAt(i).layout(mStartLeft[i], 0, mStartLeft[i] + getChildAt(i).getMeasuredWidth(), getChildAt(i).getMeasuredHeight());
		}
	}
	
	public void setInfoTitle(int title) {
		mInfoView.setTitle(title);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Log.i(TAG, "start move thread");
		for (int i = 0; i < Configuration.getMOVE_COUNT(); i++) {
			move();
			MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_DRAW);
			try {
				Thread.sleep(Configuration.getMOVE_TIME());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_MAIN_VIEW_CHACK);
	}

}
