package system.oa.com.oaprototype.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;
import com.ycl.tabview.library.TabViewUtil;

import java.util.ArrayList;
import java.util.List;

import system.oa.com.oaprototype.R;

/**
 * Created by huangyueran on 2017/1/13.
 * 基础Fragment
 */
public class FragmentSample extends Fragment {
    TabView tabView;
    boolean isAdmin;

    public FragmentSample(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        tabView = (TabView) view.findViewById(R.id.tabView);
        tabView.setImageViewTextViewMargin(-10); // 设置图片和文字距离
        tabView.setTextViewSelectedColor(Color.parseColor("#57BBF5")); //设置字体颜色
        tabView.setImageViewHeight(TabViewUtil.dp2px(getContext(), 35));
        init();
        return view;
    }

    private void init() {
        if (isAdmin) {
            //start add data
            List<TabViewChild> tabViewChildList = new ArrayList<>();
            TabViewChild tabViewChild01 = new TabViewChild(R.drawable.f1un, R.drawable.f1, "首页", FragmentFactory.createFragment(0));
            TabViewChild tabViewChild02 = new TabViewChild(R.drawable.f2un, R.drawable.f2, "收发文件", FragmentFactory.createFragment(1));
            TabViewChild tabViewChild03 = new TabViewChild(R.drawable.f3un, R.drawable.f3, "管理", FragmentFactory.createFragment(2));
            TabViewChild tabViewChild04 = new TabViewChild(R.drawable.f4un, R.drawable.f4, "功能", FragmentFactory.createFragment(3));
            tabViewChildList.add(tabViewChild01);
            tabViewChildList.add(tabViewChild02);
            tabViewChildList.add(tabViewChild03);
            tabViewChildList.add(tabViewChild04);
            //end add data
            tabView.setTabViewDefaultPosition(2);
            tabView.setTabViewChild(tabViewChildList, getChildFragmentManager());
            tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
                @Override
                public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
//                Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            //start add data
            List<TabViewChild> tabViewChildList = new ArrayList<>();
            TabViewChild tabViewChild01 = new TabViewChild(R.drawable.f1un, R.drawable.f1, "首页", FragmentFactory.createFragment(0));
            TabViewChild tabViewChild02 = new TabViewChild(R.drawable.f2un, R.drawable.f2, "收发文件", FragmentFactory.createFragment(1));
            TabViewChild tabViewChild04 = new TabViewChild(R.drawable.f4un, R.drawable.f4, "功能", FragmentFactory.createFragment(3));
            tabViewChildList.add(tabViewChild01);
            tabViewChildList.add(tabViewChild02);
            tabViewChildList.add(tabViewChild04);
            //end add data
            tabView.setTabViewDefaultPosition(2);
            tabView.setTabViewChild(tabViewChildList, getChildFragmentManager());
            tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
                @Override
                public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
//                Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
