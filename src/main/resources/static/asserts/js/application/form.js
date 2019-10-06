//目前的一个问题就是让HTML页面可以调用这里的js
layui.define(['table','layer','form'], function(){
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer; //独立版的layer无需执行这一句
    var form = layui.form;
    form.render();
    var active = {
        offset: function(othis) {
            var type = othis.data('type')  //给后面弹出层id用的
            layer.open({
                type: 1  //1为页面层
                ,title: '匹配比赛名称'  //弹出层标题
                ,area: '800px'   //设置弹出层大小[宽，高]
                ,offset: 'auto'   //设置弹出层位置 //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                ,id: 'layerDemo_ctname' + type //防止重复弹出，点击这个input只能有一个弹出层
                ,content:$("#layer_ctname")   //弹出层内容为layer_ctname块，不能直接是表格id
                , btnAlign: 'c' //按钮居中
                , shade: 0 //不显示遮罩
                , yes: function () {  //确定按钮回调方法， 需要手动关闭弹出层
                    layer.closeAll();
                }
            });
        }
    }

    var active_layer_teacher1Id = {
        offset: function(othis) {
            var type = othis.data('type')  //给后面弹出层id用的

            layer.open({
                type: 1  //1为页面层
                ,title: '指导老师1编号'  //弹出层标题
                ,area: ['800px', '400px']   //设置弹出层大小[宽，高]
                , offset: 'auto'   //设置弹出层位置 //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                , id: 'layerDemo_teacher1Id' + type //防止重复弹出，点击这个input只能有一个弹出层
                ,content:$("#layer_teacher1Id")   //弹出层内容为layer_ctname块，不能直接是表格id
                , btnAlign: 'c' //按钮居中
                , shade: 0 //不显示遮罩
                , yes: function () {  //确定按钮回调方法， 需要手动关闭弹出层
                    layer.closeAll();
                }
            });
        }
    }

    var active_layer_teacher2Id = {
        offset: function(othis) {
            var type = othis.data('type')  //给后面弹出层id用的

            layer.open({
                type: 1  //1为页面层
                ,title: '指导老师2编号'  //弹出层标题
                ,area: ['800px', '400px']   //设置弹出层大小[宽，高]
                , offset: 'auto'   //设置弹出层位置 //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                , id: 'layerDemo_teacher2Id' + type //防止重复弹出，点击这个input只能有一个弹出层
                ,content:$("#layer_teacher2Id")   //弹出层内容为layer_ctname块，不能直接是表格id
                , btnAlign: 'c' //按钮居中
                , shade: 0 //不显示遮罩
                , yes: function () {  //确定按钮回调方法， 需要手动关闭弹出层
                    layer.closeAll();
                }
            });
        }
    }

    //点击input，执行active_layer_ctname（展示比赛名称的弹出层），里面两行内容我没改，因为我也没看懂
    $('#get_tname').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });

    //点击input，执行active_layer_teacher1Id（展示指导老师的弹出层）
    $('#get_teacher1Id').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active_layer_teacher1Id[method] ? active_layer_teacher1Id[method].call(this, othis) : '';
    });

    //点击input，执行active_layer_teacher1Id（展示指导老师的弹出层）
    $('#get_teacher2Id').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active_layer_teacher2Id[method] ? active_layer_teacher2Id[method].call(this, othis) : '';
    });
    // 比赛名称弹出层>>表格
    table.render({
        elem: '#layer_com_table'
        ,height: 312
        ,url: '/getAllCom' //数据接口
        ,method:"get"
        ,page: true //开启分页
        ,toolbar:'#toolbar_ctname'
        ,cols: [
            [ //表头
                {type:'radio'}
                ,{field: 'ctid', title: '竞赛编号', width:103, sort: true}
                ,{field: 'ctname', title: '学科和科技竞赛名称', width:350}
                ,{field: 'host_unit', title: '主办单位', width:350}
            ]
        ]
    });
    // 指导老师1弹出层>>表格
    table.render({
        elem: '#layer_teacher1Id_table'
        ,height: 312
        ,url: '/getAllTeacher' //数据接口
        ,method:"get"
        ,page: true //开启分页
        ,toolbar:'#toolbar_teacher1Id'
        ,cols: [
            [ //表头
                {type:'radio'}
                ,{field: 'tno', title: '教师编号', width:103, sort: true}
                ,{field: 'tname', title: '教师名称', width:120}
                ,{field: 'tsex', title: '教师性别', width:120}
                ,{field: 'dcollege', title: '所属学院', width:120}
                ,{field: 'dname', title: '所属部门', width:120}
                ,{field: 'ttitle', title: '教师职称', width:120}
            ]
        ]
    });
    // 指导老师2弹出层>>表格
    table.render({
        elem: '#layer_teacher2Id_table'
        ,height: 312
        ,url: '/getAllTeacher' //数据接口
        ,method:"get"
        ,page: true //开启分页
        ,toolbar:'#toolbar_teacher2Id'
        ,cols: [
            [ //表头
                {type:'radio'}
                ,{field: 'tno', title: '教师编号', width:103, sort: true}
                ,{field: 'tname', title: '教师名称', width:120}
                ,{field: 'tsex', title: '教师性别', width:120}
                ,{field: 'dcollege', title: '所属学院', width:120}
                ,{field: 'dname', title: '所属部门', width:120}
                ,{field: 'ttitle', title: '教师职称', width:120}
            ]
        ]
    });
    // 比赛名称 >> 弹出层 >> 表格实例的单选框的选择的监听工作条
    table.on('toolbar(layer_com_table)', function(obj){//注：tool 是工具条事件名，layer_com_table 是 table 原始容器的属性 lay-filter="对应的值"
        var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
        switch(obj.event){
            case 'getCheckData_ctname':
                var data = checkStatus.data;  //获取选中行数据
                document.getElementById("get_tname").value = data[0].ctname;  //将获取的数据中的dno值给input
                /*'1:考试' '0:作品' */
                /*                    如果匹配到的成果类型为考试
                                    【参赛作品名称】【项目组长】【团队人数】【团队成员】消失*/
                if (data[0].result_type==1)
                {
                    $("#workName").removeAttr("lay-verify");
                    $("#div_workName,#div_textarea,#div_leader,#div_teamNum").addClass("disappear");
                    /*alert($("#div_workName").html());*/

                }
                //TODO
                //当用户又点击某些比赛的时候，有些条条要出来
                layer.closeAll(); //疯狂模式，关闭所有层
                break;
        };
    });

    // 指导老师1 >> 弹出层 >> 表格实例的单选框的选择的监听工作条
    table.on('toolbar(layer_teacher1Id_table)', function(obj){//注：tool 是工具条事件名，layer_com_table 是 table 原始容器的属性 lay-filter="对应的值"
        var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
        switch(obj.event){
            case 'getCheckData_teacher1Id':
                var data = checkStatus.data;  //获取选中行数据
                document.getElementById("get_teacher1Id").value = data[0].tno;  //将获取的数据中的dno值给input
                layer.closeAll(); //疯狂模式，关闭所有层
                break;
        };
    });

    // 指导老师2 >> 弹出层 >> 表格实例的单选框的选择的监听工作条
    table.on('toolbar(layer_teacher2Id_table)', function(obj){//注：tool 是工具条事件名，layer_com_table 是 table 原始容器的属性 lay-filter="对应的值"
        var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
        switch(obj.event){
            case 'getCheckData_teacher2Id':
                var data = checkStatus.data;  //获取选中行数据
                document.getElementById("get_teacher2Id").value = data[0].tno;  //将获取的数据中的dno值给input
                layer.closeAll(); //疯狂模式，关闭所有层
                break;
        };
    });

    //条件模糊查询
    var $ = layui.$, act = {
        reload: function () {
            var search_ctname = $('#search_ctname').val();
            //执行重载
            console.log(search_ctname);
            table.reload('layer_com_table', {   //layer_com_table为表格的id名
                method:'POST'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    ctname: search_ctname
                }
                ,url: '/competition/keyword_search'    //访问controller中的方法
            }, 'data');
        }
    };

    $('#search').on('click', function () {      //点击查询调用表格重载，这两行我也没太看懂，就会改个名
        var type = $(this).data('type');      //百度说固定用法，无需深究
        act[type] ? act[type].call(this) : '';   //不太懂，反正就开始重载 了
    });
});