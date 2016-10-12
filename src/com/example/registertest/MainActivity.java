package com.example.registertest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected static final android.content.DialogInterface.OnClickListener DialogInterface = null;
	Button registerBtn,cityBtn;
	TextView psd,psd2,name,gender,city;
	RadioButton male;
	
	protected Builder builder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerBtn=(Button) this.findViewById(R.id.registerBtn);
		cityBtn=(Button) this.findViewById(R.id.cityBtn);
		cityBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent =new Intent(MainActivity.this,ChooseCityActivity.class);
				startActivityForResult(intent,0);	
			}
		});
		registerBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String checkResult=checkInfo();
				if(checkResult!=null){
					Builder builder=new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("出错提示");
					builder.setMessage(checkResult);
					builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							psd.setText("");
							psd2.setText("");// TODO Auto-generated method stub
							
						}
					});
					builder.create().show();
					
				}else{
					Intent intent=new Intent(MainActivity.this,ResultActivity.class);
					intent.putExtra("name", name.getText().toString());
					intent.putExtra("psd", psd.getText().toString());
					String gender=male.isChecked()?"男":"女";
					intent.putExtra("city", city.getText().toString());
					startActivity(intent);
					
					
				}	
			}
		});
	}

	protected String checkInfo() {
		if(name.getText().toString()==null||name.getText().toString().equals("")){
			return"用户名不能为空";
		}
		if(psd.getText().toString().trim().length()<6||
				psd.getText().toString().trim().length()>15){
			return "密码位数应该在6~15之间";
		}
		if(!psd.getText().toString().equals(psd2.getText().toString())){
			return "两次输入的密码不一致 ";
		}
		return null;
	}
	
	
public void onActivityResult(int requestCode,int resultCode,Intent intent){
	if(requestCode==0&&resultCode==0){
		Bundle data=intent.getExtras();
		String resultCity=data.getString("city");
		city.setText(resultCity);
	}
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
