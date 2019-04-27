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
        <form class="layui-form" action="" lay-filter="formTest">
           <div class="layui-form-item layui-form-text">
               <label class="layui-form-label">消息内容</label>
               <div class="layui-input-block">
                 <textarea name="content" id="content" placeholder="请输入消息内容" class="layui-textarea"></textarea>
               </div>
           </div>
        </form>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>消息列表</a>
                </span>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                       用户名称：
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
     <script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
    <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加消息</button>
     </div>
    </script>
    
    <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-success layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
   
    <script>
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	//展示已知数据
        table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'

          ,url:'<%=basePath%>message/search'
          ,cols: [[ //标题栏
             {field: 'content', title: '消息内容', }
            ,{field: 'createtime', title: '创建时间'}
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
    	             key: demoReload.val(),
    	           
    	           }
    	         });
    	       }
    	     };
    	     
    	     $('.demoTable .layui-btn').on('click', function(){
    	       var type = $(this).data('type');
    	       active[type] ? active[type].call(this) : '';
    	     });
       
    
      
       //头工具栏事件
       table.on('toolbar(demo)', function(obj){
    	  switch(obj.event){
    	  case 'add':
    	        add()
    	       break;
    	         
    	  };
       });
       function add(data){
    	   layer.open({
    	         type: 1
    	        ,title: false //不显示标题栏
    	        ,closeBtn: true
    	        ,area: ['600px','400px']
    	        ,shade: 0.8
    	        ,btn:['确定']
    	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
    	        ,btnAlign: 'c'
    	        ,moveType: 1 //拖拽模式，0或者1
    	        ,content: $("#box"),
    	         success:function(layero, index){
    	        	 data?$("#content").val(data.content):$("#content").val('')
    	        	 form.render(); 
    	     }
      	    ,yes:function(index){
      	    	let parames = {
      	    			content:$("#content").val(),
      	    	}
      	    	data&&(parames.id=data.id)
      	    	$.ajax({
                      url:"<%=basePath%>message/addOrUpdate",
                      type:'post',//method请求方式，get或者post
                      dataType:'json',//预期服务器返回的数据类型
                      data:JSON.stringify(parames),
                      contentType: "application/json; charset=utf-8",
                      success:function(res){//res为相应体,function为回调函数
                   	      layer.close(index);
                          $(".layui-laypage-btn")[0].click();
                       
                      },
                      error:function(){
                          layer.alert('操作失败！！！',{icon:5});
                      }
                    });
      	         }
    	        
    	       ,end:function(index){
    	        	layer.close(index)
    	        }
    	      })
       }
       //监听行工具事件
       table.on('tool(demo)', function(obj){
         var data = obj.data;
         //console.log(obj)
         if(obj.event === 'del'){
           layer.confirm('真的删除行么', function(index){
        	  $.ajax({
                   url:"<%=basePath%>message/delete ",
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
         }else{
        	 add(data)
         }
       });
     
});
   </script>
</body>
</html>