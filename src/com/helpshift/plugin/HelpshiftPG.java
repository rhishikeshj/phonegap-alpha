package com.helpshift.plugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.Plugin;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import com.helpshift.Helpshift;


public class HelpshiftPG extends CordovaPlugin {

  private static final String LCAT = "PhoneGap/HelpshiftPG";
  // Helpshift methods
  private static final String INSTALL="init";
  private static final String SHOW_SUPPORT="showSupport";
  private static final String SHOW_SUPPORT_ON_PUSH="showSupportOnPush";
  private static final String SHOW_INBOX="showInbox";
  private static final String REPORT_ISSUE="reportIssue";
  private static final String SHOW_FAQS="showFAQs";
  private static final String SHOW_FAQ="showFAQ";
  private static final String SHOW_FAQ_SECTION="showFAQSection";
  private static final String SET_USER_IDENTIFIER="setUserIdentifier";
  private static final String SET_USER_NAME="setUsername";
  private static final String SET_USER_EMAIL="setUseremail";
  private static final String LEAVE_BREAD_CRUMB="leaveBreadCrumb";
  private static final String CLEAR_BREAD_CRUMBS="clearBreadCrumbs";
  private static final String CLEAR_USER_DATA="clearUserData";
  private static final String REGISTER_DEVICE_TOKEN="registerDeviceToken";
  private static final String GET_NOTIFICATION_COUNT="getNotificationCount";
  private static final String IS_FOREGROUND="isForeground";

  private Helpshift helpshift;
  private CallbackContext notificationCallback;

  @Override
  public boolean execute (String function, JSONArray arguments,
                          CallbackContext callbackContext) {
    try {
      if (INSTALL.equals(function)) {
        helpshift = new Helpshift(cordova.getActivity());
        String apiKey = arguments.getString(0);
        String domainName = arguments.getString(1);
        String appID = arguments.getString(2);

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("sdkType", "phonegap");

        if (arguments.length() >= 4) {
          JSONObject object = arguments.getJSONObject(3);
          Iterator iter = object.keys();
          while(iter.hasNext()){
            String key = (String)iter.next();
            Boolean value = object.getBoolean(key);
            map.put(key,value);
          }
        }
        helpshift.install (cordova.getActivity(), apiKey, domainName, appID, map);
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;

      } else if (SHOW_SUPPORT.equals(function)) {
        if (arguments.length() >= 1) {
          HashMap<String,Boolean> map = new HashMap<String,Boolean>();
          JSONObject object = arguments.getJSONObject(0);
          Iterator iter = object.keys();
          while(iter.hasNext()){
            String key = (String)iter.next();
            Boolean value = object.getBoolean(key);
            map.put(key,value);
          }

          helpshift.showSupport(cordova.getActivity(), map);
        }else
          helpshift.showSupport(cordova.getActivity());
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SHOW_INBOX.equals(function)) {
        helpshift.showInbox(cordova.getActivity());
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SHOW_SUPPORT_ON_PUSH.equals(function)) {
        Intent pushIntent = new Intent();
        pushIntent.putExtra("issue_id", arguments.getString(0));
        helpshift.showSupportOnPush(pushIntent);
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (REPORT_ISSUE.equals(function)) {
        if (arguments.length() >= 1) {
          HashMap<String,Boolean> map = new HashMap<String,Boolean>();
          JSONObject object = arguments.getJSONObject(0);

          Iterator iter = object.keys();
          while(iter.hasNext()){
            String key = (String)iter.next();
            Boolean value = object.getBoolean(key);
            map.put(key,value);
          }

          helpshift.showReportIssue(cordova.getActivity(), map);
        }else
          helpshift.showReportIssue(cordova.getActivity());

        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SHOW_FAQ_SECTION.equals(function)) {

        helpshift.showSection(cordova.getActivity(), arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SHOW_FAQ.equals(function)) {

        helpshift.showQuestion(cordova.getActivity(), arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SHOW_INBOX.equals(function)) {

        helpshift.showInbox(cordova.getActivity());
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SHOW_FAQS.equals(function)) {
        if (arguments.length() >= 1) {
          HashMap<String,Boolean> map = new HashMap<String,Boolean>();
          JSONObject object = arguments.getJSONObject(0);
          Iterator iter = object.keys();
          while(iter.hasNext()){
            String key = (String)iter.next();
            Boolean value = object.getBoolean(key);
            map.put(key,value);
          }
          helpshift.showFaqs(cordova.getActivity(), map);
        }
        else
          helpshift.showFaqs(cordova.getActivity());
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SET_USER_NAME.equals(function)) {
        helpshift.setUsername(arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SET_USER_EMAIL.equals(function)) {
        helpshift.setEmail(arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (SET_USER_IDENTIFIER.equals(function)) {
        helpshift.setDeviceIdentifier(arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (REGISTER_DEVICE_TOKEN.equals(function)) {
        helpshift.setDeviceToken(arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (LEAVE_BREAD_CRUMB.equals(function)) {
        helpshift.leaveBreadCrumb(arguments.getString(0));
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (CLEAR_BREAD_CRUMBS.equals(function)) {
        helpshift.clearBreadCrumbs();
        callbackContext.sendPluginResult( new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (CLEAR_USER_DATA.equals(function)) {
        helpshift.clearUserData();
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, ""));
        return true;
      } else if (GET_NOTIFICATION_COUNT.equals(function)) {
        if (arguments.length() == 0) {
          Integer count = helpshift.getNotificationCount();
          callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, count));
          return true;
        } else {
          PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT, "");
          result.setKeepCallback(true);
          this.notificationCallback = callbackContext;

          helpshift.getNotificationCount(new Handler() {
              public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle countData = (Bundle) msg.obj;
                Integer count = countData.getInt("value");
                notificationCallback.success(count);
              }
            }, new Handler() {});
          callbackContext.sendPluginResult(result);
          return true;
        }
      } else if (IS_FOREGROUND.equals(function)) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK,
                                                          helpshift.isForeground()));
        return true;
      } else {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
        return false;
      }
    } catch (JSONException e) {
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
      return false;
    }
  }
}
