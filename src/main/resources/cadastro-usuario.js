var app = angular.module("app", []);

app.controller('usuarioController', function($scope, $http, $location) {
    $scope.registrar = function () {
        var url = $location.absUrl() + "usuario";
        $scope.post('createUsuario/')
    }
});
