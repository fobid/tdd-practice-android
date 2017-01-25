/*
 * Copyright Fobid. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.fobid.tddpractice.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import me.fobid.tddpractice.R;
import me.fobid.tddpractice.ui.presenter.SignInPresenter;

/**
 * author @Fobid
 */
public class SignInActivity extends BaseActivity implements SignInPresenter.View {

    private SignInPresenter mPresenter;

    @BindView(R.id.ti_id)
    TextInputLayout mTiId;
    @BindView(R.id.id)
    TextInputEditText mEtId;
    @BindView(R.id.ti_password)
    TextInputLayout mTiPassword;
    @BindView(R.id.password)
    TextInputEditText mEtPassword;
    @BindView(R.id.btn_sign_in)
    Button mBtnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a_sign_in);
        setDisplayHomeAsUpEnabled(true);

        mPresenter = new SignInPresenter(this);

        RxTextView.textChanges(mEtId)
                .compose(bindToLifecycle())
                .subscribe(
                        charSequence -> {
                            int length = charSequence.length();
                            if (length > 0 && length <= 10) {
                                mTiId.setError(null);
                            }
                        },
                        Throwable::printStackTrace);

        RxTextView.textChanges(mEtPassword)
                .compose(bindToLifecycle())
                .subscribe(
                        charSequence -> {
                            int length = charSequence.length();
                            if (length > 0 && length <= 10) {
                                mTiPassword.setError(null);
                            }
                        },
                        Throwable::printStackTrace);

        RxView.clicks(mBtnSignIn)
                .compose(bindToLifecycle())
                .subscribe(
                        aVoid -> mPresenter.onClickSignIn(),
                        Throwable::printStackTrace);
    }

    @Override
    public String getId() {
        return mEtId.getText().toString().trim();
    }

    @Override
    public void showIdError(@StringRes int resourceId) {
        mTiId.setError(getString(resourceId));
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void showPasswordError(@StringRes int resourceId) {
        mTiPassword.setError(getString(resourceId));
    }
}
