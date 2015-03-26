package cn.hubery.commservice.adapter;

import cn.hubery.commservice.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 闪电送    adapter
 * @author Hubery
 * @edit 2015年3月26日09:26:16
 */
public class GridViewFlashAdapter extends BaseAdapter {

	private Context mContext;
	
	private int[] flashPicIdArr = {R.drawable.flash_01_market,R.drawable.flash_02_takeout,R.drawable.flash_03_vegetables,
			R.drawable.flash_04_fruits,R.drawable.flash_05_home,R.drawable.flash_06_wash_clothes,
			R.drawable.flash_07_hospital,R.drawable.flash_08_repair}; 
	private String[] flashNameArr = {"掌上超市", "外卖", "生鲜蔬菜", "水果","家政", "洗衣", "药店", "维修"};
	
	public GridViewFlashAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}
	
	@Override
	public int getCount() {
		return 8;
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
		View v = View.inflate(mContext, R.layout.grid_item_ll, null);
		ImageView flashPic = (ImageView) v.findViewById(R.id.flash_grid_item_pic);
		TextView flashName = (TextView) v.findViewById(R.id.flash_grid_item_name);
		flashPic.setBackgroundResource(flashPicIdArr[position]);
		flashName.setText(flashNameArr[position]);
		return v;
	}

}
