package com.topcheersc.schoolsystem.pojo;

public class CodeMsg {
    
    private int code;
    private String msg;
    
    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg DELETE_ERROR = new CodeMsg(500100, "删除失败");
    public static CodeMsg UPDATE_ERROR = new CodeMsg(500101, "修改失败");
    public static CodeMsg SAVE_ERROR = new CodeMsg(500102, "添加失败");
    public static CodeMsg BIND_ERROR = new CodeMsg(500103, "参数校验异常：%s");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    
    
    private CodeMsg( ) {
    }
            
    private CodeMsg( int code,String msg ) {
        this.code = code;
        this.msg = msg;
    }
   

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
    
}
