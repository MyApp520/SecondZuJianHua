package com.example.find.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.arouter.ArouterActionManager;
import com.example.commonlib.arouter.FindModuleArouterPath;
import com.example.commonlib.base.BaseFragment;
import com.example.commonlib.bean.UserBean;
import com.example.find.R;
import com.example.find.R2;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = FindModuleArouterPath.ALL_FIND_FRAGMENT)
public class AllFindFragment extends BaseFragment {

    private final String TAG = getClass().getSimpleName();

    @BindView(R2.id.tv_enter_detail)
    TextView tvEnterDetail;
    Unbinder unbinder;

    @Inject
    UserBean userBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "AllFindFragment onResume: userBean = " + userBean);
    }

    @OnClick(R2.id.tv_enter_detail)
    public void onViewClicked(View view) {
        int clickViewId = view.getId();
        if (R.id.tv_enter_detail == clickViewId) {
            ArouterActionManager.getInstance().startActivity(FindModuleArouterPath.FIND_DETAIL_ACTIVITY);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
