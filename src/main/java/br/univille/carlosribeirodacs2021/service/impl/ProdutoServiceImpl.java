package br.univille.carlosribeirodacs2021.service.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.carlosribeirodacs2021.model.Fornecedor;
import br.univille.carlosribeirodacs2021.model.Produto;
import br.univille.carlosribeirodacs2021.service.ProdutoService;
import br.univille.carlosribeirodacs2021.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> getAllProdutos() {       
        return repository.findAll();
    }

    @Override
    public Produto save(Produto produto) {        
        return repository.save(produto);
    }

    @Override
    public void delete(Produto produto) {
        repository.delete(produto);       
    }

    @Override
    public List<Produto> importProduto(Fornecedor fornecedor) {
        if(fornecedor != null){
            try {
                URL endereco = new URL(fornecedor.getUrlAPI());
                HttpURLConnection conn = (HttpURLConnection)endereco.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCode = conn.getResponseCode();
                if(responseCode == 200){ 

                    try (java.util.Scanner leitor = new Scanner(endereco.openStream())) {

                        StringBuilder jsonText = new StringBuilder();
                        while(leitor.hasNext()){
                            jsonText.append(leitor.nextLine());
                        }

                        Gson gson = new Gson();
    
                        Type typeListProdutos = new TypeToken<ArrayList<Produto>>(){}.getType();
                        ArrayList<Produto> listaProdutos = gson.fromJson(jsonText.toString(), typeListProdutos);
                        return listaProdutos;
                        
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }return new ArrayList<Produto>();
    }    
}
