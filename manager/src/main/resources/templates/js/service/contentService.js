app.service('contentService',function($http){

    this.findAll=function () {
        return $http.get('../content/findAll');
    }
    this.findOne=function (id) {
        return $http.get('../content/findOne?id='+id);
    }
    this.update=function (entity) {
        return $http.post('../content/update',entity);
    }
    this.add=function (entity) {
        return $http.post('../content/add',entity);
    }
    this.dele=function (ids) {
        return $http.get('../content/dele?ids='+ids);
    }
    this.setStatus=function (ids,status) {
        return $http.get('../content/setStatus?ids='+ids+'&status='+status)
    }
});