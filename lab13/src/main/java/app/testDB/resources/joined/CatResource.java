package app.testDB.resources.joined;

import app.testDB.domain.joined.Cat;

public final class CatResource extends AnimalResource {

    private Byte kids;

    public CatResource() {
        super();
    }

    public CatResource(Cat cat) {
        super(cat);
        this.kids = cat.getKids();
    }

    public Byte getKids() {
        return kids;
    }

    public void setKids(Byte kids) {
        this.kids = kids;
    }

    @Override
    public Cat toEntity() {
        Cat cat = new Cat();
        cat.setId(id);
        cat.setName(name);
        cat.setKids(kids);

        return cat;
    }

    @Override
    public String toString() {
        return "CatResource{" + "id=" + id +
                ", name='" + name + '\'' +
                ", kids=" + kids +
                '}';
    }
}
