package id.arieridwan.mombaking;

import android.app.Application;
import android.content.Context;

import id.arieridwan.mombaking.di.AppComponent;
import id.arieridwan.mombaking.di.AppModule;
import id.arieridwan.mombaking.di.DaggerAppComponent;
import id.arieridwan.mombaking.di.NetModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by arieridwan on 27/08/2017.
 */

public class MomBakingApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInject();
        initFont();
    }

    private void initInject() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

}