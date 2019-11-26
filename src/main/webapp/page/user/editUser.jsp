<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑学生信息</title>
<link rel="stylesheet" href="http://localhost:8080/schoolsystem/assets/libs/layui/css/layui.css" media="all">
<script src="http://localhost:8080/schoolsystem/assets/libs/layui/layui.js"></script>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body>
    <form class="layui-form" action="">

 <div class="layui-form-item">
  <div class="layui-inline">
      <label class="layui-form-label">id</label>
      <div class="layui-input-inline">
        <input name="id" lay-verify="required" readonly="" autocomplete="off" class="layui-input" type="text">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">姓名</label>
      <div class="layui-input-inline">
        <input name="name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">性别</label>
      <div class="layui-input-inline">
        <div class="layui-form">
            <select name="gender" id="gender" lay-filter="myselect">
		      <option value="1">男</option>
		      <option value="0">女</option>
            </select>
        </div>
      </div>
    </div>
   
    <div class="layui-inline">
      <label class="layui-form-label">年龄</label>
      <div class="layui-input-inline">
        <input name="age" lay-verify="required" autocomplete="off" class="layui-input" type="number">
      </div>
      <div class="layui-form-mid layui-word-aux">范围0-999</div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">出生日期</label>
      <div class="layui-input-inline">
        <input id="birthday" name="birthday" onclick="chooseDate()" lay-verify="required" autocomplete="off" class="layui-input" type="text">
      </div>
      <script>
	      function chooseDate() {
	    	  layui.use('laydate', function(){
	    		  var laydate = layui.laydate;
	    		  laydate.render({
	    		    elem: '#birthday' //指定元素
	    		    ,type: 'datetime'
	    		  });
	    		});
		}
      </script>
    </div>
    <div class="layui-inline">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="editStudent">立即提交</button>
    </div>
  </div>
</form>
    <script>
layui.use(['form', 'layedit'] ,function(){
  var $ = layui.jquery
  ,form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit; 
  var index = parent.layer.getFrameIndex(window.name); //修改成功的时候点击 确定 会关闭子窗口，这里获取一下子窗口
  form.render();
  //监听提交
  form.on('submit(editStudent)', function(data){ //这块要跟表单中的lay-filter="editStudent"对应
    $.ajax({          
              url: "http://localhost:8080/schoolsystem/user/editUser",       
              type: "post",                
              async: false,   //不要让它异步提交
              data: data.field,
              dataType: "json",       
              success: function (data) {      
                  if(data.code == 0){
                      layer.alert("修改成功",{icon: 1,time:2000},function () {
                            layer.close(layer.index); 
                            window.parent.location.reload();    //重新加载父页面，进行数据刷新
                        });   
                    } else{
                        layer.alert("修改失败",{icon: 2,time:2000});
                    }
                }   
            });  
    return false;
  });
   
});
</script>
    
    
</body>
</html>