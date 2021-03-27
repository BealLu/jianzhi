app.controller('loginController' ,function($scope,$controller,$window,loginService) {
    $controller('baseController', {$scope: $scope});
    $scope.uname="";
    $scope.pwd="";
    $scope.login=function () {
        loginService.login($scope.uname,$scope.pwd).success(
            function (response) {
                if (response!=null){
                    window.location.href="index.html?id="+response.id;
                }
                else {
                    alert("账号或密码错误，请重新登录!");
                }
            }
        )
    }
    $scope.register=function () {
        console.log("注册");
        window.location.href="register.html"
    }

})