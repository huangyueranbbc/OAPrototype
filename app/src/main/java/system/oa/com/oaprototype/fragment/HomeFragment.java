package system.oa.com.oaprototype.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import system.oa.com.oaprototype.AlertActivity;
import system.oa.com.oaprototype.R;
import system.oa.com.oaprototype.utils.UIUtils;

public class HomeFragment extends BaseFragment {

    private View view;
    private TextView mLoadMore1;
    private TextView mLoadMore2;
    private TextView mLoadMore3;
    private TextView mLoadMore4;
    private View.OnClickListener clickListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.fragment_home_layout);
        //创建监听
        clickListener = new Button.OnClickListener() {//创建监听
            public void onClick(View v) {
                TextView tv1 = (TextView) v;
                Intent intent = new Intent(getActivity(), AlertActivity.class);
                intent.putExtra("var1",tv1.getText().toString());
                startActivity(intent);
            }

        };
        initView();
        initListener();
        return view;
    }

    private void initListener() {
        mLoadMore1.setOnClickListener(clickListener);
        mLoadMore2.setOnClickListener(clickListener);
        mLoadMore3.setOnClickListener(clickListener);
        mLoadMore4.setOnClickListener(clickListener);
    }

    private void initView() {
        mLoadMore1 = (TextView) view.findViewById(R.id.tv_loadmore1);
        mLoadMore2 = (TextView) view.findViewById(R.id.tv_loadmore2);
        mLoadMore3 = (TextView) view.findViewById(R.id.tv_loadmore3);
        mLoadMore4 = (TextView) view.findViewById(R.id.tv_loadmore4);
    }

}
