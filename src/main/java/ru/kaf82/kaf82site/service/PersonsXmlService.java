package ru.kaf82.kaf82site.service;

import java.util.List;
import ru.kaf82.kaf82site.dto.PersonDto;

/**
 * Интерфейс сервиса Xml-обработки преподавателей
 * @author 
 */
public interface PersonsXmlService {
    
    /**
     * Получение списка преподавателей
     * @return список событий
     */
    List<PersonDto> getAllPersons();
    
    /**
     * Получение преподавателя по идентифиакатору
     * @param id Индетификатор
     * @return событие с данными в случае успешной работы или пустое событие в случае ошибки
     */
    PersonDto getPersonById(int id);
    
}
