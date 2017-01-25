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
package me.fobid.tddpractice.ui.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import me.fobid.tddpractice.R;

/**
 * author @Fobid
 */
public class SignInPresenter {

    private final View mView;

    public SignInPresenter(@NonNull View view) {
        mView = view;
    }

    public void onClickSignIn() {
        String id = mView.getId();
        if (id.isEmpty()) {
            mView.showIdError(R.string.id_error);
            return;
        }

        String password = mView.getPassword();
        if (password.isEmpty()) {
            mView.showPasswordError(R.string.password_error);
            return;
        }
    }

    public interface View {

        String getId();

        void showIdError(@StringRes int resourceId);

        String getPassword();

        void showPasswordError(@StringRes int resourceId);
    }
}
