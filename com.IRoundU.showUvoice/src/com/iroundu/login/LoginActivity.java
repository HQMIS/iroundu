package com.iroundu.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
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
import android.widget.Toast;

import com.iroundu.showuvoice.MainActivity;
import com.iroundu.showuvoice.R;
import com.iroundu.splash.EnterActivity;
import com.iroundu.util.NetConnection;

public class LoginActivity extends Activity implements OnTouchListener,
		OnGestureListener {

	EditText _id;
	EditText _pwd;
	
	int showorhide = 0; // showorhide = 0 ��ʾ�� showorhide = 1 ����

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
			try{
				LayoutInflater factory = LayoutInflater.from(LoginActivity.this);
				final RelativeLayout layout = (RelativeLayout) factory.inflate(
						R.layout.login, null);

				String animation = extras.getString("animation");
				// �õ�һ��LayoutAnimationController����
				if (animation.equals("left")) {
					controller = AnimationUtils.loadLayoutAnimation(this,
							R.anim.layout_left_in);
				} else {
					controller = AnimationUtils.loadLayoutAnimation(this,
							R.anim.layout_right_in);
				}
				// ���ÿؼ���ʾ��˳��
				controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
				// ���ÿؼ���ʾ���ʱ�䣻
				controller.setDelay(0);
				// ΪListView����LayoutAnimationController���ԣ�
				layout.setLayoutAnimation(controller);
				setContentView(layout);
			}catch (Exception e) {
				// TODO: handle exception
				setContentView(R.layout.login);
				
				String id = extras.getString("id");
				String pwd = extras.getString("pwd");
				
				System.out.println(id);
				System.out.println(pwd);
				
				login(id, pwd);
			}
		} else {
			setContentView(R.layout.login);
		}

		mGestureDetector = new GestureDetector(this, (OnGestureListener) this);

		_id = (EditText) findViewById(R.id.id_edit);
		_pwd = (EditText) findViewById(R.id.pwd_edit);

		final Button _backButton = (Button) findViewById(R.id.back_button);
		final Button _loginButton = (Button) findViewById(R.id.login_button);
		final Button _forgetButton = (Button) findViewById(R.id.forget_button);
		final Button _show_hide_Button = (Button) findViewById(R.id.show_hide_button);

		// final ProgressBar bar = (ProgressBar) findViewById(R.id.login_pb);

		_backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,
						EnterActivity.class);
				startActivity(intent);
				LoginActivity.this.finish();
			}
		});

		_loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Python: " + _id.getText().toString());
				System.out.println("FWL: " + _pwd.getText().toString());
				login(_id.getText().toString(), _pwd.getText().toString());
			}
		});

		_forgetButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,
						ForgetPwdActivity.class);
				startActivity(intent);
				LoginActivity.this.finish();
			}
		});

		_show_hide_Button.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (0 == showorhide){
						_pwd.setTransformationMethod(HideReturnsTransformationMethod
								.getInstance());
						_show_hide_Button.setText(getString(R.string._hidepwd));
						showorhide = 1;
					}else {
						_pwd.setTransformationMethod(PasswordTransformationMethod
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
		
		/*
		 _showpwdButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					System.out.println("Checked");
					_pwd.setTransformationMethod(HideReturnsTransformationMethod
							.getInstance());
				} else {
					System.out.println("Not Checked");
					_pwd.setTransformationMethod(PasswordTransformationMethod
							.getInstance());
				}

			}
		});
		*/
	}

	private void login(String _id, String _pwd) {
		if (_id.equals("") || _pwd.equals("")) {
			ErrorDialog(R.drawable.ic_action_search,
					R.string.error_dialog_title,
					R.string.error_dialog_content_null,
					R.string.error_dialog_makesur);
		} else {
			// ��Server�������е�¼
			// ���ȼ���������
			// Ҫ�ں���ǰ����ϣ� �ļ�����
			boolean InternetConnect = NetConnection.getInstance()
					.isMobileAvailable(getBaseContext()) || NetConnection.getInstance().isWifiAvailable(getBaseContext());

			if (false == InternetConnect) {
				ErrorDialog(R.drawable.ic_action_search,
						R.string.error_dialog_title,
						R.string.error_dialog_content_net,
						R.string.error_dialog_makesur);
			} else {
				// �����ʻ�������У��
				boolean LoginSucceed = false;

				ProgressDialog _pd = ProgressDialog.show(LoginActivity.this, "", "���ڵ�¼�����Ժ�...");
				// ��¼����
				
				//
				if (_id.equals("hqm") && _pwd.equals("hqm")) {
					LoginSucceed = true;
				}else {
					LoginSucceed = false;
				}
				
				if (false == LoginSucceed) {
					/*ErrorDialog(R.drawable.ic_action_search,
							R.string.error_dialog_title,
							R.string.error_dialog_content_wrong,
							R.string.error_dialog_makesur);*/
					// ��������򱳾�ͼ
					
					// ��toast��ʾ
					Toast toast = Toast.makeText(getApplicationContext(), "�˺Ż��������", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.TOP, 0, 0);
					toast.show();
				} else {
					// �������ߴ����ݿ�
					SQLiteDatabase showuvoice_db = SQLiteDatabase
							.openOrCreateDatabase(
									"/data/data/com.iroundu.showuvoice/databases/showuvoice.db",
									null);
					
					Cursor cursor = showuvoice_db.rawQuery("select * from userinfo where username = ? and password = ?", new String[]{_id, _pwd});

					if (0 == cursor.getCount()) {
						try {
							showuvoice_db
									.execSQL(
											"insert into userinfo(_id, username, password) values (null, ?, ?)",
											new Object[] {_id, _pwd});
						} catch (Exception e) {
							Log.v("Insert", "Insert into userinfo failed");
						}
					}
					
					showuvoice_db.close();
					
					// ��¼�ɹ��� ���븽��ҳ��
					_pd.dismiss();
					Intent intent = new Intent(LoginActivity.this,
							MainActivity.class);
					// IRoundUActivity.class);
					intent.setAction(_id);
					startActivity(intent);
					LoginActivity.this.finish();
				}
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

			// �л�Activity
			login(_id.getText().toString(), _pwd.getText().toString());
			// Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
		} else if (e2.getX() - e1.getX() > verticalMinDistance
				&& Math.abs(velocityX) > minVelocity) {
			// �л�Activity
			Intent intent = new Intent(LoginActivity.this, EnterActivity.class);
			intent.putExtra("animation", "left");
			startActivity(intent);
			LoginActivity.this.finish();
			// Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
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
		final Builder builder = new AlertDialog.Builder(LoginActivity.this);
		// ���öԻ����ͼ��
		builder.setIcon(icon);
		// ���öԻ���ı���
		builder.setTitle(title);
		// ���öԻ��������
		builder.setMessage(content);
		// ���öԻ����"ȷ��"��ť
		builder.setNegativeButton(makesur,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						System.out.println("IRoundU");
					}
				});
		AlertDialog alertDialog = builder.create();
		// ����Dialog͸��
		Window window = alertDialog.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		// ����͸����Ϊ0.3
		lp.alpha = 0.8f;
		window.setAttributes(lp);
		// Dialog��������ݻ���ģ��
		window.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
				WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		alertDialog.show();
	}
}
