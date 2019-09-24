package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.demo.entities.Empresa;

@Transactional(readOnly = true)
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {

	public Empresa findByCnpj(String cnpjEmpresa);

}
