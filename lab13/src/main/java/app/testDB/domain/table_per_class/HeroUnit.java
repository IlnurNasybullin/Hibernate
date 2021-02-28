package app.testDB.domain.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "hero_unit")
public class HeroUnit extends Unit {

    @Column(name = "class")
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    @Override
    public String toString() {
        return "HeroUnit{" + "heroClass=" + heroClass +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
