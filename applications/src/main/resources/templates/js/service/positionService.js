app.service('positionService',function($http){
    this.findTypePid=function (pid) {
        return $http.get('../position/findTypePid?pid='+pid);
    }
    this.add=function (entity) {
        return $http.post('../position/addPosition',entity);
    }
    this.update=function (entity) {
        return $http.post('../position/update',entity);
    }
    this.findOne=function (id) {
        return $http.get('../position/findOne?id='+id);
    }
})