package cn.hubery.commservice.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class IndicateViewPager extends ViewPager {

	public IndicateViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	private int childId;
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (childId > 0) {
			ViewPager pager = (ViewPager) findViewById(childId);
			if (pager != null) {
				pager.requestDisallowInterceptTouchEvent(false);
			}
		}
		return super.onInterceptTouchEvent(event);
	}

	public void setChildId(int id) {
		this.childId = id;
	}
}
