app.controller('positionController' ,function($scope,$controller,$window,positionService) {
    $controller('baseController', {$scope: $scope});
    $scope.entity={};
    $scope.findUserId=function () {
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);
        var userId=sessionStorage.getItem("userId");
        $scope.entity.userId=userId;
        if (id!=null){
            $scope.findOne(id);
        }
    }
    $scope.findTypePid=function (pid) {
        positionService.findTypePid(pid).success(
            function (response) {
                $scope.typeList1=response;

            }
        )
    }
    $scope.save=function(){
        if ($scope.entity.id!=null){
            $scope.update();
        }else {
            $scope.add();
        }
    }
   /* $scope.findDescId=function () {
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);

    }*/
    $scope.$watch('entity.type1', function(newValue, oldValue) {
        //判断一级分类有选择具体分类值，在去获取二级分类
        if(newValue){
            //根据选择的值，查询二级分类
            positionService.findTypePid(newValue).success(
                function(response){
                    $scope.typeList2=response;
                }
            );
        }
    });
    $scope.$watch('entity.type2', function(newValue, oldValue) {
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
    $scope.add=function(){
        var serviceObject;//服务层对象
        serviceObject=positionService.add( $scope.entity);//增加
        serviceObject.success(
            function(response){
                if(response.success){
                    alert(response.message)
                }else{
                    alert(response.message);
                }
            }
        );
    }
    $scope.findOne=function (id) {
        positionService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }
    $scope.update=function () {
        positionService.update($scope.entity).success(
            function (response) {
                alert(response.message)
            }
        )
    }
});