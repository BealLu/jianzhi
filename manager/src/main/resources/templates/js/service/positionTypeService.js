app.service('positionTypeService',function($http){


    this.findByParentId=function (pid) {
        return $http.get('../position/findByPid?pid='+pid);
    }

    this.findOne=function (id) {
        return $http.get('../position/findOne?id='+id);
    }
    this.update=function (entity) {
        return $http.post('../position/updatePositionType',entity);
    }
    this.add=function (entity) {
        return $http.post('../position/addPositionType',entity);
    }
    this.dele=function (ids) {
        return $http.get('../position/dele?ids='+ids);
    }
});