package com.mia.sendemail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText emailid,subject,body;
	Button sendbutton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		emailid=(EditText) findViewById(R.id.inputemail);
		subject=(EditText) findViewById(R.id.subject);
		body=(EditText) findViewById(R.id.body);
		sendbutton=(Button) findViewById(R.id.sendbutton);
		
		sendbutton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {			
				String contentemail = emailid.getText().toString();
				  String contentsubject = subject.getText().toString();
				  String contentbody = body.getText().toString();
	 
				  Intent email = new Intent(Intent.ACTION_SEND);
				  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ contentemail});
				  email.putExtra(Intent.EXTRA_SUBJECT, contentsubject);
				  email.putExtra(Intent.EXTRA_TEXT, contentbody);
				  email.setType("message/rfc822");		  
				  startActivity(Intent.createChooser(email, "Choose an Email client :"));
			}});	
	}
}