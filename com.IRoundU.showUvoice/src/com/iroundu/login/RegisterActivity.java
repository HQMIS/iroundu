package com.iroundu.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
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
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.iroundu.showuvoice.MainActivity;
import com.iroundu.showuvoice.R;
import com.iroundu.splash.EnterActivity;
import com.iroundu.util.NetConnection;

public class RegisterActivity extends Activity implements OnTouchListener,
		OnGestureListener {
	EditText register_id;
	EditText register_pwd;
	EditText register_email;
	
	int manorwoman = 0; // manorwoman = 0 男， manorwoman = 1 女
	int showorhide = 0; // showorhide = 0 显示， showorhide = 1 隐藏

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
			LayoutInflater factory = LayoutInflater.from(RegisterActivity.this);
			final RelativeLayout layout = (RelativeLayout) factory.inflate(
					R.layout.register, null);

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
			setContentView(R.layout.register);
		}

		mGestureDetector = new GestureDetector(this, (OnGestureListener) this);

		// 首先检查网络情况
		boolean InternetConnect = NetConnection.getInstance()
				.isMobileAvailable(getBaseContext());

		if (false == InternetConnect) {
			ErrorDialog(R.drawable.ic_action_search,
					R.string.error_dialog_title,
					R.string.error_dialog_content_net,
					R.string.error_dialog_makesur);
		} else {
			// do nothing
		}

		final Button register_backButton = (Button) findViewById(R.id.back_button);
		final Button register_mButton = (Button) findViewById(R.id.man_button);
		final Button register_wButton = (Button) findViewById(R.id.woman_button);

		register_id = (EditText) findViewById(R.id.id_edit);
		register_pwd = (EditText) findViewById(R.id.pwd_edit);
		register_email = (EditText) findViewById(R.id.pwd_edit);

		final Button register_registerButton = (Button) findViewById(R.id.register_button);
		final Button _show_hide_Button = (Button) findViewById(R.id.show_hide_button);
		
		_show_hide_Button.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (0 == showorhide){
						register_pwd.setTransformationMethod(HideReturnsTransformationMethod
								.getInstance());
						_show_hide_Button.setText(getString(R.string._hidepwd));
						showorhide = 1;
					}else {
						register_pwd.setTransformationMethod(PasswordTransformationMethod
								.getInstance());
						_show_hide_Button.setText(getString(R.string._showpwd));
						showorhide = 0;
					}
				} else {
					// do nothing
				}
				return false;
			}
		});

		register_backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(RegisterActivity.this,
						EnterActivity.class);
				startActivity(intent);
				RegisterActivity.this.finish();
			}
		});

		register_mButton.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					manorwoman = 0;
					v.setBackgroundResource(R.drawable.left_after);
					register_wButton
							.setBackgroundResource(R.drawable.right_before);
				} else {
					// do nothing
				}
				return false;
			}
		});

		register_wButton.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					manorwoman = 1;
					v.setBackgroundResource(R.drawable.right_after);
					register_mButton
							.setBackgroundResource(R.drawable.right_before);
				} else {
					// do nothing
				}
				return false;
			}
		});

		register_registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated methodstub
				register(register_id.getText().toString(), register_pwd
						.getText().toString(), register_email.getText()
						.toString(), manorwoman);
			}
		});

	}

	private void register(String register_id, String register_pwd,
			String register_email, int manorwoman) {
		// id pwd email 可用性判定
		if (register_id.equals("") || register_pwd.equals("")
				|| register_email.equals("")) {
			ErrorDialog(R.drawable.ic_action_search,
					R.string.error_dialog_title,
					R.string.error_dialog_content_null,
					R.string.error_dialog_makesur);
		} else {
			System.out.println(register_id);
			System.out.println(register_pwd);
			System.out.println(register_email);
			System.out.println(manorwoman);
			boolean RegisterSucceed = false;

			ProgressDialog.show(RegisterActivity.this, "", "正在注册，请稍候...");

			RegisterSucceed = true;
			if (false == RegisterSucceed) {
				ErrorDialog(R.drawable.ic_action_search,
						R.string.error_dialog_title,
						R.string.error_dialog_content_wrong,
						R.string.error_dialog_makesur);
			} else {
				// 创建或者打开数据库
				SQLiteDatabase showuvoice_db = SQLiteDatabase
						.openOrCreateDatabase(
								"/data/data/com.iroundu.showuvoice/databases/showuvoice.db",
								null);
				try {
					showuvoice_db
							.execSQL(
									"insert into userinfo(_id, username, password) values (null, ?, ?)",
									new Object[] {register_id, register_pwd});
					showuvoice_db.close();
				} catch (Exception e) {
					Log.v("Insert", "Insert into userinfo failed");
				}
				
				// 注册成功， 进入附件页面
				Intent intent = new Intent(RegisterActivity.this,
						MainActivity.class);
				// IRoundUActivity.class);
				intent.setAction(register_id);
				startActivity(intent);
				RegisterActivity.this.finish();
			}

		}
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
			register(register_id.getText().toString(), register_pwd.getText()
					.toString(), register_email.getText().toString(),
					manorwoman);
			// Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();
		} else if (e2.getX() - e1.getX() > verticalMinDistance
				&& Math.abs(velocityX) > minVelocity) {

			// 切换Activity
			Intent intent = new Intent(RegisterActivity.this,
					EnterActivity.class);
			intent.putExtra("animation", "left");
			startActivity(intent);
			RegisterActivity.this.finish();
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
	@SuppressLint("ParserError")
	private void ErrorDialog(int icon, int title, int content, int makesur) {
		final Builder builder = new AlertDialog.Builder(RegisterActivity.this);
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
						System.out.println("IRoundU");
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
