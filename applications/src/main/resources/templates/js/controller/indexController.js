app.controller('indexController' ,function($scope,$controller,indexService) {
    $controller('baseController', {$scope: $scope});
    $scope.findUser=function () {
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);
       indexService.findUser(id).success(
           function (response) {
                $scope.user=response;
                sessionStorage.setItem("userId",id);
                //sessionStorage.setItem("guanzhu",$scope.user.guanzhu);
               // document.cookie="userId="+id;
           }
       )
    }

});