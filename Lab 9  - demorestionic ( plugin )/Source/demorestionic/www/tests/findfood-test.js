describe('findFoodCtrl', function() {
	var scope, httpBackend;
	
	beforeEach(angular.mock.module('app'));
	beforeEach(angular.mock.inject(function($rootScope, $controller, $httpBackend, $http) {
		scope = $rootScope.$new();
        httpBackend = $httpBackend;
        //httpBackend.when("GET", "http://192.168.1.151:8080/MergeWebService/restexample/recipe/rice").respond([{}, {}, {}]);
        $controller('findFoodCtrl', {$scope: scope,$http: $http});
	}));

	it("Checks the Get Recipe", function () {
		/*httpBackend.flush();*/
        scope.getRecipe("rice");
        alert(scope.data);
       expect(scope.recipelist[0].name).toMatch("rice");
	});
});