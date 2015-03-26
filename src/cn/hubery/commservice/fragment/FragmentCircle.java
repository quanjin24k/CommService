package cn.hubery.commservice.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.View;

@SuppressLint("NewApi")
public class FragmentCircle extends Fragment {

	private View mCircleView;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentCircle newInstance() {
    	FragmentCircle fragment = new FragmentCircle();
        return fragment;
    }
	
}
