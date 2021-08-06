var exec = require('cordova/exec');

exports.openMicroApp = function (route, success, error) {
    exec(success, error, 'MicroAppsFlutter', 'openMicroApp', [route]);
};
