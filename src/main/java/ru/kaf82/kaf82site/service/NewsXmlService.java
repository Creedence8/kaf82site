package ru.kaf82.kaf82site.service;

import java.util.List;
import ru.kaf82.kaf82site.dto.NewDto;

/**
 * Интерфейс сервиса Xml-обработки новостей
 * @author
 */
public interface NewsXmlService {
    
    /**
     * Получение списка новостей
     * @return список событий
     */
    List<NewDto> getAllNews();
    
    /**
     * Получение новости по идентифиакатору
     * @param id Индетификатор
     * @return новость с данными в случае успешной работы или пустая новость в случае ошибки
     */
    NewDto getNewById(int id);
    
}
