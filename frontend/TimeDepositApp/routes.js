// ROUTES
timeDepositApp.config(function ($routeProvider) {

    $routeProvider.when('/', {
        templateUrl: 'pages/home.htm',
        controller: 'HomeController'
    })
    .when('/account', {
        templateUrl: 'pages/createtimedepositaccount.htm',
        controller: 'CreateAccountController'
    })
    .when('/tdaccounts', {
        templateUrl: 'pages/tdaccounts.htm',
        controller: 'tdAccountsController'
    }
    )
    .when('/transfer', {
        templateUrl: 'pages/transfer.htm',
        controller: 'tdAccountsController'
    })   
    .when('/check', {
        templateUrl: 'pages/checkallbalance.htm',
        controller: 'CheckController'
    })
    .when('/dashboard', {
        templateUrl: 'pages/dashboard.htm',
        controller: 'DashboardController'
    })      
});