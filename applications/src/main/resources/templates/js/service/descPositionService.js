app.service('descPositionService',function($http){
    this.findDesc=function (id,userId) {
        return $http.get('../position/findDesc?id='+id+'&userId='+userId);
    }
    this.findAllType=function () {
        return $http.get('../position/findAllType');
    }
    this.addguanzhu=function (descId,userId) {
        return $http.get('../position/addguanzhu?descId='+descId+'&userId='+userId);
    }
    this.remguanzhu=function (descId,userId) {
        return $http.get('../position/remguanzhu?descId='+descId+'&userId='+userId);
    }
})