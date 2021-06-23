package br.univille.carlosribeirodacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.univille.carlosribeirodacs2021.model.Produto;
import br.univille.carlosribeirodacs2021.service.ProdutoService;

@Controller
@RequestMapping("/produto")

public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping      
    public ModelAndView index(){

        List<Produto> listaProdutos = service.getAllProdutos();

        return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
    }
}
