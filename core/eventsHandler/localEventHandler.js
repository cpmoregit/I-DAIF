/**
 * 
 * Local Event Publisher
 *
 */

var EventEmitter = require('events');
var eventIDs = require("./EventID");
var clientConfiguration = require("../controller/configuration");

// Import Listeners
var startupEventListener = require("./startupEventListeners");
var shutdownEventListener = require("./shutdownEventListener");
var mqttPublishEventListener = require("./MQTTPublishListener");

// Register Listeners
class StartupEventHandler extends EventEmitter {}
const startupEventHandler = new StartupEventHandler();
startupEventHandler.on('startup', (message)=>{ startupEventListener.startup(message); });

class ShutdownEventHandler extends EventEmitter {}
const shutdownEventHandler = new ShutdownEventHandler();
shutdownEventHandler.on('shutdown', (message)=>{ shutdownEventListener.shutdown(message); });

class PublishEventHandler extends EventEmitter {}
const publishEventHandler = new PublishEventHandler();
publishEventHandler.on('publish', (message)=>{ mqttPublishEventListener.publish(message); });

// Trigger Events
function submitEvent(eventID, eventMessage){
	console.log(eventID);
	switch(eventID){
		case 0:{
			startupEventHandler.emit("startup",eventMessage);
		}break;
		
		case 1:{
			shutdownEventHandler.emit("shutdown",eventMessage);
		}break;
		
		case 2:{
			publishEventHandler.emit("publish",eventMessage);
		}break;
		
		default:{
			console.log("Undefined Event");
		}
	}
}
  
module.exports.submitEvent = submitEvent;