package app.testDB.resources.single_table;

import app.testDB.domain.single_table.HomePlant;

public final class HomePlantResource extends PlantResource {

    private String sort;

    public HomePlantResource() {
        super();
    }

    public HomePlantResource(HomePlant plant) {
        super(plant);
        this.sort = plant.getSort();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "HomePlantResource{" + "id=" + id +
                ", sort='" + sort + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public HomePlant toEntity() {
        HomePlant homePlant = new HomePlant();
        homePlant.setId(id);
        homePlant.setName(name);
        homePlant.setSort(sort);

        return homePlant;
    }
}
