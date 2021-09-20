package br.univille.carlosribeirodacs2021.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {
    public ModelAndView index(){
        try {
            URL endereco = new URL("endereço do coleguinha");
            HttpURLConnection conn = (HttpURLConnection)endereco.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            conn.getResponseCode();
            int getResponseCode = conn.getResponseCode();
            System.out.println(getResponseCode);
            Scanner leitor = new Scanner(endereco.openStream());
            while(leitor.hasNext()){
                System.out.println(leitor.nextLine());
            }

        } catch (MalformedURLException e) {            
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("/importproduto/index");
    }
}
