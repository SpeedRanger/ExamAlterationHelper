package com.example.android.examalterationhelper;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class report_gen extends AppCompatActivity {

    EditText report_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_gen);
    }


    public void send_report(View view) {
        final String msg = report_edit.getText().toString();
        if (msg.length() < 20) {
            Toast.makeText(report_gen.this, "Report is too brief, Please enter an elaborate report", Toast.LENGTH_SHORT).show();
        }
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        client.post("https://examalthelper.000webhostapp.com/send_adm_phno.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String phno = new String(responseBody);
                Intent intent = new Intent(getApplicationContext(), forgot_password.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phno, null, msg, pi, null);
                Toast.makeText(report_gen.this, "Report Sent", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), admin_pg.class));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
