package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends Activity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1 = findViewById(R.id.button);
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
            Python py = Python.getInstance();
            PyObject module = py.getModule("myfile");
            PyObject fact = module.get("factorial");
            PyObject a = fact.call(2, 11, 3);
            btn1.setText(a.toString());
    }
}
