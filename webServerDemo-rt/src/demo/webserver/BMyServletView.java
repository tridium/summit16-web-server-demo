package demo.webserver;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BServletView;
import javax.baja.web.WebOp;

/**
 * A Niagara View that's also a Servlet.
 * <p>
 * A Servlet View acts a fully fledged Niagara View for the browser. This
 * is the primary class used by Hx to create views.
 * </p>
 * <p>
 * Please note, for user interface, the preferred way to create views is
 * now bajaux!
 * </p>
 *
 * @author Gareth Johnson on 14/04/2016.
 */
@NiagaraType(agent = @AgentOn(types = {"webServerDemo:MyComponent"}))
@NiagaraSingleton
@SuppressWarnings("unused")
public final class BMyServletView extends BServletView
{
  private BMyServletView() {}

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $demo.webserver.BMyServletView(1973264512)1.0$ @*/
/* Generated Thu Apr 14 20:44:03 BST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  public static final BMyServletView INSTANCE = new BMyServletView();

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMyServletView.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void doGet(WebOp op) throws Exception
  {
    op.setContentType("text/html; charset=utf-8");

    op.getWriter().write("<!DOCTYPE html><html><body>" +
                         "<h1>Hello Servlet View!</h1>" +
                         "</body></html>");
  }
}
