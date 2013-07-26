package net.kaosfield.wv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.webview);

        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);

        wv.setWebChromeClient(new WebChromeClient());

        wv.loadUrl("file:///android_asset/index.html");
    }
    
    // バックキーが押されてもアプリを終了しない
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			WebView webView = (WebView) findViewById(R.id.webview);
			if (webView.canGoBack()) {
		    	webView.goBack();
		        return true;
		    }
			onTwoClick(webView );
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onTwoClick(View view) {	//added by eGtry
	    new AlertDialog.Builder(this)
	            .setTitle(("終了(Quit)")
	            .setMessage("終了しますか？(Quit?)")
	            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	                @Override
					public void onClick(DialogInterface dialog, int id) {
	                    //showToast("bye~");
	                    finish();
	                }
	            })
	            .setNegativeButton("No", new DialogInterface.OnClickListener() {
	                @Override
					public void onClick(DialogInterface dialog, int id) {
	                    //showToast("Invalid");
	                }
	            })
	            .create()
	            .show();
	}	
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
