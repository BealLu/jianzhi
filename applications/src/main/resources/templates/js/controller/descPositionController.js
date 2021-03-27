app.controller('descPositionController' ,function($scope,$controller,$window,descPositionService) {
    $controller('baseController', {$scope: $scope});
    var userId=sessionStorage.getItem("userId");
    $scope.findDesc = function () {
        var href = location.href; //取得整个地址栏
        var id = href.substr(href.indexOf("=") + 1);
        descPositionService.findDesc(id,userId).success(
            function (response) {
                $scope.entity=response;
            }
        )

    }
    $scope.allTypeList=[];
    $scope.findAllType=function () {
        descPositionService.findAllType().success(
            function (response) {
                for(var i= 0 ;i<response.length;i++){
                    $scope.allTypeList[response[i].id]=response[i].name;
                }
            }
        )
    }
    $scope.addguanzhu=function (descId) {
        descPositionService.addguanzhu(descId,userId).success(
            function (response) {
                if (response.success){
                    window.location.reload();
                }
                else {
                    alert("收藏失败!请重新操作");
                }
            }
        )
    }
    $scope.remguanzhu=function (descId) {
        descPositionService.remguanzhu(descId,userId).success(
            function (response) {
                if (response.success){
                  window.location.reload();
                }
                else {
                    alert("取消收藏失败!请重新操作");
                }
            }
        )
    }
    $scope.guanzhuList=[];
    $scope.isGuanZhu=function () {
      var guanzhu=$scope.entity.guanzhu;
      if (guanzhu!=null){
          $scope.guanzhuList=JSON.parse(guanzhu);
          if ($scope.guanzhuList.indexOf($scope.entity.posi.id)>-1){
              return true;
          }
          else {
              return false;
          }
      }
     return false;
    }
    $scope.isSelf=function () {
        if (userId==$scope.entity.user.id){
            return true
        }
        return false;
    }
})