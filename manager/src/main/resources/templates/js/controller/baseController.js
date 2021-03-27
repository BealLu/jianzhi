app.controller('baseController',function ($scope) {
    $scope.paginationConf={
        currentPage:1,
        totalItems:10,
        itemsPerPage:10,
        perPageOptions:[5,10,15,20,25],
        onChange:function () {
            //分页查询
            $scope.reLoadList();
        }
    }
    $scope.reLoadList=function () {
        /*$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);*/
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }
    $scope.selectIds=[];
    $scope.updateSelection=function ($event,id) {
        if ($event.target.checked){
            $scope.selectIds.push(id);
        }else {
            var index1 =  $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index1,1);
        }
    }
});