package web;

import datos.CursoDAO;
import dominio.Curso;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Curso")
public class ControladorCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCurso(request, response);
                    break;
                case "modificar":
                    this.modificarCurso(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCurso(request, response);
                    break;
                case "editar":
                    this.editarCurso(request, response);
                    break;
                case "eliminar":
                    this.eliminarCurso(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    public void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Curso> cursos = new CursoDAO().listar();
        System.out.println(cursos);
        request.setAttribute("cursos", cursos);

        int cantidad = cursos.size();
        request.setAttribute("totalCursos", cantidad);

        request.getRequestDispatcher("/WEB-INF/curso/cursos.jsp").forward(request, response);
    }

    public void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("codigo");
        String email = request.getParameter("nombre");
        int idFac = Integer.parseInt(request.getParameter("idFac"));
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        Curso curso = new Curso(nombre, email, idFac, out);
        System.out.println("curso = " + curso);

        int registrosModificados = new CursoDAO().insertar(curso);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void editarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar el id del estudiante
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));

        // Voy a recibir solo el ID del estudiante a editar
        Curso curso = new CursoDAO().encontrar(new Curso(idCurso));
        request.setAttribute("curso", curso);

        String jspEditar = "/WEB-INF/curso/cursoModificar.jsp";

        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void modificarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperamos los valores del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("codigo");
        String email = request.getParameter("nombre");
        int idFac = Integer.parseInt(request.getParameter("idFac"));
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        // Creamos el objeto Estudiante (Modelo)
        Curso curso = new Curso(id, nombre, email, idFac, out);

        // Lo modificamos en la BD
        int registrosModificados = new CursoDAO().actualizar(curso);
        System.out.println("registrosModificados = " + registrosModificados);
        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recuperamos los valores del formulario
        int id = Integer.parseInt(request.getParameter("idCurso"));

        Curso curso = new Curso(id);
        // Lo modificamos en la BD
        int registrosModificados = new CursoDAO().eliminar(curso);
        System.out.println("registrosModificados = " + registrosModificados);

        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
