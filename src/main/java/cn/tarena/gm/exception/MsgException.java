package cn.tarena.gm.exception;

/**
 * Created by Administrator on 2017/8/9.
 */
public class MsgException extends RuntimeException{

    public MsgException(){}
    public MsgException(String msg){
        super(msg);
    }
}
