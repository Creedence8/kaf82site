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
import ru.kaf82.kaf82site.dto.NewDto;
import ru.kaf82.kaf82site.dto.NewDtoContainer;
import ru.kaf82.kaf82site.service.NewsXmlService;

/**
 * Реализация сервиса Xml-обработки новостей
 * @author
 */
@Service
public class NewsXmlServiceImpl implements NewsXmlService {
    
    /**
     * Строка сообщения "Запрошена несуществующая новость"
     */
    private final String unexistsMessage = "Запрошена несуществующая новость";
    
    /**
     * Автоинициализируемое поле для сервиса работы с настройкам приложения
     */
    @Autowired
    private PropertyServiceImpl properties;
    
    /**
     * Получение списка новостей
     * @return список событий
     */
    @Override
    public List<NewDto> getAllNews() {
        return this.getNewsFromXml();
    }
    
    /**
     * Получение новости по идентифиакатору
     * @param id Индетификатор
     * @return новость с данными в случае успешной работы или пустая новость в случае ошибки
     */
    @Override
    public NewDto getNewById(int id) {
        Optional<NewDto> newOp = this.getNewsFromXml().stream().filter(newOne -> newOne.getId() == id).findFirst();
        if (newOp.isPresent()) {
            return newOp.get();
        }
        return new NewDto(-1, null, unexistsMessage, null, null);
    }
    
    /**
     * Десериалзиация Xml-файла с новостями (указан в файле настроек)
     * @return список новостей в случае успешной работы или пустой список в случае ошибки
     */
    private List<NewDto> getNewsFromXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NewDtoContainer.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(properties.getNewsXmlPath());
            NewDtoContainer news = (NewDtoContainer)jaxbUnmarshaller.unmarshal(file);
            return news.getNewDtos();
        }
        catch (JAXBException ex) {
            //ex.printStackTrace();
        }
        return new ArrayList<>();
    }
}
