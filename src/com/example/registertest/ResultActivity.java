package com.example.registertest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView resultName=(TextView ) this.findViewById(R.id.resultName);
		TextView resultCity=(TextView ) this.findViewById(R.id.resultCity);
		TextView resultPsd=(TextView ) this.findViewById(R.id.resultPsd);
		TextView resultGender=(TextView ) this.findViewById(R.id.resultGender);
		Intent intent=getIntent();
		resultName.setText(intent.getStringExtra("name"));
		resultCity.setText(intent.getStringExtra("City"));
		resultPsd.setText(intent.getStringExtra("Psd"));
		resultGender.setText(intent.getStringExtra("Gender"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
