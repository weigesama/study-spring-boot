package xyz.yuanwl.exception;

import xyz.yuanwl.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 匹配到这个异常处理器的请求，将会被转发到error页面
     * @param req 
     * @param e 
     * @return org.springframework.web.servlet.ModelAndView
     * @author Yuanwl
     * @date 2018-09-04 15:53:53
     * @version v1.0.0
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    /**
     * 匹配到这个异常处理器的请求，将会收到一个json响应——这是@ResponseBody的功效
     * @param req 
     * @param e 
     * @return ErrorInfo<java.lang.String>
     * @author Yuanwl
     * @date 2018-09-04 15:54:23
     * @version v1.0.0
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}

