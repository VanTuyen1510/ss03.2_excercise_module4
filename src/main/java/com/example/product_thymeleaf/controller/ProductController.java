package com.example.product_thymeleaf.controller;

import com.example.product_thymeleaf.entity.Product;
import com.example.product_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ModelAndView displayProduct(){
        ModelAndView modelAndView = new ModelAndView("list","products",productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView viewDetail(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView("detail","productDetail",productService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView = new ModelAndView("createOrUpdate","product",new Product());
        modelAndView.addObject("typeOfProduct",new String[]{"xách tay","hàng ngoại","hàng nội","hàng thử nghiệm"});
        modelAndView.addObject("action","create");
        return  modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView formUpdate(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView("createOrUpdate","product",productService.findById(id));
        modelAndView.addObject("typeOfProduct",new String[]{"xách tay","hàng ngoại","hàng nội","hàng thử nghiệm"});
        modelAndView.addObject("action","update");
        return modelAndView;
    }
    @PostMapping("/createOrUpdate")
    public ModelAndView create(@ModelAttribute("product")Product p ,@RequestParam("action") String action){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        if("create".equals(action)){
            productService.add(p);
        }else {
            productService.update(p);
        }
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView doDelete(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        productService.delete(id);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView modelAndView(@RequestParam("search") String name ){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        productService.findByName(name);
        return modelAndView;
    }


}
