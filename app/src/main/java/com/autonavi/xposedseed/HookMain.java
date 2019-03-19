package com.autonavi.xposedseed;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * Created by tony.zyl on 2019/3/19.
 */

public class HookMain implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Loaded app: " + lpparam.packageName);
        Log.d(Const.TAG, "Loaded app: " + lpparam.packageName );

        // Xposed模块自检测
        if (lpparam.packageName.equals(Const.PACAKGE_NAME)){
            XposedHelpers.findAndHookMethod(Const.PACAKGE_NAME+".MainActivity", lpparam.classLoader, "isModuleActive", XC_MethodReplacement
                .returnConstant(true));
        }
    }
}
