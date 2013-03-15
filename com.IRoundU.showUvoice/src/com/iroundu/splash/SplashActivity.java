package com.iroundu.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.iroundu.login.LoginActivity;
import com.iroundu.showuvoice.R;


public class SplashActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this,
						LoginActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}
		}, 1000);

	}
}