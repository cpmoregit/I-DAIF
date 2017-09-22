/**
 *
 * Controller
 * 
 */

var clientConfiguration = require("./configuration");
var deviceCommunication = require("../deviceIntegration/deviceCommunication");
var eventPublisher = require("../eventsHandler/localEventHandler");
var eventID = require("../eventsHandler/EventID");

function deviceStatusUpdate(){
	eventPublisher.submitEvent(2,"publish");
}
	
setInterval(deviceStatusUpdate, 5000, 'deviceStatusUpdate');