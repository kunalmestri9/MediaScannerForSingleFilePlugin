//
//  MediaScannerForSingleFilePlugin.js
//  MediaScannerForSingleFilePlugin PhoneGap/Cordova plugin
//
//  Created by Kunal Mestri on 24/06/2015.
//  MIT Licensed
//

module.exports = {

    scanSingleFile:function(fileName,successCallback, failureCallback) {
        // successCallback required
        if (typeof successCallback !== "function") {
            console.log("MediaScannerPlugin Error: successCallback is not a function");
			alert("Scanning Successfully Completed");
        }
        else if (typeof failureCallback !== "function") {
            console.log("MediaScannerPlugin Error: failureCallback is not a function");
			alert("Issue While Scanning File");
        }
        else {
            return cordova.exec(successCallback, failureCallback, "MediaScannerForSingleFilePlugin", "scanSingleFile", [{
				"fileName":fileName
			}]);
        }
    }
};
