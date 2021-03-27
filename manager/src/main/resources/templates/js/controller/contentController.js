app.controller('contentController' ,function($scope,$controller,$window,contentService,uploadService){
    $controller('baseController',{$scope:$scope});

    $scope.findAll=function () {
        contentService.findAll().success(
            function (response) {
                $scope.list=response;
            }
        )
    }
    $scope.entity={};
    $scope.upload=function(){
        uploadService.upload().success(
            function (response) {
                if(response.success){
                    $scope.entity.pic=response.message;
                }else {
                    alert(response.message);
                }
            }
        ).error(function () {
            alert("上传服务器故障");
        });
    }
    $scope.findOne=function(id){
        contentService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }
    $scope.statuss=["无效","有效"];
    $scope.refresh=function () {
        $window.location.reload();
    }

    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            serviceObject=contentService.update( $scope.entity); //修改
        }else {
            serviceObject=contentService.add( $scope.entity);//增加
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
    $scope.dele=function () {
        contentService.dele($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.refresh();
                }else{
                    alert(response.message);
                }
            }
        )
    }
    $scope.setStatus=function (status) {
        contentService.setStatus($scope.selectIds,status).success(
            function(response){
                if(response.success){
                    $scope.refresh();
                }else{
                    alert(response.message);
                }
            }
        )
    }
});