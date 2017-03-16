package com.example.dab.tinkerdemo;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;

/**
 * Created by dab on 2017/3/16.
 * optional, you can just use DefaultTinkerResultService
 * we can restart process when we are at background or screen off
 */

public class SuccessService extends DefaultTinkerResultService {
    private static final String TAG = "SuccessService";

    public SuccessService() {
        super();
    }

    @Override
    public void onPatchResult(final PatchResult result) {
        if (result == null) {
            Log.e(TAG, "run: PatchResult");
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (result.isSuccess) {
                        Log.e(TAG, "run: 成功");
                    } else {
                        Log.e(TAG, "run: 失败");
                    }
                }
            });
        }
    }

}
