package me.fobid.tddpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import me.fobid.tddpractice.R;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_sign_in)
    Button mBtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        RxView.clicks(mBtnSignIn)
                .compose(bindToLifecycle())
                .subscribe(
                        aVoid -> startActivity(new Intent(this, SignInActivity.class)));
    }
}
