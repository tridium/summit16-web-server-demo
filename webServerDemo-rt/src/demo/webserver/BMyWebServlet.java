package demo.webserver;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BWebServlet;
import javax.baja.web.WebOp;

/**
 * An example of a BWebServlet Component.
 * <p>
 * In order for this Servlet to be used, an instance of this Component must
 * be added to the Station database. The user must have operator read permissions
 * to access this Component in order for the web server to invoke this Servlet.
 * </p>
 * <p>
 * The 'servletName' defines how the Servlet is accessed through the Web Server.
 * For instance, if the servletName is 'foo', it will be accessed via
 * `https://localhost/foo`.
 * </p>
 *
 * @author Gareth Johnson on 14/04/2016.
 */
@NiagaraType
@NiagaraProperty(
  name = "servletName",
  type = "baja:String",
  flags = Flags.HIDDEN | Flags.READONLY,
  defaultValue = "myServlet"
)
public class BMyWebServlet extends BWebServlet
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $demo.webserver.BMyWebServlet(2329189358)1.0$ @*/
/* Generated Thu Apr 14 20:13:02 BST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "servletName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code servletName} property.
   * @see #getServletName
   * @see #setServletName
   */
  public static final Property servletName = newProperty(Flags.HIDDEN | Flags.READONLY, "myServlet", null);
  
  /**
   * Get the {@code servletName} property.
   * @see #servletName
   */
  public String getServletName() { return getString(servletName); }
  
  /**
   * Set the {@code servletName} property.
   * @see #servletName
   */
  public void setServletName(String v) { setString(servletName, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMyWebServlet.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void doGet(WebOp op) throws Exception
  {
    op.setContentType("text/html; charset=utf-8");

    op.getWriter().write("<!DOCTYPE html><html><body>" +
                         "<h1>Hello Web Servlet!</h1>" +
                         "</body></html>");
  }
}
