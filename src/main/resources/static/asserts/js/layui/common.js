

layui.define(function(exports){ //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    var $ = layui.jquery;
    var common = {
        frame_show: function(title,url,w,h){
            if (title == null || title == '') {
                title=false;
            };
            if (url == null || url == '') {
                url="404.html";
            };
            if (w == null || w == '') {
                w=($(window).width()*0.9);
            };
            if (h == null || h == '') {
                h=($(window).height() - 50);
            };
            layer.open({
                type: 2,
                area: [w+'px', h +'px'],
                fix: false, //不固定
                maxmin: true,
                shadeClose: true,
                shade:0.4,
                title: title,
                content: url
            });
        },
        cmsLayErrorMsg:function(data){
            layer.msg(data, {icon: 5});
        }
    };

    //输出common接口
    exports('common', common);
});