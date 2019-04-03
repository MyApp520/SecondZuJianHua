package second.zujian.hua.dagger.module;

import com.example.chat.dagger.module.ChatModuleAllFragmentModule;
import com.example.chat.ui.ChatMainFragment;
import com.example.commonlib.dagger.scope.FragmentScope;
import com.example.find.dagger.module.FindModuleAllFragmentModule;
import com.example.find.ui.FindMainFragment;
import com.example.group.dagger.module.GroupModuleAllFragmentModule;
import com.example.group.ui.GroupMainFragment;
import com.example.mine.dagger.module.MineModuleAllFragmentModule;
import com.example.mine.ui.MineMainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by smile on 2019/3/23.
 */

@Module(includes = {
        ChatModuleAllFragmentModule.class,
        GroupModuleAllFragmentModule.class,
        FindModuleAllFragmentModule.class,
        MineModuleAllFragmentModule.class})
public abstract class AppFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract ChatMainFragment provideChatMainFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract GroupMainFragment provideGroupMainFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract FindMainFragment provideFindMainFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract MineMainFragment provideMineMainFragment();
}
