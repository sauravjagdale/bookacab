'use strict'

angular.module('bookacab.services', []).factory('AppService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.assignDriver = function(customerId) {
				var url = CONSTANTS.assignDriver + customerId;
				return $http.get(url);
			}
			service.getAllDriver = function() {
				return $http.get(CONSTANTS.getAllDriver);
			}
			service.saveCustomer = function(customerDto) {
				return $http.post(CONSTANTS.saveCustomer, customerDto);
			}
			return service;
		} ]);