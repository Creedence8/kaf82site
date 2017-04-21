package ru.kaf82.kaf82site.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kaf82.kaf82site.exceptions.ResourceNotFoundException;

/**
 * Контроллер, отвечающий за страницы, доступные из меню, кроме сотрудников
 * @author
 */
@Controller
public class MenuController {
    
    /**
     * Названия и заголовки страниц меню
     */
    private static final Map<String, String> MENU_ITEMS = new HashMap<String, String>() {{
        put("master", "Программа подготовки бакалавров");
        put("bakalavr", "Программа подготовки магистров");
        put("science", "Научные исследования");
        put("allpersons", "Сотрудники кафедры");
        put("videos", "Видеоматериалы и записи лекций");       
        put("contacts", "Контакты");
    }};
    
    /**
     * Обработка запросов страниц меню
     * @param model Модель данных веб-страницы
     * @param item обязательный параметр - название страницы меню
     * @return строку с названием веб-страницы для отображения
     */
    @RequestMapping("/{item}")
    String menu(Model model, @PathVariable String item) {
        if (MENU_ITEMS.keySet().contains(item)) {
            model.addAttribute("title", MENU_ITEMS.getOrDefault(item, item));
            model.addAttribute("contentFragment", item);
            model.addAttribute("contentView", "fragments/menu/" + item);
            return "recordView";
        }
        throw new ResourceNotFoundException();
    }
}
