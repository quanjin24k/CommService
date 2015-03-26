package cn.hubery.commservice.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.hubery.commservice.R;

/**
 * 附近  fragment
 * @author Hubery
 * @edit 2015年3月26日09:26:16
 */
@SuppressLint("NewApi")
public class FragmentNear extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contactsLayout = inflater.inflate(R.layout.fragment_near_ll,
				container, false);
		return contactsLayout;
	}
	
}
