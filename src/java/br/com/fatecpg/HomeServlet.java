/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Weslley
 */
public class HomeServlet extends HttpServlet {

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
            out.println("<style>");
	    out.println("body{");                
		out.println("background-image: url(bg.jpg);");
		out.println("background-attachment:fixed;}");
		out.println("background-size: cover;");
		out.println("background-repeat:no-repeat;");
		out.println("}");
	    out.println("</style>");
            out.println("<title>Servlet HomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
          out.println("<h1 style= color:#fff;font-family:Arial>GROUP ONE</h1>");  
	out.println("<p  style= color:#fff;font-family:Arial;font-size:26p;x>Projeto realizado para"); 
         out.println("a disciplina de Programação 	");   
	out.println("orientada a Objeto. <br> Ministrada pelo professor ");
	
       out.println("Ricardo Pupo Larguesa.Fatec Praia Grande."); 
        
                
	out.println ("<h2 style= color:#fff;font-family:Arial>PROGRAMAÇÃO ORIENTADA A OBJETO</h2>");
	out.println("<a href='index.html'><img src=\"btn_volta.png\"/></a>");
        
        out.println("<a href='juros-simples.html'><img src=\"btn_juros.png\"/></a>");
	out.println("<a href='juros-compostos.html'><img src=\"btn_juroc.png\"/></a>");
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
