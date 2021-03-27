app.controller('positionTypeController' ,function($scope,$controller,$window,positionTypeService){
    $controller('baseController',{$scope:$scope});
    $scope.findByParentId=function (pid) {
        positionTypeService.findByParentId(pid).success(
            function (response) {
                $scope.list=response;
            }
        )
    }
    $scope.grader=1;
    $scope.setGrader=function (value) {
        $scope.grader=value;
    }
    $scope.selectList=function (p_entity) {
        if($scope.grader==1){
            $scope.entity_2=null;
            $scope.entity_3=null;
        }
        if ($scope.grader==2){
            $scope.entity_2=p_entity;
            $scope.entity_3=null;
        }
        if ($scope.grader==3){
            $scope.entity_3=p_entity;
        }
        $scope.findByParentId(p_entity.id);
    }
    $scope.typeList={};
    $scope.itemCat={};

    $scope.findTypeList=function(){
        typeTemplateService.selectOptionList().success(
            function (response) {
                $scope.typeList=response;
            }
        )
    }
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.itemCat.id!=null){//如果有ID
            serviceObject=positionTypeService.update( $scope.itemCat); //修改
        }else{
            if ($scope.grader==1){
                $scope.itemCat.pid=0;
            }
            if ($scope.grader==2){
                $scope.itemCat.pid=$scope.entity_2.id;
            }
            if ($scope.grader==3){
                $scope.itemCat.pid=$scope.entity_3.id;
            }
            serviceObject=positionTypeService.add( $scope.itemCat);//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                   $scope.refresh();
                }else{
                    alert(response.message);
                }
            }
        );
    }
    $scope.findOne=function(id){
        positionTypeService.findOne(id).success(
            function(response){
                $scope.itemCat= response;
            }
        );
    }
    $scope.dele=function(){
        //获取选中的复选框
        positionTypeService.dele( $scope.selectIds ).success(
            function(response){
                if(response.success){
                    //刷新列表
                    $scope.refresh();
                    $scope.selectIds=[];
                }
                else {
                    alert(response.message);
                    $scope.selectIds=[];
                }
            }
        );
    }
    $scope.refresh=function () {
        $window.location.reload();
    }
});