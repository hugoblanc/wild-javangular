package com.wildapi.api.services.daybook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/daybooks")
public class DaybookController {

    @Autowired
    DaybookService service;

    @GetMapping()
    public List<Daybook> getDaybooks(@RequestParam(name = "start", required = false) @DateTimeFormat(pattern = "MMddyyyy") Date startDate, @RequestParam(name = "end", required = false) @DateTimeFormat(pattern = "MMddyyyy") Date endDate) {

        System.out.println(startDate.toString());
        System.out.println(endDate.toString());
        return service.getAll(startDate, endDate);
    }


    @PostMapping()
    public Daybook postDaybook(@RequestBody Daybook daybook) {
        return service.save(daybook);
    }

    @PutMapping("/{id}")
    public Daybook putDaybook(@PathVariable("id") Long id, @RequestBody Daybook daybook) {
        return service.update(daybook, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDaybook(@PathVariable("id") Long id){
        service.delete(id);
    }
}
