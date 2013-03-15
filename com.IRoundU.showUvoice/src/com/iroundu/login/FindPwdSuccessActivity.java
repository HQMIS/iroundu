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


public class FindPwdSuccessActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.findpwd_success);

		final Button _back_login_buttonButton = (Button) findViewById(R.id.back_login_button);
		
		_back_login_buttonButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent = new Intent(FindPwdSuccessActivity.this,
						LoginActivity.class);
				startActivity(intent);
				FindPwdSuccessActivity.this.finish();
			}
		});
	}
}