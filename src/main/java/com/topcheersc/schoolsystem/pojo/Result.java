package com.topcheersc.schoolsystem.pojo;

public class Result<T> {
    
    private int code;
    private String msg;
    private int count;
    private T data;
    
    /**
     *  成功时候的调用
     * */
    public static  <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    
    public static  <T> Result<T> success(T data, int count){
        return new Result<T>(data,count);
    }
    
    /**
     *  失败时候的调用
     * */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }
    

/**
     * 成功的构造函数
     * @param data
     */
    private Result(T data){
        this.code=0;
        this.msg="";
        this.count=1000;
        this.data = data;
    }
    private Result(T data,int count){
        this.code=0;
        this.msg="";
        this.count=count;
        this.data = data;
    }
    
    private Result(int code, String msg ,int count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
    }
    /**
     * 失败的构造函数
     * @param code
     * @param msg
     */
    private Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}
