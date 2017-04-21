package ru.kaf82.kaf82site.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kaf82.kaf82site.dto.EventDto;
import ru.kaf82.kaf82site.dto.NewDto;
import ru.kaf82.kaf82site.serviceImplementation.EventsXmlServiceImpl;
import ru.kaf82.kaf82site.serviceImplementation.NewsXmlServiceImpl;

/**
 * Контроллер, отвечающий за главную страницу
 * @author
 */
@Controller
public class IndexController {
    
    /**
     * Автоинициализируемое поле для Xml-сервиса новостей
     */
    @Autowired
    private NewsXmlServiceImpl newsService;
    
    /**
     * Автоинициализируемое поле для Xml-сервиса событий
     */
    @Autowired
    private EventsXmlServiceImpl eventsService;
    
    /**
     * Обработка запроса главной страницы
     * @param model Модель данных веб-страницы
     * @return строку с названием веб-страницы для отображения
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model) {
        
        List<NewDto> newsList = newsService.getAllNews();
        newsList.sort((NewDto a, NewDto b) -> { return a.getId() - b.getId(); });
        model.addAttribute("news", newsList);
        
        List<EventDto> eventsList = eventsService.getAllEvents();
        eventsList.sort((EventDto a, EventDto b) -> { return b.getId() - a.getId(); });
        model.addAttribute("events", eventsList);
        
        return "indexView";
    }
}
