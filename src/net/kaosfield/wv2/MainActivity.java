package net.kaosfield.wv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private static final WebView webView = null;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// タイトルバーを削除する
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		// レイアウトで指定したWebViewのIDを指定する。
		WebView myWebView = (WebView) findViewById(R.id.webView1);

		// リンクをタップしたときに標準ブラウザを起動させない
		myWebView.setWebViewClient(new WebViewClient());

		//
		myWebView.loadUrl("file:///android_asset/www/index.html");
		// jacascriptを許可する
		myWebView.getSettings().setJavaScriptEnabled(true);
		// 右側のスクロールバーの隙間をなくす
		myWebView.setVerticalScrollbarOverlay(true);
		// alertDialog 
		myWebView.setWebChromeClient(new WebChromeClient() {
	          @Override
	           public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
	                       return super.onJsAlert(view, url, message, result);
	              }
	      });
		
		
	}

	// バックキーが押されてもアプリを終了しない
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			WebView webView = (WebView) findViewById(R.id.webView1);
			if (webView.canGoBack()) {
				webView.goBack();
				return true;
			}
			onTwoClick(webView);
			// WebView webView = (WebView) findViewById(R.id.webView1);
			// webView.goBack();
			// return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onTwoClick(View view) { // added by eGtry
		new AlertDialog.Builder(this)
				.setTitle("終了(Quit)")
				.setMessage("終了しますか？(Quit?)")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// showToast("bye~");
								finish();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// showToast("Invalid");
					}
				}).create().show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}
