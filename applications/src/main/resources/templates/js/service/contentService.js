app.service('contentService',function($http){
    this.findContent=function () {
        return $http.get('../content/findContent');
    }
    this.findNewPosi=function () {
        return $http.get('../index/findNewPosi');
    }
})