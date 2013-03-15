/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.showuvoice;

import com.iroundu.util.NetConnection;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author frank
 * @date 2013-1-16
 * @time ÏÂÎç2:25:24
 *
 */
public class DynamicAdapter extends BaseAdapter {

	private final String TAG = "DynamicAdapter";
	
	private Context mContext;
	
	public DynamicAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return NetConnection.getInstance().getInfoSize();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getView()");
		DynamicItem itemView = new DynamicItem(mContext);
		itemView.init(position);
		convertView = itemView.getView();
		return convertView;
	}
}
