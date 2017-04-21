package ru.kaf82.kaf82site.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Объект данных для событий с поддержкой Xml-сериализации
 * @author 
 */
@XmlRootElement(name = "Event")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDto {
    
    /**
     * Идентификатор
     */
    @XmlAttribute
    private int id;
    
    /**
     * Дата
     */
    @XmlElement(name = "Date")
    private String date;
    
    /**
     * Заголовок
     */
    @XmlElement(name = "Title")
    private String title;
    
    /**
     * Текст
     */
    @XmlElement(name = "Text")
    private String text;
    
    /**
     * Конструктор по умолчанию (пустой)
     */
    public EventDto() { }
    
    /**
     * Конструктор с полной обязательной инициализацией полей
     * @param id Идентификатор
     * @param date Дата
     * @param title Заголовок
     * @param text Текст
     */
    public EventDto(int id, String date, String title, String text) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.text = text;
    }
    
    /**
     * Геттер индентификатора
     * @return текущее значение
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Сеттер инденфикатора
     * @param id Новое значение
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Геттер даты
     * @return текущее значение
     */
    public String getDate() {
        return this.date;
    }
    
    /**
     * Сеттер даты
     * @param date Новое значение
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Геттер заголовка
     * @return текущее значение
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Сеттер заголовка
     * @param title Новое значение
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Геттер текста
     * @return текущее значение
     */
    public String getText() {
        return this.text;
    }
    
    /**
     * Сеттер текста
     * @param text Новое значение
     */
    public void setText(String text) {
        this.text = text;
    }
}
