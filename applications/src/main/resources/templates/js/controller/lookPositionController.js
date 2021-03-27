app.controller('lookPositionController' ,function($scope,$controller,$window,lookPositionService,positionService) {
    $controller('baseController', {$scope: $scope});
    $scope.searchEntity = {};
    $scope.condition="";
    $scope.findTypePid=function (pid) {
        positionService.findTypePid(pid).success(
            function (response) {
                $scope.typeList1=response;

            }
        )
    }
    $scope.$watch('searchEntity.type1', function(newValue, oldValue) {
        //判断一级分类有选择具体分类值，在去获取二级分类
        $scope.searchEntity.type3=null;
        $scope.searchEntity.type2=null;
        if(newValue){
            //根据选择的值，查询二级分类
            positionService.findTypePid(newValue).success(
                function(response){
                    $scope.typeList2=response;
                }
            );
        }
    });
    $scope.$watch('searchEntity.type2', function(newValue, oldValue) {
        //判断一级分类有选择具体分类值，在去获取二级分类
        if(newValue){
            //根据选择的值，查询二级分类
            positionService.findTypePid(newValue).success(
                function(response){
                    $scope.typeList3=response;
                }
            );
        }
    });
    $scope.$watch('condition', function(newValue, oldValue) {
        $scope.searchEntity={};
    });
    $scope.findAllPosi=function () {
        lookPositionService.findAllPosi($scope.searchEntity).success(
            function (response) {
                $scope.positionList=response;
            }
        )
    }
    $scope.findDesc=function (descFk) {
        window.location.href="descPosition.html?id="+descFk;
    }
})