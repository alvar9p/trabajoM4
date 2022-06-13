package web;

import datos.EstudianteDAO;
import dominio.Estudiante;
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

@WebServlet("/ControladorEstudiante")
public class ControladorEstudiante extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEstudiante(request, response);
                    break;
                case "modificar":
                    this.modificarEstudiante(request, response);
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
                    this.insertarEstudiante(request, response);
                    break;
                case "editar":
                    this.editarEstudiante(request, response);
                    break;
                case "eliminar":
                    this.eliminarEstudiante(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    public void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Estudiante> estudiantes = new EstudianteDAO().listar();
        System.out.println(estudiantes);
        request.setAttribute("estudiantes", estudiantes);
        System.out.println("estudiantes = " + estudiantes);
        
        int cantidad = estudiantes.size();
        request.setAttribute("totalEstudiantes", cantidad);
        
        request.getRequestDispatcher("/WEB-INF/estudiante/estudiantes.jsp").forward(request, response);
    }

    public void insertarEstudiante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario 
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        // Creando el objeto a Insertar (Sin ID porque es AI)
        Estudiante estudiante = new Estudiante(rut, nombre, email, telefono, out);
        System.out.println(estudiante);

        int registrosModificados = new EstudianteDAO().insertar(estudiante);
        System.out.println("registrosModificados = " + registrosModificados);
        
        this.accionDefault(request, response);
    }

    private void editarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar el id del estudiante
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));

        // Voy a recibir solo el ID del estudiante a editar
        Estudiante estudiante = new EstudianteDAO().encontrar(new Estudiante(idEstudiante));
        request.setAttribute("estudiante", estudiante);

        String jspEditar = "/WEB-INF/estudiante/estudianteModificar.jsp";

        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void modificarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperamos los valores del formulario
        int id = Integer.parseInt(request.getParameter("idEstudiante"));
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        // Creamos el objeto Estudiante (Modelo)
        Estudiante estudiante = new Estudiante(id, rut, nombre, email, telefono, out);
        
        // Lo modificamos en la BD
        int registrosModificados = new EstudianteDAO().actualizar(estudiante);
        System.out.println("registrosModificados = " + registrosModificados);
        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
     private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        // Recuperamos los valores del formulario
        int id = Integer.parseInt(request.getParameter("idEstudiante"));
        
        Estudiante estudiante = new Estudiante(id);
        // Lo modificamos en la BD
        int registrosModificados = new EstudianteDAO().eliminar(estudiante);
        System.out.println("registrosModificados = " + registrosModificados);
        
        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
