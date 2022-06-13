package datos;

public class Apuntes {
    /*
    
    Considerando esta BD, escribe una aplicación en JEE que implementa lógica de Servlets,
    Vistas JSP, DAO aplicando el patrón MVC según los siguientes requerimientos:
    
    1. Crea una página de inicio que señale tus datos (nombre y curso), incluye un menú
    para acceder a todas las opciones del proyecto.
    
    2. De las 4 tablas antes descritas, escribe al menos 2 mantenedores que
    implementen el CRUD correspondiente.
    
    3. Estos CRUD deben considerar la implementación de vistas que permitan
    visualizar todos los registros, editar uno en particular, actualizar los datos, crear
    nuevos registros y eliminar un registro.
    
    4. Sube tu proyecto a GitHub, y déjalo publico.
    
    5. Incluye archivo README.md que describa los objetivos de la aplicación, autor/a
    y url del repositorio GitHub.
    
    select * from estudiante inner join matricula
    on estudiante.id = matricula.id_estudiante inner join curso
    on matricula.id_curso = curso.id inner join facilitador
    on curso.id_facilitador = facilitador.id
    
    SELECT e.nombre, c.nombre FROM estudiante AS e INNER JOIN matricula AS m ON e.id = m.id_estudiante
    INNER JOIN curso AS c ON m.id_estudiante = c.id WHERE e.id = 1;
    
    DATA TABLE JQUERY
    
     */
}
