/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import android.content.Context;
import android.util.Log;
import android.view.View;

/**
 * @author frank
 * @date 2013-1-15
 * @time обнГ3:02:52
 *
 */
public abstract class BaseView {
	
	private final String TAG = "BaseView";
	
	protected Context mContext;
	protected View mView;
	
	public View getView() {
		return mView;
	}
	
	public BaseView(Context context) {
		// TODO Auto-generated constructor stub
		Log.i(TAG, "BaseView()");
		mContext = context;
		init(context);
	}
	
	protected abstract void init(Context context);

}
