package com.iroundu.util;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetConnection {
	
	private static NetConnection instance = new NetConnection();
	
	private ArrayList<HashMap<String, String>> mDynamicNearInfo;
	private ArrayList<HashMap<String, String>> mDynamicAttentionInfo;
	private ArrayList<HashMap<String, String>> mUserHotInfo;
	private ArrayList<HashMap<String, String>> mSearchInfo;
	private ArrayList<HashMap<String, String>> mHomeInfo;
	private HashMap<String, String> mHomeDetailInfo;
	
	private String[] mDynamicInfoKeys;
	private String[] mUserInfoKeys;
	private String[] mHomeInfoKeys;

	private boolean mSound;
	private boolean mDynamic;
	private boolean mSearch;
	private boolean mHome;
	private boolean mNear;
	private boolean mHot;
	
	public void setSound(boolean sound) {
		mSound = sound;
	}
	
	public boolean getSound() {
		return mSound;
	}

	public boolean getDynamic() {
		return mDynamic;
	}
	
	public void setDynamic(boolean dynamic) {
		mDynamic = dynamic;
	}
	
	public boolean getSearch() {
		return mSearch;
	}
	
	public void setSearch(boolean search) {
		mSearch = search;
		if (search) {
			mDynamic = false;
		}
	}
	
	public boolean getHome() {
		return mHome;
	}
	
	public void setHome(boolean home) {
		mHome = home;
		if (home) {
			mDynamic = false;
			mSearch = false;
		}
	}
	
	public void setNear(boolean near) {
		mNear = near;
	}
	
	public void setHot(boolean hot) {
		mHot = hot;
	}
	
    public ArrayList<HashMap<String, String>> getInfo() {
    	if (mDynamic) {
    		if (mNear) {
        		return mDynamicNearInfo;
    		}else {
    			return mDynamicAttentionInfo;
    		}
		}
    	
    	if (mSearch) {
    		return mSearchInfo;
		}
    	
    	if (mHome) {
    		return mHomeInfo;
		}
    	
    	return null;
	}
    
    public ArrayList<HashMap<String, String>> getUserInfo() {
    	if (mHot) {
    		return mUserHotInfo;
		}else {
			return mUserHotInfo;
		}
    }
    
    public HashMap<String, String> getHomeInfo() {
    	return mHomeDetailInfo;
    }
    
    public int getInfoSize() {
    	if (mDynamic) {
    		if (mNear) {
        		return mDynamicNearInfo.size();
    		}else {
    			return mDynamicAttentionInfo.size();
    		}
		}
    	
    	if (mSearch) {
    		return mSearchInfo.size();
		}
    	
    	if (mHome) {
    		return mHomeInfo.size();
		}
    	
    	return 0;
    }
    
    public int getUserSize() {
    	if (mHot) {
    		return mUserHotInfo.size();
		}else {
			return mUserHotInfo.size();
		}
	}
    
	private NetConnection() {}
	
	public static NetConnection getInstance() {
		return instance;
	}
	
    public boolean isNetworkAvailable(Context mContext) {
        return ((isWifiAvailable(mContext)) || (isMobileAvailable(mContext)));
    }

    public boolean isWifiAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMobileAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /*private void checkNetworkInfo() {
		ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		State mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
		State wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
		
		if (mobile == State.CONNECTED || mobile == State.CONNECTING
				|| wifi == State.CONNECTED
				|| wifi == State.CONNECTING) {
			return;
		}
		
		DialogFactory.getInstance().getDialog(TYPE_DIALOG.NETWORK).show();
	}*/
	
	public void init() {
		mDynamicNearInfo = new ArrayList<HashMap<String,String>>();
		mDynamicAttentionInfo = new ArrayList<HashMap<String,String>>();
		mUserHotInfo = new ArrayList<HashMap<String,String>>();
		mSearchInfo = new ArrayList<HashMap<String,String>>();
		mHomeInfo = new ArrayList<HashMap<String,String>>();
		mHomeDetailInfo = new HashMap<String, String>();
		mDynamicInfoKeys = Configuration.getDYNAMIC();
		mUserInfoKeys = Configuration.getUSER();
		mHomeInfoKeys = Configuration.getHOME();
		mSound = false;
		mDynamic = true;
		mSearch = false;
		mHome = false;
		mNear = true;
		mHot = true;
		initData();
	}
	
	private void initData() {
		initDynamicNearInfo();
		initDynamicAttentionInfo();
		initSearchInfo();
		initHotInfo();
		initHomeInfo();
		initHomeDetailInfo();
	}
	
	private void initDynamicNearInfo() {
		HashMap<String, String> one = new HashMap<String, String>();
		one.put(mDynamicInfoKeys[0], null);
		one.put(mDynamicInfoKeys[1], "路人甲");
		one.put(mDynamicInfoKeys[2], "0");
		one.put(mDynamicInfoKeys[3], "23分钟前");
		one.put(mDynamicInfoKeys[4], "0");
		one.put(mDynamicInfoKeys[5], "1");
		one.put(mDynamicInfoKeys[6], "新年快乐");
		one.put(mDynamicInfoKeys[7], "50");
		one.put(mDynamicInfoKeys[8], "70");
		one.put(mDynamicInfoKeys[9], "80");
		one.put(mDynamicInfoKeys[10], "90");
		one.put(mDynamicInfoKeys[11], null);
		one.put(mDynamicInfoKeys[12], null);
		one.put(mDynamicInfoKeys[13], null);
		one.put(mDynamicInfoKeys[14], null);
		one.put(mDynamicInfoKeys[15], null);
		one.put(mDynamicInfoKeys[16], "0");
		one.put(mDynamicInfoKeys[17], "0");
		one.put(mDynamicInfoKeys[18], "1");
		one.put(mDynamicInfoKeys[19], "1");

		HashMap<String, String> two = new HashMap<String, String>();
		two.put(mDynamicInfoKeys[0], null);
		two.put(mDynamicInfoKeys[1], "路人乙");
		two.put(mDynamicInfoKeys[2], "1");
		two.put(mDynamicInfoKeys[3], "10分钟前");
		two.put(mDynamicInfoKeys[4], "1");
		two.put(mDynamicInfoKeys[5], "1");
		two.put(mDynamicInfoKeys[6], "非常好听");
		two.put(mDynamicInfoKeys[7], "50");
		two.put(mDynamicInfoKeys[8], "70");
		two.put(mDynamicInfoKeys[9], "10");
		two.put(mDynamicInfoKeys[10], "20");
		two.put(mDynamicInfoKeys[11], "frank");
		two.put(mDynamicInfoKeys[12], "0");
		two.put(mDynamicInfoKeys[13], "新年快乐");
		two.put(mDynamicInfoKeys[14], "23分钟前");
		two.put(mDynamicInfoKeys[15], null);
		two.put(mDynamicInfoKeys[16], "1");
		two.put(mDynamicInfoKeys[17], "0");
		two.put(mDynamicInfoKeys[18], "1");
		two.put(mDynamicInfoKeys[19], "1");
		
		mDynamicNearInfo.add(two);
		mDynamicNearInfo.add(one);
		mDynamicNearInfo.add(one);
		mDynamicNearInfo.add(one);
		mDynamicNearInfo.add(two);
	}
	
	private void initDynamicAttentionInfo() {
		HashMap<String, String> one = new HashMap<String, String>();
		one.put(mDynamicInfoKeys[0], null);
		one.put(mDynamicInfoKeys[1], "朋友甲");
		one.put(mDynamicInfoKeys[2], "0");
		one.put(mDynamicInfoKeys[3], "23分钟前");
		one.put(mDynamicInfoKeys[4], "0");
		one.put(mDynamicInfoKeys[5], "1");
		one.put(mDynamicInfoKeys[6], "新年快乐");
		one.put(mDynamicInfoKeys[7], "50");
		one.put(mDynamicInfoKeys[8], "70");
		one.put(mDynamicInfoKeys[9], "80");
		one.put(mDynamicInfoKeys[10], "90");
		one.put(mDynamicInfoKeys[11], null);
		one.put(mDynamicInfoKeys[12], null);
		one.put(mDynamicInfoKeys[13], null);
		one.put(mDynamicInfoKeys[14], null);
		one.put(mDynamicInfoKeys[15], null);
		one.put(mDynamicInfoKeys[16], "0");
		one.put(mDynamicInfoKeys[17], "0");
		one.put(mDynamicInfoKeys[18], "1");
		one.put(mDynamicInfoKeys[19], "1");

		HashMap<String, String> two = new HashMap<String, String>();
		two.put(mDynamicInfoKeys[0], null);
		two.put(mDynamicInfoKeys[1], "朋友乙");
		two.put(mDynamicInfoKeys[2], "1");
		two.put(mDynamicInfoKeys[3], "10分钟前");
		two.put(mDynamicInfoKeys[4], "1");
		two.put(mDynamicInfoKeys[5], "1");
		two.put(mDynamicInfoKeys[6], "非常好听");
		two.put(mDynamicInfoKeys[7], "50");
		two.put(mDynamicInfoKeys[8], "70");
		two.put(mDynamicInfoKeys[9], "10");
		two.put(mDynamicInfoKeys[10], "20");
		two.put(mDynamicInfoKeys[11], "frank");
		two.put(mDynamicInfoKeys[12], "0");
		two.put(mDynamicInfoKeys[13], "新年快乐");
		two.put(mDynamicInfoKeys[14], "23分钟前");
		two.put(mDynamicInfoKeys[15], null);
		two.put(mDynamicInfoKeys[16], "1");
		two.put(mDynamicInfoKeys[17], "0");
		two.put(mDynamicInfoKeys[18], "1");
		two.put(mDynamicInfoKeys[19], "1");
		
		mDynamicAttentionInfo.add(two);
		mDynamicAttentionInfo.add(one);
		mDynamicAttentionInfo.add(one);
		mDynamicAttentionInfo.add(one);
		mDynamicAttentionInfo.add(two);
	}
	
	private void initSearchInfo() {
		HashMap<String, String> one = new HashMap<String, String>();
		one.put(mDynamicInfoKeys[0], null);
		one.put(mDynamicInfoKeys[1], "推荐甲");
		one.put(mDynamicInfoKeys[2], "0");
		one.put(mDynamicInfoKeys[3], "23分钟前");
		one.put(mDynamicInfoKeys[4], "0");
		one.put(mDynamicInfoKeys[5], "1");
		one.put(mDynamicInfoKeys[6], "新年快乐");
		one.put(mDynamicInfoKeys[7], "50");
		one.put(mDynamicInfoKeys[8], "70");
		one.put(mDynamicInfoKeys[9], "80");
		one.put(mDynamicInfoKeys[10], "90");
		one.put(mDynamicInfoKeys[11], null);
		one.put(mDynamicInfoKeys[12], null);
		one.put(mDynamicInfoKeys[13], null);
		one.put(mDynamicInfoKeys[14], null);
		one.put(mDynamicInfoKeys[15], null);
		one.put(mDynamicInfoKeys[16], "0");
		one.put(mDynamicInfoKeys[17], "0");
		one.put(mDynamicInfoKeys[18], "1");
		one.put(mDynamicInfoKeys[19], "1");

		HashMap<String, String> two = new HashMap<String, String>();
		two.put(mDynamicInfoKeys[0], null);
		two.put(mDynamicInfoKeys[1], "推荐乙");
		two.put(mDynamicInfoKeys[2], "1");
		two.put(mDynamicInfoKeys[3], "10分钟前");
		two.put(mDynamicInfoKeys[4], "1");
		two.put(mDynamicInfoKeys[5], "1");
		two.put(mDynamicInfoKeys[6], "非常好听");
		two.put(mDynamicInfoKeys[7], "50");
		two.put(mDynamicInfoKeys[8], "70");
		two.put(mDynamicInfoKeys[9], "10");
		two.put(mDynamicInfoKeys[10], "20");
		two.put(mDynamicInfoKeys[11], "frank");
		two.put(mDynamicInfoKeys[12], "0");
		two.put(mDynamicInfoKeys[13], "新年快乐");
		two.put(mDynamicInfoKeys[14], "23分钟前");
		two.put(mDynamicInfoKeys[15], null);
		two.put(mDynamicInfoKeys[16], "1");
		two.put(mDynamicInfoKeys[17], "0");
		two.put(mDynamicInfoKeys[18], "1");
		two.put(mDynamicInfoKeys[19], "1");
		
		mSearchInfo.add(two);
		mSearchInfo.add(one);
		mSearchInfo.add(one);
		mSearchInfo.add(one);
		mSearchInfo.add(two);
	}
	
	private void initHotInfo() {
		HashMap<String, String> one = new HashMap<String, String>();
		one.put(mUserInfoKeys[0], null);
		one.put(mUserInfoKeys[1], "微音官方新闻台");
		one.put(mUserInfoKeys[2], "0");
		one.put(mUserInfoKeys[3], "男");
		one.put(mUserInfoKeys[4], "123456");
		one.put(mUserInfoKeys[5], null);
		one.put(mUserInfoKeys[6], "0");
		
		HashMap<String, String> two = new HashMap<String, String>();
		two.put(mUserInfoKeys[0], null);
		two.put(mUserInfoKeys[1], "中国之声");
		two.put(mUserInfoKeys[2], "0");
		two.put(mUserInfoKeys[3], "男");
		two.put(mUserInfoKeys[4], "109876");
		two.put(mUserInfoKeys[5], null);
		two.put(mUserInfoKeys[6], "0");
		
		mUserHotInfo.add(one);
		mUserHotInfo.add(two);
	}
	
	private void initHomeInfo() {
		HashMap<String, String> one = new HashMap<String, String>();
		one.put(mDynamicInfoKeys[0], null);
		one.put(mDynamicInfoKeys[1], "自己");
		one.put(mDynamicInfoKeys[2], "0");
		one.put(mDynamicInfoKeys[3], "23分钟前");
		one.put(mDynamicInfoKeys[4], "0");
		one.put(mDynamicInfoKeys[5], "1");
		one.put(mDynamicInfoKeys[6], "新年快乐");
		one.put(mDynamicInfoKeys[7], "50");
		one.put(mDynamicInfoKeys[8], "70");
		one.put(mDynamicInfoKeys[9], "80");
		one.put(mDynamicInfoKeys[10], "90");
		one.put(mDynamicInfoKeys[11], null);
		one.put(mDynamicInfoKeys[12], null);
		one.put(mDynamicInfoKeys[13], null);
		one.put(mDynamicInfoKeys[14], null);
		one.put(mDynamicInfoKeys[15], null);
		one.put(mDynamicInfoKeys[16], "0");
		one.put(mDynamicInfoKeys[17], "0");
		one.put(mDynamicInfoKeys[18], "1");
		one.put(mDynamicInfoKeys[19], "1");

		HashMap<String, String> two = new HashMap<String, String>();
		two.put(mDynamicInfoKeys[0], null);
		two.put(mDynamicInfoKeys[1], "自己");
		two.put(mDynamicInfoKeys[2], "1");
		two.put(mDynamicInfoKeys[3], "10分钟前");
		two.put(mDynamicInfoKeys[4], "1");
		two.put(mDynamicInfoKeys[5], "1");
		two.put(mDynamicInfoKeys[6], "非常好听");
		two.put(mDynamicInfoKeys[7], "50");
		two.put(mDynamicInfoKeys[8], "70");
		two.put(mDynamicInfoKeys[9], "10");
		two.put(mDynamicInfoKeys[10], "20");
		two.put(mDynamicInfoKeys[11], "LOL");
		two.put(mDynamicInfoKeys[12], "0");
		two.put(mDynamicInfoKeys[13], "新年快乐");
		two.put(mDynamicInfoKeys[14], "23分钟前");
		two.put(mDynamicInfoKeys[15], null);
		two.put(mDynamicInfoKeys[16], "1");
		two.put(mDynamicInfoKeys[17], "0");
		two.put(mDynamicInfoKeys[18], "1");
		two.put(mDynamicInfoKeys[19], "1");
		
		mHomeInfo.add(two);
		mHomeInfo.add(one);
		mHomeInfo.add(one);
		mHomeInfo.add(one);
		mHomeInfo.add(two);
	}
	
	private void initHomeDetailInfo() {
		mHomeDetailInfo.put(mHomeInfoKeys[0], null);
		mHomeDetailInfo.put(mHomeInfoKeys[1], "frank");
		mHomeDetailInfo.put(mHomeInfoKeys[2], "0");
		mHomeDetailInfo.put(mHomeInfoKeys[3], "0");
		mHomeDetailInfo.put(mHomeInfoKeys[4], "1");
		mHomeDetailInfo.put(mHomeInfoKeys[5], "20");
		mHomeDetailInfo.put(mHomeInfoKeys[6], "30");
		mHomeDetailInfo.put(mHomeInfoKeys[7], "10");
	}
	
	public Drawable getDrawabe(String url) {
		return null;
	}
}