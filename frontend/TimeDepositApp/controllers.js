// CONTROLLERS
timeDepositApp.controller('HomeController', ['$scope', '$location', '$routeParams', 'cityService', function($scope, $location, $routeParams, cityService) {
    $scope.client = {
        firstName: '',
        lastName: '',
        address: '',
        phoneNo: '',
    }
    $scope.submit = ($event) => {
        axios.post("http://localhost:8080/api/v1/client/save", $scope.client).then((response) => {
          id = response.data.data.clients.id
          location.assign('index.htm#/account'); 
        })  
    }
}]);
    
timeDepositApp.controller('CreateAccountController', ['$scope', '$location', '$routeParams', 'cityService','$q', function($scope, $location, $routeParams, cityService, $q) {
    $scope.account = {
        amount: '',
        interest: '',
        date: '',
    }
    $q.when(axios.get("http://localhost:8080/api/v1/client/all", $scope.clients).then((response) => {
        $scope.clients = [];
        response.data.data.clients.forEach(element => {
                $scope.clients.push(element);
             });        
             console.log($scope.clients);
        }) 
    ) 
        
        $scope.submit = ($event) => {
            $scope.timeDepositAccount = {
                 clientId: parseInt($scope.selectedClient),
                 amount: $scope.account.amount,
                 interest: $scope.account.interest,
                 maturity: $scope.account.maturity
             }
            axios.post("http://localhost:8080/api/v1/primary-account/save", $scope.timeDepositAccount).then((response) => {
              location.assign('index.htm#/tdaccounts'); 
            })  
        }
}]);

timeDepositApp.controller('CheckAllBalance', ['$scope', '$location', '$routeParams', 'cityService','$q', function($scope, $location, $routeParams, cityService, $q) {

    $scope.accounts = [];

  
   $q.when(axios.get("http://localhost:8080/api/v1/primary-account/all", $scope.accounts).then((response) => {
        response.data.data.accounts.forEach(element => {
                $scope.accounts.push(element);       
             });
        }) 
   )
}]);
