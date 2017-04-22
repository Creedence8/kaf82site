package ru.kaf82.kaf82site.serviceImplementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import ru.kaf82.kaf82site.service.PropertyService;

/**
 * Реализация сервиса по работе с настройкам приложения
 * @author
 */
@Configuration
public class PropertyServiceImpl implements PropertyService {
    
    /**
     * Путь к Xml-файлу событий
     */
    @Value("${xml.pathToEvents}")
    private String pathToEventsXml;
    
    /**
     * Путь к Xml-файлу новостей
     */
    @Value("${xml.pathToNews}")
    private String pathToNewsXml;
    
    /**
     * Путь к Xml-файлу преподавателей
     */
    @Value("${xml.pathToPersons}")
    private String pathToPersonsXml;
    
    /***
     * Получить путь к Xml-файлу событий
     * @return строку пути к Xml-файлу событий
     */
    @Override
    public String getEventsXmlPath() {
        return pathToEventsXml;
    }
    
    /**
     * Получить путь к Xml-файлу новостей
     * @return строку пути к Xml-файлу новостей
     */
    @Override
    public String getNewsXmlPath() {
        return pathToNewsXml;
    }

    /**
     * Получить путь к Xml-файлу преподавателей
     * @return строку пути к Xml-файлу преподавателей
     */
    @Override
    public String getPersonsXmlPath() {
        return pathToPersonsXml;
    }
}
