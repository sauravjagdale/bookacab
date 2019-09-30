'use strict'

var module = angular.module('bookacab.controllers', []);
module.controller("AppController", ["$scope", "AppService",
    function($scope, AppService) {
        var vm = $scope;

        vm.resetCustomerForm = function() {
            vm.customer = {
                customerName: null,
                latitude: null,
                longitude: null
            };
        }
        vm.resetCustomerForm();

        vm.getAlldriverDetails = function() {
            AppService.getAllDriver().then(function(value) {
                vm.allDrivers = value.data;
            }, function(reason) {
            	vm.errorMessgae = reason;
                vm.showErrorMessgae = true;
                vm.showSuccessMessage = false;
            });
        }

        vm.getAlldriverDetails();
        vm.saveCustomer = function() {
            AppService.saveCustomer(vm.customer).then(function(value) {
                AppService.assignDriver(value.data.id).then(function(response) {
                    vm.successMessgae = response.data.message;
                    vm.showSuccessMessage = true;
                    vm.getAlldriverDetails();
                }, function(reason) {
                    vm.errorMessgae = reason;
                    vm.showErrorMessgae = true;
                    vm.showSuccessMessage = false;
                });
                vm.customer = {
                    customerName: null,
                    latitude: null,
                    longitude: null
                };
            }, function(reason) {
            	vm.errorMessgae = reason;
                vm.showErrorMessgae = true;
                vm.showSuccessMessage = false;
            });
        }
    }
]);