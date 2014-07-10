/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dao.AddAfiDao;
import Dao.AddAfiImpl;
import Dao.AfiDao;
import Dao.AfiImpl;
import Dao.claveDao;
import Dao.claveImpl;
import Factory.ConnectionDB;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Afiliado;
import modelo.NewAfiliado;
import modelo.clave;
import org.json.simple.JSONArray;

/**
 *
 * @author CEDISDGO
 */
public class Consulta extends HttpServlet {

    ConnectionDB conn;

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consulta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Consulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        
        String query = request.getParameter("term");

        try {
            query = query.toLowerCase();
            claveDao cl = new claveImpl();
            List<clave> l_a = new ArrayList<clave>();
            l_a = (List) cl.des(query);
            clave med = new clave();
            JSONArray arrayObj = new JSONArray();
            System.out.println(query);
            
            for (int i = 0; i < l_a.size(); i++) {
                med =(clave) l_a.get(i);
                
                String medicamento = med.getDescripcion().toLowerCase();
                if (medicamento.startsWith(query)) {
                    arrayObj.add(med.getDescripcion());
                }
            }

            out.println(arrayObj.toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
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
        int ban = Integer.parseInt(request.getParameter("ban"));

        switch (ban) {

            case 1:
                String folio = request.getParameter("folio");
                Map<String, String> l_m = new LinkedHashMap<String, String>();
                try {
                    AfiDao afiliado = new AfiImpl();
                    List<Afiliado> l_a = new ArrayList<Afiliado>();
                    l_a = (List) afiliado.n_afi(folio);
                    Afiliado Afi = new Afiliado();
                    for (int i = 0; i < l_a.size(); i++) {
                        Afi = (Afiliado) l_a.get(i);
                        l_m.put(Afi.getNombre(), Afi.getNombre());

                    }
                    String json = null;
                    json = new Gson().toJson(l_m);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);

                } catch (Exception e) {
                    e.printStackTrace();

                }

                break;
            case 2:

                NewAfiliado afi = new NewAfiliado();

                afi.setFolio(request.getParameter("folio"));
                afi.setA_p(request.getParameter("a_p"));
                afi.setA_m(request.getParameter("a_m"));
                afi.setNombre(request.getParameter("nombre"));
                afi.setF_inicio(request.getParameter("f_in"));
                afi.setF_fin(request.getParameter("f_fin"));
                afi.setF_naci(request.getParameter("f_n"));
                afi.setEdad(Integer.parseInt(request.getParameter("edad")));
                afi.setPrograma(request.getParameter("progr"));
                afi.setSexo(request.getParameter("sexo"));
                AddAfiDao afiliado = new AddAfiImpl();
                afiliado.afiliado(afi);

                break;
            case 3:
                folio = request.getParameter("folio");
                String nombre = request.getParameter("nombre");
                Map T_afi = new LinkedHashMap();
                try {
                    AfiDao t_a = new AfiImpl();
                    List<Afiliado> l_a = new ArrayList<Afiliado>();
                    l_a = (List) t_a.t_afi(folio, nombre);
                    Afiliado Afi = new Afiliado();
                    for (int i = 0; i < l_a.size(); i++) {
                        Afi = (Afiliado) l_a.get(i);
                        T_afi.put("f_i", Afi.getF_inicio());
                        T_afi.put("f_f", Afi.getF_fin());
                        T_afi.put("f_n", Afi.getF_nacimiento());
                        T_afi.put("edad", Afi.getEdad());

                    }
                    String json = null;
                    json = new Gson().toJson(T_afi);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);

                } catch (Exception e) {
                    e.printStackTrace();

                }

                break;
            case 4:

                NewAfiliado afi_1 = new NewAfiliado();

                afi_1.setFolio(request.getParameter("folio"));
                afi_1.setF_inicio(request.getParameter("f_in"));
                afi_1.setF_fin(request.getParameter("f_fin"));
                afi_1.setEdad(Integer.parseInt(request.getParameter("edad")));
                afi_1.setNombre(request.getParameter("nombre"));
                AddAfiDao afiliado_1 = new AddAfiImpl();
                afiliado_1.actualizar(afi_1);

                break;

            case 5:

                String clave = request.getParameter("clave");
                Map cv = new LinkedHashMap();
                try {
                    claveDao cl = new claveImpl();
                    List<clave> l_a = new ArrayList<clave>();
                    l_a = (List) cl.con_cm(clave);
                    clave med = new clave();
                    for (int i = 0; i < l_a.size(); i++) {
                        med = (clave) l_a.get(i);
                        cv.put("clave", med.getClave());
                        cv.put("descrip", med.getDescripcion());
                        cv.put("cant", med.getCantidad());

                    }
                    String json1 = null;
                    json1 = new Gson().toJson(cv);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json1);

                } catch (Exception e) {
                    e.printStackTrace();

                }

                break;
            case 6:
                
                    String descripcion = request.getParameter("descrip");
                Map dv = new LinkedHashMap();
                try {
                    claveDao cl = new claveImpl();
                    List<clave> l_a = new ArrayList<clave>();
                    l_a = (List) cl.con_dm(descripcion);
                    clave med = new clave();
                    for (int i = 0; i < l_a.size(); i++) {
                        med = (clave) l_a.get(i);
                        dv.put("clave", med.getClave());
                        dv.put("descrip", med.getDescripcion());
                        dv.put("cant", med.getCantidad());

                    }
                    String json1 = null;
                    json1 = new Gson().toJson(dv);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json1);

                } catch (Exception e) {
                    e.printStackTrace();

                }
                
                
            break;    

        }

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
