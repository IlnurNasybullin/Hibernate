package app.testDB.resources.table_per_class;

import app.testDB.domain.table_per_class.CombatStyle;
import app.testDB.domain.table_per_class.WarriorUnit;

import java.util.Locale;

public final class WarriorUnitResource extends UnitResource {

    private String combatStyle;

    public WarriorUnitResource() {
        super();
    }

    public WarriorUnitResource(WarriorUnit unit) {
        super(unit);
        this.combatStyle = unit.getCombatStyle().name().toLowerCase(Locale.ROOT);
    }

    public String getCombatStyle() {
        return combatStyle;
    }

    public void setCombatStyle(String combatStyle) {
        this.combatStyle = combatStyle;
    }

    @Override
    public WarriorUnit toEntity() {
        WarriorUnit warriorUnit = new WarriorUnit();
        warriorUnit.setId(id);
        warriorUnit.setCombatStyle(CombatStyle.valueOf(combatStyle));
        warriorUnit.setHealth(health);
        warriorUnit.setName(name);

        return warriorUnit;
    }

    @Override
    public String toString() {
        return "WarriorUnitResource{" + "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", combatStyle=" + combatStyle +
                '}';
    }
}
