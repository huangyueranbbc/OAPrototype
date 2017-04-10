package system.oa.com.oaprototype.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import system.oa.com.oaprototype.AlertActivity;
import system.oa.com.oaprototype.R;
import system.oa.com.oaprototype.utils.UIUtils;
import system.oa.com.oaprototype.view.MyListView;

/**
 * 发送文件
 */
public final class SendFileFragment extends Fragment {
    private static final String TAG = "SendFileFragment";

    private static final String KEY_CONTENT = "TestFragment:Content";
    private List data;

    public static SendFileFragment newInstance(String content) {
        SendFileFragment fragment = new SendFileFragment();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            builder.append(content).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        fragment.mContent = builder.toString();

        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    /**
     * 创建页面
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView listView = new MyListView(UIUtils.getContext());
        listView.setDivider(null);
        listView.setDividerHeight(1);
        // TODO 静态数据
        data = new ArrayList();
        data.add(1);
        data.add(2);

        listView.setAdapter(new MyAdapter(getContext()));
        return listView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }

    // 新建一个类继承BaseAdapter，实现视图与数据的绑定
    private class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater; //得到一个LayoutInfalter对象用来导入布局

        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size(); //返回数组的长度
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            Log.v("BaseAdapterTest", "getView " + position + " " + convertView);

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item_file_send, null);
                holder = new ViewHolder();
                /*得到各个控件的对象*/
                holder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                holder.fileName = (TextView) convertView.findViewById(R.id.file_name);
                holder.receiveUser = (TextView) convertView.findViewById(R.id.receiveUser);
                holder.createTime = (TextView) convertView.findViewById(R.id.createTime);
                holder.receiveStatus = (TextView) convertView.findViewById(R.id.receiveStatus);
                holder.pendStatus = (TextView) convertView.findViewById(R.id.pendStatus);
                convertView.findViewById(R.id.tv_loadmore).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView tv1 = (TextView) v;
                        Intent intent = new Intent(getActivity(), AlertActivity.class);
                        intent.putExtra("var1",tv1.getText().toString());
                        startActivity(intent);
                    }
                });


                convertView.setTag(holder); //绑定ViewHolder对象
            } else {
                holder = (ViewHolder) convertView.getTag(); //取出ViewHolder对象
            }

            /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
            // TODO 静态假数据
            if (position == 0) {
                holder.ivIcon.setImageResource(R.drawable.doc);
                holder.fileName.setText("组装.doc");
                holder.receiveUser.setText("接收者:李四");
                holder.createTime.setText("创建时间:1996-7-13 09:03:14");
                holder.receiveStatus.setText("接收状态:已接收");
                holder.pendStatus.setText("审核状态:待审核");
            } else {
                holder.ivIcon.setImageResource(R.drawable.pdf);
                holder.fileName.setText("算法大全.pdf");
                holder.receiveUser.setText("接收者:王五");
                holder.createTime.setText("创建时间:2017-3-25 13:03:00");
                holder.receiveStatus.setText("接收状态:未接收");
                holder.pendStatus.setText("审核状态:已审核");
            }
//            holder.title.setText(getData().get(position).get("ItemTitle").toString());
//            holder.text.setText(getData().get(position).get("ItemText").toString());
            /*为Button添加点击事件*/
//            holder.bt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.v("BaseAdapterTest", "你点击了按钮" + position);
//                }
//            });

            return convertView;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

    /*存放控件 的ViewHolder*/
    public final class ViewHolder {
        public ImageView ivIcon;
        public TextView fileName;

        public TextView receiveUser;
        public TextView createTime;
        public TextView receiveStatus;
        public TextView pendStatus;
    }
}
