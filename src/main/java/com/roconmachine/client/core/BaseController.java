package com.roconmachine.client.core;

import com.roconmachine.client.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Authors
 * roconmachine@gmail.com Rezaul Hasan
 * Application settings
 * ajax loader
 * detault page redirect
 * app state params
 */

/// TODO : invoke methods require optimization

@Component
public abstract class BaseController<T extends AppRequest> {
    private static final String MODEL_ATTR_NAME = "model";
    protected String targetView = "test";
    protected boolean redirect = false;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ListableBeanFactory beanFactory;

    @GetMapping
    public String get(Model model,
                      HttpSession session,
                      @RequestParam Map<String, String> queryParams,
                      @PathVariable Map<String, String> pathVars
    ) {

        this.invokeContribute(model,session, Method.GET);
        this.invokeContributeForController(model,session, Method.GET);
        model.addAttribute(MODEL_ATTR_NAME, handleGet(session, queryParams, pathVars));
        queryParams.forEach(model::addAttribute);
        pathVars.forEach(model::addAttribute);
        return (redirect) ? "redirect:" + targetView : targetView;
    }

    @PostMapping
    public String post(HttpServletRequest request,
                       @ModelAttribute(MODEL_ATTR_NAME) T domain,
                       HttpSession session,
                       @RequestHeader Map<String, String> headers,
                       Model model,
                       @RequestParam Map<String, String> params) {
        if(domain != null) domain.getParameters().putAll(headers);
        this.invokeContribute(model,session, Method.POST);
        this.invokeContributeForController(model,session, Method.POST);

        String nextMapping = handlePost(domain, session, model);
        return nextMapping != null && !nextMapping.isEmpty() ? nextMapping : targetView;
    }

    private void invokeContribute(Model model, HttpSession session, Method method) {
        getContributors(null)
                .forEach(
                        requestContributor ->
                        {
                            if (method.equals(Method.GET)) requestContributor.contributeGet(model, session);
                            else if(method.equals(Method.POST)) requestContributor.contributePost(model, session);
                        }
                );
    }

    private void invokeContributeForController(Model model, HttpSession session, Method method){

        getContributors(identifyYourself())
                .forEach(
                        requestContributor ->
                        {
                            if (method.equals(Method.GET)) requestContributor.contributeGet(model, session);
                            else if(method.equals(Method.POST)) requestContributor.contributePost(model, session);
                        }
                );
    }

    private List<RequestContributor> getContributors(Class<?> controllerClass){
        return applicationContext.getBeansOfType(RequestContributor.class)
                .values()
                .stream()
                .filter(requestContributor -> {
                    TargetController target = requestContributor.getClass().getAnnotation(TargetController.class);
                    if (controllerClass == null)
                        return target == null;
                    return target != null && target.value().equals(controllerClass);
                })
                .toList();
    }

    /*
    To identify which type of controller. return class type
    return LoginController.class;
     */
    protected abstract Class<?> identifyYourself();

    /*
        Method triggers when post request processed
     */
    protected abstract String handlePost(T domain,HttpSession session, Model model);
    /*
        Method triggers when get request processed
     */
    protected abstract T handleGet(HttpSession session, Map<String, String> queryParams, Map<String, String> pathVars);


    /*
        This method will enable attributes to support the page during get request.
        It will call just before get method returning.
         */
    protected abstract HashMap<String, Object> attach();

}
