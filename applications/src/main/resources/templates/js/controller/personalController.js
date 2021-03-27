app.controller('personalController' ,function($scope,$controller,$window,personalService) {
    $controller('baseController', {$scope: $scope});
    $scope.findUser=function () {
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);
        personalService.findUser(id).success(
            function (response) {
                $scope.entity=response;

            }
        )
    }
    $scope.addPublish=function (id) {
        personalService.addPublish(id).success(
            function (response) {
                alert(response.message);
            }
        )
    }
    $scope.remPublish=function (id) {
        personalService.remPublish(id).success(
            function (response) {
                alert(response.message);
            }
        )
    }
})