app.service('userService',function($http){
    this.findOne=function (id) {
        return $http.get('../user/findOne?id='+id);
    }
    this.findAll=function () {
        return $http.get('../user/findAll');
    }
    this.setStatus=function (ids,sta) {
        return $http.get('../user/setStatus?ids='+ids+'&sta='+sta);
    }
    this.findBySta=function (sta) {
        return $http.get('../user/findBySta?sta='+sta)
    }
})