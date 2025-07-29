/*
Copyright (c) 2019, Vuzix Corporation
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

*  Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

*  Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.

*  Neither the name of Vuzix Corporation nor the names of
   its contributors may be used to endorse or promote products derived
   from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.vuzix.sample.buttonfocus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity  implements View.OnClickListener {
    private final static String TAG = "ButtonFocus";
    Button mButton1;
    Button mButton2;
    Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = findViewById(R.id.button1);
        mButton1.setOnClickListener(this);

        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(this);

        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String buttonPressed;
        if (view.getId() == R.id.button1) {
            buttonPressed = getResources().getString(R.string.MessageBtn1);
        } else if (view.getId() == R.id.button2) {
            buttonPressed = getResources().getString(R.string.MessageBtn2);
        } else if (view.getId() == R.id.button3) {
            buttonPressed = getResources().getString(R.string.MessageBtn3);
        } else {
            buttonPressed = "Unknown";
        }
        Log.d(TAG, buttonPressed);
        Toast.makeText(MainActivity.this, buttonPressed, Toast.LENGTH_SHORT).show();
    }

    // Override this for debugging so we see key presses in the logcat
    @Override
    public boolean dispatchTouchEvent (MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            Log.d(TAG, "Touch event " + event);
        }
        return super.dispatchTouchEvent(event);
    }

    // Override this for debugging so we see key presses in the logcat
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_UP) {
            Log.d(TAG, "User pressed " + KeyEvent.keyCodeToString(event.getKeyCode()));
        }
        return super.dispatchKeyEvent (event);
    }
}
