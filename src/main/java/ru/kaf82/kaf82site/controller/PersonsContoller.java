package ru.kaf82.kaf82site.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kaf82.kaf82site.dto.PersonDto;
import ru.kaf82.kaf82site.serviceImplementation.PersonsXmlServiceImpl;

/**
 * Контроллер, отвечающий за страницы с сотрудниками
 * @author 
 */
@Controller
public class PersonsContoller {
    
    /**
     * Автоинициализируемое поле для Xml-сервиса сотрудников
     */
    @Autowired
    private PersonsXmlServiceImpl personsService;
    
    /**
     * Обработка запросов страницы списка сотрудников
     * @param model Модель данных веб-страницы
     * @return строку с названием веб-страницы для отображения
     */
    @RequestMapping("/allpersons")
    String allpersons(Model model) {
        model.addAttribute("title", "Сотрудники кафедры");
        model.addAttribute("contentFragment", "allpersons");
        model.addAttribute("contentView", "fragments/menu/allpersons");
        
        List<PersonDto> personsList = personsService.getAllPersons();
        personsList.sort((PersonDto a, PersonDto b) -> { return a.getId() - b.getId(); });
        model.addAttribute("persons", personsList);
        
        return "recordView";
    }
    
    /**
     * Обработка запросов страницы информации о сотруднике
     * @param model Модель данных веб-страницы
     * @param id обязательный параметр - идентификатор сотрудника
     * @return строку с названием веб-страницы для отображения
     */
    @RequestMapping("/person")
    String person(Model model, @RequestParam(value = "id") int id) {
        PersonDto person = personsService.getPersonById(id);
        
        model.addAttribute("title", person.getName());
        model.addAttribute("contentFragment", "person");
        model.addAttribute("contentView", "fragments/menu/person");
        model.addAttribute("person", person);
        
        return "recordView";
    }
}
