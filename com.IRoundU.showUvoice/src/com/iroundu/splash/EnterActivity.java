package com.iroundu.splash;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.iroundu.login.LoginActivity;
import com.iroundu.login.RegisterActivity;
import com.iroundu.showuvoice.R;

public class EnterActivity extends Activity implements OnTouchListener,
		OnGestureListener {
	/** Called when the activity is first created. */
	GestureDetector mGestureDetector;
	private int verticalMinDistance = 20;
	private int minVelocity = 0;

	LayoutAnimationController controller = null;
	Bundle extras;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		extras = getIntent().getExtras();
		if (extras != null) {
			LayoutInflater factory = LayoutInflater.from(EnterActivity.this);
			final RelativeLayout layout = (RelativeLayout) factory.inflate(
					R.layout.enter, null);
			
			String animation = extras.getString("animation");
			// 得到一个LayoutAnimationController对象；
			if (animation.equals("left")) {
				controller = AnimationUtils.loadLayoutAnimation(this,
						R.anim.layout_left_in);
			} else {
				controller = AnimationUtils.loadLayoutAnimation(this,
						R.anim.layout_right_in);
			}
			// 设置控件显示的顺序；
			controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
			// 设置控件显示间隔时间；
			controller.setDelay(0);
			// 为ListView设置LayoutAnimationController属性；
			layout.setLayoutAnimation(controller);
			setContentView(layout);
		} else {
			setContentView(R.layout.enter);
		}

		// 判断/data/data/com.iroundu.showuvoice目录下是否有databases文件夹
		// 如果没有， 则创建
		File destDir = new File("/data/data/com.iroundu.showuvoice/databases/");
		if (!destDir.exists()) {
			destDir.mkdirs();
		}

		// 创建或者打开数据库
		SQLiteDatabase showuvoice_db = SQLiteDatabase
				.openOrCreateDatabase(
						"/data/data/com.iroundu.showuvoice/databases/showuvoice.db",
						null);
		
		// 查看数据库中是否存在courseinfo表
		try {
			showuvoice_db
					.execSQL("create table userinfo(_id integer primary key, username varchar(255), password varchar(255))");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 查询courseinfo表
		Cursor cursor = showuvoice_db.rawQuery("select * from userinfo", null);

		if (cursor.getCount() > 0) {
			cursor.moveToNext();
			String _id = cursor.getString(1);
			String _pwd = cursor.getString(2);
			
			System.out.println(_id);
			System.out.println(_pwd);
			
			cursor.close();
			showuvoice_db.close();
			
			Intent intent = new Intent(EnterActivity.this,
					LoginActivity.class);
			intent.putExtra("id", _id);
			intent.putExtra("pwd", _pwd);
			startActivity(intent);
			EnterActivity.this.finish();
		}else {
			cursor.close();
			showuvoice_db.close();
		}
		
		mGestureDetector = new GestureDetector(this, (OnGestureListener) this);

		final Button _loginButton = (Button) findViewById(R.id.login_button);
		final Button _registerButton = (Button) findViewById(R.id.register_button);

		_loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EnterActivity.this,
						LoginActivity.class);
				// intent.putExtra("animation", "left");
				startActivity(intent);
				EnterActivity.this.finish();
			}
		});

		_registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EnterActivity.this,
						RegisterActivity.class);
				startActivity(intent);
				EnterActivity.this.finish();
			}
		});

	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if (e1.getX() - e2.getX() > verticalMinDistance
				&& Math.abs(velocityX) > minVelocity) {

			// 切换Activity
			Intent intent = new Intent(EnterActivity.this, LoginActivity.class);
			startActivity(intent);
			EnterActivity.this.finish();
			// Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();
		} else if (e2.getX() - e1.getX() > verticalMinDistance
				&& Math.abs(velocityX) > minVelocity) {

			// 切换Activity
			ErrorDialog(R.drawable.ic_action_search,
					R.string.exit_dialog_title, R.string.exit_dialog_content,
					R.string.exit_dialog_makesur);
			// Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return mGestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		mGestureDetector.onTouchEvent(ev);
		// scroll.onTouchEvent(ev);

		return super.dispatchTouchEvent(ev);
	}

	@SuppressWarnings("deprecation")
	private void ErrorDialog(int icon, int title, int content, int makesur) {
		final Builder builder = new AlertDialog.Builder(EnterActivity.this);
		// 设置对话框的图标
		builder.setIcon(icon);
		// 设置对话框的标题
		builder.setTitle(title);
		// 设置对话框的内容
		builder.setMessage(content);
		// 设置对话框的"确定"按钮
		builder.setNegativeButton(makesur,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						EnterActivity.this.finish();
					}
				});
		AlertDialog alertDialog = builder.create();
		// 设置Dialog透明
		Window window = alertDialog.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		// 设置透明度为0.3
		lp.alpha = 0.8f;
		window.setAttributes(lp);
		// Dialog后面的内容会变得模糊
		window.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
				WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		alertDialog.show();
	}
}