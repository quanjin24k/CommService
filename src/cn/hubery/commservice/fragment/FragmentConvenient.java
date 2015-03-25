package cn.hubery.commservice.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.hubery.commservice.R;

@SuppressLint("NewApi")
public class FragmentConvenient extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contactsLayout = inflater.inflate(R.layout.fragment_convenient_layout,
				container, false);
		return contactsLayout;
	}
	
}
