package com.example.dab.tinkerdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by dab on 2017/3/16.
 */
@DefaultLifeCycle(
        application = "com.example.dab.tinkerdemo.Application",
        flags = ShareConstants.TINKER_ENABLE_ALL)
public class AppLike extends DefaultApplicationLike {
    private static final String TAG = "AppLike";

    public AppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        try {
            TinkerInstaller.install(this);
            TinkerInstaller.onReceiveUpgradePatch(getApplication(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + e.getMessage());
        }
    }
}
