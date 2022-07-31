// CONTROLLERS
timeDepositApp.controller('homeController', ['$scope', 'cityService', function($scope, cityService) {
    
    $scope.city = cityService.city;
    
    $scope.$watch('city', function() {
       cityService.city = $scope.city; 
    });
    
}]);
timeDepositApp.controller('HomeController', ['$scope', '$location', '$routeParams', 'cityService', function($scope, $location, $routeParams, cityService) {

    $scope.client = {
        firstName: '',
        lastName: '',
        address: '',
        phoneNo: '',
    }


    $scope.submit = ($event) => {
        console.log($event);
        axios.post("http://localhost:8080/api/v1/client/save", $scope.client).then((response) => {
          id = response.data.data.clients.id
          location.assign('index.htm#/account'); 
        })  
    }
}]);
    
timeDepositApp.controller('CreateAccountController', ['$scope', '$location', '$routeParams', 'cityService',  function($scope, $location, $routeParams, cityService) {
  
    $scope.clients = [];
    
     axios.get("http://localhost:8080/api/v1/client/all", $scope.clients).then((response) => {
        response.data.data.clients.forEach(element => {
            $scope.clients.push(element);
            $scope.userselected = $scope.clients[0];
         });
         console.log($scope.clients);
         console.log($scope.userselected);
        });  

        $scope.submit = ($event) => {
            console.log($event);
            axios.post("http://localhost:8080/api/v1/client/save", $scope.client).then((response) => {
              id = response.data.data.clients.id
              location.assign('Finished/index.htm#/account'); 
            })  
        }
    // $scope.accountNumber = '';
    // $scope.id = id;
    // $scope.balance = 0;
  
    // $scope.submit = ($event) => {
    //     const params = new URLSearchParams();
    //     params.append('accountNumber', $scope.accountNumber)
    //     params.append('clientId', id )
    //     params.append('balance',  $scope.balance )
    
    //     axios.post("http://localhost:8080/time-deposit-account/save", params).then((response) => {
    //         location.assign('/index.htm#/tdaccounts'); 
    //     })  
    // }
}]);

weatherApp.controller('CheckController', ['$scope', '$resource', '$routeParams', 'cityService', async function($scope, $resource, $routeParams, cityService) {
 
    $scope.array = ['wew'];

    await axios.get("http://localhost:8080/accounts/retrieve").then((response) => {
        response.data.data.clients.forEach(element => {
           $scope.array.push(element);
        });
    });
    
    console.log($scope.array);
    
}]);