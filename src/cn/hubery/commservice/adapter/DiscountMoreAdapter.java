package cn.hubery.commservice.adapter;

import cn.hubery.commservice.R;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 更多优惠 adapter。
 * @author Hubery
 * @edit 2015年3月26日14:32:32
 */
public class DiscountMoreAdapter extends BaseAdapter {

	private Context context;
	
	public DiscountMoreAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6;
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
		View v = View.inflate(context, R.layout.takeout_discount_more_adapter_item, null);
		TextView oldPrice = (TextView) v.findViewById(R.id.takeout_discount_more_adapter_goods_price_old);
		// 删除线。
		oldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		return v;
	}

}
