/*
    Copyright (c) TODO1 SERVICES, INC. (‘TODO1’) All rights reserved, 2000 – 2021. This work is protected by the United States of America copyright laws. All information contained herein is and remains the property of TODO1 [and its suppliers, if any] *. 
    Dissemination of this information or reproduction of this material is not permitted unless prior written consent is obtained from TODO1 SERVICES, INC.
*/

package com.todo1.plugins.MicroAppsFlutter;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import android.content.Context;
import io.flutter.embedding.android.FlutterActivity;

/**
 * This class echoes a string called from JavaScript.
 */
public class MicroAppsFlutter extends CordovaPlugin {
    private static final String TAG = "MicroAppsFlutterPlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();

        if (action.equals("openMicroApp")) {
            /* Obtener ruta a iniciar */
            String route = args.getString(0);
            try {
               /*  Iniciar micro app */
                cordova.getActivity().startActivity(FlutterActivity.withNewEngine().initialRoute(route).build(context));
            } catch (Exception e) {
                callbackContext.error(e.getMessage());
            }
            Log.d(TAG, "Open");
            callbackContext.success("Open");
            return true;
        }
        return false;
    }
}