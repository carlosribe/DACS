package br.univille.carlosribeirodacs2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.carlosribeirodacs2021.model.Fornecedor;

@Service
public interface FornecedorService {
    public List<Fornecedor> getAllFornecedores();
    public Fornecedor save(Fornecedor fornecedor);
    public void delete(Fornecedor fornecedor);
}
