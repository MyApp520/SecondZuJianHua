package com.example.find.dagger.module;

import com.example.commonlib.dagger.scope.FragmentScope;
import com.example.find.ui.fragment.AllFindFragment;
import com.example.find.ui.fragment.NewestFindFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by smile on 2019/3/23.
 */

@Module
public abstract class FindModuleAllFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract AllFindFragment provideAllFindFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract NewestFindFragment provideNewestFindFragment();
}
