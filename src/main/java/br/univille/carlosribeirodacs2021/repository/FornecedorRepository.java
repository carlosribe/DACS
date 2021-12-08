package br.univille.carlosribeirodacs2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.carlosribeirodacs2021.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{
    
 }
