package demo.webserver;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.rpc.NiagaraRpc;
import javax.baja.rpc.Transport;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static javax.baja.rpc.TransportType.box;
import static javax.baja.rpc.TransportType.fox;
import static javax.baja.rpc.TransportType.web;

/**
 * A simple Component that can be added to a Niagara Station.
 * <p>
 * This class demonstates how a NiagaraRpc call be made.
 * </p>
 *
 * @see NiagaraRpc
 *
 * @author Gareth Johnson on 14/04/2016.
 */
@NiagaraType
@SuppressWarnings("unused")
public class BMyComponent extends BComponent
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $demo.webserver.BMyComponent(2979906276)1.0$ @*/
/* Generated Thu Apr 14 20:12:02 BST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMyComponent.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**
   * A very simple instance bound RPC that returns a list of strings.
   *
   * @param cx The incoming calling Context.
   * @return A list of fantastic strings.
   */
  @NiagaraRpc(
    permissions = "RWI",
    isSecure = true,
    transports = {
      @Transport(type = web),
      @Transport(type = box),
      @Transport(type = fox)
    }
  )
  public List<String> myFirstRpc(Context cx)
  {
    return Arrays.asList("Pugh", "Pugh", "Barney McGrew", "Cuthbert", "Dibble", "Grub");
  }

  /**
   * An example of calling a static method as an RPC call.
   * <p>
   * Note how this RPC can also take multiple arguments in its signiture.
   * </p>
   *
   * @param arg A String argument.
   * @param list A list of numbers.
   * @param cx The context.
   * @return A mystery string!
   */
  @NiagaraRpc(
    permissions = "unrestricted",
    transports = {
      @Transport(type = box)
    }
  )
  public static String myStaticRpc(String arg, List<Integer> list, Context cx)
  {
    return arg + ": " + list
      .stream()
      .map(String::valueOf)
      .collect(Collectors.joining(","));
  }
}
