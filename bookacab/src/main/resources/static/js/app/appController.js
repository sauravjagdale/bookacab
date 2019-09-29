'use strict'

var module = angular.module('bookacab.controllers', []);
module.controller("AppController", [ "$scope", "AppService",
		function($scope, AppService) {
			var vm = $scope;

			vm.resetCustomerForm = function() {
				vm.customer = {
					customerName : null,
					latitude : null,
					longitude : null
				};
			}
			vm.resetCustomerForm();

			vm.getAlldriverDetails = function() {
				AppService.getAllDriver().then(function(value) {
					vm.allDrivers = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			vm.getAlldriverDetails();
			vm.saveCustomer = function() {
				AppService.saveCustomer(vm.customer).then(function() {
					vm.getAlldriverDetails();
					vm.customer = {
						customerName : null,
						latitude : null,
						longitude : null
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);