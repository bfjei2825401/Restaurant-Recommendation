package com.fivetalk.userservice.util;

public class ResponseUtil {
    public static ResponseMsg success(Object object) {
        ResponseMsg msg = setMsg(200, "success");
        msg.setData(object);
        return msg;
    }


    public static ResponseMsg error(int code, String resultMsg, Object object) {
        ResponseMsg msg = setMsg(code, resultMsg);
        msg.setData(object);
        return msg;
    }

    private static ResponseMsg setMsg(int code, String resultMsg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(code);
        responseMsg.setMsg(resultMsg);
        return responseMsg;
    }
}
