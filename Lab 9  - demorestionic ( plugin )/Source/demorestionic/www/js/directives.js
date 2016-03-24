angular.module('app.directives', [])

.directive('blankDirective', [function(){

}]);

/*
.directive(‘href’, function(){
    ‘use strict’;
        return {
                restrict: ‘A’,
                scope: {
                url: ‘@href’
                },
                link: function(scope, element, attrs){
                    if(scope.url.indexOf(‘http:/'/’) === 0 || scope.url.indexOf(‘https:/'/’) === 0){
                    element.bind(‘click’, function(e){
                    e.preventDefault();
                    window.open(encodeURI(scope.url), ‘_blank’, ‘location=yes’);
                        });
                    }   
                }
        };
})
*/
