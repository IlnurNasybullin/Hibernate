package app.server.controller;

import app.server.domain.Language;
import app.server.service.TestService;
import app.server.utils.TranslateData;
import app.server.utils.TranslateQueryData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<TranslateData> get(@RequestBody TranslateQueryData queryData) {
        return service.getTranslateData(queryData);
    }

    @ResponseBody
    @PutMapping
    public Language update(@RequestParam Integer id, @RequestBody Language language) {
        return service.updateLanguage(id, language);
    }

    @DeleteMapping
    public void delete(@RequestParam String name) {
        service.deleteLanguageByName(name);
    }
}
