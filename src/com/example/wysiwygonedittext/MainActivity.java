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

		// EditText�ɉ摜��}�������� ���̂P
		SpannableString ss = new SpannableString("abc");
		Drawable d = getBaseContext().getResources().getDrawable(
				R.drawable.ic_launcher);
		d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
		ss.setSpan(span, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		et.setText(ss);
		// append���Ă��Ȃ���abc�Ƃ����o�Ȃ�
		et.append(ss);
		et.append(ss);
		et.append(ss);

		// ������
		et.append(Html.fromHtml("<br /><b>bold</b>"));

		// �Α�
		et.append(Html.fromHtml("<br /><i>italic</i>"));

		// ����
		et.append(Html.fromHtml("<br /><u>under line</u>"));

		// big
		et.append(Html.fromHtml("<br /><big>Strike</big>"));

		// small
		et.append(Html.fromHtml("<br /><small>Strike</small>"));

		// color
		et.append(Html.fromHtml("<br />" + "<font color='#ff0000'>��</font>"
				+ "<font color='#888800'>��</font>"
				+ "<font color='#00ff00'>��</font>"
				+ "<font color='#008888'>��</font>"
				+ "<font color='#0000ff'>��</font>"
				+ "<font color='#880088'>��</font><br>"));

		// EditText�ɉ摜��}�������� ���̂Q
		Html.ImageGetter ig = new Html.ImageGetter() {
			public Drawable getDrawable(String source) {
				Drawable dr = getResources()
						.getDrawable(R.drawable.ic_launcher);

				// �傫�����w��ł���
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
