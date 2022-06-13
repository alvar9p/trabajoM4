package web;

import datos.MatriculaDAO;
import dominio.Matricula;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Matricula")
public class ControladorMatricula extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Matricula> matriculas = new MatriculaDAO().listar();
        System.out.println(matriculas);
        request.setAttribute("matriculas", matriculas);
        
        request.getRequestDispatcher("/WEB-INF/matricula/matriculas.jsp").forward(request, response);
    }
    
}
