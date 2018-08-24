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
 * @author MateusVidalMarinho
 */
@WebServlet(name = "JurosCompostosServlet", urlPatterns = {"/juros-compostos.html"})
public class JurosCompostosServlet extends HttpServlet {

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
            out.println("<title>Calcular Juros Composto</title>");            
            out.println("</head>");
            out.println("<body class=\"center-form\">\n" +
                "<div class=\"center-form\">");
             out.println("<a href='home.html'><img src=\"btn_volta.png\"/></a>");
             out.println("<a href='juros-simples.html'><img src=\"btn_juros.png\"/></a>");
            
            out.println("<hr/>");
            
            out.println("<form action='juros-composto.html'>");
                 out.println("<h1 style= color:#fff;font-family:Arial> Juros Composto </h1>");
            
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
            out.println("</div>");
        
            
            // Pegando parâmetros
            Float capital = Float.parseFloat(request.getParameter("capital"));
            Double taxa = Double.parseDouble(request.getParameter("taxa"));
            int tempo = Integer.parseInt(request.getParameter("tempo"));

            // Declarando variáveis
            double montante, jurosAcumulado, juros, valor, elevado, aux;
            taxa = taxa / 100;
            aux = 0;

            // Formatando valor
            DecimalFormat formatacao = new DecimalFormat("###,##0.00");
            for (int i = 0; i <= tempo; i++) {
                if (i == 0) {
                    out.println("<table>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Mês</th>");
                    out.println("<th>Juros do mês</th>");
                    out.println("<th>Juros acumulado</th>");
                    out.println("<th>Montante acumulado</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<th>0</th>");
                    out.println("<th>-</th>");
                    out.println("<th>-</th>");
                    out.println("<th>" + formatacao.format(capital) + "</th>");
                    out.println("</tr>");
                } else {
                    valor = 1 + taxa;
                    elevado = Math.pow(valor, i);
                    jurosAcumulado = capital * (elevado - 1);
                    montante = capital * elevado;
                    if (i == 1) {
                        juros = jurosAcumulado;
                        aux = jurosAcumulado;
                    } else {
                        juros = jurosAcumulado - aux;
                        aux = jurosAcumulado;
                    }
                    out.println("<tr>");
                    out.println("<th>" + i + "</th>");
                    out.println("<th>" + formatacao.format(juros) + "</th>");
                    out.println("<th>" + formatacao.format(jurosAcumulado) + "</th>");
                    out.println("<th>" + formatacao.format(montante) + "</th>");
                    out.println("</tr>");

                    if (i == tempo) {
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                }
            }
             
            
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
