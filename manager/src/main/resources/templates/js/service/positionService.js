app.service('positionService',function($http){
    this.findAllList=function () {
        return $http.get('../audit/findAllList');
    }
    this.findAllPosi=function () {
        return $http.get('../audit/findAllPosi');
    }
    this.setStatus=function (ids,status) {
        return $http.get('../audit/setStatus?ids='+ids+'&status='+status);
    }
    this.findDesc=function (id) {
        return $http.get('../audit/findDesc?id='+id);
    }
    this.findBySta=function (sta) {
        return $http.get('../audit/findBySta?sta='+sta);
    }
})