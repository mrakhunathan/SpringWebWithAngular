var helperModule = angular.module( 'RestHelper', [] );
helperModule.controller( 'helperController', function () {
	console.log( "helperController" );
} );

helperModule.service( 'RestService', function ( $http ) {
	this.invokeRest = function ( restUrl, methodType, callback ) {
		var promise = $http( {
			method : methodType,
			url : restUrl,
			headers : {
				'Content-Type' : undefined
			}
		} ).then( function ( response ) {
			callback( response.data );
			return response.data;
		} );
		return promise;
	};

	this.invokeRestWithData = function ( restUrl, methodType, data, callback ) {
		var promise = $http( {
			method : methodType,
			data : data,
			url : restUrl,
			headers : {
				'Content-Type' : 'application/json;charset=utf-8'
			}
		} ).then( function ( response ) {
			callback( response.data );
			return response.data;
		} );
		return promise;
	};

	this.invokeRestWithUndefinedData = function ( restUrl, methodType, data, callback ) {
		var promise = $http( {
			method : methodType,
			url : restUrl,
			data : data,
			cache : false,
			headers : {
				'Content-Type' : undefined
			}
		} ).then( function ( response ) {
			callback( response.data );
			return response.data;
		} );
		return promise;
	};
} );

var fileUploaderApp = angular.module( 'FileUploader', [] );

fileUploaderApp.controller( 'FileUploaderController', function ( $scope ) {
	$scope.logOne = function () {
		console.log( $scope.files2 );
	};
} );

fileUploaderApp.directive( 'ngFile', [
		'$parse', function ( $parse ) {
			return {
				restrict : 'A',
				link : function ( $scope, element, attrs ) {
					var model = $parse( attrs.ngFile );
					var isMultiple = attrs.multiple;
					var modelSetter = model.assign;
					element.bind( 'change', function () {
						var values = [];
						angular.forEach( element[ 0 ].files, function ( item ) {
							var value = {
								name : item.name,
								size : item.size,
								url : URL.createObjectURL( item ),
								_file : item
							};
							values.push( value );
						} );
						$scope.$apply( function () {
							if ( isMultiple ) {
								modelSetter( $scope, values );
							} else {
								modelSetter( $scope, values[ 0 ] );
							}
						} );
					} );
				}
			};
		}
] );