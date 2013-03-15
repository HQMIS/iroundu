package com.iroundu.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.iroundu.showuvoice.MainActivity;
import com.iroundu.showuvoice.R;

public class ForgetPwdActivity extends Activity implements OnTouchListener,
		OnGestureListener {

	EditText forgetpwd_email;

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
			LayoutInflater factory = LayoutInflater.from(ForgetPwdActivity.this);
			final RelativeLayout layout = (RelativeLayout) factory.inflate(
					R.layout.forgetpwd, null);
			
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
		} else {
			setContentView(R.layout.forgetpwd);
		}

		mGestureDetector = new GestureDetector((OnGestureListener) this);

		forgetpwd_email = (EditText) findViewById(R.id.email_edit);
		final Button forgetpwd_backButton = (Button) findViewById(R.id.back_button);
		final Button forgetpwd_ensureButton = (Button) findViewById(R.id.ensure_button);

		forgetpwd_backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(ForgetPwdActivity.this,
						LoginActivity.class);
				startActivity(intent);
				ForgetPwdActivity.this.finish();
			}
		});

		forgetpwd_ensureButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				findback(forgetpwd_email.getText().toString());
			}
		});
	}

	private void findback(String _email) {
		boolean find_back_flag = false;
		
		if (_email.equals("huangqimin@baidu.com")) {
			find_back_flag = true;
		}else {
			find_back_flag = false;
		}
		
		if (find_back_flag) {
			Intent intent = new Intent(ForgetPwdActivity.this,
					FindPwdSuccessActivity.class);
			startActivity(intent);
			ForgetPwdActivity.this.finish();
		}else {
			Intent intent = new Intent(ForgetPwdActivity.this,
					FindPwdFailedActivity.class);
			startActivity(intent);
			ForgetPwdActivity.this.finish();
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
			findback(forgetpwd_email.getText().toString());
			// Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
		} else if (e2.getX() - e1.getX() > verticalMinDistance
				&& Math.abs(velocityX) > minVelocity) {

			// �л�Activity
			Intent intent = new Intent(ForgetPwdActivity.this,
					LoginActivity.class);
			intent.putExtra("animation", "left");
			startActivity(intent);
			ForgetPwdActivity.this.finish();
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

	private void ErrorDialog(int icon, int title, int content, int makesur) {
		final Builder builder = new AlertDialog.Builder(ForgetPwdActivity.this);
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
