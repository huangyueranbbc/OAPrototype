package system.oa.com.oaprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private TextView etUsername;
    private TextView etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) { // 管理员
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("isAdmin", true);
                    startActivity(intent);
                    finish();
                } else if (etUsername.getText().toString().equals("user") && etPassword.getText().toString().equals("user")) { // 普通用户
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("isAdmin", false);
                    startActivity(intent);
                    finish();
                } else { // 登录失败
                    Toast.makeText(getApplicationContext(), "用户名或密码错误 admin为管理员账号和密码 user为用户", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initView() {
        button = (Button) findViewById(R.id.btn_login);
        etUsername = (TextView) findViewById(R.id.et_username);
        etPassword = (TextView) findViewById(R.id.et_password);
    }
}
