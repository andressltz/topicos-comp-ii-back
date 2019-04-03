package br.feevale.bolao.interceptor;

import br.feevale.bolao.model.Success;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!request.getMethod().equals("OPTIONS") && ((HandlerMethod) handler).getMethod().getReturnType().getTypeName().equals("void")) {
            String json = new ObjectMapper().writeValueAsString(new Success());

            response.getOutputStream().write(json.getBytes());
        }

        super.postHandle(request, response, handler, modelAndView);
    }

}
