package client.com.componentbasedproject.app;

import android.app.Application;

import client.com.baselibs.app.BaseApp;
import client.com.baselibs.utils.AppConfig;
/**
 * MainApplication
 * @author zxh17
 * @version 1.0
 * */
public class MyApp extends BaseApp{
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
    }
    @Override
    public void initModuleApp(Application application) {
        for (String moduleApp: AppConfig.moduleApps){
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initModuleData(Application application) {
       for(String moduleApp:AppConfig.moduleApps){
           try {
               Class clzz = Class.forName(moduleApp);
               BaseApp bzseApp = (BaseApp) clzz.newInstance();
               bzseApp.initModuleData(this);
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InstantiationException e) {
               e.printStackTrace();
           }
       }
    }
}
