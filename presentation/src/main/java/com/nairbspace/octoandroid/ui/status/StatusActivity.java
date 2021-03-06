package com.nairbspace.octoandroid.ui.status;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import com.nairbspace.octoandroid.R;
import com.nairbspace.octoandroid.app.SetupApplication;
import com.nairbspace.octoandroid.ui.connection.ConnectionFragment;
import com.nairbspace.octoandroid.ui.files.FilesFragment;
import com.nairbspace.octoandroid.ui.playback.PlaybackFragment;
import com.nairbspace.octoandroid.ui.state.StateFragment;
import com.nairbspace.octoandroid.ui.templates.BaseNavActivity;
import com.nairbspace.octoandroid.ui.templates.Presenter;

import javax.inject.Inject;

import butterknife.BindArray;
import butterknife.BindBool;
import butterknife.ButterKnife;

public class StatusActivity extends BaseNavActivity<StatusScreen>
        implements NavigationView.OnNavigationItemSelectedListener, StatusScreen,
        StateFragment.Listener, ConnectionFragment.Listener,
        FilesFragment.Listener, PlaybackFragment.Listener {

    @Inject StatusPresenter mPresenter;
    @BindArray(R.array.status_fragment_pager_adapter) String[] mPagerArray;
    @BindBool(R.bool.is_tablet_and_landscape) boolean mIsTabletAndLandscape;
    private int mFadeIn;
    private int mFadeOut;

    public static Intent newIntent(Context context) {
        return new Intent(context, StatusActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetupApplication.get(this).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        onCreateDrawer(ButterKnife.bind(this));
        inflateAdapter(new StatusFragmentPagerAdapter(mPagerArray, getSupportFragmentManager()));
        mFadeIn = mIsTabletAndLandscape ? 0 : android.R.anim.fade_in;
        mFadeOut = mIsTabletAndLandscape ? 0 : android.R.anim.fade_out;
    }

    @NonNull
    @Override
    protected Presenter setPresenter() {
        return mPresenter;
    }

    @NonNull
    @Override
    protected StatusScreen setScreen() {
        return this;
    }

    @Override
    public void sliceButtonClicked(String apiUrl) {
        getNavigator().navigateToSlicerActivity(this, apiUrl);
        overridePendingTransition(mFadeIn, mFadeOut); // TODO should control in navigator
    }
}
