app.service('indexService',function($http){
    this.findUser=function (id) {
        return $http.get('../index/findUser?id='+id);
    }
})