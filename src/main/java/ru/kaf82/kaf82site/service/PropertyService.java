package ru.kaf82.kaf82site.service;

/**
 * Интерфейс сервиса по работе с настройкам приложения
 * @author
 */
public interface PropertyService {
    
    /***
     * Получить путь к Xml-файлу событий
     * @return строку пути к Xml-файлу событий
     */
    String getEventsXmlPath();
    
    /**
     * Получить путь к Xml-файлу новостей
     * @return строку пути к Xml-файлу новостей
     */
    String getNewsXmlPath();
    
    /**
     * Получить путь к Xml-файлу преподавателей
     * @return строку пути к Xml-файлу преподавателей
     */
    String getPersonsXmlPath();
}
