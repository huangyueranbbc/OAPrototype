package system.oa.com.oaprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import system.oa.com.oaprototype.fragment.FragmentSample;

public class MainActivity extends AppCompatActivity {
    FragmentSample fragmentSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_item_file_send);
        setContentView(R.layout.use_in_fragment);
        boolean isAdmin = getIntent().getBooleanExtra("isAdmin", false);
        fragmentSample = new FragmentSample(isAdmin);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragmentSample).show(fragmentSample).commit();
    }

}
