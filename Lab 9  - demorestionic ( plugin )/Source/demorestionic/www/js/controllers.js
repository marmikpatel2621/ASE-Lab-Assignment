angular.module('app.controllers', [])
  
.controller('findFoodCtrl', function($scope,$http) {
     $scope.recipelist = new Array();
    $scope.getRecipe = function (food) {
      //  var food = document.getElementById('food').value;
        alert( "hello " + food );
        $http.get( 'http://192.168.1.151:8080/MergeWebService/restexample/recipe/' + food).success( function (data1) {
            alert("alert "+ data1);
            $scope.data = data1.data;
            for (var i = 0; i < data1.hits.length; i++) {
                $scope.recipelist[i]= {

                    "name": data1.hits[i].recipe.label,
                    "url": data1.hits[i].recipe.url,
                    "icon": data1.hits[i].recipe.image
                };
            }
            
        } )

    };
    $scope.openInAppBrowser = function(url)
    {
 // Open in app browser
            window.open(url,'_blank'); 
    };
    

})
   
.controller('findPlaceCtrl', function($scope,$http) {
     $scope.venueList = new Array();
    $scope.getFood = function () {
        var food = document.getElementById('food1').value;
         var city = document.getElementById('city').value;
        alert( "hello" + food );
        $http.get( 'http://192.168.1.151:8080/MergeWebService/restexample/recipecity/'+ city +'/'+food).success( function (data) {
            console.log( data);
             for (var i = 0; i < data.response.venues.length; i++) {
                        $scope.venueList[i] = {
                            "name": data.response.venues[i].name,
                            "id": data.response.venues[i].id,
                            "location": data.response.venues[i].location.formattedAddress[0],
                            "url":data.response.venues[i].url
                        };
                    }
            
        } )
        .error(function(data){
            alert("Error" + data);
        })

    };
    
    $scope.openInAppBrowser = function(url)
    {
 // Open in app browser
            window.open(url,'_blank'); 
    };
    
})
   
.controller('aboutCtrl', function($scope) {

})
      
.controller('homeCtrl', function($scope) {

})
   
.controller('loginCtrl', function($scope) {

})
   
.controller('signupCtrl', function($scope) {

})
 