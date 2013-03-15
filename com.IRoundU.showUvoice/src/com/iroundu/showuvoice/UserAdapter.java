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
 * @date 2013-1-18
 * @time ÏÂÎç1:18:30
 *
 */
public class UserAdapter extends BaseAdapter {

	private final String TAG = "UserAdapter";
	
	private Context mContext;
	
	/**
	 * 
	 */
	public UserAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return NetConnection.getInstance().getUserSize();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getView()");
		UserItem itemView = new UserItem(mContext);
		itemView.init(position);
		convertView = itemView.getView();
		return convertView;
	}

}
