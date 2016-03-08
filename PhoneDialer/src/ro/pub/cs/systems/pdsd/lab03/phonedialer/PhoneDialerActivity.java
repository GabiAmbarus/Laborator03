package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_phone_dialer);
        
        final EditText numberText;
        numberText = (EditText)findViewById(R.id.editText1);
        

        
        //Numbers part
        int ids [] = {R.id.button1,R.id.button2,R.id.button3,
        		R.id.button4,R.id.button5,R.id.button6,
        		R.id.button7,R.id.button8,R.id.button9,
        		R.id.button0,R.id.buttonplus,R.id.buttons};
        
        for(int i=0;i<=11;i++){
        	final Button btn;
            btn = (Button)findViewById(ids[i]);
            
            btn.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				String oldText = numberText.getText().toString();
    				oldText = oldText + btn.getText();
    				numberText.setText(oldText);
    				
    			}
    		});
        }
        
       final ImageButton erase,call,end;
       
       erase = (ImageButton)findViewById(R.id.backspace);
       call = (ImageButton)findViewById(R.id.call);
       end = (ImageButton)findViewById(R.id.hangup);
       
       call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phoneNumber = numberText.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+phoneNumber));
				startActivity(intent);
				
			}
		});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}
