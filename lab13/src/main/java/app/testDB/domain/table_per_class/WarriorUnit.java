package app.testDB.domain.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "warrior_unit")
public final class WarriorUnit extends Unit {

    @Column(name = "combat_style")
    @Enumerated(EnumType.STRING)
    private CombatStyle combatStyle;

    public CombatStyle getCombatStyle() {
        return combatStyle;
    }

    public void setCombatStyle(CombatStyle combatStyle) {
        this.combatStyle = combatStyle;
    }

    @Override
    public String toString() {
        return "WarriorUnit{" + "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", combatStyle=" + combatStyle +
                '}';
    }
}
