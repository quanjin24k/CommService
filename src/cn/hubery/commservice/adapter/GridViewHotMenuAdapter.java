package cn.hubery.commservice.adapter;

import cn.hubery.commservice.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridViewHotMenuAdapter extends BaseAdapter {

	private Context context;
	
	public GridViewHotMenuAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		return 24;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = View.inflate(context, R.layout.takeout_hotmenu_adapter_item, null);
		return v;
	}

}
