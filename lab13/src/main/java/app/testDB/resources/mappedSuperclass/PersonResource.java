package app.testDB.resources.mappedSuperclass;

import app.testDB.domain.mappedSuperclass.Person;
import app.testDB.resources.AbstractResource;

public class PersonResource extends AbstractResource<Person> {

    protected String name;

    public PersonResource() { super();}

    public PersonResource(Person person) {
        super(person);
        this.name = person.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Person toEntity() {
        Person person = new Person();
        person.setId(getId());
        person.setName(name);

        return person;
    }

    @Override
    public String toString() {
        return "PersonResource{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
