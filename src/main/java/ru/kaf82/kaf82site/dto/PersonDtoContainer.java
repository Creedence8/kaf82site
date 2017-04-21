package ru.kaf82.kaf82site.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Список ОД преподавателей с поддержкой Xml-сериализации
 * @author
 */
@XmlRootElement(name = "Persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDtoContainer {
    
    /**
     * Список преподавателей
     */
    @XmlElement(name = "Person")
    private List<PersonDto> personDtos = null;
 
    /**
     * Геттер списка преподавателей
     * @return текущее значение
     */
    public List<PersonDto> getEventDtos() {
        return personDtos;
    }
 
    /**
     * Сеттер списка преподавателей
     * @param personDtos Новое значение
     */
    public void setEventDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
    }
}
