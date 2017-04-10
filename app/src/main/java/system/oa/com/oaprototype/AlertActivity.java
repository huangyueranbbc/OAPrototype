package system.oa.com.oaprototype;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AlertActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        String alert = getIntent().getStringExtra("var1");
        TextView mTvAlert = (TextView) findViewById(R.id.tv_alert);
        mTvAlert.setText(alert);
    }
}
