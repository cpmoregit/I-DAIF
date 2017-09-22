/**
 * http://usejsdoc.org/
 */

function shutdown(args){
	console.log('Shutdown event occurred!' + args);
}

module.exports.shutdown = shutdown;