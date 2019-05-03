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
           <div class="layui-form-item">
               <label class="layui-form-label">用户名</label>
               <div class="layui-input-block">
                 <input type="text" name="username" id="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
               </div>
           </div>
           <div class="layui-form-item">
             <label class="layui-form-label">密码</label>
                 <div class="layui-input-inline">
                   <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                 </div>
           </div>
           <div class="layui-form-item">
              <label class="layui-form-label">角色类型</label>
                <div class="layui-input-block">
                   <select id="usertypes" name="usertypes" lay-verify="required">
                       <option value=""></option>
                       <option value="1">用户管理者</option>
                       <option value="2">发布信息者</option>
                       <option value="3">审核信息者</option>
                  </select>
               </div>
           </div>
        </form>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>统计信息</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                        景点名称：
                      <div class="layui-inline">
                         <input type="text" id="demoReload"  lay-verify="required" autocomplete="off" placeholder="请输入景点名称" class="layui-input">  
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
          ,toolbar: '#toolbarDemo'

          ,url:'<%=basePath%>tickets/search'
          ,cols: [[ //标题栏
             {field: 'username', title: '用户名' }
            ,{field: 'attrname', title: '景点'}
            ,{field: 'price', title: '单价'}
            ,{field: 'quantity', title: '数量' }
            ,{field: 'sumprice', title: '总价' }
            ,{field: 'createtime', title: '购票时间' }
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
    	         var usertype = $('#usertype');
    	         //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             key: demoReload.val(),
    	             usertype: usertype.val(),
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
     
});
   </script>
</body>
</html>