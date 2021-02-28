package app.testDB.resources.table_per_class;

import app.testDB.domain.table_per_class.HeroClass;
import app.testDB.domain.table_per_class.HeroUnit;

import java.util.Locale;

public final class HeroUnitResource extends UnitResource {

    private String heroClass;

    public HeroUnitResource() {
        super();
    }

    public HeroUnitResource(HeroUnit unit) {
        super(unit);
        this.heroClass = unit.getHeroClass().name().toLowerCase(Locale.ROOT);
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    @Override
    public HeroUnit toEntity() {
        HeroUnit heroUnit = new HeroUnit();
        heroUnit.setHeroClass(HeroClass.valueOf(heroClass));
        heroUnit.setId(id);
        heroUnit.setHealth(health);
        heroUnit.setName(name);

        return heroUnit;
    }

    @Override
    public String toString() {
        return "HeroUnitResource{" + "id=" + id +
                ", heroClass='" + heroClass + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
