package ru.kaf82.kaf82site.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Список ОД новостей с поддержкой Xml-сериализации
 * @author
 */
@XmlRootElement(name = "News")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewDtoContainer {
    
    /**
     * Список новостей
     */
    @XmlElement(name = "New")
    private List<NewDto> newDtos = null;

    /**
     * Геттер списка новостей
     * @return текущее значение
     */
    public List<NewDto> getNewDtos() {
        return newDtos;
    }
 
    /**
     * Сеттер списка новостей
     * @param newDtos Новое значение
     */
    public void setNewDtos(List<NewDto> newDtos) {
        this.newDtos = newDtos;
    }
}
