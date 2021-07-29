package com.init.Markertper.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.Markertper.api.modelo.Usuario;

public interface IUsuarioService {
	public List<Usuario>BuscarTodosUsuario();
	public Optional<Usuario>BuscarPorIdUsuario(int idUsuario);
	public int guardarUsuario(Usuario u);
	public void eliminarUsuario(int idUsuario);
}
