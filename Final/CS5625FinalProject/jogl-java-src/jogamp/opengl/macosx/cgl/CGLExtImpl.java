/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/opengl/GLEmitter.java on Thu Nov 01 02:16:04 CET 2012 ----! */

package jogamp.opengl.macosx.cgl;

import java.util.*;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
import jogamp.opengl.*;
import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import java.nio.*;

public class CGLExtImpl implements CGLExt{

  // --- Begin CustomJavaCode .cfg declarations
  public CGLExtImpl(MacOSXCGLContext context) {
    this._context = context; 
  }
  public boolean isFunctionAvailable(String glFunctionName)
  {
    return _context.isFunctionAvailable(glFunctionName);
  }
  public boolean isExtensionAvailable(String glExtensionName)
  {
    return _context.isExtensionAvailable(glExtensionName);
  }
  private MacOSXCGLContext _context;
  // ---- End CustomJavaCode .cfg declarations

} // end of class CGLExtImpl
