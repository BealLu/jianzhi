app.service('loginService',function($http){
    this.login=function (username,pwd) {
        return $http.get('../login/login?username='+username+'&pwd='+pwd);
    }
})