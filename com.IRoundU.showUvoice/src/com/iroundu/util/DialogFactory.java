/**
 *
 */
package com.iroundu.util;

import com.iroundu.util.Configuration.TYPE_DIALOG;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogFactory {

	private static DialogFactory instance = new DialogFactory();

	private Context mContext;

	public void setContext(Context context) {
		this.mContext = context;
	}

	private DialogFactory() {}

	public static DialogFactory getInstance() {
		return instance;
	}

	public Dialog getDialog(TYPE_DIALOG id) {
		AlertDialog.Builder builder = new Builder(mContext);
		builder.setCancelable(true);
		switch (id) {
		case EXIT:
			builder.setMessage("您确定要退出吗？");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					MyHandler.getInstance().sendEmptyMessage(Configuration.MESSAGE_EXIT);
					dialog.cancel();
				}
			});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			break;

		default:
			break;
		}
		return builder.create();
	}

}
