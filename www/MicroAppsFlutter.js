/*
    Copyright (c) TODO1 SERVICES, INC. (‘TODO1’) All rights reserved, 2000 – 2021. This work is protected by the United States of America copyright laws. All information contained herein is and remains the property of TODO1 [and its suppliers, if any] *. 
    Dissemination of this information or reproduction of this material is not permitted unless prior written consent is obtained from TODO1 SERVICES, INC.
*/

var exec = require('cordova/exec');

exports.openMicroApp = function (route, success, error) {
    exec(success, error, 'MicroAppsFlutter', 'openMicroApp', [route]);
};
