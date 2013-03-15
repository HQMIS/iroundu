/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.util.Configuration;
import com.iroundu.util.MyHandler;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * @author frank
 * @date 2013-1-15
 * @time ÏÂÎç9:19:35
 *
 */
public class ContentView extends ViewGroup implements Runnable {
	
	private final String TAG = "ContentView";
	
	public enum MYVIEW {DYNAMIC, SEARCH, SPEAK, HOME, SETTING}
	
	private DynamicView mDynamicView;
	private SearchView mSearchView;
	private SpeakView mSpeakView;
	private HomeView mHomeView;
	private SettingView mSettingView;
	
	private MYVIEW mView;
	private int mStartLeft;
	private int mStep;
	
	/**
	 * @param context
	 */
	public ContentView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public ContentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public ContentView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}

	private void init(Context context) {
		mView = MYVIEW.DYNAMIC;
		mStartLeft = 0;
		mStep = 0;
		
		mDynamicView = new DynamicView(context);
		this.addView(mDynamicView.getView());
		mDynamicView.initData();
		
		mSearchView = new SearchView(context);
		this.addView(mSearchView.getView());
		
		mSpeakView = new SpeakView(context);
		this.addView(mSpeakView.getView());
		
		mHomeView = new HomeView(context);
		this.addView(mHomeView.getView());
		
		mSettingView = new SettingView(context);
		this.addView(mSettingView.getView());
		
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
	
	public void init() {
		switch (mView) {
		case DYNAMIC:
			mDynamicView.initData();
			break;
			
		case SEARCH:
			mSearchView.initData();
			break;

		case SPEAK:
			break;
			
		case HOME:
			mHomeView.initData();
			break;
			
		case SETTING:
			break;

		default:
			break;
		}
	}
	
	public void move(MYVIEW view) {
		mStep = (mView.ordinal() - view.ordinal()) * Configuration.getSCREEN_WIDTH() / Configuration.getMOVE_COUNT();
		mView = view;
		MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_CONTENT_VIEW_INIT);
		new Thread(this).start();
	}
	
	private void move() {
		Log.i(TAG, "move");
		mStartLeft += mStep;
		Log.i(TAG, String.valueOf(mStartLeft));
	}
	
	private void check() {
		if (mStartLeft % Configuration.getSCREEN_WIDTH() != 0) {
			mStartLeft = (0 - mView.ordinal()) * Configuration.getSCREEN_WIDTH();
		}
	}
	
	public void draw() {
		Log.i(TAG, "draw");
		int startLeft = mStartLeft;
		for (int i = 0; i < getChildCount(); i++) {
			getChildAt(i).layout(startLeft, 0, startLeft + getChildAt(i).getMeasuredWidth(), getChildAt(i).getMeasuredHeight());
			startLeft += getChildAt(i).getMeasuredWidth();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Log.i(TAG, "start move thread");
		for (int i = 0; i < Configuration.getMOVE_COUNT(); i++) {
			move();
			MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_CONTENT_VIEW_DRAW);
			try {
				Thread.sleep(Configuration.getMOVE_TIME());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		check();
		MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_CONTENT_VIEW_DRAW);
	}

}
