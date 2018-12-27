package com.fivetalk.restaurantservice.util;

public class ResponseUtil {
    public static ResponseMsg success(Object object) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(200);
        responseMsg.setMsg("success");
        responseMsg.setData(object);
        return responseMsg;
    }

    public static ResponseMsg success() {
        return success("");
    }

    public static ResponseMsg error(int code, String resultMsg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(code);
        responseMsg.setMsg(resultMsg);
        return responseMsg;
    }
}
