package cn.hubery.commservice.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.hubery.commservice.R;
import cn.hubery.commservice.TakeoutListActivity;
import cn.hubery.commservice.adapter.GridViewFlashAdapter;
import cn.hubery.commservice.adapter.GridViewServiceAdapter;
import cn.hubery.commservice.adapter.IndicatePagerAdapter;
import cn.hubery.commservice.util.PhoneCallUtil;

@SuppressLint({ "NewApi", "ValidFragment" })
public class FragmentHome extends Fragment {

	public static final String TAG = "FragmentHome";
	private Context context;
	
	private ViewPager homePager;
	private List<View> mListViews;
	private ArrayList<ImageView> imgsList;
	private final int img_ID = R.drawable.icon_circle;
	private final int img_ID_ov = R.drawable.icon_circle_ov;
	
	private GridView gridview;
	private GridView gv_comm_indicate;
	
	public FragmentHome() {}
	
	public FragmentHome(Context context) {
		this.context = context;
	}
	
	private int[] indicatePicIdArr = {R.drawable.indicate_01, R.drawable.indicate_02,
					R.drawable.indicate_03,R.drawable.indicate_04,
					R.drawable.indicate_05};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");  
		
		View v = inflater.inflate(R.layout.fragment_home_layout,container, false);
		
		v.findViewById(R.id.iv_comm_phone).setOnClickListener(new CallClickListener());
		
		homePager = (ViewPager) v.findViewById(R.id.viewpager);// viewpager
		
		gridview = (GridView) v.findViewById(R.id.gv_flash_service);
		gv_comm_indicate = (GridView) v.findViewById(R.id.gv_comm_indicate);
		gridview.setAdapter(new GridViewFlashAdapter(context));
		gv_comm_indicate.setAdapter(new GridViewServiceAdapter(context, 4));
		
		gridview.setOnItemClickListener(new GridViewClickListener());
		gv_comm_indicate.setOnItemClickListener(new CommServiceClickListener());
		
		imgsList = new ArrayList<ImageView>();
		mListViews = new ArrayList<View>();
		homePager.removeAllViewsInLayout();// removeAllViews();//赋值之前先将Adapter中的
		
		View indicateView = null;
		
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout_title_imgs);
		ImageView img = null;
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		for(int i = 0; i < 5; i++) {
			img = new ImageView(context);// 准备5个小图标。
			img.setScaleType(ScaleType.FIT_XY);
			img.setImageResource(img_ID);
			imgsList.add(img);
			img.setPadding(6, 3, 6, 3);
			layout.addView(img, params);
			indicateView = View.inflate(context, R.layout.viewpager_item, null);
			indicateView.findViewById(R.id.indicate_pager_item).setBackgroundResource(indicatePicIdArr[i]);
			mListViews.add(indicateView);
		}
		
		homePager.setAdapter(new IndicatePagerAdapter(mListViews));
		homePager.setCurrentItem(0);
		imgsList.get(0).setImageResource(img_ID_ov);
		homePager.setOnPageChangeListener(new PageListener());
		return v;
	}
	
	//------------------声明周期方法-----------------------------  
	@Override  
    public void onAttach(Activity activity) {  
        super.onAttach(activity);  
        Log.d(TAG, "onAttach");  
    }  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        Log.d(TAG, "onCreate");  
    }  
  
    @Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        Log.d(TAG, "onActivityCreated");  
    }  
  
    @Override  
    public void onStart() {  
        super.onStart();  
        Log.d(TAG, "onStart");  
    }  
  
    @Override  
    public void onResume() {  
        super.onResume();  
        Log.d(TAG, "onResume");  
    }  
  
    @Override  
    public void onPause() {  
        super.onPause();  
        Log.d(TAG, "onPause");  
    }  
  
    @Override  
    public void onStop() {  
        super.onStop();  
        Log.d(TAG, "onStop");  
    }  
  
    @Override  
    public void onDestroyView() {  
        super.onDestroyView();  
        Log.d(TAG, "onDestroyView");  
    }  
  
    @Override  
    public void onDestroy() {  
        super.onDestroy();  
        Log.d(TAG, "onDestroy");  
    }  
  
    @Override  
    public void onDetach() {  
        super.onDetach();  
        Log.d(TAG, "onDetach");  
    }  
	//------------------声明周期方法-----------------------------    
	
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
	
	/**
	 *  打电话监听
	 * @author hubery
	 *
	 */
	private class CallClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			//用intent启动拨打电话  
			PhoneCallUtil.call(context, "400 616 0066");
		}
	}
	
	/**
	 *  闪电送      点击监听
	 * @author hubery
	 *
	 */
	private class GridViewClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Toast.makeText(context, "click item id = "+ position, Toast.LENGTH_SHORT).show();
			//TODO 跳转。。
			startActivity(new Intent(context, TakeoutListActivity.class));
		}
	}
	
	/**
	 *  社区生活指南   点击监听。
	 * @author hubery
	 *
	 */
	private class CommServiceClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Toast.makeText(context, "社区生活指南,开发中。。。", Toast.LENGTH_SHORT).show();
		}
	}
	
}
