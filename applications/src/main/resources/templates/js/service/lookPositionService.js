app.service('lookPositionService',function($http){
    this.findAllPosi=function (entity) {
        return $http.post('../position/findAllPosi',entity)
    }

})