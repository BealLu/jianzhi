app.controller('contentController' ,function($scope,$controller,$location,$window,contentService) {
    $controller('baseController', {$scope: $scope});
    $scope.findContent=function () {
        contentService.findContent().success(
            function (response) {
                $scope.content=response;
            }
        )
    }
    $scope.findUser=function () {
        var href = location.href; //取得整个地址栏
        alert(href);
    }
    $scope.findNewPosi=function () {
        contentService.findNewPosi().success(
            function (response) {
                $scope.newList=response;
            }
        )
    }
});