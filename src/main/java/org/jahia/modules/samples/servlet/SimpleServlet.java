package org.jahia.modules.samples.servlet;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by loom on 27.08.14.
 */
public class SimpleServlet extends HttpServlet {

    private HttpService httpService;

    public SimpleServlet() {
    }

    public void postConstruct() {
        try {
            httpService.registerServlet("/org.jahia.modules.samples.servlet", this, null, null);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (NamespaceException e) {
            e.printStackTrace();
        }
    }

    public void preDestroy() {
        httpService.unregister("/org.jahia.modules.samples.servlet");
    }

    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><pre>");
        writer.println("Context path=" + req.getContextPath());
        writer.println("Servlet path=" + req.getServletPath());
        writer.println("Path info=" + req.getPathInfo());
        writer.println("Query string=" + req.getQueryString());
        writer.println("</pre></body></html>");
    }
}
