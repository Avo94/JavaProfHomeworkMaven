package Prof33Homework_15_06_2023;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeaController {

    private List<Tea> teaList = new ArrayList<>();

    @GetMapping("/teaList")
    public Iterable<Tea> getTeaList() {
        return teaList;
    }

    @PostMapping("/teaList/addTea")
    public Tea createTea(@RequestBody Tea tea) {
        teaList.add(tea);
        return tea;
    }
}