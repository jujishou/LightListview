package com.sniper.lightListview.ui.component;

import android.app.ProgressDialog;
import android.content.Context;

import com.sniper.listListview.R;

public class QProgressDialog extends ProgressDialog {

	public QProgressDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setMessage(context.getResources().getString(R.string.loading2));
	}

	public QProgressDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}


}
