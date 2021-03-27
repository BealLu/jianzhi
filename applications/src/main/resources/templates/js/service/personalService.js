app.service('personalService',function($http){
    this.findUser=function (id) {
        return $http.get('../user/findPersonal?id='+id);
    }
    this.addPublish=function (id) {
        return $http.get('../position/addPublish?id='+id);
    }
    this.remPublish=function (id) {
        return $http.get('../position/remPublish?id='+id);
    }
})