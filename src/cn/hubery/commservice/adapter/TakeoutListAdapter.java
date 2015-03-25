package cn.hubery.commservice.adapter;

import cn.hubery.commservice.R;
import cn.hubery.commservice.util.PhoneCallUtil;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class TakeoutListAdapter extends BaseAdapter {

	private Context context;
	
	
	public TakeoutListAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
		View v = View.inflate(context, R.layout.takeout_service_item, null);
		ImageView phoneView = (ImageView) v.findViewById(R.id.iv_takeout_business_phone);
		phoneView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//用intent启动拨打电话  
				PhoneCallUtil.call(context, "400 616 0066");
			}
		});
		return v;
	}

}
