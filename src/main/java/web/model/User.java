package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Поле не должно быть пустым!")
    @Size(min = 2, max = 25, message = "от 2 до 25 символов")
    private String name;
    @NotEmpty(message = "Поле не должно быть пустым!")
    @Column(name = "last_name")
    private String surname;
    @NotEmpty(message = "Поле не должно быть пустым!")
    @Email(message = "Не корректно указан адрес эл.почты")
    private String email;

    public User() {
    }

    // Конструктор для UserDaoArrayListImpl - id поле в реальной БД будет присваиваться автоматически
    public User(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
