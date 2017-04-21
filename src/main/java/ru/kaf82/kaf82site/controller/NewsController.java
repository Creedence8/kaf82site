package ru.kaf82.kaf82site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kaf82.kaf82site.serviceImplementation.NewsXmlServiceImpl;

/**
 * Контроллер, отвечающий за новости (из списка на главной странице)
 * @author
 */
@Controller
public class NewsController {
    
    /**
     * Автоинициализируемое поле для Xml-сервиса новостей
     */
    @Autowired
    private NewsXmlServiceImpl newsService;
    
    /**
     * Обработка запроса новости
     * @param model Модель данных веб-страницы
     * @param id обязательный параметр - идентификатор новости
     * @return строку с названием веб-страницы для отображения
     */
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    String news(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("event", newsService.getNewById(id));
        return "eventView";
    }
}
