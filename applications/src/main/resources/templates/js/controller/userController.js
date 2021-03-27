app.controller('userController' ,function($scope,$controller,$window,userService,uploadService) {
    $controller('baseController', {$scope: $scope});
    $scope.findAddressPid=function (pid) {
        userService.findAddressPid(pid).success(
            function (response) {
                $scope.addressList=response;
            }
        )
    }
    $scope.entity={}
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            serviceObject=userService.updateUser($scope.entity); //修改
        }else {
            serviceObject=userService.addUser($scope.entity);//增加
        }
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
    $scope.findOne=function(){
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);
        if (id==null){
          return;
        }
        userService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }

    $scope.$watch('entity.address1', function(newValue, oldValue) {
        //判断一级分类有选择具体分类值，在去获取二级分类
        if(newValue){
            //根据选择的值，查询二级分类
            userService.findAddressPid(newValue).success(
                function(response){
                    $scope.addressList2=response;
                }
            );
        }
    });
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
});