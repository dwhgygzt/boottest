package cn.guzt.boottest.base.exception;

import cn.guzt.boottest.base.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 公共异常
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVo<String> handleException(Exception e) {
        logger.debug("公共未定义异常-- begin：", e);
        logger.debug("公共未定义异常-- end");
        return ResponseVo.fail(ResponseVo.FAIL,ResponseVo.FAIL_MSG,e.getMessage());
    }

    /**
     * 自定义业务异常
     *
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseVo<String> handleBusinessException(BusinessException e) {
        logger.debug("BusinessException -- errorCode：{} errorMsg：{}", e.getErrorCode(), e.getErrorMsg());
        return ResponseVo.fail(e.getErrorCode(), e.getErrorMsg(),null);
    }

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.debug("MethodArgumentNotValidException -- errorMsg：{}", e.getMessage());
        return ResponseVo.fail(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
