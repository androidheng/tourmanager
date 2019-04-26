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
           <table id="detail" lay-filter="detail" ></table>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>群组管理</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                            查询条件：
                      <div class="layui-inline">
                        <input type="text" id="demoReload" name="demoReload" lay-verify="required" autocomplete="off" placeholder="请输入联系电话" class="layui-input">  
                      </div>
                      <button class="layui-btn" data-type="reload">查询</button>
                    </div>
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.js"></script>
    
    <script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
       <a class="layui-btn layui-btn-info layui-btn-xs" lay-event="checkDetail">查看详情</a>
    </script>
     <script type="text/html" id="barDetail">
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
   
    <script>
  
   
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	 //展示已知数据
         table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'
          ,url:'<%=basePath%>swork/myWork'
          ,cols: [[ //标题栏
             {field: 'committime', title: '提交时间', }
            ,{field: 'status', title: '批改状态'}
            ,{field: 'teachername', title: '老师名字'}
            ,{field: 'score', title: '分数'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
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
    	             key: demoReload.val()
    	           }
    	         });
    	       }
    	     };
    	     
    	     $('.demoTable .layui-btn').on('click', function(){
    	       var type = $(this).data('type');
    	       active[type] ? active[type].call(this) : '';
    	     });
       
    
       //打开添加站点弹窗
       function getCitys(data){
    	   layer.open({
  	         type: 1
  	        ,title: false //不显示标题栏
  	        ,closeBtn: true
  	        ,area: ['600px','400px']
  	        ,shade: 0.8
  	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
  	        ,btnAlign: 'c'
  	        ,moveType: 1 //拖拽模式，0或者1
  	        ,content: $("#box"),
  	         success:function(layero, index){
  	           table.render({
  	             elem: '#detail'
  	            ,toolbar: '#toolbarDetail'
  	            ,url:'<%=basePath%>swork/myWork'
  	            ,cols: [[ //标题栏
  	               {field: 'committime', title: '提交时间', }
  	              ,{field: 'status', title: '批改状态'}
  	              ,{field: 'teachername', title: '老师名字'}
  	              ,{field: 'score', title: '分数'}
  	              ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
  	           ]]
  	          ,id:'testDetail'
  	          ,skin: 'line' //表格风格
  	          ,even: true
  	          ,page: true //是否显示分页
  	          ,limits: [5, 7, 10]
  	          ,limit: 5 //每页默认显示的数量
  	           });
  	           
  	         //监听行工具事件
  	         table.on('tool(detail)', function(obj){
  	           var data = obj.data;
  	           //console.log(obj)
  	           if(obj.event === 'del'){
  	             layer.confirm('真的删除行么', function(index){
  	          	  $.ajax({
  	                     url:"<%=basePath%>swork/delete",
  	                     type:'post',//method请求方式，get或者post
  	                     dataType:'json',//预期服务器返回的数据类型
  	                     data:JSON.stringify({id:data.id}),
  	                     contentType: "application/json; charset=utf-8",
  	                     success:function(res){//res为相应体,function为回调函数
  	                  	   obj.del();
  	                       layer.close(index);
  	                       $(".layui-laypage-btn")[0].click();
  	                     },
  	                     error:function(){
  	                         layer.alert('操作失败！！！',{icon:5});
  	                     }
  	                   });
  	             
  	             });
  	           } else{
  	          	 getCitys(data)
  	           }
  	         });
  	         }
  	        
  	       ,end:function(index){
  	        	layer.close(index)
  	        }
  	      });
  	   
       }
     
       //监听行工具事件
       table.on('tool(demo)', function(obj){
         var data = obj.data;
         //console.log(obj)
         if(obj.event === 'del'){
           layer.confirm('真的删除行么', function(index){
        	  $.ajax({
                   url:"<%=basePath%>swork/delete",
                   type:'post',//method请求方式，get或者post
                   dataType:'json',//预期服务器返回的数据类型
                   data:JSON.stringify({id:data.id}),
                   contentType: "application/json; charset=utf-8",
                   success:function(res){//res为相应体,function为回调函数
                	   obj.del();
                       layer.close(index);
                       $(".layui-laypage-btn")[0].click();
                    
                   },
                   error:function(){
                       layer.alert('操作失败！！！',{icon:5});
                   }
                 });
           
           });
         } else{
        	 getCitys(data)
         }
       });
     
});
   </script>
</body>
</html>