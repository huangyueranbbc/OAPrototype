package system.oa.com.oaprototype.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;

import java.util.Random;

import system.oa.com.oaprototype.adapter.TestFragmentAdapter;


/**
 * Created by huangyueran on 2017/1/13.
 */
public abstract class BaseFragment extends Fragment {
    private static final Random RANDOM = new Random();

    TestFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;

}
