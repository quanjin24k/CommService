package cn.hubery.commservice.adapter;

import cn.hubery.commservice.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 社区服务 adapter
 * @author Hubery
 * @edit 2015年3月26日09:26:16
 */
public class GridViewServiceAdapter extends BaseAdapter {

	private Context mContext;
	private int itemNum;
	
	private int[] servicePicIdArr = {R.drawable.service_notice,R.drawable.service_wuye,
			 R.drawable.service_huangye,R.drawable.service_banshi};

	
	public GridViewServiceAdapter(Context mContext, int itemNum) {
		super();
		this.mContext = mContext;
		this.itemNum = itemNum;
	}

	@Override
	public int getCount() {
		return itemNum;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = View.inflate(mContext, R.layout.grid_item_ll_2, null);
		ImageView iv_grid_item = (ImageView) v.findViewById(R.id.iv_grid_item);
		iv_grid_item.setBackgroundResource(servicePicIdArr[position]);
		
		return v;
	}

}
