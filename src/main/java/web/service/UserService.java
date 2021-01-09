package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    /**
     * Создает нового клиента
     * @param user - клиент для создания
     */
    void createNewUser(User user);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<User> getAllUsers();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    User getCurrentUser(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param user - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    void update(User user, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    void delete(int id);
}
