package com.flower.api.interceptor;

import com.flower.common.bean.BaseBean;
import com.flower.common.bean.ResponseResult;
import com.flower.common.exception.BizException;
import com.flower.common.exception.SysException;
import com.flower.common.utils.DateUtils;
import com.flower.common.utils.JsonUtil;
import com.flower.common.utils.LoggerUtil;
import com.flower.core.bean.RecordBean;
import com.flower.core.utils.RequestPool;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cyk
 * @date 2018/8/15/015 11:27
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Aspect
@Component
public class UserActionInterceptor {

    private String [] exclusionIntercept = new String [] {};

    private String [] exclusionRecord = new String [] {};

    @Around("execution(* com.flower.api.ctrl..*.*(..))")
    public Object action(ProceedingJoinPoint proceedingJoinPoint){

        // 获取request 对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // RequestPool 中放入当前请求对象
        RequestPool.set(request);

        ResponseResult result = null;
        RecordBean recordBean = null;
        String requestMethod = request.getMethod();
        String url = request.getRequestURL().toString();

        // 用户 登陆 注册 没有操作对象与内容
        // TODO: 2018/8/15/015
//        String operateId = String.valueOf(RequestPool.getUserId());
//        String operateName = RequestPool.getUserName();
        String operateTime = DateUtils.getNowTimeString(DateUtils.DATE_PATTERN_4);
        // 不拦截进行记录
        // TODO: 2018/8/15/015

        // 获取方法中的所有参数
        Map<String,Object> param = new HashMap<>();
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object obj: args) {
            if (obj instanceof BaseBean || obj instanceof Map){ // body中的参数,body参数只使用BaseBean 实现类后者Map接收
                param.put("body",obj);
            }
        }
        // 获取url后拼接的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        param.put("formData",parameterMap);
        // 获取pathvarieable中的参数
        Map attribute = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        param.put("pathVariable",attribute);
        LoggerUtil.info(this.getClass(),"请求参数:"+this.getClass(),JsonUtil.objToJson(param));
        Object proceed = null;
        try {
            if (proceedingJoinPoint != null){
                // @ResponseBody 的返回结果
                proceed = proceedingJoinPoint.proceed();
                result = ResponseResult.ok();
                result.setData(proceed);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 抛出异常，否则异常无法进行处理
            if (throwable instanceof BizException){
                BizException biz = (BizException) throwable;
                result = new ResponseResult();
                result.setStatusCode(biz.getErrorCode().getCode());
                result.setStatusString(biz.getErrorCode().getReturnMsg());
            }else if (throwable instanceof SysException){
                SysException sysException= (SysException) throwable;
                result = new ResponseResult();
                result.setStatusCode(-1);
                result.setStatusString(sysException.getMessage());
            }else {
                result = ResponseResult.error();
            }
        } finally {
            RequestPool.remove();
        }
        recordBean = new RecordBean();
        recordBean.setParam(JsonUtil.objToJson(param));
        recordBean.setResult(JsonUtil.objToJson(result));
//        recordBean.setOperateId(operateId);
//        recordBean.setOperateName(operateName);
        recordBean.setOperateTime(operateTime);
        recordBean.setRequestMethod(requestMethod);
        recordBean.setUrl(url);
        // TODO: 2018/8/15/015  插入到mongo中 子线程

        return result;
    }


    /**
     * 获取请求Body
     *
     * @param inputStream
     *
     * @return
     */
    public String getBodyString(final InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
