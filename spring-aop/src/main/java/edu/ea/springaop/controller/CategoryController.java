package edu.ea.springaop.controller;


 
import edu.ea.springaop.dto.FullCategoryDto;
import edu.ea.springaop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping
    List<FullCategoryDto> findAll()
    {
        return categoryService.findAll();
    }

    @GetMapping("/search")
    FullCategoryDto findById(@RequestParam Integer id) throws Exception {
        return categoryService.findById(id);
    }

    @PostMapping
    FullCategoryDto add ( @RequestBody  FullCategoryDto fullCategoryDto)  {
        return categoryService.add(fullCategoryDto);
    }


    @PutMapping("/{id}")
    FullCategoryDto update (@PathVariable Integer id,@RequestBody  FullCategoryDto fullCategoryDto) throws Exception {
        return categoryService.update(id,fullCategoryDto);
    }

    @DeleteMapping("/{id}")
    Boolean delete (@PathVariable Integer id ) throws Exception {
        return categoryService.delete(id);
    }




}

