package com.iroundu.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.iroundu.login.LoginActivity;
import com.iroundu.showuvoice.R;
import com.iroundu.splash.EnterActivity;


public class FindPwdFailedActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.findpwd_failed);
		
		final Button _re_emailButton = (Button) findViewById(R.id.re_email_button);
		final Button _new_registerButton = (Button) findViewById(R.id.new_register_button);
		
		_re_emailButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(FindPwdFailedActivity.this,
						ForgetPwdActivity.class);
				startActivity(intent);
				FindPwdFailedActivity.this.finish();
			}
		});
		
		_new_registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(FindPwdFailedActivity.this,
						RegisterActivity.class);
				startActivity(intent);
				FindPwdFailedActivity.this.finish();
			}
		});
	}
}