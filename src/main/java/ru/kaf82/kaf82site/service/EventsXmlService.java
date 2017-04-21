package ru.kaf82.kaf82site.service;

import java.util.List;
import ru.kaf82.kaf82site.dto.EventDto;

/**
 * Интерфейс сервиса Xml-обработки событий
 * @author
 */
public interface EventsXmlService {
    
    /**
     * Получение списка событий
     * @return список событий
     */
    List<EventDto> getAllEvents();
    
    /**
     * Получение события по идентифиакатору
     * @param id Индетификатор
     * @return событие с данными в случае успешной работы или пустое событие в случае ошибки
     */
    EventDto getEventById(int id);
    
}
