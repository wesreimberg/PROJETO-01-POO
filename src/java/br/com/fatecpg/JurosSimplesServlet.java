/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Positivo
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<Style>");
            out.println("a:link, a:active, a:visited{");
            out.println("color: Black;");
            out.println("text-decoration: none;}");
            out.println("body{");                
            out.println("background-image: url(bg.jpg);");
            out.println("background-attachment:fixed;");
            out.println("background-size: cover;");
            out.println("background-repeat:no-repeat;");
            out.println("}");
           
            out.println("  body.center-form {\n" +
"    min-height: 50vh;\n" +
"  }\n" +
"\n" +
"  div.center-form {\n" +
"    position: relative;\n" +
"    min-height: 50vh;\n" +
"  }\n" +
"\n" +
"  div.center-form > form {\n" +
"    position: absolute;\n" +
"    top: 50%;\n" +
"    left: 50%;\n" +
"    transform: translateY(-50%) translateX(-50%);\n" +
"  }");
            
            
            
            out.println("</Style>");
            out.println("<title>Calcular Juros Simples</title>");            
            out.println("</head>");
            out.println("<body class=\"center-form\">\n" +
                "<div class=\"center-form\">");
             out.println("<a href='home.html'><img src=\"btn_volta.png\"/></a>");
             out.println("<a href=\'juros-compostos.html'\"><img src=\"btn_juroc.png\"/></a>");
            
            out.println("<hr/>");
            
            out.println("<form>");
            out.println("<form action='juros-simples.html'>");
                 out.println("<h1 style= color:#fff;font-family:Arial> Juros Simples </h1>");
            
                 out.println("<label style= color:#fff;font-family:Arial>Capital</label>");
                 out.println("<br>");            
                 out.println("<input type='text' name='capital'/>");
                 out.println("<br>");
            
                 out.println("<label style= color:#fff;font-family:Arial>Taxa (%)</label>");
                 out.println("<br>");            
                 out.println("<input type='text' name='taxa'/>");
                 out.println("<br>");
            
                out.println("<label style= color:#fff;font-family:Arial>Tempo (meses)</label>");
                out.println("<br>");            
                out.println("<input type='text' name='tempo'/>");            
                out.println("<br>");
                
            
                out.println("<input type='submit' name='Calcular'/>");
            out.println("</form>");
             out.println("</form>");
            out.println("</div>");
        
            
            Float valorCapital = Float.parseFloat(request.getParameter("capital"));
            Double valorTaxa = Double.parseDouble(request.getParameter("taxa"));
            int valorTempo = Integer.parseInt(request.getParameter("tempo"));
            
            Float montante = valorCapital * (1 + (float)(valorTaxa / 100)* valorTempo);
            Float juros = valorCapital *(float) (valorTaxa / 100)* valorTempo;
            
            out.println("<hr/>");
            out.println("<h1 style= color:#fff;font-family:Arial>O valor do  Juros  é: R$"+ juros + " </h1>");
             out.println("<h1 style= color:#fff;font-family:Arial>A soma do Montante é: R$"+ montante + " </h1>");
             
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
