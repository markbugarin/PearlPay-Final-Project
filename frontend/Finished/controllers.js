let id = 0;

// CONTROLLERS
weatherApp.controller('homeController', ['$scope', 'cityService', function($scope, cityService) {
    
    $scope.city = cityService.city;
    
    $scope.$watch('city', function() {
       cityService.city = $scope.city; 
    });
    
}]);

weatherApp.controller('forecastController', ['$scope', '$resource', '$routeParams', 'cityService', function($scope, $resource, $routeParams, cityService) {
    
    $scope.city = cityService.city;
    
    $scope.days = $routeParams.days || '2';
    
    $scope.weatherAPI = $resource("http://api.openweathermap.org/data/2.5/forecast/daily", { callback: "JSON_CALLBACK" }, { get: { method: "JSONP" }});
   
    $scope.weatherResult = $scope.weatherAPI.get({ q: $scope.city, cnt: $scope.days });
    console.log($scope.weatherResult)
    $scope.convertToFahrenheit = function(degK) {
        
        return Math.round((1.8 * (degK - 273)) + 32);
        
    }
    
    $scope.convertToDate = function(dt) { 
      
        return new Date(dt * 1000);
        
    };
    
}]);

weatherApp.controller('hotdogController', ['$scope', '$location', '$routeParams', 'cityService', function($scope, $location, $routeParams, cityService) {

    $scope.client = {
        firstName: '',
        lastName: '',
        address: '',
        email: '',
        phoneNumber: '',
    }


    $scope.submit = ($event) => {
        console.log($event);
        axios.post("http://localhost:8080/client/save", $scope.client).then((response) => {
          id = response.data.data.clients.id
          location.assign('/index.htm#/account'); 
        })  
    }
}]);
    
weatherApp.controller('CreateAccountNumberController', ['$scope', '$location', '$routeParams', 'cityService', function($scope, $location, $routeParams, cityService) {
  
    $scope.accountNumber = '';
    $scope.id = id;
    $scope.balance = 0;
  
    $scope.submit = ($event) => {
        const params = new URLSearchParams();
        params.append('accountNumber', $scope.accountNumber)
        params.append('clientId', id )
        params.append('balance',  $scope.balance )
    
        axios.post("http://localhost:8080/time-deposit-account/save", params).then((response) => {
            location.assign('/index.htm#/tdaccounts'); 
        })  
    }
}]);

weatherApp.controller('tdAccountsController', ['$scope', '$resource', '$routeParams', 'cityService', async function($scope, $resource, $routeParams, cityService) {
 
    $scope.array = ['wew'];

    await axios.get("http://localhost:8080/accounts/retrieve").then((response) => {
        response.data.data.clients.forEach(element => {
           $scope.array.push(element);
        });
    });
    
    console.log($scope.array);
    
}]);