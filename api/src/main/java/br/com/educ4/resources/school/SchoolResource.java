package br.com.educ4.resources.school;

import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.resources.school.request.CreateSchoolRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schools")
@RequiredArgsConstructor

public class SchoolResource {
    private final CreateSchoolPort createSchoolPort;
    @PostMapping
    public String post(@RequestBody CreateSchoolRequest request) {
        var school = request.toSchool();
        var response = createSchoolPort.execute(school);
        return response.getId();
    }
}
