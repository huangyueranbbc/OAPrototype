package system.oa.com.oaprototype.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import system.oa.com.oaprototype.R;
import system.oa.com.oaprototype.UserInfoActivity;
import system.oa.com.oaprototype.utils.UIUtils;

/**
 * 功能模块
 */
public class FunctionFragment extends BaseFragment {
    private static final String TAG = "FunctionFragment";

    private View view;
    private Button btn01;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.fragment_function_layout);

        btn01 = (Button) view.findViewById(R.id.button2);
        // TODO 跳转到个人信息页面
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
