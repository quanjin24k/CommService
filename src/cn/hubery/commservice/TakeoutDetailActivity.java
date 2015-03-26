package cn.hubery.commservice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import cn.hubery.commservice.adapter.DiscountMoreAdapter;
import cn.hubery.commservice.adapter.GridViewHotMenuAdapter;
import cn.hubery.commservice.adapter.IndicatePagerAdapter;
import cn.hubery.commservice.util.PhoneCallUtil;

/**
 * 外卖详情
 * @author Hubery
 * @edit 2015年3月26日09:24:48
 */
public class TakeoutDetailActivity extends Activity implements OnClickListener {
	
	private Button btn_takeout_item_title_back;
	private ImageView takeout_item_shop_info_phone;
	private TextView takeout_item_pic_wall_more_tv;
	
	private ViewPager viewpager;
	
	private ListView takeout_item_more_discount_list;
	private GridView takeout_item_hot_menu_gridview;
	
	private List<View> mListViews;
	private ArrayList<ImageView> imgsList;
	private final int img_ID = R.drawable.icon_circle;
	private final int img_ID_ov = R.drawable.icon_circle_ov;
	private int[] indicatePicIdArr = {R.drawable.indicate_01, R.drawable.indicate_02,
			R.drawable.indicate_03,R.drawable.indicate_04,
			R.drawable.indicate_05};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.takeout_item_detail_ll);
		
		btn_takeout_item_title_back = (Button) findViewById(R.id.btn_takeout_item_title_back);
		btn_takeout_item_title_back.setOnClickListener(this);
		takeout_item_shop_info_phone = (ImageView) findViewById(R.id.takeout_item_shop_info_phone);
		takeout_item_shop_info_phone.setOnClickListener(this);
		takeout_item_pic_wall_more_tv = (TextView) findViewById(R.id.takeout_item_pic_wall_more_tv);
		takeout_item_pic_wall_more_tv.setOnClickListener(this);
		
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		
		takeout_item_more_discount_list = (ListView) findViewById(R.id.takeout_item_more_discount_list);
		takeout_item_more_discount_list.setAdapter(new DiscountMoreAdapter(this));
		
		takeout_item_hot_menu_gridview = (GridView) findViewById(R.id.takeout_item_hot_menu_gridview);
		takeout_item_hot_menu_gridview.setAdapter(new GridViewHotMenuAdapter(this));
		
		imgsList = new ArrayList<ImageView>();
		mListViews = new ArrayList<View>();
		viewpager.removeAllViewsInLayout();// removeAllViews();//赋值之前先将Adapter中的
		
		View indicateView = null;
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout_title_imgs);
		ImageView img = null;
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		for(int i = 0; i < 5; i++) {
			img = new ImageView(this);// 准备5个小图标。
			img.setScaleType(ScaleType.FIT_XY);
			img.setImageResource(img_ID);
			imgsList.add(img);
			img.setPadding(6, 3, 6, 3);
			layout.addView(img, params);
			indicateView = View.inflate(this, R.layout.viewpager_item, null);
			indicateView.findViewById(R.id.indicate_pager_item).setBackgroundResource(indicatePicIdArr[i]);
			mListViews.add(indicateView);
		}
		
		viewpager.setAdapter(new IndicatePagerAdapter(mListViews));
		viewpager.setCurrentItem(0);
		imgsList.get(0).setImageResource(img_ID_ov);
		viewpager.setOnPageChangeListener(new PageListener());
	}
	
	/**
	 *  viewpager滑动
	 * @author hubery
	 *
	 */
	private class PageListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int index) {
			if (index > 2) {
				index = index % imgsList.size();
			}

			for (int i = 0; i < imgsList.size(); i++) {
				imgsList.get(index).setImageResource(img_ID_ov);
				if (index != i) {
					imgsList.get(i).setImageResource(img_ID);
				}
			}
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int position, float arg1, int arg2) {
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_takeout_item_title_back:
			finish();
			break;
		case R.id.takeout_item_shop_info_phone:
			PhoneCallUtil.call(this, "10086");	
			break;
		case R.id.takeout_item_pic_wall_more_tv:
			Toast.makeText(this, "查看更多功能开发中", Toast.LENGTH_SHORT).show();
			break;
//		case value:
//			break;
//		case value:
//			break;
//		case value:
//			break;
		default:
			break;
		}
	}
	
}
