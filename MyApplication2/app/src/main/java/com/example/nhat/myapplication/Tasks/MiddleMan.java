package com.example.nhat.myapplication.Tasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nhat.myapplication.MainActivity;
import com.example.nhat.myapplication.R;

import java.util.ArrayList;

public class MiddleMan extends AppCompatActivity {
    public final static String EXTRA_HOUR = "com.example.nhat.myapplication.MESSAGE";
    public final static String EXTRA_MINUTE = "com.example.nhat.myapplication.MESSAGE";
    private ArrayList<String> brightess = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra("theText");
        handleWithKey(message);
    }

    private  void loadBrightData(){
        brightess.add("độ sáng");
        brightess.add("tăng sáng");
        brightess.add("giảm sáng");
        brightess.add("chỉnh sáng");
        brightess.add("bật sáng");
    }
    public void handleWithKey(String text){

            boolean brightCommand= false;
        for (String str: brightess){
            if (text.contains(str)) {
                brightCommand=true;
                break;
            }
        }

            if(text.contains("báo thức")||text.contains("hẹn giờ")) {
                int k=text.indexOf("giờ");
                String hour = text.substring(k-3, k).trim();
                String minute = text.substring(k+4,k+6).trim();
                Intent setAlarmIntent = new Intent(this, SetAlarm.class);
                setAlarmIntent.putExtra("HOUR",hour);
                setAlarmIntent.putExtra("MINUTE", minute);
                startActivity(setAlarmIntent);
                finish();
            } else
                if (brightCommand){
                    String str;
                    str = text.replaceAll("[^0-9]+"," ");
                   Intent setBright= new Intent(this, )
                }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_middle_man, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        Intent startMain = new Intent(this, MainActivity.class);
        startMain.putExtra("RESULT","Alarm Set OK!");
        startActivity(startMain);
        super.onDestroy();
    }

}
