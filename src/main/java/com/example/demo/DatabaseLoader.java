package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final AlumnoRepository repositoryAlumno;
	private final CursoRepository repositoryCurso;
	private final MatriculaRepository repositorioMatricula;
	private final SeccionRepository repositorioSeccion;


	@Autowired
	public DatabaseLoader(AlumnoRepository repositoryAlumno, CursoRepository repositoryCurso,
						  MatriculaRepository repositorioMatricula, SeccionRepository repositorioSeccion) {
		this.repositoryAlumno = repositoryAlumno;
		this.repositoryCurso = repositoryCurso;
		this.repositorioMatricula = repositorioMatricula;
		this.repositorioSeccion = repositorioSeccion;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repositoryAlumno.save(new Alumno("Marcos", "Pimentel", "LN78451236"));
		this.repositoryAlumno.save(new Alumno("Juan", "Sandoval", "SM65329874"));
		this.repositoryAlumno.save(new Alumno("Jose", "Portocarrero Mio", "SM79541238"));

		//Alumno
		Alumno a1 = new Alumno("David", "Salinas Portilla", "PI73117002");
		this.repositoryAlumno.save(a1);

		this.repositoryCurso.save(new Curso("Aplicaciones Móviles", "4"));
		this.repositoryCurso.save(new Curso("Gestión de proyectos", "3"));
		
		//Curso
		Curso c1 = new Curso("Servicios Web", "4");
		this.repositoryCurso.save(c1);

		//Seccion
		Seccion s = new Seccion("V.05.2023-IIE");
		this.repositorioSeccion.save(s);

		//Matricula o Registro
		this.repositorioMatricula.save(new Matricula(s,a1,c1));
	}
}