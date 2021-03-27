app.service('userService',function($http){
    this.findAddressPid=function (pid) {
        return $http.get('../user/findAddressPid?pid='+pid);
    }
    this.findOne=function (id) {
        return $http.get('../user/findOne?id='+id);
    }
    this.updateUser=function (entity) {
        return $http.post('../user/updateUser?',entity);
    }
    this.addUser=function (entity) {
        return $http.post('../user/addUser?',entity);
    }
})