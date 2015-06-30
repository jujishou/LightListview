package com.sniper.lightListview.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.ButterKnife;

import com.sniper.lightListview.ui.fragment.DemoListFragment;
import com.sniper.listListview.R;

public class DemoListActivity extends FragmentActivity {

	private DemoListFragment demoFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		ButterKnife.inject(this);
		demoFragment = new DemoListFragment();
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, demoFragment).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		// int id = item.getItemId();
		// if (id == R.id.action_settings) {
		// startActivity(new Intent(this, SendQuestionActivity.class));
		// return true;
		// }
		return super.onOptionsItemSelected(item);
	}

}
