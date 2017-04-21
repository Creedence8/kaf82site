package ru.kaf82.kaf82site.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Объект данных преподавателя с поддержкой Xml-сериализации
 * @author
 */
@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDto {
    
    /* --- Атрибуты --------------------------------------------------------- */
    
    /**
     * Идентификатор
     */
    @XmlAttribute(name = "id")
    private int id;
    
    /**
     * ФИО
     */
    @XmlAttribute(name = "FIO")
    private String name;
    
    /**
     * Название фотографии в /images/photos
     */
    @XmlAttribute(name = "Photo")
    private String photo;
    
    /**
     * Номер телефона
     */
    @XmlAttribute(name = "Phone")
    private String phone;
    
    /**
     * Электронная почта
     */
    @XmlAttribute(name = "Email")
    private String email;
    
    /**
     * Научная степень
     */
    @XmlAttribute(name = "Phd")
    private String degree;
    
    /**
     * Должность
     */
    @XmlAttribute(name = "Position")
    private String position;
    
    /**
     * Роль (зачем нужно???)
     */
    @XmlAttribute(name = "Post")
    private String post;
    
    /* --- Элементы --------------------------------------------------------- */
    
    /**
     * Профиль
     */
    @XmlElement(name = "Profile")
    private String profile;
    
    /**
     * Карьера
     */
    @XmlElement(name = "Career")
    private String career;
    
    /**
     * Образовательная работа
     */
    @XmlElement(name = "Educational_work")
    private String eduWork;
    
    /**
     * Научная работа
     */
    @XmlElement(name = "Scientific_work")
    private String sciWork;
    
    /**
     * Публикации
     */
    @XmlElement(name = "Publications")
    private String publications;
    
    /* --- Конструкторы ----------------------------------------------------- */
    
    /**
     * Конструктор по умолчанию (пустой)
     */
    public PersonDto() { }
    
    /**
     * Конструктор с полной обязательной инициализацией полей
     * @param id Идентификатор
     * @param name ФИО
     * @param photo Фото
     * @param phone Номер телефона
     * @param email Электронная почта
     * @param degree Научная степень
     * @param position Должность
     * @param post Роль
     * @param profile Профиль
     * @param career Карьера
     * @param eduWork Обр. работа
     * @param sciWork Научная работа
     * @param publications Публикации
     */
    public PersonDto(
            int id,
            String name,
            String photo,
            String phone,
            String email,
            String degree,
            String position,
            String post,
            String profile,
            String career,
            String eduWork,
            String sciWork,
            String publications) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.phone = phone;
        this.email = email;
        this.degree = degree;
        this.position = position;
        this.post = post;
        this.profile = profile;
        this.career = career;
        this.eduWork = eduWork;
        this.sciWork = sciWork;
        this.publications = publications;
    }
    
    /* --- Геттеры и сеттеры ------------------------------------------------ */
    
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
     * Геттер ФИО
     * @return текущее значение
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Сеттер ФИО
     * @param name Новое значение
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Геттер фото
     * @return текущее значение
     */
    public String getPhoto() {
        return this.photo;
    }
    
    /**
     * Сеттер фото
     * @param photo Новое значение
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    /**
     * Геттер номера телефона
     * @return текущее значение
     */
    public String getPhone() {
        return this.phone;
    }
    
    /**
     * Сеттер номера телефона
     * @param phone Новое значение
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Геттер почты
     * @return текущее значение
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * Сеттер почты
     * @param email Новое значение
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Геттер степени
     * @return текущее значение
     */
    public String getDegree() {
        return this.degree;
    }
    
    /**
     * Сеттер степени
     * @param degree Новое значение
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    /**
     * Геттер должности
     * @return текущее значение
     */
    public String getPosition() {
        return this.position;
    }
    
    /**
     * Сеттер должности
     * @param position Новое значение
     */
    public void setPosition(String position) {
        this.position = position;
    }
    
    /**
     * Геттер роли
     * @return текущее значение
     */
    public String getPost() {
        return this.post;
    }
    
    /**
     * Сеттер роли
     * @param post Новое значение
     */
    public void setPost(String post) {
        this.post = post;
    }
    
    /**
     * Геттер профиля
     * @return текущее значение
     */
    public String getProfile() {
        return this.profile;
    }
    
    /**
     * Сеттер профиля
     * @param profile Новое значение
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    /**
     * Геттер карьеры
     * @return текущее значение
     */
    public String getCareer() {
        return this.career;
    }
    
    /**
     * Сеттер карьеры
     * @param career Новое значение
     */
    public void setCareer(String career) {
        this.career = career;
    }
    
    /**
     * Геттер обр. работы
     * @return текущее значение
     */
    public String getEduWork() {
        return this.eduWork;
    }
    
    /**
     * Сеттер обр. работы
     * @param eduWork Новое значение
     */
    public void setEduWork(String eduWork) {
        this.eduWork = eduWork;
    }
    
    /**
     * Геттер научной работы
     * @return текущее значение
     */
    public String getSciWork() {
        return this.sciWork;
    }
    
    /**
     * Сеттер научной работы
     * @param sciWork Новое значение
     */
    public void setSciWork(String sciWork) {
        this.sciWork = sciWork;
    }
    
    /**
     * Геттер научной работы
     * @return текущее значение
     */
    public String getPublications() {
        return this.publications;
    }
    
    /**
     * Сеттер научной работы
     * @param publications Новое значение
     */
    public void setPublications(String publications) {
        this.publications = publications;
    }
}
