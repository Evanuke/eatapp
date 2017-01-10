package com.majstry.eatapp;

import com.majstry.eatapp.activities.MainActivity;
import com.majstry.eatapp.fragments.MainFragment;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.fragments.OrderFragment;
import com.majstry.eatapp.presenters.MainFragmentPresenter;
import com.majstry.eatapp.presenters.MenuFragmentPresenter;
import com.majstry.eatapp.presenters.OrderDetailsFragmentPresenter;
import com.majstry.eatapp.presenters.OrderFragmentPresenter;
import com.majstry.eatapp.presenters.RatingsFragmentPresenter;
import com.majstry.eatapp.presenters.SpecialOffersFragmentPresenter;
import com.majstry.eatapp.presenters.YourOrdersFragmentPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(MainFragmentPresenter mainFragmentPresenter);
    void inject(MyApplication myApplication);
    void inject(MenuFragmentPresenter menuFragmentPresenter);
    void inject(OrderFragmentPresenter orderFragmentPresenter);
    void inject(OrderDetailsFragmentPresenter orderDetailsFragmentPresenter);
    void inject(YourOrdersFragmentPresenter yourOrdersFragmentPresenter);
    void inject(SpecialOffersFragmentPresenter specialOffersFragmentPresenter);
    void inject(RatingsFragmentPresenter ratingsFragmentPresenter);

}
