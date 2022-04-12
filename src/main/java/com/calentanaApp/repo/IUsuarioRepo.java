package com.calentanaApp.repo;

import com.calentanaApp.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>  {

	//from usuario where username = ?
	Usuario findOneByUsername(String username);	
}
