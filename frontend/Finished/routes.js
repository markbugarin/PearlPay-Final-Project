// ROUTES
weatherApp.config(function ($routeProvider) {

    $routeProvider.when('/', {
        templateUrl: 'pages/home.htm',
        controller: 'hotdogController'
    })
    .when('/account', {
        templateUrl: 'pages/createtimedepositaccount.htm',
        controller: 'CreateAccountNumberController'
    })
    .when('/tdaccounts', {
        templateUrl: 'pages/tdaccounts.htm',
        controller: 'tdAccountsController'
    }
    ).when('/transfer', {
        templateUrl: 'pages/transfer.htm',
        controller: 'tdAccountsController'
    })   
});