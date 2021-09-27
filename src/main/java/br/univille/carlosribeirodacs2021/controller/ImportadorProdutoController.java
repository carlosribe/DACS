package br.univille.carlosribeirodacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.carlosribeirodacs2021.model.Fornecedor;
import br.univille.carlosribeirodacs2021.service.FornecedorService;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ModelAndView index(){
        List<Fornecedor> listaFornecedor = fornecedorService.getAllFornecedores();

        return new ModelAndView("/importproduto/index", "listaFornecedor", listaFornecedor);
    }
}