package com.sniper.lightListview.base;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class QBaseAdapter<T> extends BaseAdapter {

	public interface CreateHolderListener {

		public BaseCellHolder cellHolder(View cellView);
	}

	public List<T> dataList;
	public CreateHolderListener holderListener;

	protected LayoutInflater mInflater = null;
	protected Context mContext;

	private int cellId;

	/**
	 * 
	 * @param context
	 * @param dataList
	 * @param cellId
	 *            cell id in res
	 * @param holderListener
	 *            can't null
	 */
	public QBaseAdapter(Context context, List<T> dataList, int cellId,
			CreateHolderListener holderListener) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
		this.dataList = dataList;
		this.cellId = cellId;
		this.holderListener = holderListener;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	public int getItemViewType(int position) {
		return 1;
	}

	@Override
	public int getCount() {
		if (holderListener == null) {
			return 0;
		}
		int count = dataList != null ? dataList.size() : 0;
		return count;
	}

	@Override
	public Object getItem(int position) {
		if (0 <= position && position < getCount()) {
			return dataList.get(position);
		} else {
			return null;
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected View dequeueReuseableCellView(int position, View convertView,
			ViewGroup parent) {
		return null;
	}

	public void update(int newState) {
		notifyDataSetInvalidated();
	}

	@Override
	public View getView(int position, View cellView, ViewGroup parent) {

		BaseCellHolder holder = null;
		if (cellView == null) {
			cellView = mInflater.inflate(cellId, null);
			holder = holderListener.cellHolder(cellView);
			if (null != holder) {
				cellView.setTag(holder);
			}
		} else {
			holder = (BaseCellHolder) cellView.getTag();
			if (holder == null) {
				Log.v("lottery", "error");
			}
		}
		if (null != holder) {
			holder.position = position;
		}
		holder.bindData(getItem(position));
		// bindData(position, cellView, parent, holder);
		return cellView;
	}
}
