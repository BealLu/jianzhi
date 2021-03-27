app.controller('positionController' ,function($scope,$controller,$window,positionService){
    $controller('baseController',{$scope:$scope});
    $scope.sta="";
    $scope.allTypeList=[];
    $scope.findAllList=function () {
        positionService.findAllList().success(
            function (response) {
                for(var i= 0 ;i<response.length;i++){
                    $scope.allTypeList[response[i].id]=response[i].name;
                }
            }
        )
    }
    $scope.findAllPosi=function () {
        positionService.findAllPosi().success(
            function (response) {
                $scope.positionList=response;
            }
        )
    }
    $scope.status=['未审核','审核通过','审核未通过','关闭'];

    $scope.setStatus=function (status) {
        positionService.setStatus($scope.selectIds,status).success(
            function (response) {
                if (response.success){
                    window.location.reload();
                }else
                {
                    alert("修改失败");
                }
            }
        )
    }
    $scope.findDesc=function (id) {
        window.location.href="lookPosition.html?id="+id;
    }
    $scope.findBySta=function () {
        positionService.findBySta($scope.sta).success(
            function (response) {
                $scope.positionList=response;
            }
        )
    }
})