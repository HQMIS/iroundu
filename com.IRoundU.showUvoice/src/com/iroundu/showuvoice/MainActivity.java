/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.util.Configuration;
import com.iroundu.util.DialogFactory;
import com.iroundu.util.MyHandler;
import com.iroundu.util.NetConnection;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * @author frank
 * @date 2013-1-15
 * @time ÏÂÎç3:51:58
 *
 */
public class MainActivity extends Activity {
	
	private MainView mMainView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		init();
		setContentView(R.layout.mainview);
		
		mMainView = (MainView)findViewById(R.id.mainview);
		MyHandler.getInstance().setmMainActivity(this);
		MyHandler.getInstance().setmMainView(mMainView);
	}
	
	private void init() {
    	DisplayMetrics displayMetrics = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		Configuration.init(displayMetrics);
		
		DialogFactory.getInstance().setContext(this);
		NetConnection.getInstance().init();
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	}
	
}
