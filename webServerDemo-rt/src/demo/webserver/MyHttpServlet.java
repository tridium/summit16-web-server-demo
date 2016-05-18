package demo.webserver;

import org.owasp.encoder.Encode;

import javax.baja.user.BUser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * An example of a standard Java HTTP Servlet in a Niagara Module.
 *
 * @author Gareth Johnson on 14/04/2016.
 */
@SuppressWarnings("serial")
public class MyHttpServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    BUser user = BUser.getCurrentAuthenticatedUser();
    String userName = user != null ? user.getUsername() : "unknown";
    String lang = req.getLocale().toLanguageTag();

    resp.getWriter().write(String.format(
      "<!DOCTYPE html><html><body>" +
      "<h1>Your user name is %s and your language is %s</h1>" +
      "</body></html>", Encode.forHtml(userName), Encode.forHtml(lang)));
  }
}
