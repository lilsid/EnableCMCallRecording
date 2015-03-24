package com.pyler.enablecmcallrec;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import android.content.Context;
import android.media.MediaRecorder;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class EnableCallRecording implements IXposedHookLoadPackage,
		IXposedHookInitPackageResources {
	public static final String DIALER = "com.android.dialer";
	public static final String CALL_RECORDING_SERVICE = "com.android.services.callrecorder.CallRecorderService";

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam)
			throws Throwable {
		if (!DIALER.equals(resparam.packageName)) {
			return;
		}
		resparam.res.setReplacement(DIALER, "integer", "call_recording_audio_source",
                		4);
				
			}

}
