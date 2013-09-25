package com.example.wysiwygonedittext;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText et = (EditText) findViewById(R.id.editText1);

		// EditText‚É‰æ‘œ‚ğ‘}“ü‚µ‚½‚¢ ‚»‚Ì‚P
		SpannableString ss = new SpannableString("abc");
		Drawable d = getBaseContext().getResources().getDrawable(
				R.drawable.ic_launcher);
		d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
		ss.setSpan(span, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		et.setText(ss);
		// append‚µ‚Ä‚à‚È‚º‚©abc‚Æ‚µ‚©o‚È‚¢
		et.append(ss);
		et.append(ss);
		et.append(ss);

		// ‘¾•¶š
		et.append(Html.fromHtml("<br /><b>bold</b>"));

		// Î‘Ì
		et.append(Html.fromHtml("<br /><i>italic</i>"));

		// ‰ºü
		et.append(Html.fromHtml("<br /><u>under line</u>"));

		// big
		et.append(Html.fromHtml("<br /><big>Strike</big>"));

		// small
		et.append(Html.fromHtml("<br /><small>Strike</small>"));

		// color
		et.append(Html.fromHtml("<br />" + "<font color='#ff0000'>Ô</font>"
				+ "<font color='#888800'>‰©</font>"
				+ "<font color='#00ff00'>—Î</font>"
				+ "<font color='#008888'>Â—Î</font>"
				+ "<font color='#0000ff'>Â</font>"
				+ "<font color='#880088'>‡</font><br>"));

		// EditText‚É‰æ‘œ‚ğ‘}“ü‚µ‚½‚¢ ‚»‚Ì‚Q
		Html.ImageGetter ig = new Html.ImageGetter() {
			public Drawable getDrawable(String source) {
				Drawable dr = getResources()
						.getDrawable(R.drawable.ic_launcher);

				// ‘å‚«‚³‚ğw’è‚Å‚«‚é
				dr.setBounds(0, 0, 200, 200);
				return dr;
			}
		};

		et.append(Html.fromHtml("<img src='star'>", ig, null));

		// Link
		et.setMovementMethod(android.text.method.LinkMovementMethod
				.getInstance());
		Spanned spanned = Html
				.fromHtml("<br /><a href='http://www.google.com/'>link</a>");
		et.append(spanned);

	}
}
