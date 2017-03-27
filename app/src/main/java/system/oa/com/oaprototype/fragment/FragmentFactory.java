package system.oa.com.oaprototype.fragment;

import java.util.HashMap;


/**
 * Created by huangyueran on 2017/1/13.
 * 生产Fragment的工厂
 */
public class FragmentFactory {
    private static final String TAG = "FragmentFactory";

    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int pos) {

        BaseFragment fragment = mFragmentMap.get(pos);
        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new FileSendAndGetFragment();
                    break;
                case 2:
                    fragment = new ManagerFragment();
                    break;
                case 3:
                    fragment = new FunctionFragment();
                    break;
                default:
                    break;
            }
        }

        mFragmentMap.put(pos, fragment); // 保存在集合中
        return fragment;
    }

}
