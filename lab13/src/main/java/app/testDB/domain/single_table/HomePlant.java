package app.testDB.domain.single_table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "home_plant")
public class HomePlant extends Plant {

    @Column
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "HomePlant{" + "sort='" + sort + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
