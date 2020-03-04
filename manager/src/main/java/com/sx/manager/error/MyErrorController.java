package com.sx.manager.error;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : Anui
 * @date : 2020/3/3
 * @time : 14:51
 * @Description :自定义错误处理Controller
 */
public class MyErrorController extends BasicErrorController {

    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }
    /**
     * {
     *     x"timestamp": "2020-03-03 15:02:13",
     *     x"status": 500,
     *     x"error": "Internal Server Error",
     *     x"exception": "java.lang.IllegalArgumentException",
     *     "message": "编号不可为空",
     *     x"path": "/manager/products"
     *     + code
     *     + canRetry
     * }
     */
    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        Map<String, Object> attrs = super.getErrorAttributes(request, includeStackTrace);
        attrs.remove("timestamp");
        attrs.remove("status");
        attrs.remove("error");
        attrs.remove("exception");
        attrs.remove("path");
        String errorCode = (String) attrs.get("message");
        ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
        attrs.put("message", errorEnum.getMessage());
        attrs.put("code", errorEnum.getCode());
        attrs.put("canRetry",errorEnum.isCanRetry());
        return attrs;
    }
}
