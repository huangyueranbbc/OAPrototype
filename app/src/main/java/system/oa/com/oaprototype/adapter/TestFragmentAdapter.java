package system.oa.com.oaprototype.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;

import system.oa.com.oaprototype.R;
import system.oa.com.oaprototype.fragment.ReceiveFileFragment;
import system.oa.com.oaprototype.fragment.SendFileFragment;

public class TestFragmentAdapter extends FragmentPagerAdapter {
    protected static final String[] CONTENT = new String[]{"接收文件", "发送文件"};

    private int mCount = CONTENT.length;
    private TextView textView; // 标题

    public TestFragmentAdapter(FragmentManager fm, View view) {
        super(fm);
        textView = (TextView) view.findViewById(R.id.tv_title);
    }

    @Override
    public Fragment getItem(int position) {
        // 创建Fragment
        if (position == 0) {
            return ReceiveFileFragment.newInstance(CONTENT[position % CONTENT.length]);
        } else {
            return SendFileFragment.newInstance(CONTENT[position % CONTENT.length]);
        }

    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TestFragmentAdapter.CONTENT[position % CONTENT.length];
    }


    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }

}