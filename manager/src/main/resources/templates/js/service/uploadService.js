app.service("uploadService" ,function ($http) {
    this.upload=function () {
        var formData=new FormData();
        formData.append("file",file.files[0]);
        return $http({
            method:"POST",
            url:"../upload",
            data:formData,
            headers:{"Content-Type":undefined},
            transformRequest:angular.identity//对请求的数据序列化操作
        })
    }
});