package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring con Model!");

		return "index";
	}

	@GetMapping("/perfil")
	public String pefil(Model model) {
		Usuario usuario = new Usuario();

		usuario.setNombre("Roberto");
		usuario.setApellido("Sánchez");
		usuario.setEmail("roberto@correo.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");

		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		return Arrays.asList(	new Usuario("Andrés", "Guzman", "andres@correo.com"),
								new Usuario("Roberto", "Sánchez", "roberto@correo.com"),
								new Usuario("John", "Doe", "john@correo.com"),
								new Usuario("Jane", "Doe", "jane@correo.com"));
	}

}
