package app.testDB.controller.mapperSuperclass;

import app.testDB.controller.Controller;
import app.testDB.domain.mappedSuperclass.Staff;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.mappedSuperclass.StaffResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/staff")
public final class StaffController implements Controller<StaffResource> {

    private final static Logger logger = Loggers.logger(StaffController.class);

    private final Repository<Staff> repository;

    public StaffController(@Qualifier("staffRepository") Repository<Staff> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody StaffResource staff) {
        logger.log(Level.INFO, "Request to server for posting staff {0}", staff);
        if (staff != null) {
            repository.persist(staff.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody StaffResource[] staffs) {
        logger.info("Request to server for posting staffs");
        if (staffs != null && staffs.length != 0) {
            repository.persistAll(Arrays.stream(staffs).map(StaffResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<StaffResource> getAll() {
        logger.info("Request to server for getting all staffs");
        return repository.select().stream().map(StaffResource::new).collect(Collectors.toList());
    }
}
