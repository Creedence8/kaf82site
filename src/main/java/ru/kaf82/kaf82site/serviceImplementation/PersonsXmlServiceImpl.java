package ru.kaf82.kaf82site.serviceImplementation;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kaf82.kaf82site.dto.PersonDto;
import ru.kaf82.kaf82site.dto.PersonDtoContainer;
import ru.kaf82.kaf82site.service.PersonsXmlService;
import ru.kaf82.kaf82site.staticXML.Events;
import ru.kaf82.kaf82site.staticXML.Persons;

/**
 * Реализация сервиса Xml-обработки преподавателей
 * @author 
 */
@Service
public class PersonsXmlServiceImpl implements PersonsXmlService {
    
    /**
     * Строка сообщения "Запрошен несуществующий человек"
     */
    private final String unexistsMessage = "Запрошен несуществующий человек";
    
    /**
     * Автоинициализируемое поле для сервиса работы с настройкам приложения
     */
    @Autowired
    private PropertyServiceImpl properties;

    /**
     * Получение списка преподавателей
     * @return список событий
     */
    @Override
    public List<PersonDto> getAllPersons() {
        return this.getPersonsFromXml();
    }

    /**
     * Получение преподавателя по идентифиакатору
     * @param id Индетификатор
     * @return событие с данными в случае успешной работы или пустое событие в случае ошибки
     */
    @Override
    public PersonDto getPersonById(int id) {
        Optional<PersonDto> eventOp = this.getPersonsFromXml().stream().filter(person -> person.getId() == id).findFirst();
        if (eventOp.isPresent()) {
            return eventOp.get();
        }
        return new PersonDto(
                -1,
                unexistsMessage,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
               );
    }

    /**
     * Десериалзиация Xml-файла с преподавателями (указан в файле настроек)
     * @return писок преподавателей в случае успешной работы или пустой список в случае ошибки
     */
    private List<PersonDto> getPersonsFromXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonDtoContainer.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Reader personsReader = new StringReader(Persons.getPersons());
            PersonDtoContainer events = (PersonDtoContainer)jaxbUnmarshaller.unmarshal(personsReader);
            List<PersonDto> foo = events.getEventDtos();
            Reader personsReader2 = new StringReader(Persons.getPersons2());
            PersonDtoContainer events2 = (PersonDtoContainer)jaxbUnmarshaller.unmarshal(personsReader2);
            List<PersonDto> bar = events2.getEventDtos();
            foo.addAll(bar);
            return foo;
        }
        catch (JAXBException ex) {
            //ex.printStackTrace();
        }
        return new ArrayList<>();
    }
    
}
