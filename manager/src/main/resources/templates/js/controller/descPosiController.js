app.controller('descPosiController' ,function($scope,$controller,$window,positionService) {
    $controller('baseController', {$scope: $scope});
    $scope.findDesc=function () {
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);
        positionService.findDesc(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }

})