package com.majstry.eatapp;

import com.majstry.eatapp.activities.MainActivity;
import com.majstry.eatapp.fragments.MainFragment;
import com.majstry.eatapp.fragments.MenuFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
    void inject(MyApplication myApplication);
    void inject(MenuFragment menuFragment);

}
