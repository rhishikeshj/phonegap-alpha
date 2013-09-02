/*
 *  helpshiftpg.js
 *  PhoneGap native plugin for HelpshiftSDK version 2.7.0-v.1
 *
 *  Copyright (c) 2013 Helpshift,Inc., All rights reserved.
 */

/**
    @namespace HelpshiftPG

    @description
    This document describes the API's exposed by the Helpshift PhoneGap Plugin which the developers can use to integrate Helpshift support
    into their iOS PhoneGap applications. If you want documentation regarding how to use the various features provided by the Helpshift SDK,
    please visit <a href="http://www.helpshift.com/docs/howto/ios/v2.x/">helpshift how-to page</a>

    @class
*/

var HelpshiftPG = {

    /**
    * Initialize Helpshift support. When initializing Helpshift you must pass these three params.
      You initialize Helpshift by adding HelpshiftPG.init method in onDeviceReady method.
    *
    * @param {string} appId This is the unique ID assigned to your app
    * @param {string} domainName This is your domain name without any http:// or forward slashes
    * @param {string} apiKey This is your developer API Key
    * @param {object} [option] To initialize the helpshift sdk with additional config options
    *
    * @example HelpshiftPG.init("&lt;APP_ID&gt;", "&lt;DOMAIN_NAME&gt;", "&lt;API_KEY&gt;", {disableInAppNotif : false});
    */
    init:function(appId, domainName, apiKey, config) {
      if (config && typeof config === "object")
        cordova.exec (null, null, "HelpshiftPG", "init", [apiKey, domainName, appId, config]);
      else
        cordova.exec (null, null, "HelpshiftPG", "init", [apiKey, domainName, appId]);
    },

    /**
    * Show the Helpshift support screen
    *
    * @param {object} [options] To show helpshift support screen with additional configuration options
    *
    * @example HelpshiftPG.showSupport();
    *  HelpshiftPG.showSupport({'showConvOnReportIssue':'YES'});
    */
    showSupport:function(options) {
        if (options && typeof options === "object") {
            if ('showConvOnReportIssue' in options) {
                cordova.exec(null, null, "HelpshiftPG", "showSupport", [options]);
            }
        } else {
            cordova.exec(null, null, "HelpshiftPG", "showSupport", []);
        }
    },

    /**
    * Show the helpshift screen to report an issue
    *
    * @param {object} [options] To show helpshift report an issue screen with additional configuration options
    *
    * @example HelpshiftPG.reportIssue();
    *  HelpshiftPG.reportIssue({'showConvOnReportIssue':'NO'});
    */
    reportIssue:function(options) {
        if (options && typeof options === "object") {
            if ('showConvOnReportIssue' in options) {
                cordova.exec(null, null, "HelpshiftPG", "reportIssue", [options]);
            }
        } else {
            cordova.exec(null, null, "HelpshiftPG", "reportIssue", []);
        }
    },

    /**
    * Show the helpshift issues inbox screen
    *
    * @example HelpshiftPG.showInbox();
    */
    showInbox:function() {
        cordova.exec(null, null, "HelpshiftPG", "showInbox", []);
    },

    /**
    * Show the support screen with only the faqs
    *
    * @param {object} [options] To show the Helpshift screen with only the faq sections with search and additional configuration options
    *
    * @example HelpshiftPG.showFAQs();
    *  HelpshiftPG.showFAQs({'showConvOnReportIssue':'NO','showReportIssue':'YES'});
    */
    showFAQs:function(options) {
        if (options && typeof options === "object") {
            if (('showConvOnReportIssue' in options) || ('showReportIssue' in options)) {
                cordova.exec(null, null, "HelpshiftPG", "showFAQs", [options]);
            }
        } else {
            cordova.exec(null, null, "HelpshiftPG", "showFAQs", []);
        }
    },

    /**
    * Show the helpshift screen with faqs from a particular section.
      To show the Helpshift screen for showing a particular faq section you need to pass the publish-id of the faq section.
    *
    * @param {string} faqSectionPublishId The publish id associated with the faq section which is shown in the FAQ page on the admin side
        (__yourcompanyname__.helpshift.com/admin/faq/).
    *
    * @example HelpshiftPG.showFAQSection("&lt;PUBLISH_ID&gt;");
    */
    showFAQSection:function(faqSectionPublishId) {
        if(faqSectionPublishId && typeof faqSectionPublishId === "string") {
            cordova.exec(null, null, "HelpshiftPG", "showFAQSection", [faqSectionPublishId]);
        }
    },

    /**
    * Show the helpshift screen with a particular faq.
      To show the Helpshift screen for showing a particular faq you need to pass the publish-id of the faq.
    *
    * @param {string} faqPublishId The publish id associated with the faq which is shown when you expand a single FAQ
        (__yourcompanyname__.helpshift.com/admin/faq/)
    *
    * @example HelpshiftPG.showFAQ("&lt;PUBLISH_ID&gt;");
    */
    showFAQ:function(faqPublishId) {
        if(faqPublishId && typeof faqPublishId === "string") {
            cordova.exec(null, null, "HelpshiftPG", "showFAQ", [faqPublishId]);
        }
    },

    /**
    * Set the user identifier for your users.
      This is part of additional user configuration. You can setup the identifier that this user will have with this api.
    *
    * @param {string} userIdentifier A string to identify your users.
    *
    * @example HelpshiftPG.setUserIdentifier("user-id-100");
    */
    setUserIdentifier:function(userIdentifier) {
        if(userIdentifier && typeof userIdentifier === "string") {
            cordova.exec(null, null, "HelpshiftPG", "setUserIdentifier", [userIdentifier]);
        }
    },

    /**
    * Set the name of the application user.
      This is part of additional user configuration. If this is provided through the api, user will not be prompted to re-enter this information again.
    *
    * @param {string} username The name of the user.
    *
    * @example HelpshiftPG.setUsername("John");
    */
    setUsername:function(username) {
        if(username && typeof username === "string") {
            cordova.exec(null, null, "HelpshiftPG", "setUsername", [username]);
        }
    },

    /**
    * Set the email-id of the application user.
      This is part of additional user configuration. If this is provided through the api, user will not be prompted to re-enter this information again.
    *
    * @param {string} useremail A unique string to identify your users.
    *
    * @example HelpshiftPG.setUseremail("john@example.com");
    */
    setUseremail:function(useremail) {
        if(useremail && typeof useremail === "string") {
            cordova.exec(null, null, "HelpshiftPG", "setUseremail", [useremail]);
        }
    },

    /**
    * Add extra debug information regarding user-actions.
      You can add additional debugging statements to your code, and see exactly what the user was doing right before they reported the issue.
    *
    * @param {string} breadCrumb The string containing any relevant debugging information.
    *
    * @example HelpshiftPG.leaveBreadCrumb("settings button");
    */
    leaveBreadCrumb:function(breadCrumb) {
        if(breadCrumb && typeof breadCrumb === "string") {
            cordova.exec(null, null, "HelpshiftPG", "leaveBreadcrumb", [breadCrumb]);
        }
    },

    /**
    * Get the notification count for replies to reported issues.
    * If you want to show your user notifications for replies on the issues posted, you can get
    * the notification count asynchronously by setting the isAsync param to true
    *
    *
    * @param {boolean} isAsync Whether the notification count is to be returned asynchronously
    *
    * @example
    *  HelpshiftPG.getNotificationCount(function (count) {
    *         alert("Count of notifications is " + count);
    *      }, true);
    */

    getNotificationCount : function (callback, isAsync) {
      cordova.exec (callback, null, "HelpshiftPG", "getNotificationCount", [isAsync]);
    },

    /**
    * Register the deviceToken to enable push notifications
      To enable push notifications in the Helpshift iOS SDK, set the Push Notifications deviceToken using this method.
      Please contact us at support[at]helpshift.com for implementing Apple Push Notification.
    *
    * @param {string} deviceToken The deviceToken received from the push notification servers.
    *
    * @example HelpshiftPG.registerDeviceToken("&lt;DEVICE_TOKEN&gt;");
    */
    registerDeviceToken:function(deviceToken) {
        if(deviceToken && typeof deviceToken === "string") {
            cordova.exec(null, null, "HelpshiftPG", "registerDeviceToken", [deviceToken]);
        }
    },

    /**
    * Forward the push notification for the HelpshiftSDK to handle
      To show support on Notification opened, call showSupportOnPush. If the value of the “origin” field is “helpshift” call the showSupportOnPush api.
      Please contact us at support[at]helpshift.com for implementing GCM Push Notification.
    *
    * @param {object} notificationInfo The issue_id for which the notification was
    * received. This information will be available in the push payload.
    *
    * @example HelpshiftPG.showSupportOnPush(issue_id);
    */
    showSupportOnPush:function(issue_id) {
        if(notificationInfo) {
            cordova.exec(null, null, "HelpshiftPG", "showSupportOnPush", [issue_id]);
        }
    },
};
