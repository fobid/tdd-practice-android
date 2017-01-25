package me.fobid.tddpractice.ui.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import me.fobid.tddpractice.R;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * author @Fobid
 */
@RunWith(MockitoJUnitRunner.class)
public class SignInPresenterTest {

    @Mock
    private SignInPresenter.View mView;
    private SignInPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new SignInPresenter(mView);
    }

    @Test
    public void shouldShowErrorMessageWhenIdIsEmpty() throws Exception {
        when(mView.getId()).thenReturn("");

        mPresenter.onClickSignIn();

        verify(mView).showIdError(R.string.id_error);
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(mView.getId()).thenReturn("fobid");
        when(mView.getPassword()).thenReturn("");

        mPresenter.onClickSignIn();

        verify(mView).showPasswordError(R.string.password_error);
    }
}