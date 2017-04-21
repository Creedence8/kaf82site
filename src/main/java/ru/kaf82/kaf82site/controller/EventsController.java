package ru.kaf82.kaf82site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kaf82.kaf82site.serviceImplementation.EventsXmlServiceImpl;

/**
 * Контроллер, отвечающий за события (из списка на главной странице)
 * @author 
 */
@Controller
public class EventsController {
    
    /**
     * Автоинициализируемое поле для Xml-сервиса событий
     */
    @Autowired
    private EventsXmlServiceImpl eventsService;
    
    /**
     * Обработка запроса события
     * @param model Модель данных веб-страницы
     * @param id обязательный параметр - идентификатор события
     * @return строку с названием веб-страницы для отображения
     */
    @RequestMapping("/events")
    String events(Model model, @RequestParam(value = "id") int id){
        model.addAttribute("event", eventsService.getEventById(id));
        return "eventView";
    }
}
