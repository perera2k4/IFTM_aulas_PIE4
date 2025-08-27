package br.edu.iftm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
