package com.example.web;

import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", products);
        return "list-product";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product(null,null));
        return "add-product";
    }

    @PostMapping("/add")
    public String addProductSubmit(@ModelAttribute Product product) {
        products.add(product);
        return "redirect:/";
    }
}
