package app.testDB.resources.joined;

import app.testDB.domain.joined.Animal;
import app.testDB.resources.AbstractResource;

public class AnimalResource extends AbstractResource<Animal> {

    protected String name;

    public AnimalResource() {
        super();
    }

    public AnimalResource(Animal animal) {
        super(animal);
        this.name = animal.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Animal toEntity() {
        Animal animal = new Animal();
        animal.setId(id);
        animal.setName(name);

        return animal;
    }

    @Override
    public String toString() {
        return "AnimalResource{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
