package cn.hubery.commservice;

import cn.hubery.commservice.fragment.FragmentConvenient;
import cn.hubery.commservice.fragment.FragmentHome;
import cn.hubery.commservice.fragment.FragmentNear;
import cn.hubery.commservice.fragment.FragmentUserCenter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 主界面
 * @author Hubery
 * @edit 2015年3月26日09:24:02
 */
@SuppressLint("NewApi")
public class HomeActivity extends Activity implements OnClickListener {

	/** 
     * 用于对Fragment进行管理 
     */  
    private FragmentManager fragmentManager;
    
    private Fragment homeFragment;
    private Fragment nearFragment;
    private Fragment convenientFragment;
    private Fragment userCenterFragment;
    
    
    /**
	 * 消息界面布局
	 */
	private View messageLayout;

	/**
	 * 联系人界面布局
	 */
	private View contactsLayout;

	/**
	 * 动态界面布局
	 */
	private View newsLayout;

	/**
	 * 设置界面布局
	 */
	private View settingLayout;

	/**
	 * 在Tab布局上显示消息图标的控件
	 */
	private ImageView messageImage;

	/**
	 * 在Tab布局上显示联系人图标的控件
	 */
	private ImageView contactsImage;

	/**
	 * 在Tab布局上显示动态图标的控件
	 */
	private ImageView newsImage;

	/**
	 * 在Tab布局上显示设置图标的控件
	 */
	private ImageView settingImage;

	/**
	 * 在Tab布局上显示消息标题的控件
	 */
	private TextView messageText;

	/**
	 * 在Tab布局上显示联系人标题的控件
	 */
	private TextView contactsText;

	/**
	 * 在Tab布局上显示动态标题的控件
	 */
	private TextView newsText;

	/**
	 * 在Tab布局上显示设置标题的控件
	 */
	private TextView settingText;
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.home_layout); 
		
		initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
 		setTabSelection(0);
	}
	
	
	/**
	 * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
	 */
	private void initViews() {
		messageLayout = findViewById(R.id.message_layout);
		contactsLayout = findViewById(R.id.contacts_layout);
		newsLayout = findViewById(R.id.news_layout);
		settingLayout = findViewById(R.id.setting_layout);
		messageImage = (ImageView) findViewById(R.id.message_image);
		contactsImage = (ImageView) findViewById(R.id.contacts_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		settingImage = (ImageView) findViewById(R.id.setting_image);
		messageText = (TextView) findViewById(R.id.message_text);
		contactsText = (TextView) findViewById(R.id.contacts_text);
		newsText = (TextView) findViewById(R.id.news_text);
		settingText = (TextView) findViewById(R.id.setting_text);
		messageLayout.setOnClickListener(this);
		contactsLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.message_layout:
			// 当点击了消息tab时，选中第1个tab
			setTabSelection(0);
			break;
		case R.id.contacts_layout:
			// 当点击了联系人tab时，选中第2个tab
			setTabSelection(1);
			break;
		case R.id.news_layout:
			// 当点击了动态tab时，选中第3个tab
			setTabSelection(2);
			break;
		case R.id.setting_layout:
			// 当点击了设置tab时，选中第4个tab
			setTabSelection(3);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
	 */
	@SuppressLint("NewApi")
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了消息tab时，改变控件的图片和文字颜色
			messageImage.setImageResource(R.drawable.tab_home_selected);
			messageText.setTextColor(Color.WHITE);
			
			if (homeFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				homeFragment = new FragmentHome(this);
				transaction.add(R.id.content, homeFragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(homeFragment);
			}
			break;
		case 1:
			// 当点击了联系人tab时，改变控件的图片和文字颜色
			contactsImage.setImageResource(R.drawable.tab_near_selected);
			contactsText.setTextColor(Color.WHITE);
			if (nearFragment == null) {
				// 如果ContactsFragment为空，则创建一个并添加到界面上
				nearFragment = new FragmentNear();
				transaction.add(R.id.content, nearFragment);
			} else {
				// 如果ContactsFragment不为空，则直接将它显示出来
				transaction.show(nearFragment);
			}
			break;
		case 2:
			// 当点击了动态tab时，改变控件的图片和文字颜色
			newsImage.setImageResource(R.drawable.tab_util_selected);
			newsText.setTextColor(Color.WHITE);
			if (convenientFragment == null) {
				// 如果NewsFragment为空，则创建一个并添加到界面上
				convenientFragment = new FragmentConvenient();
				transaction.add(R.id.content, convenientFragment);
			} else {
				// 如果NewsFragment不为空，则直接将它显示出来
				transaction.show(convenientFragment);
			}
			break;
		case 3:
		default:
			// 当点击了设置tab时，改变控件的图片和文字颜色
			settingImage.setImageResource(R.drawable.tab_user_center_selected);
			settingText.setTextColor(Color.WHITE);
			if (userCenterFragment == null) {
				// 如果SettingFragment为空，则创建一个并添加到界面上
				userCenterFragment = new FragmentUserCenter();
				transaction.add(R.id.content, userCenterFragment);
			} else {
				// 如果SettingFragment不为空，则直接将它显示出来
				transaction.show(userCenterFragment);
			}
			break;
		}
		transaction.commit();
	}
	
	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.tab_home_unselected);
		messageText.setTextColor(Color.parseColor("#82858b"));
		contactsImage.setImageResource(R.drawable.tab_near_unselected);
		contactsText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.tab_util_unselected);
		newsText.setTextColor(Color.parseColor("#82858b"));
		settingImage.setImageResource(R.drawable.tab_user_center_unselected);
		settingText.setTextColor(Color.parseColor("#82858b"));
	}
	
	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (homeFragment != null) {
			transaction.hide(homeFragment);
		}
		if (nearFragment != null) {
			transaction.hide(nearFragment);
		}
		if (convenientFragment != null) {
			transaction.hide(convenientFragment);
		}
		if (userCenterFragment != null) {
			transaction.hide(userCenterFragment);
		}
	}
	
	
}
