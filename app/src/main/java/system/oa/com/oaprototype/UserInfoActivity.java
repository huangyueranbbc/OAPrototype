package system.oa.com.oaprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoActivity extends Activity {

    private Button btn02;
    private TextView mTvEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initView();
        initListener();
    }

    private void initListener() {
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv1 = (TextView) v;
                Intent intent = new Intent(UserInfoActivity.this, AlertActivity.class);
                intent.putExtra("var1", tv1.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btn02 = (Button) findViewById(R.id.btn02);
        mTvEdit = (TextView) findViewById(R.id.tv_edit);
    }
}
