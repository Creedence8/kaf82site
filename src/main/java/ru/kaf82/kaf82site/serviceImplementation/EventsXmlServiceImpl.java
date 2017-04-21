package ru.kaf82.kaf82site.serviceImplementation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kaf82.kaf82site.dto.EventDto;
import ru.kaf82.kaf82site.dto.EventDtoContainer;
import ru.kaf82.kaf82site.service.EventsXmlService;

/**
 * Реализация сервиса Xml-обработки событий
 * @author
 */
@Service
public class EventsXmlServiceImpl implements EventsXmlService {
    
    /**
     * Строка сообщения "Запрошено несуществующее событие"
     */
    private final String unexistsMessage = "Запрошено несуществующее событие";
    
    /**
     * Автоинициализируемое поле для сервиса работы с настройкам приложения
     */
    @Autowired
    private PropertyServiceImpl properties;
    
    /**
     * Получение списка событий
     * @return список событий
     */
    @Override
    public List<EventDto> getAllEvents() {
        return this.getEventsFromXml();
    }
    
    /**
     * Получение события по идентифиакатору
     * @param id Индетификатор
     * @return событие с данными в случае успешной работы или пустое событие в случае ошибки
     */
    @Override
    public EventDto getEventById(int id) {
        Optional<EventDto> eventOp = this.getEventsFromXml().stream().filter(event -> event.getId() == id).findFirst();
        if (eventOp.isPresent()) {
            return eventOp.get();
        }
        return new EventDto(-1, null, unexistsMessage, null);
    }
    
    /**
     * Десериалзиация Xml-файла с событиями (указан в файле настроек)
     * @return список событий в случае успешной работы или пустой список в случае ошибки
     */
    private List<EventDto> getEventsFromXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EventDtoContainer.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File("/xml/events.xml");
            EventDtoContainer events = (EventDtoContainer)jaxbUnmarshaller.unmarshal(file);
            return events.getEventDtos();
        }
        catch (JAXBException ex) {
            //ex.printStackTrace();
        }
        return new ArrayList<>();
    }
    
}
