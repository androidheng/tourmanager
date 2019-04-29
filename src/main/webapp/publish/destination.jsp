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
        <form class="layui-form"  lay-filter="example">
           <div class="layui-form-item">
               <label class="layui-form-label">城市</label>
               <div class="layui-input-block">
                 <input type="text" name="city" id="city" required  lay-verify="required" placeholder="请输入城市" autocomplete="off" class="layui-input">
               </div>
           </div>
         
             <div class="layui-form-item">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="logo">logo</button> 
                    <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                                                                      预览图：
                      <div class="layui-upload-list" id="logoPre">
                          <img src="" class="layui-upload-img">
                      </div>
                   </blockquote>
                </div>
             </div>
           
           <div class="layui-form-item">
              <label class="layui-form-label">城市类型</label>
                <div class="layui-input-block">
                   <select id="citytypes" name="citytype" lay-verify="required">
                       <option value=""></option>
                       <option value="0">国内</option>
                       <option value="1"> 国外</option>
                  </select>
               </div>
           </div>
            <div class="layui-form-item">
             <label class="layui-form-label">年龄范围</label>
                 <div class="layui-input-block">
                   <input type="number" style="display:inline-block;width:45%" name="startage" id="startage" required lay-verify="required" placeholder="请输最小年龄" autocomplete="off" class="layui-input">
                   <input type="number" style="display:inline-block;width:45%" name="endage" id="endage" required lay-verify="required" placeholder="请输最大年龄" autocomplete="off" class="layui-input">
                 </div>
           </div>
           
           <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">城市简介</label>
                <div class="layui-input-block">
                   <textarea name="introduction" id="introduction" placeholder="请输入城市简介" class="layui-textarea"></textarea>
                </div>
           </div>
           <div class="layui-form-item">
             <label class="layui-form-label">攻略</label>
                 <div class="layui-input-block">
                   <textarea id="edit" name="content" style="display: none;" placeholder="请输入攻略"></textarea>
                 </div>
           </div>
           <div class="layui-form-item">
               <div class="layui-input-block">
                 <button class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo">立即提交</button>
                 <button type="reset" class="layui-btn layui-btn-primary">重置</button>
               </div>
             </div>
           
        </form>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>目的地信息</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                  
                     <div class="demoTable">
                                                                        目的地名称：
                       <div class="layui-inline">
                         <input type="text" id="demoReload"  lay-verify="required" autocomplete="off" placeholder="请输入目的地名称" class="layui-input">  
                       </div>
                       <div class="layui-inline">
                        <form class="layui-form" >
                                                                              城市类型
                         <div class="layui-inline">
                           <select  id="citytype" lay-verify="required">
                             <option value=""></option>
                             <option value="0">国内</option>
                             <option value="1">国外</option>
                           </select>
                        </div>
                        </form>
                      </div>
                      <div class="layui-inline">
                        <form class="layui-form" >
                                                                              状态
                         <div class="layui-inline">
                           <select  id="status" lay-verify="required">
                             <option value=""></option>
                             <option value="0">未审核</option>
                             <option value="1">已审核</option>
                           </select>
                        </div>
                        </form>
                      </div>
                      <button class="layui-btn" data-type="reload">查询</button>
                    </div>
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
     <%--<script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>--%>
   
     <script src="<%=basePath%>assets/layui.all.js"></script>  
    <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加目的地</button>
     </div>
    </script>
    
    <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-success layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
   
    <script>
    let logo = ''
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	//展示已知数据
        table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'
          ,url:'<%=basePath%>strategy/search'
          ,cols: [[ //标题栏
             {field: 'city', title: '城市', }
            ,{field: 'citytype', title: '城市类型'}
            ,{field: 'startage', title: '最小年龄'}
            ,{field: 'endage', title: '最大年龄'}
            ,{field: 'introduction', title: '目的地描述'}
            ,{field: 'status', title: '审核状态'}
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
    	         var citytype = $('#citytype');
    	         var status = $('#status');
    	         //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             key: demoReload.val(),
    	             citytype: citytype.val(),
    	             status: status.val(),
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
       function add(rowData){
    	   //console.log(rowData)
    	   rowData&&form.val('example', rowData)
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
    	        	   layui.use('layedit', function(){
    	                 var layedit = layui.layedit;
    	                 layedit.set({
    	                	  uploadImage: {
    	                	    url: '<%=basePath%>/upload' 
    	                	    ,type: '' //默认post
    	                	    
    	                	  }
    	                	});
    	                 layedit.build('edit'); //建立编辑器
    	               });
    	        	   //图片上传
    	             layui.use('upload',function(){
    	                 let upload = layui.upload;
    	                 upload.render({
    	                    elem: '#logo'
    	                   ,url: '<%=basePath%>/upload'
    	                   ,multiple: true
    	                   ,before: function(obj){
    	                   //预读本地文件示例，不支持ie8
    	                    obj.preview(function(index, file, result){
    	                     
    	                      //$('#demo2 img')
    	                      $('#logoPre').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
    	                    });
    	                  }
    	                   ,done: function(res){
    	                	   logo = res.message
    	                	   console.log(res)
    	                  //上传完毕
    	                   }
    	                });
    	              })

                       //提交
                  form.on('submit(formDemo)', function(data){
                	  data.field.logo =rowData?rowData.logo:logo;
                	  rowData&&(data.field.id=rowData.id)
                	  delete data.field.file
                	  $.ajax({
                          url:"<%=basePath%>strategy/addOrUpdate",
                          type:'post',//method请求方式，get或者post
                          dataType:'json',//预期服务器返回的数据类型
                          data:JSON.stringify(data.field),
                          contentType: "application/json; charset=utf-8",
                          success:function(res){//res为相应体,function为回调函数
                        	  if(res.success){
                        		  layer.alert('添加成功',{icon:1});
                        		  layer.close(index);
                                  $(".layui-laypage-btn")[0].click();
                        	  }
                       	     
                           
                          },
                          error:function(){
                              layer.alert('操作失败！！！',{icon:5});
                          }
                        });
                    layer.close(index)  //关闭弹窗
                    return false;
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
                   url:"<%=basePath%>strategy/delete",
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