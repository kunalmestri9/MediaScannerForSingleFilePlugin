package com.laurus.plugins.MediaScannerForSingleFilePlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * MediaScannerForSingleFilePlugin.java
 *
 * Inspirated by Peter Gao's MediaScanner Plugin
 *
 * @author Kunal Mestri <kunal@laurus-it.com>
 */
public class MediaScannerForSingleFilePlugin extends CordovaPlugin {
    public static final String ACTION = "scanSingleFile";
    private static final String TAG = "MediaScannerForSingleFilePlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (!action.equals(ACTION)) {
			return false;
		}
		
		try {
			JSONObject fullObject = args.getJSONObject(0);
			String fileName=fullObject.getString("fileName");
			this.scanSingleFile(fileName,callbackContext);
			callbackContext.success();
			return true;
		}catch(Exception e){
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}
    }
	
	protected boolean scanSingleFile(String filePath,CallbackContext callbackContext){
		Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		Uri contentUri = Uri.parse(filePath.toString());
		mediaScanIntent.setData(contentUri);
		cordova.getActivity().sendBroadcast(mediaScanIntent);
		return true;
	}
	
}
