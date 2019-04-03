package com.example.find.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.arouter.ArouterActionManager;
import com.example.commonlib.arouter.FindModuleArouterPath;
import com.example.commonlib.base.BaseActivity;
import com.example.commonlib.bean.UserBean;
import com.example.commonlib.util.ShowToast;
import com.example.find.R;
import com.example.find.R2;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = FindModuleArouterPath.FIND_MAIN_ACTIVITY)
public class FindMainActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    @BindView(R2.id.btn_attack)
    Button btnAttack;
    @BindView(R2.id.btn_protect)
    Button btnProtect;
    @BindView(R2.id.tablayout)
    TabLayout tablayout;
    @BindView(R2.id.viewpager)
    ViewPager viewpager;

    @Inject
    Context context;
    @Inject
    UserBean userBean;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_main);
        ButterKnife.bind(this);

        fragmentList = new ArrayList<>();
        fragmentList.add(ArouterActionManager.getInstance().getFragmentInstance(FindModuleArouterPath.ALL_FIND_FRAGMENT));
        fragmentList.add(ArouterActionManager.getInstance().getFragmentInstance(FindModuleArouterPath.NEWEST_FIND_FRAGMENT));

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewpager.setAdapter(fragmentPagerAdapter);

        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setText("进攻");
        tablayout.getTabAt(1).setText("防守");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "FindMainActivity onResume: userBean = " + userBean);
    }

    @OnClick({R2.id.btn_attack, R2.id.btn_protect})
    public void onViewClicked(View view) {
        if (R.id.btn_attack == view.getId()) {
            ShowToast.showToast(context, "进攻第一");
            btnAttack.setTextColor(ContextCompat.getColor(context, R.color.white));
            btnAttack.setBackground(ContextCompat.getDrawable(context, R.drawable.blue_left_oval_shape));

            btnProtect.setTextColor(ContextCompat.getColor(context, R.color.black));
            btnProtect.setBackground(ContextCompat.getDrawable(context, R.drawable.white_right_oval_shape));
        } else if (R.id.btn_protect == view.getId()) {
            ShowToast.showToast(context, "防守第一");
            btnAttack.setTextColor(ContextCompat.getColor(context, R.color.black));
            btnAttack.setBackground(ContextCompat.getDrawable(context, R.drawable.white_left_oval_shape));

            btnProtect.setTextColor(ContextCompat.getColor(context, R.color.white));
            btnProtect.setBackground(ContextCompat.getDrawable(context, R.drawable.blue_right_oval_shape));
        }
    }
}
