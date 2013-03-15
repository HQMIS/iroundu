/**
 * @project com.IRoundU.showUvoice
 *
 */
package com.iroundu.util;

import android.util.DisplayMetrics;

/**
 * @author frank
 * @date 2013-1-15
 * @time ÏÂÎç8:36:06
 *
 */
public class Configuration {

	public static enum TYPE_DIALOG {EXIT};
	
	private static int SCREEN_WIDTH;
	private static int SCREEN_HEIGHT;
	private static int MOVE_COUNT = 16;
	private static int MOVE_TIME = 30;
	
	public final static int MESSAGE_MAIN_VIEW_DRAW = 0;
	public final static int MESSAGE_MAIN_VIEW_MOVE = 1;
	public final static int MESSAGE_MAIN_VIEW_BACK = 2;
	public final static int MESSAGE_MAIN_VIEW_CHACK = 3;
	public final static int MESSAGE_MAIN_VIEW_INFO = 4;
	public final static int MESSAGE_CONTENT_VIEW_DRAW = 10;
	public final static int MESSAGE_CONTENT_VIEW_INIT = 11;
	public final static int MESSAGE_EXIT = 20;
	
	private static String[] DYNAMIC = {"image", "name", "V", "time", "sex", "local", "describe", "count", "length", "like", "comment", "ename", "eV", "edescribe", "etime", "duration", "self", "main", "home", "visitor"};
	private static String[] USER = {"image", "name", "V", "sex", "fan", "local", "hot"};
	private static String[] HOME = {"image", "name", "V", "sex", "local", "attention", "fan", "count"};
	
	public static int getSCREEN_WIDTH() {
		return SCREEN_WIDTH;
	}
	
	public static int getSCREEN_HEIGHT() {
		return SCREEN_HEIGHT;
	}

	public static int getMOVE_COUNT() {
		return MOVE_COUNT;
	}

	public static int getMOVE_TIME() {
		return MOVE_TIME;
	}

	public static String[] getDYNAMIC() {
		return DYNAMIC;
	}

	public static String[] getUSER() {
		return USER;
	}
	
	public static String[] getHOME() {
		return HOME;
	}
	
	public static void init(DisplayMetrics displayMetrics) {
		SCREEN_WIDTH = displayMetrics.widthPixels;
		SCREEN_HEIGHT = displayMetrics.heightPixels;
	}

}
