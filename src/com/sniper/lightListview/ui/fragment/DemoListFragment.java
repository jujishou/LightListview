package com.sniper.lightListview.ui.fragment;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.sniper.lightListview.base.BaseCellHolder;
import com.sniper.lightListview.base.QBaseAdapter;
import com.sniper.lightListview.base.QBaseAdapter.CreateHolderListener;
import com.sniper.lightListview.entity.DemoModel;
import com.sniper.lightListview.ui.cellHolder.AnswerCellHolder;
import com.sniper.lightListview.ui.component.LoadingFooter;
import com.sniper.lightListview.ui.component.OnLoadNextListener;
import com.sniper.lightListview.ui.component.PageListView;
import com.sniper.listListview.R;

@SuppressLint({ "InlinedApi", "ValidFragment" })
public class DemoListFragment extends Fragment implements
		SwipeRefreshLayout.OnRefreshListener, OnLoadNextListener {

	@InjectView(R.id.swipe_container)
	SwipeRefreshLayout swipeLayout;

	@InjectView(R.id.listview_question_answer)
	PageListView listView;

	private QBaseAdapter<DemoModel> adapter;

	@SuppressLint("ValidFragment")
	public DemoListFragment() {
	}

	@SuppressLint("InlinedApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_demo, container,
				false);
		ButterKnife.inject(this, rootView);
		initSwipeLayout();

		adapter = new QBaseAdapter<DemoModel>(getActivity(), null,
				R.layout.cell_demo, new CreateHolderListener() {

					@Override
					public BaseCellHolder cellHolder(View cellView) {
						// TODO Auto-generated method stub
						return new AnswerCellHolder(cellView);
					}
				});
		listView.setAdapter(adapter);
		listView.setLoadNextListener(this);

		loadData(true);
		return rootView;
	}

	/**
	 * 此处为从网络异步获取数据，demo中简化处理
	 * 
	 * @param refresh
	 *            如果为true，page重置
	 * 
	 */
	private void loadData(boolean refresh) {
		ArrayList<DemoModel> dataArray = new ArrayList<DemoModel>();
		for (int i = 0; i < 15; i++) {
			DemoModel demoModel = new DemoModel();
			demoModel.setName(" item   " + i);
			dataArray.add(demoModel);
		}
		if (adapter.dataList != null && !refresh) {
			adapter.dataList.addAll(dataArray);
		} else {
			adapter.dataList = dataArray;
		}

		adapter.notifyDataSetChanged();
		setRefreshing(false);
		listView.setState(LoadingFooter.State.Idle);
	}

	private void initSwipeLayout() {
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
	}

	private void setRefreshing(boolean refreshing) {
		swipeLayout.setRefreshing(refreshing);
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		loadData(true);
	}

	@Override
	public void onLoadNext() {
		// TODO Auto-generated method stub
		loadData(false);
	}

}
