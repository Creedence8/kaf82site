package ru.kaf82.kaf82site.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Список ОД событий с поддержкой Xml-сериализации
 * @author
 */
@XmlRootElement(name = "Events")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDtoContainer {
    
    /**
     * Список событий
     */
    @XmlElement(name = "Event")
    private List<EventDto> eventDtos = null;
 
    /**
     * Геттер списка событий
     * @return текущее значение
     */
    public List<EventDto> getEventDtos() {
        return eventDtos;
    }
 
    /**
     * Сеттер списка событий
     * @param eventDtos Новое значение
     */
    public void setEventDtos(List<EventDto> eventDtos) {
        this.eventDtos = eventDtos;
    }
}
