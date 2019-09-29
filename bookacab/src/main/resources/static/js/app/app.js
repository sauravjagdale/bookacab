'use strict'

var bookacabApp = angular.module('bookacab', [ 'ui.bootstrap',
		'bookacab.controllers', 'bookacab.services' ]);
bookacabApp.constant("CONSTANTS", {
	getAllDriver : "/api/v1/driver",
	assignDriver : "/api/v1/customer/assignDriver/",
	saveCustomer : "/api/v1/customer"
});