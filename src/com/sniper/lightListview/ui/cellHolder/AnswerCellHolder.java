package com.sniper.lightListview.ui.cellHolder;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.sniper.lightListview.base.BaseCellHolder;
import com.sniper.lightListview.entity.DemoModel;
import com.sniper.listListview.R;

public class AnswerCellHolder extends BaseCellHolder {

	@InjectView(R.id.textview_title)
	TextView titleTV;

	public AnswerCellHolder(View cellView) {
		ButterKnife.inject(this, cellView);
	}

	@Override
	public void bindData(Object obj) {
		// TODO Auto-generated method stub
		DemoModel model = (DemoModel) obj;
		titleTV.setText(model.getName());
	}
}
