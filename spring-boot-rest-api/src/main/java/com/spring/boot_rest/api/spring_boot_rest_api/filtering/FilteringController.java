package com.spring.boot_rest.api.spring_boot_rest_api.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", " value3", "value4");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4")
        );
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filteringDynamic() {

        SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue filteringListDynamic() {
        List<SomeBean> someBeanList = Arrays.asList(
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4")
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanList);

        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;

    }
}
