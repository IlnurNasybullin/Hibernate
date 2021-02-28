package app.testDB.resources.mappedSuperclass;

import app.testDB.domain.mappedSuperclass.Client;

public final class ClientResource extends PersonResource {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ClientResource() {super();}

    public ClientResource(Client client) {
        super(client);
        this.age = client.getAge();
    }

    @Override
    public Client toEntity() {
        Client client = new Client();
        client.setId(getId());
        client.setAge(age);
        client.setName(getName());

        return client;
    }

    @Override
    public String toString() {
        return "ClientResource{" + "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
