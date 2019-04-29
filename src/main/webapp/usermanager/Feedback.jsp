<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
   
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-view-body">
     <div class="layui-content" id="box" style="display:none">
        
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>反馈列表</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                        用户名：
                      <div class="layui-inline">
                         <input type="text" id="demoReload"  lay-verify="required" autocomplete="off" placeholder="请输入用户名" class="layui-input">  
                      </div>
                      <button class="layui-btn" data-type="reload">查询</button>
                    </div>
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
  <script src="<%=basePath%>assets/layui.all.js"></script>
   <script>
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	//展示已知数据
        table.render({
           elem: '#demo'
          ,url:'<%=basePath%>feedback/search'
          ,cols: [[ //标题栏
             {field: 'username', title: '用户名', }
            ,{field: 'content', title: '反馈内容'}
            ,{field: 'createtime', title: '反馈时间'}
           
         ]]
        ,id:'testReload'
        ,skin: 'line' //表格风格
        ,even: true
        ,page: true //是否显示分页
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
       });
       var  active = {
    	       reload: function(){
    	         var demoReload = $('#demoReload');
    	         //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             key: demoReload.val(),
    	           
    	           }
    	         });
    	       }
    	     };
    	     
    	     $('.demoTable .layui-btn').on('click', function(){
    	       var type = $(this).data('type');
    	       active[type] ? active[type].call(this) : '';
    	     });
         });
   </script>
</body>
</html>