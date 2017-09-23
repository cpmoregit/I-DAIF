/**
 * http://usejsdoc.org/
 */
//var clientConfiguration = require("../controller/configuration");
var mqttClient = require("ibmiotf");
var config = {
	    "org" : "quickstart",
	    "id" : "ibmid",
	    "domain": "internetofthings.ibmcloud.com",
	    "type" : "sampledevice",
	    "auth-method" : "token",
	    "auth-token" : "ibmtoken"
	};

function publish(message){
    console.log('Send Message Event occurred!');
  
    var deviceClient = new mqttClient.IotfDevice(config);
	deviceClient.connect();
	
	// On Error
	deviceClient.on("error", function (err) {
	    console.log("Error : "+err);
	});
	
	deviceClient.on('connect', function () {	
		//publishing event using the default quality of service
		deviceClient.publish("status","json",message);
		console.log(message);
	});
}

module.exports.publish = publish;