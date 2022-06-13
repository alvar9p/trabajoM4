package web;

import datos.FacilitadorDAO;
import dominio.Facilitador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Facilitador")
public class ControladorFacilitador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Facilitador> facilitadores = new FacilitadorDAO().listar();
        System.out.println(facilitadores + "<br>");
        request.setAttribute("facilitador", facilitadores);

        request.getRequestDispatcher("/WEB-INF/facilitador/facilitadores.jsp").forward(request, response);
    }
}
