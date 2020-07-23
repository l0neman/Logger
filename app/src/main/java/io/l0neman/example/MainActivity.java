package io.l0neman.example;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.l0neman.logger.Logger;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private int mId = 0x08;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    testLogger();
    testAndroidLog();
  }

  private void testLogger() {
    Logger.d(TAG, "#testAndroidLog mId=%d", mId);
    myLoggerD(TAG, "hello world");
  }

private void myLoggerD(String tag, String log) {
  Logger.d(tag, log);
}


  private void testAndroidLog() {
    logD(TAG, "#testAndroidLog mId=" + mId);
  }

  private static void logD(String tag, String log) {
    Log.d(TAG, log);
  }
}
