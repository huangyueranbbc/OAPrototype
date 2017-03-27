package system.oa.com.oaprototype.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import system.oa.com.oaprototype.R;
import system.oa.com.oaprototype.utils.UIUtils;

public class ManagerFragment extends BaseFragment {

    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.fragment_manager_layout);
        return view;
    }
}
