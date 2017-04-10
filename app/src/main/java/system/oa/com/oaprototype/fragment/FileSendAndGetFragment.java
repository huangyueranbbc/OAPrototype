package system.oa.com.oaprototype.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import system.oa.com.oaprototype.R;
import system.oa.com.oaprototype.adapter.TestFragmentAdapter;
import system.oa.com.oaprototype.utils.UIUtils;

public class FileSendAndGetFragment extends BaseFragment {
    private static final String TAG = "FileSendAndGetFragment";
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.simple_circles);
        mAdapter = new TestFragmentAdapter(getChildFragmentManager(), view);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        // 设置滑动监听事件
        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG, "onPageScrolled: " + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: " + position);
                if (position == 0) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    textView.setText("接收文件");
                } else {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    textView.setText("发送文件");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
}
