package com.example.dab.tinkerdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv);
        Test test = new Test();
        textView.setText(test.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinkerInstaller.onReceiveUpgradePatch(getApplication(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
            }
        });
    }

    public void sada(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
