package app.testDB.resources.mappedSuperclass;

import app.testDB.domain.mappedSuperclass.Staff;

public final class StaffResource extends PersonResource {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public StaffResource() {
        super();
    }

    public StaffResource(Staff staff) {
        super(staff);
        this.position = staff.getPosition();
    }

    @Override
    public Staff toEntity() {
        Staff staff = new Staff();
        staff.setId(getId());
        staff.setName(getName());
        staff.setPosition(position);

        return staff;
    }

    @Override
    public String toString() {
        return "StaffResource{" + "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
