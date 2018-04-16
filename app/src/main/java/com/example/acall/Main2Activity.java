package com.example.acall;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.design.widget.TextInputEditText;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mTextTextView;
    private TextInputEditText mTextSummary;
    private Button mTextButton;
    private ImageButton mVoiceButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_text:
                    mTextMessage.setText(R.string.nav_text);
                    mTextTextView.setVisibility(View.VISIBLE);
                    mTextSummary.setVisibility(View.VISIBLE);
                    mTextButton.setVisibility(View.VISIBLE);
                    mVoiceButton.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_voice:
                    mTextMessage.setText(R.string.nav_voice);
                    mTextTextView.setVisibility(View.INVISIBLE);
                    mTextSummary.setVisibility(View.INVISIBLE);
                    mTextButton.setVisibility(View.INVISIBLE);
                    mVoiceButton.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextTextView = (TextView) findViewById(R.id.textTextView);
        mTextSummary = (TextInputEditText) findViewById(R.id.summary);
        mTextButton = (Button) findViewById(R.id.textButton);
        mVoiceButton = (ImageButton) findViewById(R.id.voiceButton);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /* mTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextTextView.setText(mTextSummary.getText());
                String eventStr = mTextSummary.getText().toString();
                String[] strSplit = eventStr.split(";");
                HashMap<String, String> eventInfo = new HashMap<String, String>();
                String timezone = null;
                for (int i = strSplit.length - 1; i >= 0; i--) {
                    String[] clsf = strSplit[i].split(";");

                    if (clsf.length == 1) {
                        HashMap<String, String> istime = customTimeProcessor(clsf[0]);
                        if (istime == null) {
                            eventInfo.put("summary", clsf[0]);
                        } else {
                            if (eventInfo.get("start") != null) {
                                eventInfo.put("start", istime);
                            } else {
                                String comp = "dateTime";
                                if (eventInfo.get("start") == "") {
                                    comp = 'date';
                                }

                                var stD = new Date(eventInfo['start'][comp]);
                                var compD = new Date(istime[comp]);
                                if (stD.getTime() > compD.getTime()) {
                                    eventInfo['end'] = eventInfo['start'];
                                    eventInfo['start'] = istime;
                                } else {
                                    eventInfo['end'] = istime;
                                }
                            }
                        }
                    } else {
                        switch(clsf[0]) {
                            case 'from':
                                eventInfo['start'] = customTimeProcessor(clsf[1]);
                                break;
                            case 'to':
                                eventInfo['end'] = customTimeProcessor(clsf[1]);
                                break;
                            case 'at':
                                eventInfo['location'] = clsf[1];
                                break;
                            case 'time':
                                timezone = clsf[1].toLowerCase().trim();
                                break;
                        }
                    }

                }
                mTextSummary.setText(null);
            }
        }); */
    }

    private HashMap<String, String> customTimeProcessor(String timeStr) {
        return null;
    }

}
