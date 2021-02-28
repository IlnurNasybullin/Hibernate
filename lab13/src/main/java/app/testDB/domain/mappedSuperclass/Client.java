package app.testDB.domain.mappedSuperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends Person {

    @Column
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
