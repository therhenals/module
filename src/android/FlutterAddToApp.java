package com.todo1.plugins.FlutterAddToApp;

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
public class FlutterAddToApp extends CordovaPlugin {
    private static final String TAG = "FlutterAddToAppPlugin";

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