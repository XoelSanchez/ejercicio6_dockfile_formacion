package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	RestTemplate template;
	
	private String url = "http://servicio-cursos/";
	
	@Override
	public List<Formacion> cursos() {
		List<Formacion> formaciones = new ArrayList<Formacion>();
		
		List<Curso> cursos = Arrays.asList(template.getForObject(url + "cursos", Curso[].class));
		if (cursos != null && !cursos.isEmpty()) {
			cursos.forEach((c)-> {
				if (c.getDuracion() >= 50) {
					formaciones.add(new Formacion(c.getNombre(), 10, c.getPrecio()));
				} else {
					formaciones.add(new Formacion(c.getNombre(), 5, c.getPrecio()));
				}
			});
		}
		
		return formaciones;
	}
	
	@Override
	public void nuevoCurso(Formacion formacion) {
		int duracionCurso = formacion.getAsignaturas() * 10;
		String codCurso = formacion.getCurso().substring(0, 3) + duracionCurso;
		
		Curso cursoExistente = template.getForObject(url + "curso/{codCurso}", Curso.class, codCurso); 
		
		if (cursoExistente == null ) {
			Curso curso = new Curso(codCurso, formacion.getCurso(), duracionCurso, formacion.getPrecio());
			
			template.postForLocation(url + "altaCurso", curso);
		}
	}
	
	
}
