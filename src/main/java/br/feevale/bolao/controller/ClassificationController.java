package br.feevale.bolao.controller;

import br.feevale.bolao.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("classification")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/teams")
    public Object teams() {
        return classificationService.getTeamsClassification();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Object users() {
        return classificationService.getUsersClassification();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/round/{number}")
    public Object users(@PathVariable("number") int number) {
        return classificationService.getRound(number);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public void update() {
        classificationService.update();
    }
}
