app.controller('userController' ,function($scope,$controller,$window,userService) {
    $controller('baseController', {$scope: $scope});
    $scope.findOne=function () {
        userService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }
    $scope.findAll=function () {
        userService.findAll().success(
            function (response) {
                $scope.userList=response
            }
        )
    }
    $scope.status=['未审核','审核通过','审核未通过','封禁'];
    $scope.setStatus=function (sta) {
        userService.setStatus($scope.selectIds,sta).success(
            function (response) {
                if (response.success){
                    window.location.reload();
                }
                else {
                    alert(response.message);
                }
            }
        )
    }
    $scope.sta="";
    $scope.findBySta=function () {
        userService.findBySta($scope.sta).success(
            function (response) {
                $scope.userList=response;
            }
        )
    }
});