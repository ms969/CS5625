package javax.media.opengl;

import java.io.*;
import javax.media.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import javax.media.opengl.GL3bc;
import javax.media.opengl.GL2;
import javax.media.opengl.GL3;

/** <P> Composable pipeline which wraps an underlying {@link GL} implementation,
    providing tracing information to a user-specified {@link java.io.PrintStream}
    before and after each OpenGL method call. Sample code which installs this pipeline: </P>

<PRE>
     GL gl = drawable.setGL(new TraceGL(drawable.getGL(), System.err));
</PRE>
*/
public class TraceGL3bc implements javax.media.opengl.GL2, javax.media.opengl.GL3, javax.media.opengl.GL3bc{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("TraceGL3bc");
  public TraceGL3bc(GL3bc downstreamGL3bc, PrintStream stream)
  {
    if (downstreamGL3bc == null) {
      throw new IllegalArgumentException("null downstreamGL3bc");
    }
    this.downstreamGL3bc = downstreamGL3bc;
    this.stream = stream;
  }

  public boolean isGL() {
    return true;
  }
  public boolean isGL4bc() {
    return false;
  }
  public boolean isGL4() {
    return false;
  }
  public boolean isGL3bc() {
    return true;
  }
  public boolean isGL3() {
    return true;
  }
  public boolean isGL2() {
    return true;
  }
  public boolean isGLES1() {
    return false;
  }
  public boolean isGLES2() {
    return false;
  }
  public boolean isGL2ES1() {
    return true;
  }
  public boolean isGL2ES2() {
    return true;
  }
  public boolean isGL2GL3() {
    return true;
  }
  public boolean isGLES() {
    return isGLES2() || isGLES1();
  }
  public boolean isGLES2Compatible() {
    return downstreamGL3bc.isGLES2Compatible();
  }
  public javax.media.opengl.GL getGL() {
    return this;
  }
  public javax.media.opengl.GL4bc getGL4bc() {
    throw new GLException("Not a GL4bc implementation");
  }
  public javax.media.opengl.GL4 getGL4() {
    throw new GLException("Not a GL4 implementation");
  }
  public javax.media.opengl.GL3bc getGL3bc() {
    return this;
  }
  public javax.media.opengl.GL3 getGL3() {
    return this;
  }
  public javax.media.opengl.GL2 getGL2() {
    return this;
  }
  public javax.media.opengl.GLES1 getGLES1() {
    throw new GLException("Not a GLES1 implementation");
  }
  public javax.media.opengl.GLES2 getGLES2() {
    throw new GLException("Not a GLES2 implementation");
  }
  public javax.media.opengl.GL2ES1 getGL2ES1() {
    return this;
  }
  public javax.media.opengl.GL2ES2 getGL2ES2() {
    return this;
  }
  public javax.media.opengl.GL2GL3 getGL2GL3() {
    return this;
  }
  public GLProfile getGLProfile() {
    return downstreamGL3bc.getGLProfile();
  }
  public  void glEvalCoord2f(float arg0,float arg1)
  {
    printIndent();
    print(    "glEvalCoord2f("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glEvalCoord2f(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord4iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord4iv(arg0,arg1);
    println("");
  }
  public  void glNormal3bv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glNormal3bv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glNormal3bv(arg0);
    println("");
  }
  public  void glUniform3dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glUniform3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureParameterivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glTextureParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glTextureParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix3fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  int glGetGraphicsResetStatus()
  {
    printIndent();
    print(    "glGetGraphicsResetStatus("+")");
    int _res = downstreamGL3bc.glGetGraphicsResetStatus();
    println(" = "+_res);
    return _res;
  }
  public  void glUniformMatrix4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glEvalCoord2dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glEvalCoord2dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEvalCoord2dv(arg0,arg1);
    println("");
  }
  public  void glTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4fv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4dvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexP4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glEvalCoord2d(double arg0,double arg1)
  {
    printIndent();
    print(    "glEvalCoord2d("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glEvalCoord2d(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetNamedStringivARB(int arg0,java.lang.String arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedStringivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedStringivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3ubv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3ubv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3ubv(arg0,arg1);
    println("");
  }
  public  void glGetVideoCaptureivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVideoCaptureivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVideoCaptureivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawTransformFeedback(int arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDrawTransformFeedback(arg0,arg1);
    println("");
  }
  public  void glUniform2i64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform2i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform2i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glSecondaryColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glSecondaryColorPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1fARB(int arg0,float arg1)
  {
    printIndent();
    print(    "glVertexAttrib1fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glVertexAttrib1fARB(arg0,arg1);
    println("");
  }
  public  void glGetnUniformuiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnUniformuiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoord3dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix2x4dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x4dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL4dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glColorPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glColorPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoordP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glTexCoordP3uiv(arg0,arg1);
    println("");
  }
  public  void glVertexWeightPointerEXT(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glVertexWeightPointerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glVertexWeightPointerEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSecondaryColor3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3ui(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramEnvParameter4dvARB(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glProgramEnvParameter4dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glProgramEnvParameter4dvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexLevelParameterivEXT(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetMultiTexLevelParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetMultiTexLevelParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTessellationFactorAMD(float arg0)
  {
    printIndent();
    print(    "glTessellationFactorAMD("+"<float> "+arg0+")");
downstreamGL3bc.glTessellationFactorAMD(arg0);
    println("");
  }
  public  void glGetMapAttribParameterfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetMapAttribParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetMapAttribParameterfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1svARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1svARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnPolygonStipple(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetnPolygonStipple("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glGetnPolygonStipple(arg0,arg1);
    println("");
  }
  public  void glProgramUniformui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniformui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenFramebuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetTexGeniv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform3iEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3iEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribIivEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribIivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glPNTrianglesiATI(int arg0,int arg1)
  {
    printIndent();
    print(    "glPNTrianglesiATI("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPNTrianglesiATI(arg0,arg1);
    println("");
  }
  public  void glCompressedMultiTexImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedMultiTexImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glCompressedMultiTexImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glPointParameteriv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glPointParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glPointParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glVertex3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glVertex3d(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL3ui64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL3ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL3ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInvariantIntegervEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetInvariantIntegervEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetInvariantIntegervEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4fEXT(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glProgramUniform4fEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glProgramUniform4fEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttrib2dARB(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glVertexAttrib2dARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glVertexAttrib2dARB(arg0,arg1,arg2);
    println("");
  }
  public  void glMatrixRotatefEXT(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glMatrixRotatefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glMatrixRotatefEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform4fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glValidateProgram(int arg0)
  {
    printIndent();
    print(    "glValidateProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glValidateProgram(arg0);
    println("");
  }
  public  void glNamedFramebufferTexture2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glNamedFramebufferTexture2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferTexture2DEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVideoCaptureStreamParameterivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVideoCaptureStreamParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glVideoCaptureStreamParameterivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL1ui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL1ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL1ui64vNV(arg0,arg1);
    println("");
  }
  public  void glIndexubv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glIndexubv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glIndexubv(arg0);
    println("");
  }
  public  void glProgramBufferParametersfvNV(int arg0,int arg1,int arg2,int arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramBufferParametersfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramBufferParametersfvNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWindowPos2sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos2sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos2sv(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord3sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord3sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord3sv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetBufferSubData(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetProgramLocalParameterIuivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramLocalParameterIuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramLocalParameterIuivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindTransformFeedbackNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTransformFeedbackNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindTransformFeedbackNV(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glViewportArrayv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glViewportArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glViewportArrayv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI1uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1uiv(arg0,arg1,arg2);
    println("");
  }
  public  java.lang.String glGetStringi(int arg0,int arg1)
  {
    printIndent();
    print(    "glGetStringi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.lang.String _res = downstreamGL3bc.glGetStringi(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glMultiTexCoord2fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord2fv(arg0,arg1,arg2);
    println("");
  }
  public  void glFinish()
  {
    printIndent();
    print(    "glFinish("+")");
downstreamGL3bc.glFinish();
    println("");
  }
  public  void glGetShaderInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetShaderInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glScissorIndexedv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glScissorIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glScissorIndexedv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexParameterIuivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexParameterIuivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsVertexArray(int arg0)
  {
    printIndent();
    print(    "glIsVertexArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsVertexArray(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glBindProgramARB(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindProgramARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindProgramARB(arg0,arg1);
    println("");
  }
  public  boolean glTestFenceNV(int arg0)
  {
    printIndent();
    print(    "glTestFenceNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glTestFenceNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetUniformBufferSizeEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glGetUniformBufferSizeEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    int _res = downstreamGL3bc.glGetUniformBufferSizeEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glEvalMapsNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glEvalMapsNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEvalMapsNV(arg0,arg1);
    println("");
  }
  public  void glCompressedTextureSubImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glCompressedTextureSubImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glCompressedTextureSubImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glPixelMapuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glPixelMapuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDetachShader(int arg0,int arg1)
  {
    printIndent();
    print(    "glDetachShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDetachShader(arg0,arg1);
    println("");
  }
  public  void glColor3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glColor3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glColor3sv(arg0);
    println("");
  }
  public  void glVertexAttrib4NubvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4NubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4NubvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4x3fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x3fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMatrixLoadIdentityEXT(int arg0)
  {
    printIndent();
    print(    "glMatrixLoadIdentityEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMatrixLoadIdentityEXT(arg0);
    println("");
  }
  public  void glGetVertexAttribIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClearIndex(float arg0)
  {
    printIndent();
    print(    "glClearIndex("+"<float> "+arg0+")");
downstreamGL3bc.glClearIndex(arg0);
    println("");
  }
  public  void glMultiTexCoordP4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUseProgram(int arg0)
  {
    printIndent();
    print(    "glUseProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glUseProgram(arg0);
    println("");
  }
  public  void glBindFragDataLocationIndexed(int arg0,int arg1,int arg2,java.lang.String arg3)
  {
    printIndent();
    print(    "glBindFragDataLocationIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.lang.String> "+arg3+")");
downstreamGL3bc.glBindFragDataLocationIndexed(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenerateMipmap(int arg0)
  {
    printIndent();
    print(    "glGenerateMipmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glGenerateMipmap(arg0);
    println("");
  }
  public  void glIndexsv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glIndexsv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glIndexsv(arg0);
    println("");
  }
  public  void glMatrixScalefEXT(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glMatrixScalefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glMatrixScalefEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glActiveTexture(int arg0)
  {
    printIndent();
    print(    "glActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glActiveTexture(arg0);
    println("");
  }
  public  void glGetMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetMapfv(arg0,arg1,arg2);
    println("");
  }
  public  void glScaled(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glScaled("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glScaled(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureParameterfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glTextureParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glTextureParameterfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVideoCaptureStreamParameterfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glVideoCaptureStreamParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVideoCaptureStreamParameterfvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColorTableParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glColorTableParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glColorTableParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos3fv(arg0);
    println("");
  }
  public  int glRenderMode(int arg0)
  {
    printIndent();
    print(    "glRenderMode("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glRenderMode(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glAlphaFunc(int arg0,float arg1)
  {
    printIndent();
    print(    "glAlphaFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glAlphaFunc(arg0,arg1);
    println("");
  }
  public  void glTexCoord1iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord1iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord1iv(arg0);
    println("");
  }
  public  void glAttachShader(int arg0,int arg1)
  {
    printIndent();
    print(    "glAttachShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glAttachShader(arg0,arg1);
    println("");
  }
  public  void glGetHistogramParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetHistogramParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetHistogramParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex2fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glVertex2fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glVertex2fv(arg0);
    println("");
  }
  public  void glVertexAttribFormatNV(int arg0,int arg1,int arg2,boolean arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribFormatNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetDoublev(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glGetDoublev("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glGetDoublev(arg0,arg1);
    println("");
  }
  public  void glMapVertexAttrib1dAPPLE(int arg0,int arg1,double arg2,double arg3,int arg4,int arg5,double[] arg6,int arg7)
  {
    printIndent();
    print(    "glMapVertexAttrib1dAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glMapVertexAttrib1dAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glTexGeni(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexGeni("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexGeni(arg0,arg1,arg2);
    println("");
  }
  public  void glColorP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glColorP3uiv(arg0,arg1);
    println("");
  }
  public  void glDisableClientStateIndexedEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisableClientStateIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDisableClientStateIndexedEXT(arg0,arg1);
    println("");
  }
  public  void glGetProgramLocalParameterfvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramLocalParameterfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramLocalParameterfvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib2hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2hv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL1i64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL1i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL1i64vNV(arg0,arg1);
    println("");
  }
  public  void glTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexEnviv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4iv(arg0,arg1);
    println("");
  }
  public  void glVariantfvEXT(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVariantfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVariantfvEXT(arg0,arg1);
    println("");
  }
  public  void glUniform2fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform2fv(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureLightEXT(int arg0)
  {
    printIndent();
    print(    "glTextureLightEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glTextureLightEXT(arg0);
    println("");
  }
  public  void glDeleteTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteTransformFeedbacks(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glVertexAttribP3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoordP2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP2ui(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedProgramivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedProgramivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedProgramivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4s(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glVertexAttrib4s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
downstreamGL3bc.glVertexAttrib4s(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenFencesNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenFencesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenFencesNV(arg0,arg1,arg2);
    println("");
  }
  public  void glDepthRangeIndexed(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glDepthRangeIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glDepthRangeIndexed(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexParameterIivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexParameterIivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetColorTableParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetColorTableParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetColorTableParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexArrayParameteriAPPLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexArrayParameteriAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexArrayParameteriAPPLE(arg0,arg1);
    println("");
  }
  public  void glEnableVertexAttribAPPLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnableVertexAttribAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEnableVertexAttribAPPLE(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWindowPos2i(int arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos2i(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glVertexAttrib4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glVertexAttrib4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib1fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1fv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glVertexAttrib4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glVertexAttrib4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glWindowPos2f(float arg0,float arg1)
  {
    printIndent();
    print(    "glWindowPos2f("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glWindowPos2f(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4h(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glVertexAttrib4h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
downstreamGL3bc.glVertexAttrib4h(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glWindowPos2d(double arg0,double arg1)
  {
    printIndent();
    print(    "glWindowPos2d("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glWindowPos2d(arg0,arg1);
    println("");
  }
  public  void glGetBooleani_v(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetBooleani_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
downstreamGL3bc.glGetBooleani_v(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsEnabled(int arg0)
  {
    printIndent();
    print(    "glIsEnabled("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsEnabled(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGenTransformFeedbacksNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTransformFeedbacksNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenTransformFeedbacksNV(arg0,arg1,arg2);
    println("");
  }
  public  void glTexImage3DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
    printIndent();
    print(    "glTexImage3DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+")");
downstreamGL3bc.glTexImage3DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glWindowPos2s(short arg0,short arg1)
  {
    printIndent();
    print(    "glWindowPos2s("+"<short> "+arg0+", "+"<short> "+arg1+")");
downstreamGL3bc.glWindowPos2s(arg0,arg1);
    println("");
  }
  public  void glDeleteFencesNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteFencesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteFencesNV(arg0,arg1);
    println("");
  }
  public  void glTexEnvi(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexEnvi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexEnvi(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexP2uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexP2uiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4uiv(arg0,arg1);
    println("");
  }
  public  void glUniform3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glColorPointer(javax.media.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glColorPointer("+"<javax.media.opengl.GLArrayData> "+arg0+")");
downstreamGL3bc.glColorPointer(arg0);
    println("");
  }
  public  boolean hasBasicFBOSupport()
  {
        return downstreamGL3bc.hasBasicFBOSupport();
  }
  public  void glMatrixIndexuivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixIndexuivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixIndexuivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexWeighthv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertexWeighthv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertexWeighthv(arg0);
    println("");
  }
  public  void glActiveShaderProgram(int arg0,int arg1)
  {
    printIndent();
    print(    "glActiveShaderProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glActiveShaderProgram(arg0,arg1);
    println("");
  }
  public  void glGenPerfMonitorsAMD(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenPerfMonitorsAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenPerfMonitorsAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glVertex3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glVertex3dv(arg0);
    println("");
  }
  public  void glUnlockArraysEXT()
  {
    printIndent();
    print(    "glUnlockArraysEXT("+")");
downstreamGL3bc.glUnlockArraysEXT();
    println("");
  }
  public  void glCopyTextureImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTextureImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glCopyTextureImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glConvolutionParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glConvolutionParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glConvolutionParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawPixels(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glDrawPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL3bc.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2h(int arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glVertexAttrib2h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glVertexAttrib2h(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glVertexAttrib2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glVertexAttrib2f(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord4h(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
downstreamGL3bc.glMultiTexCoord4h(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glUnmapNamedBufferEXT(int arg0)
  {
    printIndent();
    print(    "glUnmapNamedBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glUnmapNamedBufferEXT(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
downstreamGL3bc.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3x4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glVertexAttrib2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glVertexAttrib2d(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTextureImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glTextureImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glMultiTexCoord4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix3x4fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glLightfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glMultiTexCoord4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetLightfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetActiveUniform(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveUniform("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL3bc.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glColor4uiv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4uiv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4uiv(arg0,arg1);
    println("");
  }
  public  void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord1sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord1sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord1sv(arg0,arg1);
    println("");
  }
  public  void glVDPAUIsSurfaceNV(long arg0)
  {
    printIndent();
    print(    "glVDPAUIsSurfaceNV("+"<long> "+arg0+")");
downstreamGL3bc.glVDPAUIsSurfaceNV(arg0);
    println("");
  }
  public  void glSetInvariantEXT(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glSetInvariantEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glSetInvariantEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL3bc.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform4iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib2s(int arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glVertexAttrib2s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glVertexAttrib2s(arg0,arg1,arg2);
    println("");
  }
  public  void glWeightdvARB(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightdvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glMatrixLoaddEXT(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixLoaddEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixLoaddEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glPixelTransformParameterfvEXT(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glPixelTransformParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glPixelTransformParameterfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glValidateProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glValidateProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glValidateProgramPipeline(arg0);
    println("");
  }
  public  void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord1s(short arg0)
  {
    printIndent();
    print(    "glTexCoord1s("+"<short> "+arg0+")");
downstreamGL3bc.glTexCoord1s(arg0);
    println("");
  }
  public  void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformBlockName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL3bc.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glReadnPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWindowPos3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos3iv(arg0);
    println("");
  }
  public  void glRasterPos4dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos4dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos4dv(arg0);
    println("");
  }
  public  void glTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord1h(short arg0)
  {
    printIndent();
    print(    "glTexCoord1h("+"<short> "+arg0+")");
downstreamGL3bc.glTexCoord1h(arg0);
    println("");
  }
  public  void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glFogCoordFormatNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glFogCoordFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFogCoordFormatNV(arg0,arg1);
    println("");
  }
  public  void glGetVideoCaptureStreamivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetVideoCaptureStreamivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetVideoCaptureStreamivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4fvARB(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4fvARB(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4sv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetActiveAtomicCounterBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform(javax.media.opengl.GLUniformData arg0)
  {
    printIndent();
    print(    "glUniform("+"<javax.media.opengl.GLUniformData> "+arg0+")");
downstreamGL3bc.glUniform(arg0);
    println("");
  }
  public  void glTexCoord2dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord2dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord2dv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4Nsv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nsv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4Nsv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureSubImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glTextureSubImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glTextureSubImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glMultiTexCoord2s(int arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glMultiTexCoord2s(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribs1hv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribs1hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribs1hv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1fvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4i64NV(int arg0,long arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glUniform4i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glUniform4i64NV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4bvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4bvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4bvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2x3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glSamplerParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVariantFloatvEXT(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVariantFloatvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVariantFloatvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTessellationModeAMD(int arg0)
  {
    printIndent();
    print(    "glTessellationModeAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glTessellationModeAMD(arg0);
    println("");
  }
  public  boolean glIsOcclusionQueryNV(int arg0)
  {
    printIndent();
    print(    "glIsOcclusionQueryNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsOcclusionQueryNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glMultTransposeMatrixf(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glMultTransposeMatrixf("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMultTransposeMatrixf(arg0,arg1);
    println("");
  }
  public  void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  java.nio.ByteBuffer glMapNamedBufferRangeEXT(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "glMapNamedBufferRangeEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGL3bc.glMapNamedBufferRangeEXT(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glCompressedMultiTexSubImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedMultiTexSubImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glCompressedMultiTexSubImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glNormal3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glNormal3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormal3dv(arg0,arg1);
    println("");
  }
  public  boolean glIsFenceNV(int arg0)
  {
    printIndent();
    print(    "glIsFenceNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsFenceNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glNamedProgramLocalParametersI4ivEXT(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glNamedProgramLocalParametersI4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParametersI4ivEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPolygonStipple(long arg0)
  {
    printIndent();
    print(    "glPolygonStipple("+"<long> "+arg0+")");
downstreamGL3bc.glPolygonStipple(arg0);
    println("");
  }
  public  void glWaitSync(long arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glWaitSync("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glWaitSync(arg0,arg1,arg2);
    println("");
  }
  public  void glShadeModel(int arg0)
  {
    printIndent();
    print(    "glShadeModel("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glShadeModel(arg0);
    println("");
  }
  public  void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glShaderSource(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<long> "+arg7+")");
downstreamGL3bc.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glProgramUniform1uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSwapAPPLE()
  {
    printIndent();
    print(    "glSwapAPPLE("+")");
downstreamGL3bc.glSwapAPPLE();
    println("");
  }
  public  boolean glIsPBOUnpackEnabled()
  {
    printIndent();
    print(    "glIsPBOUnpackEnabled("+")");
    boolean _res = downstreamGL3bc.glIsPBOUnpackEnabled();
    println(" = "+_res);
    return _res;
  }
  public  void glTexCoordP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoordP3ui(arg0,arg1);
    println("");
  }
  public  void glVertexAttribIPointerEXT(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glVertexAttribIPointerEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glDepthBoundsEXT(double arg0,double arg1)
  {
    printIndent();
    print(    "glDepthBoundsEXT("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glDepthBoundsEXT(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4usvARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4usvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4usvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexGenivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexGenivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexGenivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glTexCoord3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glTexCoord3s(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord3h(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glTexCoord3h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glTexCoord3h(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord4s(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
downstreamGL3bc.glMultiTexCoord4s(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glStencilFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glStencilFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glStencilFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColorP4ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glColorP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColorP4ui(arg0,arg1);
    println("");
  }
  public  void glUniform2ui64NV(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glUniform2ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL3bc.glUniform2ui64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiDrawElementsIndirectAMD(int arg0,int arg1,java.nio.Buffer arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glMultiDrawElementsIndirectAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiDrawElementsIndirectAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib1hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1hv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColor3usv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glColor3usv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glColor3usv(arg0);
    println("");
  }
  public  void glRasterPos4sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos4sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos4sv(arg0);
    println("");
  }
  public  void glVertexAttrib4NusvARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4NusvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4NusvARB(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI3uiv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPixelMapusv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glPixelMapusv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI2uivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI2uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI2uivEXT(arg0,arg1);
    println("");
  }
  public  void glMatrixMultdEXT(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMatrixMultdEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMatrixMultdEXT(arg0,arg1);
    println("");
  }
  public  void glVertexBlendARB(int arg0)
  {
    printIndent();
    print(    "glVertexBlendARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glVertexBlendARB(arg0);
    println("");
  }
  public  void glMatrixIndexusvARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixIndexusvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixIndexusvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1dEXT(int arg0,int arg1,double arg2)
  {
    printIndent();
    print(    "glProgramUniform1dEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+")");
downstreamGL3bc.glProgramUniform1dEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nub(int arg0,byte arg1,byte arg2,byte arg3,byte arg4)
  {
    printIndent();
    print(    "glVertexAttrib4Nub("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+", "+"<byte> "+arg4+")");
downstreamGL3bc.glVertexAttrib4Nub(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glWindowPos2dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos2dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos2dv(arg0,arg1);
    println("");
  }
  public  void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glDrawRangeElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL3bc.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetTransformFeedbackVarying("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL3bc.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  int glCheckNamedFramebufferStatusEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glCheckNamedFramebufferStatusEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    int _res = downstreamGL3bc.glCheckNamedFramebufferStatusEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform4iEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4iEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glSecondaryColor3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3fv(arg0,arg1);
    println("");
  }
  public  void glLoadTransposeMatrixf(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glLoadTransposeMatrixf("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glLoadTransposeMatrixf(arg0,arg1);
    println("");
  }
  public  void glGetProgramEnvParameterdvARB(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramEnvParameterdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramEnvParameterdvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glDisableVertexAttribArray(int arg0)
  {
    printIndent();
    print(    "glDisableVertexAttribArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDisableVertexAttribArray(arg0);
    println("");
  }
  public  void glColor3hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glColor3hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glColor3hv(arg0);
    println("");
  }
  public  void glNamedRenderbufferStorageEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glNamedRenderbufferStorageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glNamedRenderbufferStorageEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1i64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsNameAMD(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsNameAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsNameAMD(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform2dvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2dvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1dARB(int arg0,double arg1)
  {
    printIndent();
    print(    "glVertexAttrib1dARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL3bc.glVertexAttrib1dARB(arg0,arg1);
    println("");
  }
  public  void glLinkProgram(int arg0)
  {
    printIndent();
    print(    "glLinkProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glLinkProgram(arg0);
    println("");
  }
  public  void glBindVertexShaderEXT(int arg0)
  {
    printIndent();
    print(    "glBindVertexShaderEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBindVertexShaderEXT(arg0);
    println("");
  }
  public  void glBlendFuncSeparateIndexedAMD(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBlendFuncSeparateIndexedAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glBlendFuncSeparateIndexedAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform1i64NV(int arg0,long arg1)
  {
    printIndent();
    print(    "glUniform1i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glUniform1i64NV(arg0,arg1);
    println("");
  }
  public  void glGetTextureParameterIuivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetTextureParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetTextureParameterIuivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4fvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor3ub(byte arg0,byte arg1,byte arg2)
  {
    printIndent();
    print(    "glColor3ub("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+")");
downstreamGL3bc.glColor3ub(arg0,arg1,arg2);
    println("");
  }
  public  void glMultMatrixf(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glMultMatrixf("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glMultMatrixf(arg0);
    println("");
  }
  public  int glCheckFramebufferStatus(int arg0)
  {
    printIndent();
    print(    "glCheckFramebufferStatus("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glCheckFramebufferStatus(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glMatrixTranslatedEXT(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glMatrixTranslatedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glMatrixTranslatedEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetDoubleIndexedvEXT(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetDoubleIndexedvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetDoubleIndexedvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSetLocalConstantEXT(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glSetLocalConstantEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glSetLocalConstantEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawArraysInstanced(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawArraysInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glDrawArraysInstanced(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glInterleavedArrays(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glInterleavedArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glInterleavedArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glMultiTexCoord2f(arg0,arg1,arg2);
    println("");
  }
  public  void glWindowPos3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos3sv(arg0);
    println("");
  }
  public  void glTexCoordP2uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexCoordP2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glMultiTexCoord2d(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL2ui64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL2ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL2ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord2h(int arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glMultiTexCoord2h(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord2i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord2i(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glNormal3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glNormal3i(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformSubroutinesuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniformSubroutinesuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniformSubroutinesuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexGenivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexGenivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexGenivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoordP1uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexCoordP1uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glCopyConvolutionFilter1D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glCopyConvolutionFilter1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glCopyConvolutionFilter1D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenProgramsARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenProgramsARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenProgramsARB(arg0,arg1);
    println("");
  }
  public  void glVDPAUUnmapSurfacesNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVDPAUUnmapSurfacesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVDPAUUnmapSurfacesNV(arg0,arg1);
    println("");
  }
  public  void glIndexub(byte arg0)
  {
    printIndent();
    print(    "glIndexub("+"<byte> "+arg0+")");
downstreamGL3bc.glIndexub(arg0);
    println("");
  }
  public  void glSamplerParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glSamplerParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glSamplerParameterf(arg0,arg1,arg2);
    println("");
  }
  public  void glEdgeFlagv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glEdgeFlagv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEdgeFlagv(arg0,arg1);
    println("");
  }
  public  void glGetNamedProgramLocalParameterIivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedProgramLocalParameterIivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribdvARB(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribdvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  long glVDPAURegisterVideoSurfaceNV(java.nio.Buffer arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVDPAURegisterVideoSurfaceNV("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    long _res = downstreamGL3bc.glVDPAURegisterVideoSurfaceNV(arg0,arg1,arg2,arg3,arg4);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib4uivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4uivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4uivARB(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindImageTexture(int arg0,int arg1,int arg2,boolean arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glBindImageTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glBindImageTexture(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glMatrixLoadTransposefEXT(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMatrixLoadTransposefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMatrixLoadTransposefEXT(arg0,arg1);
    println("");
  }
  public  int glObjectUnpurgeableAPPLE(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glObjectUnpurgeableAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    int _res = downstreamGL3bc.glObjectUnpurgeableAPPLE(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniformMatrix2x3dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x3dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPixelTransformParameterivEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glPixelTransformParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glPixelTransformParameterivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetOcclusionQueryivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetOcclusionQueryivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetOcclusionQueryivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex4iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex4iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex4iv(arg0,arg1);
    println("");
  }
  public  void glTexCoord3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord3fv(arg0,arg1);
    println("");
  }
  public  void glGetObjectParameterivAPPLE(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetObjectParameterivAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetObjectParameterivAPPLE(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glValidateProgramARB(int arg0)
  {
    printIndent();
    print(    "glValidateProgramARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glValidateProgramARB(arg0);
    println("");
  }
  public  void glGetMaterialiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMaterialiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMaterialiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetInfoLogARB(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetInfoLogARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetInfoLogARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glEndPerfMonitorAMD(int arg0)
  {
    printIndent();
    print(    "glEndPerfMonitorAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEndPerfMonitorAMD(arg0);
    println("");
  }
  public  void glColor4iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4iv(arg0,arg1);
    println("");
  }
  public  void glVertex2hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex2hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex2hv(arg0,arg1);
    println("");
  }
  public  void glGetnMinmax(int arg0,boolean arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetnMinmax("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glGetnMinmax(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glCopyMultiTexImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyMultiTexImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
downstreamGL3bc.glCopyMultiTexImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glWindowPos2dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos2dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos2dv(arg0);
    println("");
  }
  public  void glColorTableParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glColorTableParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glColorTableParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniform4ui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4ui64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord4sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord4sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord4sv(arg0);
    println("");
  }
  public  void glColorMaski(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    printIndent();
    print(    "glColorMaski("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+", "+"<boolean> "+arg4+")");
downstreamGL3bc.glColorMaski(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexArrayRangeNV(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glVertexArrayRangeNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glVertexArrayRangeNV(arg0,arg1);
    println("");
  }
  public  void glMatrixMultdEXT(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixMultdEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixMultdEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glWeightuivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightuivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightuivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParameterI4ivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glNamedProgramLocalParameterI4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glNamedProgramLocalParameterI4ivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVariantuivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantuivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3svARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3svARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawTransformFeedbackStreamInstanced(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawTransformFeedbackStreamInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glDrawTransformFeedbackStreamInstanced(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetFloatv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexEnvivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexEnvivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexEnvivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramSubroutineParameteruivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramSubroutineParameteruivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramSubroutineParameteruivNV(arg0,arg1,arg2);
    println("");
  }
  public  int glObjectPurgeableAPPLE(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glObjectPurgeableAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    int _res = downstreamGL3bc.glObjectPurgeableAPPLE(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glGetPerfMonitorGroupStringAMD(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetPerfMonitorGroupStringAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetPerfMonitorGroupStringAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetLocalConstantIntegervEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLocalConstantIntegervEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetLocalConstantIntegervEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4ubv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4ubv(arg0,arg1);
    println("");
  }
  public  void glGetDoubleIndexedvEXT(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetDoubleIndexedvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetDoubleIndexedvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2ivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2ivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetProgramInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribIuivEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribIuivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glCopyTextureSubImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyTextureSubImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
downstreamGL3bc.glCopyTextureSubImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glMultiTexCoord3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glMultiTexCoord3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glMultiTexCoord3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glVertexAttrib3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glVertexAttrib3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2dvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glEvalCoord1fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glEvalCoord1fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glEvalCoord1fv(arg0);
    println("");
  }
  public  void glCopyTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
downstreamGL3bc.glCopyTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glGetProgramEnvParameterdvARB(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramEnvParameterdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramEnvParameterdvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetMapAttribParameterivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMapAttribParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMapAttribParameterivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteSamplers(arg0,arg1);
    println("");
  }
  public  void glGetTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetTexGenfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3fv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVariantBooleanvEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetVariantBooleanvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
downstreamGL3bc.glGetVariantBooleanvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexWeightfEXT(float arg0)
  {
    printIndent();
    print(    "glVertexWeightfEXT("+"<float> "+arg0+")");
downstreamGL3bc.glVertexWeightfEXT(arg0);
    println("");
  }
  public  void glMapParameterfvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glMapParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMapParameterfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribdvARB(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribdvARB(arg0,arg1,arg2);
    println("");
  }
  public  int glGetDebugMessageLogARB(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,int[] arg10,int arg11,byte[] arg12,int arg13)
  {
    printIndent();
    print(    "glGetDebugMessageLogARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg13).toUpperCase()+")");
    int _res = downstreamGL3bc.glGetDebugMessageLogARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13);
    println(" = "+_res);
    return _res;
  }
  public  void glGetActiveAttrib(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL3bc.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glMap2f(int arg0,float arg1,float arg2,int arg3,int arg4,float arg5,float arg6,int arg7,int arg8,float[] arg9,int arg10)
  {
    printIndent();
    print(    "glMap2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<float> "+arg5+", "+"<float> "+arg6+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL3bc.glMap2f(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glRasterPos2sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos2sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos2sv(arg0,arg1);
    println("");
  }
  public  void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenTextures(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL4i64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL4i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL4i64vNV(arg0,arg1);
    println("");
  }
  public  void glTexCoord1hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord1hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord1hv(arg0,arg1);
    println("");
  }
  public  void glMapGrid2d(int arg0,double arg1,double arg2,int arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glMapGrid2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glMapGrid2d(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glFogCoordfv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glFogCoordfv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFogCoordfv(arg0,arg1);
    println("");
  }
  public  void glPushAttrib(int arg0)
  {
    printIndent();
    print(    "glPushAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glPushAttrib(arg0);
    println("");
  }
  public  void glVertexAttrib4fARB(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glVertexAttrib4fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glVertexAttrib4fARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMapGrid2f(int arg0,float arg1,float arg2,int arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glMapGrid2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glMapGrid2f(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetMapiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetMapiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetMapiv(arg0,arg1,arg2);
    println("");
  }
  public  void glHistogram(int arg0,int arg1,int arg2,boolean arg3)
  {
    printIndent();
    print(    "glHistogram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+")");
downstreamGL3bc.glHistogram(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramLocalParameter4fvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glProgramLocalParameter4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glProgramLocalParameter4fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexPointer(javax.media.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glVertexPointer("+"<javax.media.opengl.GLArrayData> "+arg0+")");
downstreamGL3bc.glVertexPointer(arg0);
    println("");
  }
  public  void glGetColorTableParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetColorTableParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetColorTableParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glMap1f(int arg0,float arg1,float arg2,int arg3,int arg4,float[] arg5,int arg6)
  {
    printIndent();
    print(    "glMap1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glMap1f(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glNormal3h(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glNormal3h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glNormal3h(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetPerfMonitorCounterInfoAMD(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetPerfMonitorCounterInfoAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetPerfMonitorCounterInfoAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNormal3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glNormal3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glNormal3s(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInvariantFloatvEXT(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetInvariantFloatvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetInvariantFloatvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glVertexAttrib1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL3bc.glVertexAttrib1d(arg0,arg1);
    println("");
  }
  public  void glGetFramebufferParameterivEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFramebufferParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetFramebufferParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetAttachedShaders(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetAttachedShaders("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetAttachedShaders(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetAttachedShaders(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetAttachedShaders("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetAttachedShaders(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureNormalEXT(int arg0)
  {
    printIndent();
    print(    "glTextureNormalEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glTextureNormalEXT(arg0);
    println("");
  }
  public  void glVertexAttrib2sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2sv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedProgramLocalParameter4fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glNamedProgramLocalParameter4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glNamedProgramLocalParameter4fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x3dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x3dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glIsList(int arg0)
  {
    printIndent();
    print(    "glIsList("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsList(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDrawBuffersATI(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDrawBuffersATI("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDrawBuffersATI(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramPipelineiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramPipelineiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramPipelineiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPolygonStipple(long arg0)
  {
    printIndent();
    print(    "glGetPolygonStipple("+"<long> "+arg0+")");
downstreamGL3bc.glGetPolygonStipple(arg0);
    println("");
  }
  public  void glVertex2sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex2sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex2sv(arg0,arg1);
    println("");
  }
  public  void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColorSubTable(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glColorSubTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL3bc.glColorSubTable(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glPointParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glMatrixLoaddEXT(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMatrixLoaddEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMatrixLoaddEXT(arg0,arg1);
    println("");
  }
  public  void glDebugMessageEnableAMD(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,boolean arg4)
  {
    printIndent();
    print(    "glDebugMessageEnableAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<boolean> "+arg4+")");
downstreamGL3bc.glDebugMessageEnableAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformui64NV(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glProgramUniformui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glProgramUniformui64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetQueryObjecti64vEXT(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjecti64vEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryObjecti64vEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWeightdvARB(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glWeightdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glWeightdvARB(arg0,arg1);
    println("");
  }
  public  void glPixelDataRangeNV(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glPixelDataRangeNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glPixelDataRangeNV(arg0,arg1,arg2);
    println("");
  }
  public  int glGetUniformBlockIndex(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformBlockIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL3bc.glGetUniformBlockIndex(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glGetQueryObjecti64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjecti64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryObjecti64v(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glVertexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glVertexPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetLightiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLightiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetLightiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4svARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4svARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramLocalParametersI4uivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramLocalParametersI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParametersI4uivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex3dv(arg0,arg1);
    println("");
  }
  public  void glTexCoord1i(int arg0)
  {
    printIndent();
    print(    "glTexCoord1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glTexCoord1i(arg0);
    println("");
  }
  public  void glUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2x4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetQueryObjectiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryObjectiv(arg0,arg1,arg2);
    println("");
  }
  public  java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glMapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGL3bc.glMapBuffer(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glMapVertexAttrib1fAPPLE(int arg0,int arg1,float arg2,float arg3,int arg4,int arg5,java.nio.FloatBuffer arg6)
  {
    printIndent();
    print(    "glMapVertexAttrib1fAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg6+")");
downstreamGL3bc.glMapVertexAttrib1fAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttribI2i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2i(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord2dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord2dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord2dv(arg0);
    println("");
  }
  public  void glBindRenderbuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindRenderbuffer(arg0,arg1);
    println("");
  }
  public  void glUniform2iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform2iv(arg0,arg1,arg2);
    println("");
  }
  public  void glEndConditionalRender()
  {
    printIndent();
    print(    "glEndConditionalRender("+")");
downstreamGL3bc.glEndConditionalRender();
    println("");
  }
  public  void glMultiTexCoord4fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord4fv(arg0,arg1);
    println("");
  }
  public  void glRasterPos4dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos4dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos4dv(arg0,arg1);
    println("");
  }
  public  void glVariantbvEXT(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVariantbvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVariantbvEXT(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL1ui64NV(int arg0,long arg1)
  {
    printIndent();
    print(    "glVertexAttribL1ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glVertexAttribL1ui64NV(arg0,arg1);
    println("");
  }
  public  void glIndexMaterialEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glIndexMaterialEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexMaterialEXT(arg0,arg1);
    println("");
  }
  public  void glFramebufferDrawBuffersEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glFramebufferDrawBuffersEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glFramebufferDrawBuffersEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4uivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4uivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetHistogramParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetHistogramParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetHistogramParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glRectdv(java.nio.DoubleBuffer arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glRectdv("+"<java.nio.DoubleBuffer> "+arg0+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glRectdv(arg0,arg1);
    println("");
  }
  public  void glRectdv(double[] arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glRectdv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRectdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramEnvParameter4fvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glProgramEnvParameter4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glProgramEnvParameter4fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glNormal3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glNormal3dv(arg0);
    println("");
  }
  public  void glVariantusvEXT(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantusvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantusvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoordP1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glVertexAttribP2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEndList()
  {
    indent-=2;
    printIndent();
    print(    "glEndList("+")");
downstreamGL3bc.glEndList();
    println("");
  }
  public  int glGetError()
  {
    printIndent();
    print(    "glGetError("+")");
    int _res = downstreamGL3bc.glGetError();
    println(" = "+_res);
    return _res;
  }
  public  void glGetFenceivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFenceivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetFenceivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexEnvfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glConvolutionParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glConvolutionParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glConvolutionParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexParameterIivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexParameterIivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteBuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib1sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1sv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetShaderSourceARB(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderSourceARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetShaderSourceARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoord3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoord3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexCoord3i(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1i(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glUniform1i(arg0,arg1);
    println("");
  }
  public  void glUniformui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniformui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFeedbackBuffer(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glFeedbackBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glFeedbackBuffer(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsTexture(int arg0)
  {
    printIndent();
    print(    "glIsTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsTexture(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glMultiTexCoord1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1d(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetInternalformativ("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetPerfMonitorCounterDataAMD(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetPerfMonitorCounterDataAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetPerfMonitorCounterDataAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetPerfMonitorCounterDataAMD(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetPerfMonitorCounterDataAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetPerfMonitorCounterDataAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoord4hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord4hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord4hv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetConvolutionFilter(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glGetConvolutionFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glGetConvolutionFilter(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSecondaryColor3uiv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3uiv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3uiv(arg0);
    println("");
  }
  public  void glGetMultiTexEnvivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexEnvivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexEnvivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3f(int arg0,int arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glProgramUniform3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glProgramUniform3f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glIndexPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glIndexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glIndexPointer(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteNamesAMD(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glDeleteNamesAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glDeleteNamesAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glEndVideoCaptureNV(int arg0)
  {
    printIndent();
    print(    "glEndVideoCaptureNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEndVideoCaptureNV(arg0);
    println("");
  }
  public  void glGetLocalConstantBooleanvEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetLocalConstantBooleanvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
downstreamGL3bc.glGetLocalConstantBooleanvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glSelectPerfMonitorCountersAMD(int arg0,boolean arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glSelectPerfMonitorCountersAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glSelectPerfMonitorCountersAMD(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glSetFenceAPPLE(int arg0)
  {
    printIndent();
    print(    "glSetFenceAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glSetFenceAPPLE(arg0);
    println("");
  }
  public  boolean glIsNamedStringARB(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glIsNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    boolean _res = downstreamGL3bc.glIsNamedStringARB(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glRectfv(java.nio.FloatBuffer arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glRectfv("+"<java.nio.FloatBuffer> "+arg0+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glRectfv(arg0,arg1);
    println("");
  }
  public  void glRectfv(float[] arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glRectfv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRectfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexEnvfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsPBOPackEnabled()
  {
    printIndent();
    print(    "glIsPBOPackEnabled("+")");
    boolean _res = downstreamGL3bc.glIsPBOPackEnabled();
    println(" = "+_res);
    return _res;
  }
  public  void glRasterPos3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos3iv(arg0);
    println("");
  }
  public  void glVertexAttribI4ubvEXT(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4ubvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4ubvEXT(arg0,arg1);
    println("");
  }
  public  void glTextureImage3DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,boolean arg8)
  {
    printIndent();
    print(    "glTextureImage3DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<boolean> "+arg8+")");
downstreamGL3bc.glTextureImage3DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVertexAttrib2svARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2svARB(arg0,arg1);
    println("");
  }
  public  void glGetQueryiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex2h(short arg0,short arg1)
  {
    printIndent();
    print(    "glVertex2h("+"<short> "+arg0+", "+"<short> "+arg1+")");
downstreamGL3bc.glVertex2h(arg0,arg1);
    println("");
  }
  public  void glVertex2f(float arg0,float arg1)
  {
    printIndent();
    print(    "glVertex2f("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glVertex2f(arg0,arg1);
    println("");
  }
  public  void glGetProgramivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord1fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord1fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord1fv(arg0);
    println("");
  }
  public  void glVertex2d(double arg0,double arg1)
  {
    printIndent();
    print(    "glVertex2d("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glVertex2d(arg0,arg1);
    println("");
  }
  public  void glVertexWeightfvEXT(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glVertexWeightfvEXT("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glVertexWeightfvEXT(arg0);
    println("");
  }
  public  int getMaxRenderbufferSamples()
  {
        return downstreamGL3bc.getMaxRenderbufferSamples();
  }
  public  void glSecondaryColor3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3iv(arg0,arg1);
    println("");
  }
  public  void glGetNamedFramebufferAttachmentParameterivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedFramebufferAttachmentParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedFramebufferAttachmentParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex2i(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertex2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex2i(arg0,arg1);
    println("");
  }
  public  void glTexCoord3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord3iv(arg0,arg1);
    println("");
  }
  public  void glLoadMatrixf(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glLoadMatrixf("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glLoadMatrixf(arg0,arg1);
    println("");
  }
  public  void glBitmap(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5,long arg6)
  {
    printIndent();
    print(    "glBitmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<long> "+arg6+")");
downstreamGL3bc.glBitmap(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glWindowPos3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos3fv(arg0);
    println("");
  }
  public  void glVertex2s(short arg0,short arg1)
  {
    printIndent();
    print(    "glVertex2s("+"<short> "+arg0+", "+"<short> "+arg1+")");
downstreamGL3bc.glVertex2s(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI2iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2iv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4usv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4usv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetDoublev(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetDoublev("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetDoublev(arg0,arg1,arg2);
    println("");
  }
  public  void glMapVertexAttrib1dAPPLE(int arg0,int arg1,double arg2,double arg3,int arg4,int arg5,java.nio.DoubleBuffer arg6)
  {
    printIndent();
    print(    "glMapVertexAttrib1dAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg6+")");
downstreamGL3bc.glMapVertexAttrib1dAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glUniform3iARB(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3iARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3iARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI2uiEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2uiEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramStringEXT(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glNamedProgramStringEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glNamedProgramStringEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBlendFunc(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBlendFunc(arg0,arg1);
    println("");
  }
  public  void glVertexAttribs2hv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribs2hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribs2hv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnPixelMapusv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glGetnPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL3bc.glGetnPixelMapusv(arg0,arg1,arg2);
    println("");
  }
  public  void glBeginPerfMonitorAMD(int arg0)
  {
    printIndent();
    print(    "glBeginPerfMonitorAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBeginPerfMonitorAMD(arg0);
    println("");
  }
  public  void glPopAttrib()
  {
    printIndent();
    print(    "glPopAttrib("+")");
downstreamGL3bc.glPopAttrib();
    println("");
  }
  public  void glVertexAttribDivisor(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribDivisor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexAttribDivisor(arg0,arg1);
    println("");
  }
  public  void glGetMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMaterialfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
    printIndent();
    print(    "glGetActiveSubroutineName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.ByteBuffer> "+arg5+")");
downstreamGL3bc.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetMultisamplefv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMultisamplefv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMultisamplefv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParametersI4uivEXT(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParametersI4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glNamedProgramLocalParametersI4uivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramLocalParameterIivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramLocalParameterIivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramLocalParameterIivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glBlendEquationi(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBlendEquationi(arg0,arg1);
    println("");
  }
  public  void glRectiv(java.nio.IntBuffer arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glRectiv("+"<java.nio.IntBuffer> "+arg0+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glRectiv(arg0,arg1);
    println("");
  }
  public  void glRectiv(int[] arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glRectiv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRectiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform4fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex4f(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glVertex4f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glVertex4f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI2iEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2iEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex4d(double arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glVertex4d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glVertex4d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetFloati_v(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetFloati_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetFloati_v(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4usvEXT(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4usvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4usvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetShaderiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetShaderiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetShaderiv(arg0,arg1,arg2);
    println("");
  }
  public  int glGetBoundBuffer(int arg0)
  {
    printIndent();
    print(    "glGetBoundBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glGetBoundBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertex4i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertex4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertex4i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMatrixScaledEXT(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glMatrixScaledEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glMatrixScaledEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex4h(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glVertex4h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glVertex4h(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawElementsInstanced(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexEnviv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedProgramLocalParameter4fEXT(int arg0,int arg1,int arg2,float arg3,float arg4,float arg5,float arg6)
  {
    printIndent();
    print(    "glNamedProgramLocalParameter4fEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<float> "+arg6+")");
downstreamGL3bc.glNamedProgramLocalParameter4fEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glTexCoordFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexCoordFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glFrontFace(int arg0)
  {
    printIndent();
    print(    "glFrontFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glFrontFace(arg0);
    println("");
  }
  public  int getBoundFramebuffer(int arg0)
  {
        return downstreamGL3bc.getBoundFramebuffer(arg0);
  }
  public  void glVertex4s(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glVertex4s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glVertex4s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex2iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glVertex2iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glVertex2iv(arg0);
    println("");
  }
  public  void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedMultiTexImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glCompressedMultiTexImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glCompressedMultiTexImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glUseProgramObjectARB(int arg0)
  {
    printIndent();
    print(    "glUseProgramObjectARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glUseProgramObjectARB(arg0);
    println("");
  }
  public  void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    printIndent();
    print(    "glTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<long> "+arg7+")");
downstreamGL3bc.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glEvalCoord1d(double arg0)
  {
    printIndent();
    print(    "glEvalCoord1d("+"<double> "+arg0+")");
downstreamGL3bc.glEvalCoord1d(arg0);
    println("");
  }
  public  void glMultiTexSubImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glMultiTexSubImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glMultiTexSubImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glProgramUniform1uivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1uivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex4fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex4fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex4fv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL3bc.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glTextureImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glTextureImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glTextureImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glGetObjectParameterfvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetObjectParameterfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetObjectParameterfvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexArrayRangeAPPLE(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glVertexArrayRangeAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glVertexArrayRangeAPPLE(arg0,arg1);
    println("");
  }
  public  void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteFramebuffers(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2x4dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x4dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiTexCoord3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord3dv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL4dv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4bv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4bv(arg0,arg1,arg2);
    println("");
  }
  public  void glSecondaryColor3us(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glSecondaryColor3us("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glSecondaryColor3us(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4i64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexImage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
    printIndent();
    print(    "glTexImage2DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+")");
downstreamGL3bc.glTexImage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGenNamesAMD(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGenNamesAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGenNamesAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedBufferParameterui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetNamedBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetNamedBufferParameterui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVideoCaptureStreamfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetVideoCaptureStreamfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetVideoCaptureStreamfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3ivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3ivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4dvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4dvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEvalCoord2dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glEvalCoord2dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glEvalCoord2dv(arg0);
    println("");
  }
  public  void glUniform3dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiDrawElements(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5)
  {
    printIndent();
    print(    "glMultiDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glMultiDrawElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTextureStorage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoord1hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1hv(arg0,arg1);
    println("");
  }
  public  void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9)
  {
    printIndent();
    print(    "glTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<long> "+arg9+")");
downstreamGL3bc.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glGetQueryObjectuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryObjectuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glScissorIndexed(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glScissorIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glScissorIndexed(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnColorTable(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetnColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glGetnColorTable(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glVertexAttribP1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiTexCoord4sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord4sv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramLocalParameterI4iNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramLocalParameterI4iNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameterI4iNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDisableVertexAttribAPPLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisableVertexAttribAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDisableVertexAttribAPPLE(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord2iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord2iv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVariantIntegervEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVariantIntegervEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVariantIntegervEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPixelTransferf(int arg0,float arg1)
  {
    printIndent();
    print(    "glPixelTransferf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glPixelTransferf(arg0,arg1);
    println("");
  }
  public  void glProgramEnvParameter4dvARB(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramEnvParameter4dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameter4dvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetBooleanIndexedv(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetBooleanIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
downstreamGL3bc.glGetBooleanIndexedv(arg0,arg1,arg2);
    println("");
  }
  public  java.lang.Object getPlatformGLExtensions()
  {
        return downstreamGL3bc.getPlatformGLExtensions();
  }
  public  void glProgramUniformMatrix2x3fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x3fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGenQueries(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenQueries(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform2uivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2uivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4x2fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x2fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveUniformARB(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveUniformARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL3bc.glGetActiveUniformARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glVertexAttrib1sARB(int arg0,short arg1)
  {
    printIndent();
    print(    "glVertexAttrib1sARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL3bc.glVertexAttrib1sARB(arg0,arg1);
    println("");
  }
  public  void glGenSamplers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenSamplers(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsVariantEnabledEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsVariantEnabledEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsVariantEnabledEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glConvolutionFilter2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glConvolutionFilter2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL3bc.glConvolutionFilter2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttrib4NsvARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4NsvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4NsvARB(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI3uivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI3uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3uivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParameterI4uivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParameterI4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameterI4uivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBindVideoCaptureStreamTextureNV(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBindVideoCaptureStreamTextureNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glBindVideoCaptureStreamTextureNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetQueryObjectui64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectui64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryObjectui64v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL4ui64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL4ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL4ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParameters4fvEXT(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParameters4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glNamedProgramLocalParameters4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniform4ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribP2ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP2ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2ui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2ui64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord4hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord4hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord4hv(arg0);
    println("");
  }
  public  void glWindowPos3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glWindowPos3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glWindowPos3d(arg0,arg1,arg2);
    println("");
  }
  public  void glGetSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetSamplerParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI3ivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI3ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3ivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGenerateTextureMipmapEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glGenerateTextureMipmapEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glGenerateTextureMipmapEXT(arg0,arg1);
    println("");
  }
  public  void glDisableClientState(int arg0)
  {
    printIndent();
    print(    "glDisableClientState("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDisableClientState(arg0);
    println("");
  }
  public  void glVertexAttribI3ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribI3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDepthRangeArrayv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glDepthRangeArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glDepthRangeArrayv(arg0,arg1,arg2);
    println("");
  }
  public  void glResetHistogram(int arg0)
  {
    printIndent();
    print(    "glResetHistogram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glResetHistogram(arg0);
    println("");
  }
  public  void glUniformMatrix3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI4bv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4bv(arg0,arg1);
    println("");
  }
  public  void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDrawPixels(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glDrawPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTexGendv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexGendv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexGendv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWindowPos3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos3dv(arg0,arg1);
    println("");
  }
  public  void glFramebufferTexture3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glFramebufferTexture3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform2dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glUniform2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteri64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetBufferParameteri64v(arg0,arg1,arg2);
    println("");
  }
  public  void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    printIndent();
    print(    "glTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<long> "+arg10+")");
downstreamGL3bc.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glMatrixMultTransposefEXT(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixMultTransposefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixMultTransposefEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord3iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord3iv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL3dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glEnableVertexAttribArrayARB(int arg0)
  {
    printIndent();
    print(    "glEnableVertexAttribArrayARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEnableVertexAttribArrayARB(arg0);
    println("");
  }
  public  void glGetVideoCaptureStreamdvNV(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetVideoCaptureStreamdvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glGetVideoCaptureStreamdvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1ui64NV(int arg0,long arg1)
  {
    printIndent();
    print(    "glUniform1ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glUniform1ui64NV(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord4dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glClientActiveTexture(int arg0)
  {
    printIndent();
    print(    "glClientActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glClientActiveTexture(arg0);
    println("");
  }
  public  void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.ByteBuffer> "+arg5+")");
downstreamGL3bc.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetMinmaxParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMinmaxParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMinmaxParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glSecondaryColor3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3sv(arg0);
    println("");
  }
  public  void glGetMultiTexParameterfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformi64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformi64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformi64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord1fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord1fv(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3b(byte arg0,byte arg1,byte arg2)
  {
    printIndent();
    print(    "glNormal3b("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+")");
downstreamGL3bc.glNormal3b(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4usv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glColor4usv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glColor4usv(arg0);
    println("");
  }
  public  void glSecondaryColor3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glSecondaryColor3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glSecondaryColor3d(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnPixelMapuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetnPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetnPixelMapuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDrawBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDrawBuffers(arg0,arg1);
    println("");
  }
  public  void glColor3ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glColor3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glColor3ui(arg0,arg1,arg2);
    println("");
  }
  public  void glGenFencesAPPLE(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenFencesAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenFencesAPPLE(arg0,arg1);
    println("");
  }
  public  void glLinkProgramARB(int arg0)
  {
    printIndent();
    print(    "glLinkProgramARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glLinkProgramARB(arg0);
    println("");
  }
  public  void glTextureParameterIivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glTextureParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glTextureParameterIivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSamplerParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSamplerParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glSamplerParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetBooleanIndexedv(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBooleanIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetBooleanIndexedv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramBufferParametersIivNV(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glProgramBufferParametersIivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glProgramBufferParametersIivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMatrixMultfEXT(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixMultfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixMultfEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPixelMapfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetPixelMapfv(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteFencesAPPLE(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteFencesAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteFencesAPPLE(arg0,arg1,arg2);
    println("");
  }
  public  void glBeginQuery(int arg0,int arg1)
  {
    printIndent();
    print(    "glBeginQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBeginQuery(arg0,arg1);
    println("");
  }
  public  void glCompressedTextureSubImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,java.nio.Buffer arg11)
  {
    printIndent();
    print(    "glCompressedTextureSubImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+", "+"<java.nio.Buffer> "+arg11+")");
downstreamGL3bc.glCompressedTextureSubImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println("");
  }
  public  void glGetProgramEnvParameterIuivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramEnvParameterIuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramEnvParameterIuivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glNormal3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glNormal3f(arg0,arg1,arg2);
    println("");
  }
  public  long glGetBufferSize(int arg0)
  {
    printIndent();
    print(    "glGetBufferSize("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    long _res = downstreamGL3bc.glGetBufferSize(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDeleteProgramsARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteProgramsARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteProgramsARB(arg0,arg1);
    println("");
  }
  public  void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL3bc.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glFogCoordhv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glFogCoordhv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glFogCoordhv(arg0);
    println("");
  }
  public  void glMultiTexCoord2sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord2sv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1i64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedProgramLocalParameterdvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterdvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedProgramLocalParameterdvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTextureLevelParameterfvEXT(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glGetTextureLevelParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glGetTextureLevelParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetConvolutionParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetConvolutionParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetConvolutionParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1d(int arg0,int arg1,double arg2)
  {
    printIndent();
    print(    "glProgramUniform1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+")");
downstreamGL3bc.glProgramUniform1d(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex3hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex3hv(arg0,arg1);
    println("");
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glIndexfv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glIndexfv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexfv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x2fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x2fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL3bc.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glRasterPos3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glRasterPos3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glRasterPos3d(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetShaderPrecisionFormat(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderPrecisionFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderPrecisionFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform3fvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform3fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform3fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glFogCoordd(double arg0)
  {
    printIndent();
    print(    "glFogCoordd("+"<double> "+arg0+")");
downstreamGL3bc.glFogCoordd(arg0);
    println("");
  }
  public  void glShaderBinary(int arg0,java.nio.IntBuffer arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glShaderBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glShaderBinary(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBindBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glBindBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glBindBufferRange(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glNormalPointer(javax.media.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glNormalPointer("+"<javax.media.opengl.GLArrayData> "+arg0+")");
downstreamGL3bc.glNormalPointer(arg0);
    println("");
  }
  public  boolean glTestObjectAPPLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glTestObjectAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glTestObjectAPPLE(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glMapVertexAttrib2dAPPLE(int arg0,int arg1,double arg2,double arg3,int arg4,int arg5,double arg6,double arg7,int arg8,int arg9,double[] arg10,int arg11)
  {
    printIndent();
    print(    "glMapVertexAttrib2dAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<double> "+arg6+", "+"<double> "+arg7+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+")");
downstreamGL3bc.glMapVertexAttrib2dAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println("");
  }
  public  boolean glIsProgramARB(int arg0)
  {
    printIndent();
    print(    "glIsProgramARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsProgramARB(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glMultiTexCoord1sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1sv(arg0,arg1);
    println("");
  }
  public  void glPixelMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glPixelMapfv(arg0,arg1,arg2);
    println("");
  }
  public  void glClearColorIui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glClearColorIui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glClearColorIui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetUniformiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetTexLevelParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCullParameterfvEXT(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glCullParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glCullParameterfvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetSamplerParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNormalFormatNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glNormalFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormalFormatNV(arg0,arg1);
    println("");
  }
  public  void glGetnMapfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnMapfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glLightiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glLightiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glLightiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4ubvEXT(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4ubvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4ubvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glBindBufferBase(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBindBufferBase("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBindBufferBase(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3ui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform3ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform3ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI2ivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI2ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI2ivEXT(arg0,arg1);
    println("");
  }
  public  void glNamedFramebufferTextureLayerEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glNamedFramebufferTextureLayerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferTextureLayerEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int glGetSubroutineUniformLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glGetSubroutineUniformLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
    int _res = downstreamGL3bc.glGetSubroutineUniformLocation(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glEvalCoord1dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glEvalCoord1dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEvalCoord1dv(arg0,arg1);
    println("");
  }
  public  void glVariantivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetCompressedMultiTexImageEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetCompressedMultiTexImageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetCompressedMultiTexImageEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSelectBuffer(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glSelectBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glSelectBuffer(arg0,arg1);
    println("");
  }
  public  void glGetMultisamplefvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMultisamplefvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetMultisamplefvNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetUniformIndices("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetUniformIndices(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix2x4fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glDrawRangeElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWeightfvARB(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glWeightfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glWeightfvARB(arg0,arg1);
    println("");
  }
  public  void glRasterPos4fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos4fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos4fv(arg0);
    println("");
  }
  public  void glEnableVertexAttribArray(int arg0)
  {
    printIndent();
    print(    "glEnableVertexAttribArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEnableVertexAttribArray(arg0);
    println("");
  }
  public  void glGetVertexAttribLi64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribLi64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribLi64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glLightModeliv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glLightModeliv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glLightModeliv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform3ivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform3ivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glFrameTerminatorGREMEDY()
  {
    printIndent();
    print(    "glFrameTerminatorGREMEDY("+")");
downstreamGL3bc.glFrameTerminatorGREMEDY();
    println("");
  }
  public  void glVertex3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glVertex3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glVertex3fv(arg0);
    println("");
  }
  public  int glGetFragDataIndex(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetFragDataIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL3bc.glGetFragDataIndex(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4Nuiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4Nuiv(arg0,arg1);
    println("");
  }
  public  void glVariantsvEXT(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVariantsvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVariantsvEXT(arg0,arg1);
    println("");
  }
  public  void glInterleavedArrays(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glInterleavedArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glInterleavedArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3hv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeletePerfMonitorsAMD(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeletePerfMonitorsAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeletePerfMonitorsAMD(arg0,arg1);
    println("");
  }
  public  void glUniform4ui64NV(int arg0,long arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glUniform4ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glUniform4ui64NV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformSubroutineuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformSubroutineuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformSubroutineuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultMatrixd(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glMultMatrixd("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glMultMatrixd(arg0);
    println("");
  }
  public  void glGetInteger64v(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glGetInteger64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glGetInteger64v(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoordP3ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP3ui(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramEnvParameterI4ivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glProgramEnvParameterI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glProgramEnvParameterI4ivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib1fvARB(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexP2ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexP2ui(arg0,arg1);
    println("");
  }
  public  void glIndexMask(int arg0)
  {
    printIndent();
    print(    "glIndexMask("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glIndexMask(arg0);
    println("");
  }
  public  void glVertexAttribL1i64NV(int arg0,long arg1)
  {
    printIndent();
    print(    "glVertexAttribL1i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glVertexAttribL1i64NV(arg0,arg1);
    println("");
  }
  public  void glFogiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glFogiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glFogiv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexSubImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glMultiTexSubImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glMultiTexSubImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glIndexd(double arg0)
  {
    printIndent();
    print(    "glIndexd("+"<double> "+arg0+")");
downstreamGL3bc.glIndexd(arg0);
    println("");
  }
  public  void glProgramLocalParameter4dvARB(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramLocalParameter4dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameter4dvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetAttribLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetAttribLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL3bc.glGetAttribLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glUniform2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3dvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glStencilMaskSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glStencilMaskSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glStencilMaskSeparate(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL3ui64NV(int arg0,long arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glVertexAttribL3ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glVertexAttribL3ui64NV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSampleMaskIndexedNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glSampleMaskIndexedNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSampleMaskIndexedNV(arg0,arg1);
    println("");
  }
  public  void glBlendEquationSeparateIndexedAMD(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendEquationSeparateIndexedAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBlendEquationSeparateIndexedAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glColor4sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glColor4sv(arg0);
    println("");
  }
  public  void glCullFace(int arg0)
  {
    printIndent();
    print(    "glCullFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glCullFace(arg0);
    println("");
  }
  public  void glProgramLocalParameterI4uivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramLocalParameterI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameterI4uivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSetMultisamplefvAMD(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glSetMultisamplefvAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glSetMultisamplefvAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMapParameterivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMapParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMapParameterivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMatrixMultTransposedEXT(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMatrixMultTransposedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMatrixMultTransposedEXT(arg0,arg1);
    println("");
  }
  public  void glNamedFramebufferRenderbufferEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glNamedFramebufferRenderbufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferRenderbufferEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWriteMaskEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glWriteMaskEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glWriteMaskEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVDPAUMapSurfacesNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVDPAUMapSurfacesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVDPAUMapSurfacesNV(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetQueryObjectui64vEXT(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectui64vEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryObjectui64vEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteTransformFeedbacksNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacksNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteTransformFeedbacksNV(arg0,arg1);
    println("");
  }
  public  void glNamedFramebufferTextureFaceEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glNamedFramebufferTextureFaceEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferTextureFaceEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetPixelMapuiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGetPixelMapuiv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetMultiTexEnvfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexEnvfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexEnvfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCopyColorSubTable(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glCopyColorSubTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glCopyColorSubTable(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveUniformName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetActiveUniformName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glTexCoord2iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord2iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord2iv(arg0);
    println("");
  }
  public  void glGetProgramStageiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramStageiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetProgramStageiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMatrixLoadfEXT(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixLoadfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixLoadfEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glTexEnvf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexEnvf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glTexEnvf(arg0,arg1,arg2);
    println("");
  }
  public  void glMaterialiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMaterialiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMaterialiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPopName()
  {
    printIndent();
    print(    "glPopName("+")");
downstreamGL3bc.glPopName();
    println("");
  }
  public  void glVertexAttribI1iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI1iv(arg0,arg1);
    println("");
  }
  public  void glProgramEnvParametersI4ivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramEnvParametersI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParametersI4ivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord2sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord2sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord2sv(arg0,arg1);
    println("");
  }
  public  void glDepthRange(double arg0,double arg1)
  {
    printIndent();
    print(    "glDepthRange("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glDepthRange(arg0,arg1);
    println("");
  }
  public  void glMultiTexEnvfEXT(int arg0,int arg1,int arg2,float arg3)
  {
    printIndent();
    print(    "glMultiTexEnvfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<float> "+arg3+")");
downstreamGL3bc.glMultiTexEnvfEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTransformFeedbackVaryings(int arg0,int arg1,java.lang.String[] arg2,int arg3)
  {
    printIndent();
    print(    "glTransformFeedbackVaryings("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTransformFeedbackVaryings(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glSecondaryColorPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCopyMultiTexSubImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glCopyMultiTexSubImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glCopyMultiTexSubImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glColorPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glColorPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexWeightPointerEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glVertexWeightPointerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glVertexWeightPointerEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform3fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform3fv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI2uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glUniform4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glUniform4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniform4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4iv(arg0,arg1);
    println("");
  }
  public  void glClearBufferiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glClearBufferiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetFloatIndexedvEXT(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetFloatIndexedvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetFloatIndexedvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glRasterPos2iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos2iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos2iv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix4dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVariantbvEXT(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantbvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantbvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramEnvParameterfvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramEnvParameterfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramEnvParameterfvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glPixelTransformParameterfEXT(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glPixelTransformParameterfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glPixelTransformParameterfEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNormalP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glNormalP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormalP3ui(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix3x2dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x2dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColor4b(byte arg0,byte arg1,byte arg2,byte arg3)
  {
    printIndent();
    print(    "glColor4b("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+")");
downstreamGL3bc.glColor4b(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4d(double arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glColor4d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glColor4d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexGenfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL4ui64NV(int arg0,long arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribL4ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glVertexAttribL4ui64NV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform1ivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1ivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexGenf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexGenf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glTexGenf(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureParameterfEXT(int arg0,int arg1,int arg2,float arg3)
  {
    printIndent();
    print(    "glTextureParameterfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<float> "+arg3+")");
downstreamGL3bc.glTextureParameterfEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEdgeFlagFormatNV(int arg0)
  {
    printIndent();
    print(    "glEdgeFlagFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEdgeFlagFormatNV(arg0);
    println("");
  }
  public  void glGetPixelMapfv(int arg0,long arg1)
  {
    printIndent();
    print(    "glGetPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glGetPixelMapfv(arg0,arg1);
    println("");
  }
  public  void glColor4s(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glColor4s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glColor4s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFramebufferTextureARB(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTextureARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4f(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glColor4f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glColor4f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glColor4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glColor4i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTextureParameterfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTextureParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetTextureParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColor4h(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glColor4h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glColor4h(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClipPlane(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glClipPlane("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glClipPlane(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1ui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramSubroutineParametersuivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glProgramSubroutineParametersuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glProgramSubroutineParametersuivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoordP4ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoordP4ui(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColorP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColorP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColorP3ui(arg0,arg1);
    println("");
  }
  public  boolean glIsVBOElementArrayEnabled()
  {
    printIndent();
    print(    "glIsVBOElementArrayEnabled("+")");
    boolean _res = downstreamGL3bc.glIsVBOElementArrayEnabled();
    println(" = "+_res);
    return _res;
  }
  public  void glPushClientAttrib(int arg0)
  {
    printIndent();
    print(    "glPushClientAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glPushClientAttrib(arg0);
    println("");
  }
  public  void glDeleteQueries(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteQueries(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexGenfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexGenfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexGenfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetLocalConstantBooleanvEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLocalConstantBooleanvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetLocalConstantBooleanvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDebugMessageInsertAMD(int arg0,int arg1,int arg2,int arg3,java.lang.String arg4)
  {
    printIndent();
    print(    "glDebugMessageInsertAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.lang.String> "+arg4+")");
downstreamGL3bc.glDebugMessageInsertAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBlitFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glBlitFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
downstreamGL3bc.glBlitFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glGetSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetSamplerParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glNormal3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glNormal3iv(arg0);
    println("");
  }
  public  void glProgramEnvParameters4fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramEnvParameters4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameters4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glClearColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glClearColor(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetClipPlane(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glGetClipPlane("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glGetClipPlane(arg0,arg1);
    println("");
  }
  public  void glMapParameterivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMapParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMapParameterivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex2dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glVertex2dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glVertex2dv(arg0);
    println("");
  }
  public  void glSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glSamplerParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean isExtensionAvailable(java.lang.String arg0)
  {
        return downstreamGL3bc.isExtensionAvailable(arg0);
  }
  public  void glUniform1ui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEndTransformFeedback()
  {
    printIndent();
    print(    "glEndTransformFeedback("+")");
downstreamGL3bc.glEndTransformFeedback();
    println("");
  }
  public  void glLockArraysEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glLockArraysEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glLockArraysEXT(arg0,arg1);
    println("");
  }
  public  void glNamedFramebufferTexture1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glNamedFramebufferTexture1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferTexture1DEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glNormal3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glNormal3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glNormal3sv(arg0);
    println("");
  }
  public  void glVertexAttribI4uiEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4uiEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glIsVertexAttribEnabledAPPLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsVertexAttribEnabledAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsVertexAttribEnabledAPPLE(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glGetMapParameterfvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMapParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMapParameterfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glResetMinmax(int arg0)
  {
    printIndent();
    print(    "glResetMinmax("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glResetMinmax(arg0);
    println("");
  }
  public  void glProgramEnvParameterI4uivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramEnvParameterI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameterI4uivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glAccum(int arg0,float arg1)
  {
    printIndent();
    print(    "glAccum("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glAccum(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDisable(int arg0)
  {
    printIndent();
    print(    "glDisable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDisable(arg0);
    println("");
  }
  public  void glVertexAttribI4ubv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4ubv(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glColor4hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glColor4hv(arg0);
    println("");
  }
  public  void glGetMultiTexParameterivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetMapdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetMapdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetMapdv(arg0,arg1,arg2);
    println("");
  }
  public  void glWeightusvARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glWeightusvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glWeightusvARB(arg0,arg1);
    println("");
  }
  public  void glMultiTexEnvfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexEnvfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexEnvfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBeginTransformFeedback(int arg0)
  {
    printIndent();
    print(    "glBeginTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBeginTransformFeedback(arg0);
    println("");
  }
  public  void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramPipelineInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramPipelineInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glRasterPos3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos3dv(arg0);
    println("");
  }
  public  void glWindowPos2iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos2iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos2iv(arg0);
    println("");
  }
  public  void glStringMarkerGREMEDY(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glStringMarkerGREMEDY("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glStringMarkerGREMEDY(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib1dvARB(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1dvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveUniformsiv(int arg0,int arg1,int[] arg2,int arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformsiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetActiveUniformsiv(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformsiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDebugMessageControlARB(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,boolean arg5)
  {
    printIndent();
    print(    "glDebugMessageControlARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<boolean> "+arg5+")");
downstreamGL3bc.glDebugMessageControlARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetVariantBooleanvEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVariantBooleanvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVariantBooleanvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3ub(byte arg0,byte arg1,byte arg2)
  {
    printIndent();
    print(    "glSecondaryColor3ub("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+")");
downstreamGL3bc.glSecondaryColor3ub(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord1dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord1dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord1dv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glVertexAttribP4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib3sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3sv(arg0,arg1);
    println("");
  }
  public  void glBufferAddressRangeNV(int arg0,int arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glBufferAddressRangeNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glBufferAddressRangeNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDrawTransformFeedbackInstanced(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawTransformFeedbackInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDrawTransformFeedbackInstanced(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2dEXT(int arg0,int arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glProgramUniform2dEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glProgramUniform2dEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex4hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertex4hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertex4hv(arg0);
    println("");
  }
  public  void glUniformBlockBinding(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniformBlockBinding("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glUniformBlockBinding(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1dv(arg0,arg1);
    println("");
  }
  public  boolean hasFullFBOSupport()
  {
        return downstreamGL3bc.hasFullFBOSupport();
  }
  public  boolean glIsShader(int arg0)
  {
    printIndent();
    print(    "glIsShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsShader(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttribI1uivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI1uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1uivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glColor3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3iv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib2fvARB(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2fvARB(arg0,arg1);
    println("");
  }
  public  void glNamedProgramLocalParameter4dEXT(int arg0,int arg1,int arg2,double arg3,double arg4,double arg5,double arg6)
  {
    printIndent();
    print(    "glNamedProgramLocalParameter4dEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+", "+"<double> "+arg6+")");
downstreamGL3bc.glNamedProgramLocalParameter4dEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetNamedBufferParameterivEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetNamedBufferParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetNamedBufferParameterivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureLayer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glTestFenceAPPLE(int arg0)
  {
    printIndent();
    print(    "glTestFenceAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glTestFenceAPPLE(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform4dEXT(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glProgramUniform4dEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glProgramUniform4dEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  boolean glAreTexturesResident(int arg0,int[] arg1,int arg2,byte[] arg3,int arg4)
  {
    printIndent();
    print(    "glAreTexturesResident("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glAreTexturesResident(arg0,arg1,arg2,arg3,arg4);
    println(" = "+_res);
    return _res;
  }
  public  boolean glIsNamedBufferResidentNV(int arg0)
  {
    printIndent();
    print(    "glIsNamedBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsNamedBufferResidentNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glTexCoord4fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord4fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord4fv(arg0,arg1);
    println("");
  }
  public  void glBeginOcclusionQueryNV(int arg0)
  {
    printIndent();
    print(    "glBeginOcclusionQueryNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBeginOcclusionQueryNV(arg0);
    println("");
  }
  public  void glVertexAttrib4NubARB(int arg0,byte arg1,byte arg2,byte arg3,byte arg4)
  {
    printIndent();
    print(    "glVertexAttrib4NubARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+", "+"<byte> "+arg4+")");
downstreamGL3bc.glVertexAttrib4NubARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenBuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteVertexArrays(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4svEXT(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4svEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4svEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetShaderSource(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetShaderSource(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexParameterfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribs4hv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glVertexAttribs4hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL3bc.glVertexAttribs4hv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4sv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord3sv(arg0);
    println("");
  }
  public  void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTexStorage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexStorage1D(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedRenderbufferStorageMultisampleCoverageEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glNamedRenderbufferStorageMultisampleCoverageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glNamedRenderbufferStorageMultisampleCoverageEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniform3dEXT(int arg0,int arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glProgramUniform3dEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glProgramUniform3dEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTextureParameterivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTextureParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetTextureParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2i64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2i64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix2fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetIntegerui64i_vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegerui64i_vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetIntegerui64i_vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPerfMonitorCounterStringAMD(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetPerfMonitorCounterStringAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL3bc.glGetPerfMonitorCounterStringAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex2dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex2dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex2dv(arg0,arg1);
    println("");
  }
  public  void glFrustumf(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glFrustumf("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glFrustumf(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glEvalCoord2fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glEvalCoord2fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glEvalCoord2fv(arg0);
    println("");
  }
  public  void glTexCoord1dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord1dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord1dv(arg0);
    println("");
  }
  public  void glMatrixPushEXT(int arg0)
  {
    printIndent();
    print(    "glMatrixPushEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMatrixPushEXT(arg0);
    println("");
  }
  public  void glCopyMultiTexImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyMultiTexImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glCopyMultiTexImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glGenTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenTransformFeedbacks(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMapVertexAttrib2fAPPLE(int arg0,int arg1,float arg2,float arg3,int arg4,int arg5,float arg6,float arg7,int arg8,int arg9,float[] arg10,int arg11)
  {
    printIndent();
    print(    "glMapVertexAttrib2fAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<float> "+arg6+", "+"<float> "+arg7+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+")");
downstreamGL3bc.glMapVertexAttrib2fAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println("");
  }
  public  void glGetNamedProgramLocalParameterIuivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedProgramLocalParameterIuivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord3fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord3fv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib1dvARB(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1dvARB(arg0,arg1);
    println("");
  }
  public  void glPixelZoom(float arg0,float arg1)
  {
    printIndent();
    print(    "glPixelZoom("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glPixelZoom(arg0,arg1);
    println("");
  }
  public  void glDeleteProgram(int arg0)
  {
    printIndent();
    print(    "glDeleteProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDeleteProgram(arg0);
    println("");
  }
  public  void glProgramUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4ui(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glRasterPos3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos3dv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix4fvARB(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoordP2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glMultiTexCoordP2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPerfMonitorCountersAMD(int arg0,int[] arg1,int arg2,int[] arg3,int arg4,int arg5,int[] arg6,int arg7)
  {
    printIndent();
    print(    "glGetPerfMonitorCountersAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glGetPerfMonitorCountersAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glMultiTexCoord2hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord2hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord2hv(arg0,arg1);
    println("");
  }
  public  javax.media.opengl.GLContext getContext()
  {
        return downstreamGL3bc.getContext();
  }
  public  void glGetMapdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMapdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMapdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureImage2DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
    printIndent();
    print(    "glTextureImage2DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+")");
downstreamGL3bc.glTextureImage2DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glSamplerParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramBufferParametersIuivNV(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramBufferParametersIuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramBufferParametersIuivNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  long glFenceSync(int arg0,int arg1)
  {
    printIndent();
    print(    "glFenceSync("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    long _res = downstreamGL3bc.glFenceSync(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glOrthof(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glOrthof("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glOrthof(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMakeNamedBufferResidentNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glMakeNamedBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMakeNamedBufferResidentNV(arg0,arg1);
    println("");
  }
  public  void glGetQueryIndexediv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetQueryIndexediv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetQueryIndexediv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBufferParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBufferParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBufferParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoordP3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glMultiTexCoordP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribLui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribLui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribLui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoordP4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexCoordP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferParameterui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetBufferParameterui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTexStorage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glHint(int arg0,int arg1)
  {
    printIndent();
    print(    "glHint("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glHint(arg0,arg1);
    println("");
  }
  public  void glPixelTransferi(int arg0,int arg1)
  {
    printIndent();
    print(    "glPixelTransferi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPixelTransferi(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI1ivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI1ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1ivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glMakeNamedBufferNonResidentNV(int arg0)
  {
    printIndent();
    print(    "glMakeNamedBufferNonResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMakeNamedBufferNonResidentNV(arg0);
    println("");
  }
  public  void glUniform2ivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2ivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glSamplerParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetnUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetConvolutionParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetConvolutionParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetConvolutionParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glFogfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glFogfv(arg0,arg1,arg2);
    println("");
  }
  public  void glEdgeFlagv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glEdgeFlagv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glEdgeFlagv(arg0);
    println("");
  }
  public  void glColor3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glColor3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glColor3d(arg0,arg1,arg2);
    println("");
  }
  public  void glGetIntegeri_v(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegeri_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetIntegeri_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEndQueryIndexed(int arg0,int arg1)
  {
    printIndent();
    print(    "glEndQueryIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEndQueryIndexed(arg0,arg1);
    println("");
  }
  public  void glCopyTextureSubImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glCopyTextureSubImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
downstreamGL3bc.glCopyTextureSubImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glHintPGI(int arg0,int arg1)
  {
    printIndent();
    print(    "glHintPGI("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glHintPGI(arg0,arg1);
    println("");
  }
  public  void glDisableIndexed(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisableIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDisableIndexed(arg0,arg1);
    println("");
  }
  public  void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glProgramUniform3uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawTransformFeedbackNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTransformFeedbackNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDrawTransformFeedbackNV(arg0,arg1);
    println("");
  }
  public  void glLightModelfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glLightModelfv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetMultiTexGenfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexGenfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexGenfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform4i64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4i64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glShaderOp2EXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glShaderOp2EXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glShaderOp2EXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRenderbufferStorage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedProgramLocalParameterfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetNamedProgramLocalParameterfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGetIntegerv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glSecondaryColor3usv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3usv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3usv(arg0,arg1);
    println("");
  }
  public  void glClearBufferuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glClearBufferuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glViewportIndexedfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glViewportIndexedfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glViewportIndexedfv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetOcclusionQueryuivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetOcclusionQueryuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetOcclusionQueryuivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetFragDataLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetFragDataLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL3bc.glGetFragDataLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform3uivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3uivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTextureLevelParameterivEXT(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetTextureLevelParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetTextureLevelParameterivEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  boolean isFunctionAvailable(java.lang.String arg0)
  {
        return downstreamGL3bc.isFunctionAvailable(arg0);
  }
  public  boolean glIsSync(long arg0)
  {
    printIndent();
    print(    "glIsSync("+"<long> "+arg0+")");
    boolean _res = downstreamGL3bc.glIsSync(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteTextures(arg0,arg1);
    println("");
  }
  public  void glGetPerfMonitorGroupsAMD(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetPerfMonitorGroupsAMD("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetPerfMonitorGroupsAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetPerfMonitorGroupsAMD(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetPerfMonitorGroupsAMD("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetPerfMonitorGroupsAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureParameterIuivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glTextureParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glTextureParameterIuivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteOcclusionQueriesNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteOcclusionQueriesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteOcclusionQueriesNV(arg0,arg1,arg2);
    println("");
  }
  public  void glRasterPos4iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos4iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos4iv(arg0);
    println("");
  }
  public  void glMultiTexParameterivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPointSize(float arg0)
  {
    printIndent();
    print(    "glPointSize("+"<float> "+arg0+")");
downstreamGL3bc.glPointSize(arg0);
    println("");
  }
  public  void glMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMaterialfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord3hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord3hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord3hv(arg0,arg1,arg2);
    println("");
  }
  public  int glCreateShaderObjectARB(int arg0)
  {
    printIndent();
    print(    "glCreateShaderObjectARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glCreateShaderObjectARB(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glUniform3i64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform3i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform3i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform3iv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribs3hv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribs3hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribs3hv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glVertexAttribI4iEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4iEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2fv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetTexLevelParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetProgramEnvParameterIivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramEnvParameterIivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramEnvParameterIivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexLevelParameterfvEXT(int arg0,int arg1,int arg2,int arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetMultiTexLevelParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexLevelParameterfvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetVertexAttribIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4ivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4ivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glFinishFenceAPPLE(int arg0)
  {
    printIndent();
    print(    "glFinishFenceAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glFinishFenceAPPLE(arg0);
    println("");
  }
  public  void glGetLocalConstantFloatvEXT(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetLocalConstantFloatvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetLocalConstantFloatvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPushMatrix()
  {
    printIndent();
    print(    "glPushMatrix("+")");
downstreamGL3bc.glPushMatrix();
    println("");
  }
  public  void glGetUniformfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNormalP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glNormalP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glNormalP3uiv(arg0,arg1);
    println("");
  }
  public  void glBlendEquationIndexedAMD(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationIndexedAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBlendEquationIndexedAMD(arg0,arg1);
    println("");
  }
  public  void glClipPlane(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glClipPlane("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glClipPlane(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix3fvARB(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3fvARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glStencilOpSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glStencilOpSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glStencilOpSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetInteger64i_v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetInteger64i_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetInteger64i_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenVertexArrays(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4bvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4bvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4bvARB(arg0,arg1);
    println("");
  }
  public  void glDeleteProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteProgramPipelines(arg0,arg1,arg2);
    println("");
  }
  public  void glRasterPos3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos3sv(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribfvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribfvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glListBase(int arg0)
  {
    printIndent();
    print(    "glListBase("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glListBase(arg0);
    println("");
  }
  public  void glPrimitiveRestartIndex(int arg0)
  {
    printIndent();
    print(    "glPrimitiveRestartIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glPrimitiveRestartIndex(arg0);
    println("");
  }
  public  void glConvolutionFilter2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glConvolutionFilter2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glConvolutionFilter2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glActiveStencilFaceEXT(int arg0)
  {
    printIndent();
    print(    "glActiveStencilFaceEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glActiveStencilFaceEXT(arg0);
    println("");
  }
  public  void glVDPAUUnregisterSurfaceNV(long arg0)
  {
    printIndent();
    print(    "glVDPAUUnregisterSurfaceNV("+"<long> "+arg0+")");
downstreamGL3bc.glVDPAUUnregisterSurfaceNV(arg0);
    println("");
  }
  public  void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4NuivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4NuivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4NuivARB(arg0,arg1);
    println("");
  }
  public  long glVDPAURegisterOutputSurfaceNV(java.nio.Buffer arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVDPAURegisterOutputSurfaceNV("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    long _res = downstreamGL3bc.glVDPAURegisterOutputSurfaceNV(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniformMatrix3x2dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x2dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glIndexiv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glIndexiv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3fvARB(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetClipPlane(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetClipPlane("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetClipPlane(arg0,arg1,arg2);
    println("");
  }
  public  void glAttachObjectARB(int arg0,int arg1)
  {
    printIndent();
    print(    "glAttachObjectARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glAttachObjectARB(arg0,arg1);
    println("");
  }
  public  void glFramebufferTextureLayerARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureLayerARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureLayerARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glEdgeFlag(boolean arg0)
  {
    printIndent();
    print(    "glEdgeFlag("+"<boolean> "+arg0+")");
downstreamGL3bc.glEdgeFlag(arg0);
    println("");
  }
  public  void glInsertComponentEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glInsertComponentEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glInsertComponentEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glUseProgramStages(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUseProgramStages("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glUseProgramStages(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1ivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1ivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexBufferEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexBufferEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform2fvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4NivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4NivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4NivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex3sv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3i64NV(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glProgramUniform3i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glProgramUniform3i64NV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPatchParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glPatchParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glPatchParameterfv(arg0,arg1);
    println("");
  }
  public  void glRasterPos2i(int arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos2i(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3ui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3ui64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform2ui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform2ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform2ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetActiveUniformBlockiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsFenceAPPLE(int arg0)
  {
    printIndent();
    print(    "glIsFenceAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsFenceAPPLE(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glEvalCoord1dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glEvalCoord1dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glEvalCoord1dv(arg0);
    println("");
  }
  public  void glPushClientAttribDefaultEXT(int arg0)
  {
    printIndent();
    print(    "glPushClientAttribDefaultEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glPushClientAttribDefaultEXT(arg0);
    println("");
  }
  public  void glRasterPos2d(double arg0,double arg1)
  {
    printIndent();
    print(    "glRasterPos2d("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glRasterPos2d(arg0,arg1);
    println("");
  }
  public  void glRasterPos2f(float arg0,float arg1)
  {
    printIndent();
    print(    "glRasterPos2f("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glRasterPos2f(arg0,arg1);
    println("");
  }
  public  void glTexCoord2fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord2fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord2fv(arg0);
    println("");
  }
  public  void glProgramUniform3i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glFramebufferDrawBufferEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glFramebufferDrawBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFramebufferDrawBufferEXT(arg0,arg1);
    println("");
  }
  public  void glRasterPos2s(short arg0,short arg1)
  {
    printIndent();
    print(    "glRasterPos2s("+"<short> "+arg0+", "+"<short> "+arg1+")");
downstreamGL3bc.glRasterPos2s(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL2i64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL2i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL2i64vNV(arg0,arg1);
    println("");
  }
  public  void glColor3uiv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3uiv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3uiv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4ivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4ivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetObjectParameterivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetObjectParameterivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetObjectParameterivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTextureStorage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glReleaseShaderCompiler()
  {
    printIndent();
    print(    "glReleaseShaderCompiler("+")");
downstreamGL3bc.glReleaseShaderCompiler();
    println("");
  }
  public  void glWindowPos2fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos2fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos2fv(arg0);
    println("");
  }
  public  void glVertexAttrib4fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4fv(arg0,arg1);
    println("");
  }
  public  void glCompileShaderIncludeARB(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glCompileShaderIncludeARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glCompileShaderIncludeARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  int glGenVertexShadersEXT(int arg0)
  {
    printIndent();
    print(    "glGenVertexShadersEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glGenVertexShadersEXT(arg0);
    println(" = "+_res);
    return _res;
  }
  public  java.nio.ByteBuffer glAllocateMemoryNV(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glAllocateMemoryNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    java.nio.ByteBuffer _res = downstreamGL3bc.glAllocateMemoryNV(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glTexCoord3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glTexCoord3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glTexCoord3f(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1fARB(int arg0,float arg1)
  {
    printIndent();
    print(    "glUniform1fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glUniform1fARB(arg0,arg1);
    println("");
  }
  public  void glUniform1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glUniform1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glUniform1f(arg0,arg1);
    println("");
  }
  public  void glProgramLocalParameterI4ivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramLocalParameterI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameterI4ivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiDrawArraysIndirectAMD(int arg0,java.nio.Buffer arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiDrawArraysIndirectAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiDrawArraysIndirectAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3dvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3dvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedRenderbufferParameterivEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetNamedRenderbufferParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetNamedRenderbufferParameterivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnCompressedTexImage(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetnCompressedTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetnCompressedTexImage(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramLocalParameter4dvARB(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glProgramLocalParameter4dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glProgramLocalParameter4dvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGenOcclusionQueriesNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenOcclusionQueriesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenOcclusionQueriesNV(arg0,arg1,arg2);
    println("");
  }
  public  void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    printIndent();
    print(    "glColorMask("+"<boolean> "+arg0+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+")");
downstreamGL3bc.glColorMask(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindBufferOffset(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glBindBufferOffset("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glBindBufferOffset(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos4f(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glRasterPos4f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glRasterPos4f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos4i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRasterPos4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRasterPos4i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4Niv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Niv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4Niv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos4d(double arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glRasterPos4d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glRasterPos4d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetPixelMapusv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetPixelMapusv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultMatrixd(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glMultMatrixd("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMultMatrixd(arg0,arg1);
    println("");
  }
  public  void glGetBooleani_v(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBooleani_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetBooleani_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWeightivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glRasterPos4s(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glRasterPos4s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glRasterPos4s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnMapiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnMapiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnMapiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetSamplerParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glColorMaskIndexed(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    printIndent();
    print(    "glColorMaskIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+", "+"<boolean> "+arg4+")");
downstreamGL3bc.glColorMaskIndexed(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glNormal3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glNormal3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glNormal3fv(arg0);
    println("");
  }
  public  void glVertex3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glVertex3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glVertex3iv(arg0);
    println("");
  }
  public  void glVertexAttrib4usv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4usv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP3ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMatrixMultTransposedEXT(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixMultTransposedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixMultTransposedEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4uivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4uivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnPixelMapfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetnPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetnPixelMapfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClearBufferfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glClearBufferfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex4sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertex4sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertex4sv(arg0);
    println("");
  }
  public  void glGetUniformfvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformfvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord3hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord3hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord3hv(arg0);
    println("");
  }
  public  void glFinishObjectAPPLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glFinishObjectAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFinishObjectAPPLE(arg0,arg1);
    println("");
  }
  public  void glUniform2fARB(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glUniform2fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glUniform2fARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glUniform3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glUniform3f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColorSubTable(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glColorSubTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glColorSubTable(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniform2iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2uiEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2uiEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos2fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos2fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos2fv(arg0,arg1);
    println("");
  }
  public  void glCallLists(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glCallLists("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glCallLists(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord1f(float arg0)
  {
    printIndent();
    print(    "glTexCoord1f("+"<float> "+arg0+")");
downstreamGL3bc.glTexCoord1f(arg0);
    println("");
  }
  public  void glNormal3bv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glNormal3bv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormal3bv(arg0,arg1);
    println("");
  }
  public  void glProgramParameteriARB(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramParameteriARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glProgramParameteriARB(arg0,arg1,arg2);
    println("");
  }
  public  void glColor3us(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glColor3us("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glColor3us(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVideoCaptureStreamdvNV(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetVideoCaptureStreamdvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetVideoCaptureStreamdvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoord4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord4dv(arg0,arg1);
    println("");
  }
  public  void glUniform4ui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3hv(arg0);
    println("");
  }
  public  void glLoadIdentity()
  {
    printIndent();
    print(    "glLoadIdentity("+")");
downstreamGL3bc.glLoadIdentity();
    println("");
  }
  public  void glVertexAttribL3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL3dv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nusv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4Nusv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3ubv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3ubv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3ubv(arg0);
    println("");
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix2fvARB(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWindowPos3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos3dv(arg0);
    println("");
  }
  public  void glGetTexGendv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetTexGendv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetTexGendv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform2dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glVertexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glVertexPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetMultiTexParameterIuivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexParameterIuivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformMatrix3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetSynciv(long arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetSynciv("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetSynciv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetSynciv(long arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetSynciv("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetSynciv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDepthRangeArrayv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glDepthRangeArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glDepthRangeArrayv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBlendColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glBlendColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glBlendColor(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramLocalParameter4dARB(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glProgramLocalParameter4dARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glProgramLocalParameter4dARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glClearAccum(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glClearAccum("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glClearAccum(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glShaderSourceARB(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glShaderSourceARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glShaderSourceARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexImage2DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexImage2DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL3bc.glTexImage2DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetnPolygonStipple(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetnPolygonStipple("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetnPolygonStipple(arg0,arg1,arg2);
    println("");
  }
  public  void glWeightPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glWeightPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glWeightPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsSampler(int arg0)
  {
    printIndent();
    print(    "glIsSampler("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsSampler(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glTranslatef(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glTranslatef("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glTranslatef(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord4iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord4iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord4iv(arg0,arg1);
    println("");
  }
  public  void glNormal3hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glNormal3hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormal3hv(arg0,arg1);
    println("");
  }
  public  void glSecondaryColorP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glSecondaryColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glSecondaryColorP3uiv(arg0,arg1);
    println("");
  }
  public  void glEvalPoint1(int arg0)
  {
    printIndent();
    print(    "glEvalPoint1("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEvalPoint1(arg0);
    println("");
  }
  public  void glNamedRenderbufferStorageMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glNamedRenderbufferStorageMultisampleEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedRenderbufferStorageMultisampleEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI3iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3iv(arg0,arg1,arg2);
    println("");
  }
  public  int glBindParameterEXT(int arg0)
  {
    printIndent();
    print(    "glBindParameterEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glBindParameterEXT(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glScissorArrayv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glScissorArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glScissorArrayv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord1iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord1iv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL3i64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL3i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL3i64vNV(arg0,arg1);
    println("");
  }
  public  void glColor3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3fv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3i64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexGenfEXT(int arg0,int arg1,int arg2,float arg3)
  {
    printIndent();
    print(    "glMultiTexGenfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<float> "+arg3+")");
downstreamGL3bc.glMultiTexGenfEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL2i64NV(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glVertexAttribL2i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL3bc.glVertexAttribL2i64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedProgramLocalParameterdvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterdvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedProgramLocalParameterdvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexGeniv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedStringARB(int arg0,java.lang.String arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetNamedStringARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttrib4ivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4ivARB(arg0,arg1);
    println("");
  }
  public  void glNamedBufferDataEXT(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glNamedBufferDataEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glNamedBufferDataEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glIndexubv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glIndexubv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexubv(arg0,arg1);
    println("");
  }
  public  void glBeginQueryIndexed(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBeginQueryIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBeginQueryIndexed(arg0,arg1,arg2);
    println("");
  }
  public  void glWeightsvARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glWeightsvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glWeightsvARB(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1fEXT(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glProgramUniform1fEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glProgramUniform1fEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMinmaxParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMinmaxParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMinmaxParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4ivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform4ivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramLocalParametersI4ivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramLocalParametersI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParametersI4ivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenProgramPipelines(arg0,arg1,arg2);
    println("");
  }
  public  void glColorP4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glColorP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glColorP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferTextureEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTextureEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSampleCoverage(float arg0,boolean arg1)
  {
    printIndent();
    print(    "glSampleCoverage("+"<float> "+arg0+", "+"<boolean> "+arg1+")");
downstreamGL3bc.glSampleCoverage(arg0,arg1);
    println("");
  }
  public  void glFinishRenderAPPLE()
  {
    printIndent();
    print(    "glFinishRenderAPPLE("+")");
downstreamGL3bc.glFinishRenderAPPLE();
    println("");
  }
  public  void glTexCoord2hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord2hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord2hv(arg0,arg1);
    println("");
  }
  public  void glGetIntegerui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glGetIntegerui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glGetIntegerui64vNV(arg0,arg1);
    println("");
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMapVertexAttrib2dAPPLE(int arg0,int arg1,double arg2,double arg3,int arg4,int arg5,double arg6,double arg7,int arg8,int arg9,java.nio.DoubleBuffer arg10)
  {
    printIndent();
    print(    "glMapVertexAttrib2dAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<double> "+arg6+", "+"<double> "+arg7+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg10+")");
downstreamGL3bc.glMapVertexAttrib2dAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glProgramEnvParametersI4uivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramEnvParametersI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramEnvParametersI4uivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetConvolutionFilter(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetConvolutionFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetConvolutionFilter(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4NubvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4NubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4NubvARB(arg0,arg1);
    println("");
  }
  public  void glGetIntegerIndexedv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegerIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetIntegerIndexedv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramLocalParameters4fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramLocalParameters4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramLocalParameters4fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib2sARB(int arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glVertexAttrib2sARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glVertexAttrib2sARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTextureParameterIivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetTextureParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetTextureParameterIivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsTransformFeedbackNV(int arg0)
  {
    printIndent();
    print(    "glIsTransformFeedbackNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsTransformFeedbackNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib4hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4hv(arg0,arg1,arg2);
    println("");
  }
  public  void glPopClientAttrib()
  {
    printIndent();
    print(    "glPopClientAttrib("+")");
downstreamGL3bc.glPopClientAttrib();
    println("");
  }
  public  void glProgramUniform1i64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1i64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetnUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetHistogramParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetHistogramParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetHistogramParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFramebufferDrawBuffersEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferDrawBuffersEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glFramebufferDrawBuffersEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4uivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4uivEXT(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord1dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4usv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4usv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4usv(arg0,arg1);
    println("");
  }
  public  void glCompressedMultiTexSubImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,java.nio.Buffer arg11)
  {
    printIndent();
    print(    "glCompressedMultiTexSubImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+", "+"<java.nio.Buffer> "+arg11+")");
downstreamGL3bc.glCompressedMultiTexSubImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println("");
  }
  public  void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glTexEnvfv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform2iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedBufferSubDataEXT(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glNamedBufferSubDataEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glNamedBufferSubDataEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2ui64NV(int arg0,int arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glProgramUniform2ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glProgramUniform2ui64NV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetHistogram(int arg0,boolean arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glGetHistogram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL3bc.glGetHistogram(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3fARB(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glUniform3fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glUniform3fARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4dvARB(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4dvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetQueryObjectiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryObjectiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCurrentPaletteMatrix(int arg0)
  {
    printIndent();
    print(    "glCurrentPaletteMatrix("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glCurrentPaletteMatrix(arg0);
    println("");
  }
  public  void glProgramLocalParametersI4uivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramLocalParametersI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramLocalParametersI4uivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetLightiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetLightiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetLightiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3h(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glVertex3h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glVertex3h(arg0,arg1,arg2);
    println("");
  }
  public  void glSecondaryColor3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3sv(arg0,arg1);
    println("");
  }
  public  void glProgramEnvParameter4fvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramEnvParameter4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameter4fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glColor3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glColor3f(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4ui64NV(int arg0,int arg1,long arg2,long arg3,long arg4,long arg5)
  {
    printIndent();
    print(    "glProgramUniform4ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+", "+"<long> "+arg5+")");
downstreamGL3bc.glProgramUniform4ui64NV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3x2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glUniform1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glVariantdvEXT(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantdvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantdvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glReadBuffer(int arg0)
  {
    printIndent();
    print(    "glReadBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glReadBuffer(arg0);
    println("");
  }
  public  void glLightModeli(int arg0,int arg1)
  {
    printIndent();
    print(    "glLightModeli("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glLightModeli(arg0,arg1);
    println("");
  }
  public  void glIndexdv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glIndexdv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexdv(arg0,arg1);
    println("");
  }
  public  void glGetActiveUniformName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL3bc.glGetActiveUniformName(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix3dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glConvolutionParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glConvolutionParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glConvolutionParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParameter4dvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glNamedProgramLocalParameter4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glNamedProgramLocalParameter4dvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetTexEnvfv(arg0,arg1,arg2);
    println("");
  }
  public  void glStencilOpValueAMD(int arg0,int arg1)
  {
    printIndent();
    print(    "glStencilOpValueAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glStencilOpValueAMD(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4i64NV(int arg0,int arg1,long arg2,long arg3,long arg4,long arg5)
  {
    printIndent();
    print(    "glProgramUniform4i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+", "+"<long> "+arg5+")");
downstreamGL3bc.glProgramUniform4i64NV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDebugMessageEnableAMD(int arg0,int arg1,int arg2,int[] arg3,int arg4,boolean arg5)
  {
    printIndent();
    print(    "glDebugMessageEnableAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+")");
downstreamGL3bc.glDebugMessageEnableAMD(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glBeginVideoCaptureNV(int arg0)
  {
    printIndent();
    print(    "glBeginVideoCaptureNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBeginVideoCaptureNV(arg0);
    println("");
  }
  public  void glWindowPos3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glWindowPos3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWindowPos3i(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord4fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord4fv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glCompressedTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
downstreamGL3bc.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glUniform4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMapVertexAttrib1fAPPLE(int arg0,int arg1,float arg2,float arg3,int arg4,int arg5,float[] arg6,int arg7)
  {
    printIndent();
    print(    "glMapVertexAttrib1fAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glMapVertexAttrib1fAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glSelectPerfMonitorCountersAMD(int arg0,boolean arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glSelectPerfMonitorCountersAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glSelectPerfMonitorCountersAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glUnmapBuffer(int arg0)
  {
    printIndent();
    print(    "glUnmapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glUnmapBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDeleteNamesAMD(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glDeleteNamesAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glDeleteNamesAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord1sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord1sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord1sv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformBufferEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniformBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glUniformBufferEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexEnvivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexEnvivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexEnvivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetBufferParameteri64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteri64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetBufferParameteri64v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3uiv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3uiv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3uiv(arg0,arg1);
    println("");
  }
  public  void glTexCoordP1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoordP1ui(arg0,arg1);
    println("");
  }
  public  void glColor3b(byte arg0,byte arg1,byte arg2)
  {
    printIndent();
    print(    "glColor3b("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+")");
downstreamGL3bc.glColor3b(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertex3hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertex3hv(arg0);
    println("");
  }
  public  void glColor3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3dv(arg0,arg1);
    println("");
  }
  public  void glConvolutionParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glConvolutionParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glConvolutionParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glVertex3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glVertex3s(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetInternalformativ("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiTexEnviEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexEnviEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexEnviEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawTransformFeedbackStream(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawTransformFeedbackStream("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDrawTransformFeedbackStream(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glVertexAttribL2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glVertexAttribL2d(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteBuffers(arg0,arg1);
    println("");
  }
  public  void glMultiTexParameterIivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexParameterIivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEnable(int arg0)
  {
    printIndent();
    print(    "glEnable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEnable(arg0);
    println("");
  }
  public  void glDeleteShader(int arg0)
  {
    printIndent();
    print(    "glDeleteShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDeleteShader(arg0);
    println("");
  }
  public  void glFogCoordhv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glFogCoordhv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFogCoordhv(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord2sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord2sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord2sv(arg0,arg1);
    println("");
  }
  public  void glGetFenceivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetFenceivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetFenceivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glClearBufferfi(int arg0,int arg1,float arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferfi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glClearBufferfi(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDisableVariantClientStateEXT(int arg0)
  {
    printIndent();
    print(    "glDisableVariantClientStateEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDisableVariantClientStateEXT(arg0);
    println("");
  }
  public  void glVertexP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexP3ui(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP2uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glClearDepthf(float arg0)
  {
    printIndent();
    print(    "glClearDepthf("+"<float> "+arg0+")");
downstreamGL3bc.glClearDepthf(arg0);
    println("");
  }
  public  void glMultiTexCoordP1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glMultiTexCoordP1uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformi64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformi64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformi64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    printIndent();
    print(    "glDrawRangeElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glMatrixTranslatefEXT(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glMatrixTranslatefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glMatrixTranslatefEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetInvariantFloatvEXT(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetInvariantFloatvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetInvariantFloatvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3)
  {
    printIndent();
    print(    "glColor4ub("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+")");
downstreamGL3bc.glColor4ub(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteSamplers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteSamplers(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glCompressedTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetMapAttribParameterivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetMapAttribParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetMapAttribParameterivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMap1f(int arg0,float arg1,float arg2,int arg3,int arg4,java.nio.FloatBuffer arg5)
  {
    printIndent();
    print(    "glMap1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg5+")");
downstreamGL3bc.glMap1f(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVariantsvEXT(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantsvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantsvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glCopyImageSubDataNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,int arg11,int arg12,int arg13,int arg14)
  {
    printIndent();
    print(    "glCopyImageSubDataNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg12).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg13).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg14).toUpperCase()+")");
downstreamGL3bc.glCopyImageSubDataNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13,arg14);
    println("");
  }
  public  void glColor4ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glColor4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glColor4ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib3hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3hv(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4us(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glColor4us("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glColor4us(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureSubImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,java.nio.Buffer arg11)
  {
    printIndent();
    print(    "glTextureSubImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+", "+"<java.nio.Buffer> "+arg11+")");
downstreamGL3bc.glTextureSubImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println("");
  }
  public  void glVertexAttribP4ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP4ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribIuivEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribIuivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glPointParameterfv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2ivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2ivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetInteger64v(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetInteger64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetInteger64v(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramPipelineInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetProgramPipelineInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetLocalConstantIntegervEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetLocalConstantIntegervEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetLocalConstantIntegervEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParameter4fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParameter4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameter4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform1fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform1dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib3fARB(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glVertexAttrib3fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glVertexAttrib3fARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFogCoordfv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glFogCoordfv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glFogCoordfv(arg0);
    println("");
  }
  public  void glGetProgramSubroutineParameteruivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramSubroutineParameteruivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramSubroutineParameteruivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4dARB(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glVertexAttrib4dARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glVertexAttrib4dARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetQueryObjectui64vEXT(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectui64vEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryObjectui64vEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexEnvivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexEnvivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexEnvivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL2dv(arg0,arg1);
    println("");
  }
  public  void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glFlushMappedBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL3bc.glFlushMappedBufferRange(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVDPAUMapSurfacesNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVDPAUMapSurfacesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVDPAUMapSurfacesNV(arg0,arg1,arg2);
    println("");
  }
  public  void glMap2f(int arg0,float arg1,float arg2,int arg3,int arg4,float arg5,float arg6,int arg7,int arg8,java.nio.FloatBuffer arg9)
  {
    printIndent();
    print(    "glMap2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<float> "+arg5+", "+"<float> "+arg6+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg9+")");
downstreamGL3bc.glMap2f(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenRenderbuffers(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI3uiEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribI3uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3uiEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBitmap(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5,byte[] arg6,int arg7)
  {
    printIndent();
    print(    "glBitmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glBitmap(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glVariantuivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVariantuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVariantuivEXT(arg0,arg1);
    println("");
  }
  public  void glVertexAttribLFormatNV(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribLFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribLFormatNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetColorTableParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetColorTableParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetColorTableParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedProgramLocalParameterI4ivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParameterI4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameterI4ivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix4x3dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x3dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glWeightuivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glWeightuivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glWeightuivARB(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2ui(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nbv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nbv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4Nbv(arg0,arg1);
    println("");
  }
  public  java.lang.String glGetString(int arg0)
  {
    printIndent();
    print(    "glGetString("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    java.lang.String _res = downstreamGL3bc.glGetString(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramLocalParameter4fvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramLocalParameter4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameter4fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMateriali(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMateriali("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMateriali(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedBufferSubDataEXT(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetNamedBufferSubDataEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetNamedBufferSubDataEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glAreTexturesResident(int arg0,java.nio.IntBuffer arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glAreTexturesResident("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.ByteBuffer> "+arg2+")");
    boolean _res = downstreamGL3bc.glAreTexturesResident(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glWeightubvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightubvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnMapdv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnMapdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnMapdv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramPipelineiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramPipelineiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramPipelineiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetSeparableFilter(int arg0,int arg1,int arg2,java.nio.Buffer arg3,java.nio.Buffer arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetSeparableFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<java.nio.Buffer> "+arg4+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glGetSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glQueryCounter(int arg0,int arg1)
  {
    printIndent();
    print(    "glQueryCounter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glQueryCounter(arg0,arg1);
    println("");
  }
  public  void glDrawBuffersATI(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDrawBuffersATI("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDrawBuffersATI(arg0,arg1);
    println("");
  }
  public  void glEvalCoord1fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glEvalCoord1fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEvalCoord1fv(arg0,arg1);
    println("");
  }
  public  void glBlendEquation(int arg0)
  {
    printIndent();
    print(    "glBlendEquation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBlendEquation(arg0);
    println("");
  }
  public  void glUniform3ui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexGeniEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexGeniEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexGeniEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexGenfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMapParameterfvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glMapParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glMapParameterfvNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetFramebufferParameterivEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetFramebufferParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetFramebufferParameterivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3fv(arg0,arg1);
    println("");
  }
  public  void glUniform1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform1uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramEnvParameterI4uiNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramEnvParameterI4uiNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameterI4uiNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glFinishFenceNV(int arg0)
  {
    printIndent();
    print(    "glFinishFenceNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glFinishFenceNV(arg0);
    println("");
  }
  public  void glColor4sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4sv(arg0,arg1);
    println("");
  }
  public  void setSwapInterval(int arg0)
  {
    downstreamGL3bc.setSwapInterval(arg0);
  }
  public  void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBlendFuncIndexedAMD(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendFuncIndexedAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBlendFuncIndexedAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glColorTableParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glColorTableParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glColorTableParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL3bc.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPolygonMode(int arg0,int arg1)
  {
    printIndent();
    print(    "glPolygonMode("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPolygonMode(arg0,arg1);
    println("");
  }
  public  void glGetMapiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMapiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMapiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenTextures(arg0,arg1);
    println("");
  }
  public  void glGetDoublei_v(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetDoublei_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetDoublei_v(arg0,arg1,arg2);
    println("");
  }
  public  void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glGetFloatv(arg0,arg1);
    println("");
  }
  public  long glImportSyncEXT(int arg0,long arg1,int arg2)
  {
    printIndent();
    print(    "glImportSyncEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    long _res = downstreamGL3bc.glImportSyncEXT(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glGetVertexAttribLi64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribLi64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribLi64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedProgramLocalParameters4fvEXT(int arg0,int arg1,int arg2,int arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glNamedProgramLocalParameters4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameters4fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColor3bv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glColor3bv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glColor3bv(arg0);
    println("");
  }
  public  void glVertexAttrib4Nubv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4Nubv(arg0,arg1);
    println("");
  }
  public  void glNormalPointer(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glNormalPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glNormalPointer(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVariantIntegervEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVariantIntegervEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVariantIntegervEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord2iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord2iv(arg0,arg1);
    println("");
  }
  public  void glColor3ubv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glColor3ubv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glColor3ubv(arg0);
    println("");
  }
  public  void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP1uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetQueryObjectuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryObjectuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glMultiTexImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glMultiTexImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glCopyBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glCopyBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glCopyBufferSubData(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glBeginVertexShaderEXT()
  {
    printIndent();
    print(    "glBeginVertexShaderEXT("+")");
downstreamGL3bc.glBeginVertexShaderEXT();
    println("");
  }
  public  void glMultiDrawElements(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4)
  {
    printIndent();
    print(    "glMultiDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiDrawElements(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord1d(double arg0)
  {
    printIndent();
    print(    "glTexCoord1d("+"<double> "+arg0+")");
downstreamGL3bc.glTexCoord1d(arg0);
    println("");
  }
  public  void glProgramUniformMatrix2x3fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x3fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glUniform3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glUniform3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos2dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos2dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos2dv(arg0);
    println("");
  }
  public  void glBindFramebuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindFramebuffer(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix4x2fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x2fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoord2sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord2sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord2sv(arg0);
    println("");
  }
  public  void glProgramUniform3ivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3ivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPrimitiveRestartIndexNV(int arg0)
  {
    printIndent();
    print(    "glPrimitiveRestartIndexNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glPrimitiveRestartIndexNV(arg0);
    println("");
  }
  public  void glGenNamesAMD(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGenNamesAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGenNamesAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramLocalParameterdvARB(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramLocalParameterdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramLocalParameterdvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glBufferSubData(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform1ui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1ui64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteFramebuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glCopyConvolutionFilter2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glCopyConvolutionFilter2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glCopyConvolutionFilter2D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetUniformui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI3ivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI3ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI3ivEXT(arg0,arg1);
    println("");
  }
  public  void glPointParameteri(int arg0,int arg1)
  {
    printIndent();
    print(    "glPointParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPointParameteri(arg0,arg1);
    println("");
  }
  public  void glGetSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindTexture(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindTexture(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix3x4dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x4dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glFramebufferTextureFaceARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureFaceARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureFaceARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glWeightbvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightbvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightbvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glIndexFormatNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glIndexFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexFormatNV(arg0,arg1);
    println("");
  }
  public  void glDeleteLists(int arg0,int arg1)
  {
    printIndent();
    print(    "glDeleteLists("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDeleteLists(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord1i(int arg0,int arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord1i(arg0,arg1);
    println("");
  }
  public  int glGetHandleARB(int arg0)
  {
    printIndent();
    print(    "glGetHandleARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glGetHandleARB(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedProgramLocalParameterI4uivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glNamedProgramLocalParameterI4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glNamedProgramLocalParameterI4uivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glTexCoord3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glTexCoord3d(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI3uivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI3uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI3uivEXT(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVideoCaptureStreamfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetVideoCaptureStreamfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetVideoCaptureStreamfvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glUniform1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL3bc.glUniform1d(arg0,arg1);
    println("");
  }
  public  void glTexGendv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexGendv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexGendv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenSamplers(arg0,arg1);
    println("");
  }
  public  void glMatrixOrthoEXT(int arg0,double arg1,double arg2,double arg3,double arg4,double arg5,double arg6)
  {
    printIndent();
    print(    "glMatrixOrthoEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+", "+"<double> "+arg6+")");
downstreamGL3bc.glMatrixOrthoEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glOrtho("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glOrtho(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetUniformdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformdv(arg0,arg1,arg2);
    println("");
  }
  public  void glGenQueries(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenQueries(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2uivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2uivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glEnablei(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnablei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEnablei(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4ubv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4ubv(arg0,arg1,arg2);
    println("");
  }
  public  java.lang.Object getExtension(java.lang.String arg0)
  {
        return downstreamGL3bc.getExtension(arg0);
  }
  public  void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glBufferData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glBufferData(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI2iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI2iv(arg0,arg1);
    println("");
  }
  public  void glEnd()
  {
    indent-=2;
    printIndent();
    print(    "glEnd("+")");
downstreamGL3bc.glEnd();
    println("");
  }
  public  void glMultiTexCoord3i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoord3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord3i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetObjectParameterfvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetObjectParameterfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetObjectParameterfvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4bvEXT(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4bvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4bvEXT(arg0,arg1);
    println("");
  }
  public  void glWeightusvARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightusvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightusvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4hv(arg0,arg1);
    println("");
  }
  public  void glTexCoord3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord3iv(arg0);
    println("");
  }
  public  void glGetNamedFramebufferAttachmentParameterivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedFramebufferAttachmentParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedFramebufferAttachmentParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex4fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glVertex4fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glVertex4fv(arg0);
    println("");
  }
  public  void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSecondaryColor3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3iv(arg0);
    println("");
  }
  public  void glNormal3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glNormal3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormal3sv(arg0,arg1);
    println("");
  }
  public  void glGetMultisamplefv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMultisamplefv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetMultisamplefv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetQueryiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryiv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL3bc.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glEvalMesh1(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glEvalMesh1("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glEvalMesh1(arg0,arg1,arg2);
    println("");
  }
  public  void glRasterPos3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos3iv(arg0,arg1);
    println("");
  }
  public  void glGetFloati_v(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFloati_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetFloati_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib2dvARB(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2dvARB(arg0,arg1);
    println("");
  }
  public  java.nio.ByteBuffer glMapNamedBufferEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glMapNamedBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGL3bc.glMapNamedBufferEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glEvalMesh2(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glEvalMesh2("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glEvalMesh2(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform4fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform4fv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedProgramStringEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetNamedProgramStringEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetNamedProgramStringEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glLoadMatrixf(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glLoadMatrixf("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glLoadMatrixf(arg0);
    println("");
  }
  public  void glProgramUniform1dvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1dvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawBuffer(int arg0)
  {
    printIndent();
    print(    "glDrawBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDrawBuffer(arg0);
    println("");
  }
  public  void glWindowPos3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos3fv(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoordP4ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP4ui(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform3iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTextureRangeAPPLE(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glTextureRangeAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glTextureRangeAPPLE(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1uivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1uivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribdv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetMaterialfv(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteRenderbuffers(arg0,arg1);
    println("");
  }
  public  void glUniform1ui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform1ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform1ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex2iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex2iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex2iv(arg0,arg1);
    println("");
  }
  public  void glIndexFuncEXT(int arg0,float arg1)
  {
    printIndent();
    print(    "glIndexFuncEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glIndexFuncEXT(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetTexEnviv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex4hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex4hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex4hv(arg0,arg1);
    println("");
  }
  public  void glGetMultiTexImageEXT(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetMultiTexImageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glGetMultiTexImageEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetShaderiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetShaderiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetShaderiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetPolygonStipple(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glGetPolygonStipple("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glGetPolygonStipple(arg0,arg1);
    println("");
  }
  public  void glPixelMapuiv(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glPixelMapuiv(arg0,arg1,arg2);
    println("");
  }
  public  boolean isTextureFormatBGRA8888Available()
  {
        return downstreamGL3bc.isTextureFormatBGRA8888Available();
  }
  public  void glProgramBinary(int arg0,int arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramBinary(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetProgramLocalParameterIivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramLocalParameterIivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramLocalParameterIivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glShaderOp1EXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glShaderOp1EXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glShaderOp1EXT(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glCompressedTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL3bc.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glNamedProgramLocalParametersI4uivEXT(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glNamedProgramLocalParametersI4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParametersI4uivEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexP3uiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3sv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord1fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord1fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord1fv(arg0,arg1);
    println("");
  }
  public  void glVertexWeightfvEXT(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertexWeightfvEXT("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexWeightfvEXT(arg0,arg1);
    println("");
  }
  public  void glViewportIndexedf(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glViewportIndexedf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glViewportIndexedf(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2dv(arg0,arg1);
    println("");
  }
  public  void glEndOcclusionQueryNV()
  {
    printIndent();
    print(    "glEndOcclusionQueryNV("+")");
downstreamGL3bc.glEndOcclusionQueryNV();
    println("");
  }
  public  void glMakeBufferResidentNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glMakeBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMakeBufferResidentNV(arg0,arg1);
    println("");
  }
  public  void glTranslated(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glTranslated("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glTranslated(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord3s(int arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glMultiTexCoord3s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glMultiTexCoord3s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord2hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord2hv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP3uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteTransformFeedbacks(arg0,arg1);
    println("");
  }
  public  void glFlushRenderAPPLE()
  {
    printIndent();
    print(    "glFlushRenderAPPLE("+")");
downstreamGL3bc.glFlushRenderAPPLE();
    println("");
  }
  public  void glColor4bv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4bv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4bv(arg0,arg1);
    println("");
  }
  public  void glSecondaryColor3b(byte arg0,byte arg1,byte arg2)
  {
    printIndent();
    print(    "glSecondaryColor3b("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+")");
downstreamGL3bc.glSecondaryColor3b(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3d(double arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glNormal3d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glNormal3d(arg0,arg1,arg2);
    println("");
  }
  public  void glFlushVertexArrayRangeAPPLE(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glFlushVertexArrayRangeAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glFlushVertexArrayRangeAPPLE(arg0,arg1);
    println("");
  }
  public  void glUniform2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glUniform2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glUniform2f(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTextureSubImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedTextureSubImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glCompressedTextureSubImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glVertexAttribI4iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4iv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glUniform2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glUniform2d(arg0,arg1,arg2);
    println("");
  }
  public  void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glTexEnviv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform2i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glUniform2i(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferParameterui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetBufferParameterui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glColorP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glColorP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4fARB(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glUniform4fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glUniform4fARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribLui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribLui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribLui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glBindAttribLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glBindAttribLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
downstreamGL3bc.glBindAttribLocation(arg0,arg1,arg2);
    println("");
  }
  public  void glGetCompressedTexImage(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glGetCompressedTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glGetCompressedTexImage(arg0,arg1,arg2);
    println("");
  }
  public  void glLoadName(int arg0)
  {
    printIndent();
    print(    "glLoadName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glLoadName(arg0);
    println("");
  }
  public  void glSwizzleEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glSwizzleEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glSwizzleEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPassThrough(float arg0)
  {
    printIndent();
    print(    "glPassThrough("+"<float> "+arg0+")");
downstreamGL3bc.glPassThrough(arg0);
    println("");
  }
  public  void glVertexAttrib3s(int arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glVertexAttrib3s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glVertexAttrib3s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureBufferEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTextureBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTextureBufferEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord1iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord1iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord1iv(arg0,arg1);
    println("");
  }
  public  boolean glIsBufferResidentNV(int arg0)
  {
    printIndent();
    print(    "glIsBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsBufferResidentNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib2dvARB(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2dvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4svEXT(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4svEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4svEXT(arg0,arg1);
    println("");
  }
  public  void glColorTableParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glColorTableParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glColorTableParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4i64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI3i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribI3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glUniform4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glUniform4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform1f(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glProgramUniform1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glProgramUniform1f(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord3h(int arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glMultiTexCoord3h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glMultiTexCoord3h(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureImage2DMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTextureImage2DMultisampleNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL3bc.glTextureImage2DMultisampleNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttrib3h(int arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glVertexAttrib3h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glVertexAttrib3h(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI3iEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribI3iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3iEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFogCoordf(float arg0)
  {
    printIndent();
    print(    "glFogCoordf("+"<float> "+arg0+")");
downstreamGL3bc.glFogCoordf(arg0);
    println("");
  }
  public  void glVertexAttrib1fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib1fv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4sv(arg0,arg1);
    println("");
  }
  public  void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glTexCoordPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glTexCoordPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glRasterPos3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glRasterPos3f(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord3sv(arg0,arg1);
    println("");
  }
  public  void glPixelStorei(int arg0,int arg1)
  {
    printIndent();
    print(    "glPixelStorei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPixelStorei(arg0,arg1);
    println("");
  }
  public  void glVertexAttribs4hv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribs4hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribs4hv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetIntegerui64i_vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegerui64i_vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetIntegerui64i_vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glArrayElement(int arg0)
  {
    printIndent();
    print(    "glArrayElement("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glArrayElement(arg0);
    println("");
  }
  public  void glMatrixRotatedEXT(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glMatrixRotatedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glMatrixRotatedEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenPerfMonitorsAMD(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenPerfMonitorsAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenPerfMonitorsAMD(arg0,arg1);
    println("");
  }
  public  void glTexCoord2f(float arg0,float arg1)
  {
    printIndent();
    print(    "glTexCoord2f("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glTexCoord2f(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2i64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFlushVertexArrayRangeNV()
  {
    printIndent();
    print(    "glFlushVertexArrayRangeNV("+")");
downstreamGL3bc.glFlushVertexArrayRangeNV();
    println("");
  }
  public  void glTexCoord2d(double arg0,double arg1)
  {
    printIndent();
    print(    "glTexCoord2d("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL3bc.glTexCoord2d(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex2fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex2fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex2fv(arg0,arg1);
    println("");
  }
  public  void glGetHistogramParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetHistogramParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetHistogramParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord2i(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord2i(arg0,arg1);
    println("");
  }
  public  void glTexCoord2h(short arg0,short arg1)
  {
    printIndent();
    print(    "glTexCoord2h("+"<short> "+arg0+", "+"<short> "+arg1+")");
downstreamGL3bc.glTexCoord2h(arg0,arg1);
    println("");
  }
  public  void glMatrixIndexuivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glMatrixIndexuivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glMatrixIndexuivARB(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteVertexShaderEXT(int arg0)
  {
    printIndent();
    print(    "glDeleteVertexShaderEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDeleteVertexShaderEXT(arg0);
    println("");
  }
  public  void glVertexP2uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexP2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord2s(short arg0,short arg1)
  {
    printIndent();
    print(    "glTexCoord2s("+"<short> "+arg0+", "+"<short> "+arg1+")");
downstreamGL3bc.glTexCoord2s(arg0,arg1);
    println("");
  }
  public  void glDeleteFencesNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteFencesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteFencesNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramLocalParameterfvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramLocalParameterfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramLocalParameterfvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib3sARB(int arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glVertexAttrib3sARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glVertexAttrib3sARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVariantfvEXT(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantfvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1dvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform2fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1s(int arg0,short arg1)
  {
    printIndent();
    print(    "glVertexAttrib1s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL3bc.glVertexAttrib1s(arg0,arg1);
    println("");
  }
  public  void glVideoCaptureStreamParameterfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glVideoCaptureStreamParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glVideoCaptureStreamParameterfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetDebugMessageLogAMD(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,byte[] arg10,int arg11)
  {
    printIndent();
    print(    "glGetDebugMessageLogAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+")");
    int _res = downstreamGL3bc.glGetDebugMessageLogAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println(" = "+_res);
    return _res;
  }
  public  void glBindSampler(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindSampler("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindSampler(arg0,arg1);
    println("");
  }
  public  void glTextureParameterfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glTextureParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glTextureParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGenTransformFeedbacksNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTransformFeedbacksNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenTransformFeedbacksNV(arg0,arg1);
    println("");
  }
  public  void glSecondaryColor3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glSecondaryColor3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glSecondaryColor3f(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib2fARB(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glVertexAttrib2fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glVertexAttrib2fARB(arg0,arg1,arg2);
    println("");
  }
  public  void glClampColor(int arg0,int arg1)
  {
    printIndent();
    print(    "glClampColor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glClampColor(arg0,arg1);
    println("");
  }
  public  void glMatrixIndexubvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glMatrixIndexubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glMatrixIndexubvARB(arg0,arg1);
    println("");
  }
  public  void glGetMapfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMapfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribLPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL3bc.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetColorTableParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetColorTableParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetColorTableParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVDPAUSurfaceAccessNV(long arg0,int arg1)
  {
    printIndent();
    print(    "glVDPAUSurfaceAccessNV("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVDPAUSurfaceAccessNV(arg0,arg1);
    println("");
  }
  public  void glBegin(int arg0)
  {
    printIndent();
    print(    "glBegin("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBegin(arg0);
    println("");
  }
  public  void glGetMultiTexParameterIivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexParameterIivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos3fv(arg0,arg1);
    println("");
  }
  public  int getDefaultDrawFramebuffer()
  {
        return downstreamGL3bc.getDefaultDrawFramebuffer();
  }
  public  void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertexBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGenFencesNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenFencesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenFencesNV(arg0,arg1);
    println("");
  }
  public  void glGetNamedProgramivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedProgramivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedProgramivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib1h(int arg0,short arg1)
  {
    printIndent();
    print(    "glVertexAttrib1h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL3bc.glVertexAttrib1h(arg0,arg1);
    println("");
  }
  public  boolean glIsProgram(int arg0)
  {
    printIndent();
    print(    "glIsProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsProgram(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetInvariantIntegervEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetInvariantIntegervEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetInvariantIntegervEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColorFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSecondaryColorFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glSecondaryColorFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glPopMatrix()
  {
    printIndent();
    print(    "glPopMatrix("+")");
downstreamGL3bc.glPopMatrix();
    println("");
  }
  public  void glMapGrid1d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glMapGrid1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL3bc.glMapGrid1d(arg0,arg1,arg2);
    println("");
  }
  public  void glMapGrid1f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glMapGrid1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glMapGrid1f(arg0,arg1,arg2);
    println("");
  }
  public  void glStencilClearTagEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glStencilClearTagEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glStencilClearTagEXT(arg0,arg1);
    println("");
  }
  public  void glPointParameteriv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glPointParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glPointParameteriv(arg0,arg1);
    println("");
  }
  public  void glIndexf(float arg0)
  {
    printIndent();
    print(    "glIndexf("+"<float> "+arg0+")");
downstreamGL3bc.glIndexf(arg0);
    println("");
  }
  public  void glTexRenderbufferNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexRenderbufferNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexRenderbufferNV(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribIivEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribIivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenFramebuffers(arg0,arg1);
    println("");
  }
  public  void glGetTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetTexGeniv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramStringARB(int arg0,int arg1,int arg2,java.lang.String arg3)
  {
    printIndent();
    print(    "glProgramStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.lang.String> "+arg3+")");
downstreamGL3bc.glProgramStringARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribs3hv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glVertexAttribs3hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL3bc.glVertexAttribs3hv(arg0,arg1,arg2);
    println("");
  }
  public  void glSecondaryColor3bv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3bv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3bv(arg0,arg1);
    println("");
  }
  public  void glGetMultiTexLevelParameterivEXT(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetMultiTexLevelParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexLevelParameterivEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVariantubvEXT(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVariantubvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVariantubvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4x3fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x3fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoordP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexCoordP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInteger64i_v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetInteger64i_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetInteger64i_v(arg0,arg1,arg2);
    println("");
  }
  public  void glLightf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glLightf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glLightf(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL2ui64NV(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glVertexAttribL2ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL3bc.glVertexAttribL2ui64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnUniformuiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetnUniformuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramBufferParametersfvNV(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramBufferParametersfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramBufferParametersfvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramLocalParameterdvARB(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramLocalParameterdvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramLocalParameterdvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4uiv(arg0,arg1);
    println("");
  }
  public  void glDrawElementsIndirect(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glDrawElementsIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glDrawElementsIndirect(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord3hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord3hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord3hv(arg0,arg1);
    println("");
  }
  public  void glCopyColorTable(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glCopyColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glCopyColorTable(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform4fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVideoCaptureivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVideoCaptureivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVideoCaptureivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedStringivARB(int arg0,java.lang.String arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedStringivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedStringivARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexP4uiv(arg0,arg1);
    println("");
  }
  public  void glEnableIndexed(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnableIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEnableIndexed(arg0,arg1);
    println("");
  }
  public  void glRasterPos2dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos2dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos2dv(arg0,arg1);
    println("");
  }
  public  void glPolygonOffset(float arg0,float arg1)
  {
    printIndent();
    print(    "glPolygonOffset("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glPolygonOffset(arg0,arg1);
    println("");
  }
  public  void glTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glTexParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glEnableClientStateIndexedEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnableClientStateIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEnableClientStateIndexedEXT(arg0,arg1);
    println("");
  }
  public  void glGetCompressedTextureImageEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetCompressedTextureImageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetCompressedTextureImageEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3usv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3usv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3usv(arg0);
    println("");
  }
  public  void glViewportArrayv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glViewportArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glViewportArrayv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord2fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord2fv(arg0,arg1);
    println("");
  }
  public  void glTextureParameterivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glTextureParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glTextureParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord4iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord4iv(arg0,arg1,arg2);
    println("");
  }
  public  long glCreateSyncFromCLeventARB(java.nio.Buffer arg0,java.nio.Buffer arg1,int arg2)
  {
    printIndent();
    print(    "glCreateSyncFromCLeventARB("+"<java.nio.Buffer> "+arg0+", "+"<java.nio.Buffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    long _res = downstreamGL3bc.glCreateSyncFromCLeventARB(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glFinishTextureSUNX()
  {
    printIndent();
    print(    "glFinishTextureSUNX("+")");
downstreamGL3bc.glFinishTextureSUNX();
    println("");
  }
  public  void glGetMapAttribParameterfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMapAttribParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMapAttribParameterfvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3i64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glResumeTransformFeedback()
  {
    printIndent();
    print(    "glResumeTransformFeedback("+")");
downstreamGL3bc.glResumeTransformFeedback();
    println("");
  }
  public  void glMultiTexCoordP4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glMultiTexCoordP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glCopyTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glCopyTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glCopyTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttribI1uiEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribI1uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1uiEXT(arg0,arg1);
    println("");
  }
  public  void glPolygonStipple(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glPolygonStipple("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPolygonStipple(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord1s(int arg0,short arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1s(arg0,arg1);
    println("");
  }
  public  void glProgramEnvParameter4fARB(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glProgramEnvParameter4fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glProgramEnvParameter4fARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetColorTable(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glGetColorTable(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetTexParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertex3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertex3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertex3sv(arg0);
    println("");
  }
  public  void glProgramUniformMatrix3x4dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x4dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPixelMapuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glPixelMapuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDrawArraysIndirect(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glDrawArraysIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glDrawArraysIndirect(arg0,arg1);
    println("");
  }
  public  void glStencilOp(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glStencilOp(arg0,arg1,arg2);
    println("");
  }
  public  void glScissorIndexedv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glScissorIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glScissorIndexedv(arg0,arg1);
    println("");
  }
  public  void glMultiTexParameterIuivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexParameterIuivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int glGenSymbolsEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glGenSymbolsEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    int _res = downstreamGL3bc.glGenSymbolsEXT(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glProgramUniformMatrix3fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTextureParameteriEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTextureParameteriEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTextureParameteriEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI1uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI1uiv(arg0,arg1);
    println("");
  }
  public  void glColor4fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glColor4fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glColor4fv(arg0);
    println("");
  }
  public  void glPixelMapusv(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glPixelMapusv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4ubvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4ubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4ubvARB(arg0,arg1);
    println("");
  }
  public  void glFramebufferTextureLayerEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureLayerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureLayerEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetSubroutineIndex(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glGetSubroutineIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
    int _res = downstreamGL3bc.glGetSubroutineIndex(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glGetProgramLocalParameterIuivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramLocalParameterIuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetProgramLocalParameterIuivNV(arg0,arg1,arg2);
    println("");
  }
  public  int glGenLists(int arg0)
  {
    printIndent();
    print(    "glGenLists("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glGenLists(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glMultiTexCoord1h(int arg0,short arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1h("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1h(arg0,arg1);
    println("");
  }
  public  void glTexGendv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glTexGendv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glTexGendv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedStringARB(int arg0,java.lang.String arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL3bc.glGetNamedStringARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVideoCaptureStreamParameterivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVideoCaptureStreamParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVideoCaptureStreamParameterivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4x2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVDPAUGetSurfaceivNV(long arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glVDPAUGetSurfaceivNV("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glVDPAUGetSurfaceivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVDPAUGetSurfaceivNV(long arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glVDPAUGetSurfaceivNV("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glVDPAUGetSurfaceivNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttribI1i(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribI1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1i(arg0,arg1);
    println("");
  }
  public  void glColor4ubv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4ubv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4ubv(arg0,arg1);
    println("");
  }
  public  void glRasterPos3sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos3sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos3sv(arg0);
    println("");
  }
  public  void glBlendFuncSeparatei(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBlendFuncSeparatei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glBlendFuncSeparatei(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glConvolutionFilter1D(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glConvolutionFilter1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL3bc.glConvolutionFilter1D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMatrixFrustumEXT(int arg0,double arg1,double arg2,double arg3,double arg4,double arg5,double arg6)
  {
    printIndent();
    print(    "glMatrixFrustumEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+", "+"<double> "+arg6+")");
downstreamGL3bc.glMatrixFrustumEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetTextureParameterIuivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTextureParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetTextureParameterIuivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glVertexAttribL1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL3bc.glVertexAttribL1d(arg0,arg1);
    println("");
  }
  public  void glFogCoordPointer(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glFogCoordPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glFogCoordPointer(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform3fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMatrixLoadTransposefEXT(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixLoadTransposefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixLoadTransposefEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferReadBufferEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glFramebufferReadBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFramebufferReadBufferEXT(arg0,arg1);
    println("");
  }
  public  void glDepthMask(boolean arg0)
  {
    printIndent();
    print(    "glDepthMask("+"<boolean> "+arg0+")");
downstreamGL3bc.glDepthMask(arg0);
    println("");
  }
  public  void glTexGend(int arg0,int arg1,double arg2)
  {
    printIndent();
    print(    "glTexGend("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+")");
downstreamGL3bc.glTexGend(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexRenderbufferEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexRenderbufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexRenderbufferEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord3fv(arg0);
    println("");
  }
  public  void glGetPerfMonitorCounterStringAMD(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetPerfMonitorCounterStringAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetPerfMonitorCounterStringAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glProgramUniformMatrix4x3dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x3dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  boolean hasGLSL()
  {
        return downstreamGL3bc.hasGLSL();
  }
  public  void glVertexAttrib4NbvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4NbvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4NbvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI2uivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2uivEXT(arg0,arg1,arg2);
    println("");
  }
  public  int getSwapInterval()
  {
        return downstreamGL3bc.getSwapInterval();
  }
  public  int glCreateProgram()
  {
    printIndent();
    print(    "glCreateProgram("+")");
    int _res = downstreamGL3bc.glCreateProgram();
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttribI3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetShaderSource(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetShaderSource(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL3bc.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVertexAttribL2dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glLineWidth(float arg0)
  {
    printIndent();
    print(    "glLineWidth("+"<float> "+arg0+")");
downstreamGL3bc.glLineWidth(arg0);
    println("");
  }
  public  void glProgramUniform1dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord3hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord3hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord3hv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glVertexAttribL3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glVertexAttribL3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glColor4iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glColor4iv(arg0);
    println("");
  }
  public  void glVertexAttribL2i64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL2i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL2i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  int glVideoCaptureNV(int arg0,java.nio.IntBuffer arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glVideoCaptureNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.LongBuffer> "+arg2+")");
    int _res = downstreamGL3bc.glVideoCaptureNV(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttribIFormatNV(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribIFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribIFormatNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex4sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex4sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex4sv(arg0,arg1);
    println("");
  }
  public  void glGetMaterialiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetMaterialiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetMaterialiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetObjectParameterivAPPLE(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetObjectParameterivAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetObjectParameterivAPPLE(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4bv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4bv(arg0,arg1,arg2);
    println("");
  }
  public  void glLoadTransposeMatrixf(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glLoadTransposeMatrixf("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glLoadTransposeMatrixf(arg0);
    println("");
  }
  public  void glVertex4iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glVertex4iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glVertex4iv(arg0);
    println("");
  }
  public  void glGetOcclusionQueryivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetOcclusionQueryivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetOcclusionQueryivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4usv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4usv(arg0,arg1,arg2);
    println("");
  }
  public  void glPixelTransformParameterivEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glPixelTransformParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glPixelTransformParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMinmax(int arg0,int arg1,boolean arg2)
  {
    printIndent();
    print(    "glMinmax("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+")");
downstreamGL3bc.glMinmax(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4fvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform4fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glMultMatrixf(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glMultMatrixf("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMultMatrixf(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3ui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform3ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform2ui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindTransformFeedback(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindTransformFeedback(arg0,arg1);
    println("");
  }
  public  void glGetnMapdv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetnMapdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glGetnMapdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4uivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4uivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4uivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPixelMapusv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glGetPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glGetPixelMapusv(arg0,arg1);
    println("");
  }
  public  long glVDPAURegisterVideoSurfaceNV(java.nio.Buffer arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVDPAURegisterVideoSurfaceNV("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    long _res = downstreamGL3bc.glVDPAURegisterVideoSurfaceNV(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glGetNamedProgramLocalParameterIivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedProgramLocalParameterIivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramEnvParameterI4iNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramEnvParameterI4iNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameterI4iNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetDoublei_v(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetDoublei_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetDoublei_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColorTable(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL3bc.glColorTable(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoordP1uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glTexCoordP1uiv(arg0,arg1);
    println("");
  }
  public  void glGenProgramsARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenProgramsARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenProgramsARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformSubroutinesuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniformSubroutinesuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniformSubroutinesuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetMultiTexGenivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexGenivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexGenivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMinSampleShading(float arg0)
  {
    printIndent();
    print(    "glMinSampleShading("+"<float> "+arg0+")");
downstreamGL3bc.glMinSampleShading(arg0);
    println("");
  }
  public  void glSecondaryColor3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3fv(arg0);
    println("");
  }
  public  void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glTextureStorage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glTexCoordP2uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glTexCoordP2uiv(arg0,arg1);
    println("");
  }
  public  void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glGetBooleanv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2i64NV(int arg0,int arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glProgramUniform2i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glProgramUniform2i64NV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsRenderbuffer(int arg0)
  {
    printIndent();
    print(    "glIsRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsRenderbuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetIntegerui64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetIntegerui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetIntegerui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glEdgeFlagPointer(int arg0,long arg1)
  {
    printIndent();
    print(    "glEdgeFlagPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glEdgeFlagPointer(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetActiveAtomicCounterBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4dvARB(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4dvARB(arg0,arg1);
    println("");
  }
  public  void glGetVideoCaptureStreamivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetVideoCaptureStreamivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetVideoCaptureStreamivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCopyPixels(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glCopyPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glCopyPixels(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertex3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertex3i(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glTexParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glWindowPos3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos3iv(arg0,arg1);
    println("");
  }
  public  void glProvokingVertexEXT(int arg0)
  {
    printIndent();
    print(    "glProvokingVertexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glProvokingVertexEXT(arg0);
    println("");
  }
  public  void glTexCoord4s(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glTexCoord4s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glTexCoord4s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTextureImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glTextureImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
downstreamGL3bc.glTextureImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glTexCoord4i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTexCoord4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexCoord4i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribPointerARB(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glVertexAttribPointerARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL3bc.glVertexAttribPointerARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glNormal3hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glNormal3hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glNormal3hv(arg0);
    println("");
  }
  public  void glTexCoord4f(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glTexCoord4f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glTexCoord4f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexSubImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,java.nio.Buffer arg11)
  {
    printIndent();
    print(    "glMultiTexSubImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+", "+"<java.nio.Buffer> "+arg11+")");
downstreamGL3bc.glMultiTexSubImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println("");
  }
  public  void glMultiTexCoord1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1dv(arg0,arg1);
    println("");
  }
  public  void glTexCoord4h(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glTexCoord4h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glTexCoord4h(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord4d(double arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glTexCoord4d("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glTexCoord4d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVariantFloatvEXT(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetVariantFloatvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetVariantFloatvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform4iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform4iv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultTransposeMatrixf(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glMultTransposeMatrixf("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glMultTransposeMatrixf(arg0);
    println("");
  }
  public  void glNamedProgramLocalParameter4dvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParameter4dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameter4dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform1fvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform1fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform1fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glColor4uiv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glColor4uiv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glColor4uiv(arg0);
    println("");
  }
  public  void glTexParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glTexParameterf(arg0,arg1,arg2);
    println("");
  }
  public  void glIndexdv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glIndexdv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glIndexdv(arg0);
    println("");
  }
  public  void glProgramUniform1ui64NV(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glProgramUniform1ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glProgramUniform1ui64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureImage3DMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
    printIndent();
    print(    "glTextureImage3DMultisampleNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+")");
downstreamGL3bc.glTextureImage3DMultisampleNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glVariantdvEXT(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVariantdvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVariantdvEXT(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform1dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform1dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCopyTextureImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyTextureImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
downstreamGL3bc.glCopyTextureImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVertexAttrib4Nusv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4Nusv(arg0,arg1);
    println("");
  }
  public  void glSecondaryColor3hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3hv(arg0,arg1);
    println("");
  }
  public  void glConvolutionParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glConvolutionParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glConvolutionParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteNamedStringARB(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glDeleteNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
downstreamGL3bc.glDeleteNamedStringARB(arg0,arg1);
    println("");
  }
  public  void glColor3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glColor3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glColor3dv(arg0);
    println("");
  }
  public  void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVariantPointerEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glVariantPointerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glVariantPointerEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4hv(arg0,arg1);
    println("");
  }
  public  void glInitNames()
  {
    printIndent();
    print(    "glInitNames("+")");
downstreamGL3bc.glInitNames();
    println("");
  }
  public  void glBindBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBindBuffer(arg0,arg1);
    println("");
  }
  public  void glGetMinmax(int arg0,boolean arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetMinmax("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glGetMinmax(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexGenivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexGenivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexGenivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4ui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform4ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform4ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4fvARB(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glBlendEquationSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBlendEquationSeparate(arg0,arg1);
    println("");
  }
  public  void glCompileShaderARB(int arg0)
  {
    printIndent();
    print(    "glCompileShaderARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glCompileShaderARB(arg0);
    println("");
  }
  public  void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform1uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glShaderSource(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawArrays(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDrawArrays(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsVBOArrayEnabled()
  {
    printIndent();
    print(    "glIsVBOArrayEnabled("+")");
    boolean _res = downstreamGL3bc.glIsVBOArrayEnabled();
    println(" = "+_res);
    return _res;
  }
  public  void glFramebufferTextureFaceEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureFaceEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTextureFaceEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glNamedProgramLocalParameterI4uiEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glNamedProgramLocalParameterI4uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameterI4uiEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glProgramUniform3i64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3i64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glNamedProgramLocalParametersI4ivEXT(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glNamedProgramLocalParametersI4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glNamedProgramLocalParametersI4ivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glLightfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL3i64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL3i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL3i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3x4fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x4fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWindowPos3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glWindowPos3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glWindowPos3s(arg0,arg1,arg2);
    println("");
  }
  public  void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetLightfv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInvariantBooleanvEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetInvariantBooleanvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
downstreamGL3bc.glGetInvariantBooleanvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord2hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord2hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord2hv(arg0);
    println("");
  }
  public  void glFogf(int arg0,float arg1)
  {
    printIndent();
    print(    "glFogf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glFogf(arg0,arg1);
    println("");
  }
  public  void glProgramLocalParameterI4uiNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramLocalParameterI4uiNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameterI4uiNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPixelTransformParameterfvEXT(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glPixelTransformParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glPixelTransformParameterfvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteSync(long arg0)
  {
    printIndent();
    print(    "glDeleteSync("+"<long> "+arg0+")");
downstreamGL3bc.glDeleteSync(arg0);
    println("");
  }
  public  void glSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glSamplerParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glUniform2ui(arg0,arg1,arg2);
    println("");
  }
  public  void glWeightsvARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightsvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightsvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnSeparableFilter(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5,java.nio.Buffer arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glGetnSeparableFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glGetnSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glNormalP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glNormalP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glNormalP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glEndQuery(int arg0)
  {
    printIndent();
    print(    "glEndQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEndQuery(arg0);
    println("");
  }
  public  void glMultiTexCoord2dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3fvARB(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3fvARB(arg0,arg1);
    println("");
  }
  public  void glProgramEnvParameter4dARB(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glProgramEnvParameter4dARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glProgramEnvParameter4dARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glNormalPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glNormalPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glNormalPointer(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glUniform4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedCopyBufferSubDataEXT(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glNamedCopyBufferSubDataEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glNamedCopyBufferSubDataEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformBlockName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttribI4ivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4ivEXT(arg0,arg1);
    println("");
  }
  public  void glGetProgramEnvParameterIivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramEnvParameterIivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramEnvParameterIivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL1ui64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL1ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL1ui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glBindProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glBindProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBindProgramPipeline(arg0);
    println("");
  }
  public  void glUniform2fvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform2fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform2fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1svARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1svARB(arg0,arg1);
    println("");
  }
  public  void glGetPixelMapusv(int arg0,long arg1)
  {
    printIndent();
    print(    "glGetPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glGetPixelMapusv(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribfvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribfvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColor3h(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glSecondaryColor3h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glSecondaryColor3h(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexParameterivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos4iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos4iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos4iv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3fvARB(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix3fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteOcclusionQueriesNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteOcclusionQueriesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteOcclusionQueriesNV(arg0,arg1);
    println("");
  }
  public  void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteTextures(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureParameterIuivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glTextureParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glTextureParameterIuivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glVertexAttrib1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glVertexAttrib1f(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetActiveUniform(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveUniform("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL3bc.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glScissor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glScissor(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTextureLevelParameterivEXT(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetTextureLevelParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetTextureLevelParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3uivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3uivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSecondaryColor3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glSecondaryColor3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glSecondaryColor3s(arg0,arg1,arg2);
    println("");
  }
  public  void glGetOcclusionQueryuivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetOcclusionQueryuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetOcclusionQueryuivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glClearBufferuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glClearBufferuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetIntegerv(arg0,arg1,arg2);
    println("");
  }
  public  void glDebugMessageInsertARB(int arg0,int arg1,int arg2,int arg3,int arg4,java.lang.String arg5)
  {
    printIndent();
    print(    "glDebugMessageInsertARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.lang.String> "+arg5+")");
downstreamGL3bc.glDebugMessageInsertARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTexLevelParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetMultiTexLevelParameterfvEXT(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glGetMultiTexLevelParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glGetMultiTexLevelParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexParameterfEXT(int arg0,int arg1,int arg2,float arg3)
  {
    printIndent();
    print(    "glMultiTexParameterfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<float> "+arg3+")");
downstreamGL3bc.glMultiTexParameterfEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glIndexsv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glIndexsv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glIndexsv(arg0,arg1);
    println("");
  }
  public  void glUniform2i64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform2i64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRenderbufferStorageMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glRenderbufferStorageMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttrib4NivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4NivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4NivARB(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1ivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1ivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib2fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib2fv(arg0,arg1);
    println("");
  }
  public  void glSecondaryColor3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColor3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3dv(arg0,arg1);
    println("");
  }
  public  void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glFrustum("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glFrustum(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVideoCaptureStreamParameterdvNV(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glVideoCaptureStreamParameterdvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glVideoCaptureStreamParameterdvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnHistogram(int arg0,boolean arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetnHistogram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glGetnHistogram(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColor4dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor4dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor4dv(arg0,arg1);
    println("");
  }
  public  void glColor3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3sv(arg0,arg1);
    println("");
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glBindLightParameterEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindLightParameterEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    int _res = downstreamGL3bc.glBindLightParameterEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glGetLocalConstantFloatvEXT(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLocalConstantFloatvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetLocalConstantFloatvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoordP2ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoordP2ui(arg0,arg1);
    println("");
  }
  public  void glIndexiv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glIndexiv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glIndexiv(arg0);
    println("");
  }
  public  void glRasterPos3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glRasterPos3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glRasterPos3s(arg0,arg1,arg2);
    println("");
  }
  public  void glSetFenceNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glSetFenceNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSetFenceNV(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL3ui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL3ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL3ui64vNV(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1ui(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord3sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord3sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord3sv(arg0,arg1);
    println("");
  }
  public  void glUniform3i64NV(int arg0,long arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glUniform3i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glUniform3i64NV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  long glVDPAURegisterOutputSurfaceNV(java.nio.Buffer arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVDPAURegisterOutputSurfaceNV("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    long _res = downstreamGL3bc.glVDPAURegisterOutputSurfaceNV(arg0,arg1,arg2,arg3,arg4);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib4NuivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4NuivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4NuivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glExtractComponentEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glExtractComponentEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glExtractComponentEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetInvariantBooleanvEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetInvariantBooleanvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetInvariantBooleanvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glViewportIndexedfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glViewportIndexedfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glViewportIndexedfv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniformui64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL4i64NV(int arg0,long arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribL4i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glVertexAttribL4i64NV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glMaterialfv(arg0,arg1,arg2);
    println("");
  }
  public  void glFogCoordh(short arg0)
  {
    printIndent();
    print(    "glFogCoordh("+"<short> "+arg0+")");
downstreamGL3bc.glFogCoordh(arg0);
    println("");
  }
  public  void glDeleteProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteProgramPipelines(arg0,arg1);
    println("");
  }
  public  void glRectsv(java.nio.ShortBuffer arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glRectsv("+"<java.nio.ShortBuffer> "+arg0+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glRectsv(arg0,arg1);
    println("");
  }
  public  void glRectsv(short[] arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glRectsv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRectsv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glMultiTexCoord3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glMultiTexCoord3f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWindowPos2sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glWindowPos2sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glWindowPos2sv(arg0);
    println("");
  }
  public  void glVertexAttrib3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glVertexAttrib3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glVertexAttrib3f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMatrixMode(int arg0)
  {
    printIndent();
    print(    "glMatrixMode("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMatrixMode(arg0);
    println("");
  }
  public  void glPauseTransformFeedback()
  {
    printIndent();
    print(    "glPauseTransformFeedback("+")");
downstreamGL3bc.glPauseTransformFeedback();
    println("");
  }
  public  void glGenVertexArrays(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenVertexArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferTexture(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glFramebufferTexture(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawArraysInstancedBaseInstance(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glDrawArraysInstancedBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glDrawArraysInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2hv(arg0,arg1,arg2);
    println("");
  }
  public  void glLightModelfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glLightModelfv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetMultiTexGenfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexGenfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexGenfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3uiEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3uiEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoordP2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetPerfMonitorCountersAMD(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetPerfMonitorCountersAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetPerfMonitorCountersAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMatrixLoadTransposedEXT(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMatrixLoadTransposedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMatrixLoadTransposedEXT(arg0,arg1);
    println("");
  }
  public  void glVertexFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedProgramLocalParameterfvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedProgramLocalParameterfvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTexture2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetNamedProgramLocalParameterIuivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedProgramLocalParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetNamedProgramLocalParameterIuivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetTexParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGenTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenTransformFeedbacks(arg0,arg1);
    println("");
  }
  public  void glPushName(int arg0)
  {
    printIndent();
    print(    "glPushName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glPushName(arg0);
    println("");
  }
  public  void glClearStencil(int arg0)
  {
    printIndent();
    print(    "glClearStencil("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glClearStencil(arg0);
    println("");
  }
  public  boolean glIsFramebuffer(int arg0)
  {
    printIndent();
    print(    "glIsFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsFramebuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glBindMultiTextureEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBindMultiTextureEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBindMultiTextureEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribPointer(javax.media.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<javax.media.opengl.GLArrayData> "+arg0+")");
downstreamGL3bc.glVertexAttribPointer(arg0);
    println("");
  }
  public  void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetTransformFeedbackVarying("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL3bc.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glGetTexImage(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glGetTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL3bc.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glViewport("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glViewport(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4fvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL1dv(arg0,arg1);
    println("");
  }
  public  void glLoadMatrixd(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glLoadMatrixd("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glLoadMatrixd(arg0);
    println("");
  }
  public  void glGetTextureParameterivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetTextureParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetTextureParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPointParameterf(int arg0,float arg1)
  {
    printIndent();
    print(    "glPointParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glPointParameterf(arg0,arg1);
    println("");
  }
  public  void glProgramUniform3d(int arg0,int arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glProgramUniform3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glProgramUniform3d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glNewList(int arg0,int arg1)
  {
    printIndent();
    print(    "glNewList("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNewList(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4NbvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4NbvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4NbvARB(arg0,arg1);
    println("");
  }
  public  void glGetConvolutionParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetConvolutionParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetConvolutionParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFogfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glFogfv(arg0,arg1);
    println("");
  }
  public  void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glRotatef(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glRotatef("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glRotatef(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1f(arg0,arg1);
    println("");
  }
  public  void glRotated(double arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glRotated("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glRotated(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteVertexArrays(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteVertexArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glEnableClientState(int arg0)
  {
    printIndent();
    print(    "glEnableClientState("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEnableClientState(arg0);
    println("");
  }
  public  void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenBuffers(arg0,arg1);
    println("");
  }
  public  void glVertex4dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glVertex4dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glVertex4dv(arg0);
    println("");
  }
  public  void glSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glSamplerParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  boolean isNPOTTextureAvailable()
  {
        return downstreamGL3bc.isNPOTTextureAvailable();
  }
  public  void glMultiTexCoord3fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord3fv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4fvARB(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4fvARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexWeighthv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertexWeighthv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexWeighthv(arg0,arg1);
    println("");
  }
  public  boolean glIsEnabledIndexed(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnabledIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsEnabledIndexed(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glEvalCoord2fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glEvalCoord2fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEvalCoord2fv(arg0,arg1);
    println("");
  }
  public  void glGetInfoLogARB(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetInfoLogARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetInfoLogARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4bv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4bv(arg0,arg1);
    println("");
  }
  public  void glMapVertexAttrib2fAPPLE(int arg0,int arg1,float arg2,float arg3,int arg4,int arg5,float arg6,float arg7,int arg8,int arg9,java.nio.FloatBuffer arg10)
  {
    printIndent();
    print(    "glMapVertexAttrib2fAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<float> "+arg6+", "+"<float> "+arg7+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg10+")");
downstreamGL3bc.glMapVertexAttrib2fAPPLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glProgramUniform3uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramLocalParameter4fARB(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glProgramLocalParameter4fARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glProgramLocalParameter4fARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetIntegeri_v(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegeri_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetIntegeri_v(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexParameterfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexParameterfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribLdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribLdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetVertexAttribLdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL1i64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL1i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL1i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform2ivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform2ivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI1ivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI1ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI1ivEXT(arg0,arg1);
    println("");
  }
  public  void glTexCoordP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glTexCoordP4uiv(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribfv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix2fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiTexCoordP3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetQueryIndexediv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetQueryIndexediv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetQueryIndexediv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glCompressedTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttrib4sARB(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glVertexAttrib4sARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
downstreamGL3bc.glVertexAttrib4sARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetBooleanv(arg0,arg1,arg2);
    println("");
  }
  public  void glIndexs(short arg0)
  {
    printIndent();
    print(    "glIndexs("+"<short> "+arg0+")");
downstreamGL3bc.glIndexs(arg0);
    println("");
  }
  public  void glFramebufferTexture1D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTexture1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glFramebufferTexture1D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramBufferParametersIuivNV(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glProgramBufferParametersIuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glProgramBufferParametersIuivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glScissorArrayv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glScissorArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glScissorArrayv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord1iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1iv(arg0,arg1);
    println("");
  }
  public  void glTextureBarrierNV()
  {
    printIndent();
    print(    "glTextureBarrierNV("+")");
downstreamGL3bc.glTextureBarrierNV();
    println("");
  }
  public  void glVertexAttribI3iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI3iv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribs1hv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glVertexAttribs1hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL3bc.glVertexAttribs1hv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glUniform1fv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nsv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nsv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4Nsv(arg0,arg1);
    println("");
  }
  public  void glFogCoorddv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glFogCoorddv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glFogCoorddv(arg0);
    println("");
  }
  public  void glVertexAttribI4sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4sv(arg0,arg1);
    println("");
  }
  public  void glSecondaryColorP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glSecondaryColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glSecondaryColorP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord4iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord4iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord4iv(arg0);
    println("");
  }
  public  void glVertexAttribI1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribI1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1ui(arg0,arg1);
    println("");
  }
  public  void glSecondaryColor3bv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3bv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3bv(arg0);
    println("");
  }
  public  void glDepthFunc(int arg0)
  {
    printIndent();
    print(    "glDepthFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDepthFunc(arg0);
    println("");
  }
  public  void glVariantubvEXT(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVariantubvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVariantubvEXT(arg0,arg1);
    println("");
  }
  public  void glProgramLocalParameters4fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramLocalParameters4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramLocalParameters4fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glShaderSourceARB(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glShaderSourceARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glShaderSourceARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetHistogram(int arg0,boolean arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetHistogram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glGetHistogram(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBlendFunci(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendFunci("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBlendFunci(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord1sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord1sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord1sv(arg0);
    println("");
  }
  public  void glGetMinmaxParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMinmaxParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetMinmaxParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glMaterialf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glMaterialf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glMaterialf(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexParameterIuivEXT(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexParameterIuivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexParameterIuivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glCompileShader(int arg0)
  {
    printIndent();
    print(    "glCompileShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glCompileShader(arg0);
    println("");
  }
  public  void glUniform2iARB(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2iARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glUniform2iARB(arg0,arg1,arg2);
    println("");
  }
  public  void glEvalCoord1f(float arg0)
  {
    printIndent();
    print(    "glEvalCoord1f("+"<float> "+arg0+")");
downstreamGL3bc.glEvalCoord1f(arg0);
    println("");
  }
  public  void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    printIndent();
    print(    "glCompressedTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<long> "+arg10+")");
downstreamGL3bc.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPolygonStipple(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glPolygonStipple("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glPolygonStipple(arg0);
    println("");
  }
  public  void glGetTextureParameterIivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTextureParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetTextureParameterIivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetnTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glGetnTexImage(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColorMaterial(int arg0,int arg1)
  {
    printIndent();
    print(    "glColorMaterial("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColorMaterial(arg0,arg1);
    println("");
  }
  public  void glBlendFuncSeparateINGR(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glBlendFuncSeparateINGR("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glBlendFuncSeparateINGR(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetIntegerIndexedv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegerIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetIntegerIndexedv(arg0,arg1,arg2);
    println("");
  }
  public  void glColor3fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glColor3fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glColor3fv(arg0);
    println("");
  }
  public  void glProgramEnvParametersI4uivNV(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramEnvParametersI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParametersI4uivNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMemoryBarrier(int arg0)
  {
    printIndent();
    print(    "glMemoryBarrier("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMemoryBarrier(arg0);
    println("");
  }
  public  void glVertexAttrib4usvARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4usvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4usvARB(arg0,arg1);
    println("");
  }
  public  void glGetShaderInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetShaderInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetBufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glPixelTransformParameteriEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glPixelTransformParameteriEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glPixelTransformParameteriEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureRenderbufferEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTextureRenderbufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTextureRenderbufferEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glMultTransposeMatrixd(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glMultTransposeMatrixd("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glMultTransposeMatrixd(arg0,arg1);
    println("");
  }
  public  void glMultiTexGendvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexGendvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexGendvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColorP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glColorP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glColorP4uiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4ubvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4ubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4ubvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGenProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenProgramPipelines(arg0,arg1);
    println("");
  }
  public  void glProgramLocalParametersI4ivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramLocalParametersI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramLocalParametersI4ivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4ivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4ivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDepthRangef(float arg0,float arg1)
  {
    printIndent();
    print(    "glDepthRangef("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL3bc.glDepthRangef(arg0,arg1);
    println("");
  }
  public  void glFlushPixelDataRangeNV(int arg0)
  {
    printIndent();
    print(    "glFlushPixelDataRangeNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glFlushPixelDataRangeNV(arg0);
    println("");
  }
  public  void glProgramUniform1i64NV(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glProgramUniform1i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glProgramUniform1i64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4ivARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4ivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glLogicOp(int arg0)
  {
    printIndent();
    print(    "glLogicOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glLogicOp(arg0);
    println("");
  }
  public  void glGetPixelMapuiv(int arg0,long arg1)
  {
    printIndent();
    print(    "glGetPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glGetPixelMapuiv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix2fvARB(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2fvARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColor4ubv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glColor4ubv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glColor4ubv(arg0);
    println("");
  }
  public  void glTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glTexGeniv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor4bv(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glColor4bv("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glColor4bv(arg0);
    println("");
  }
  public  void glProgramLocalParameterI4ivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glProgramLocalParameterI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glProgramLocalParameterI4ivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnPixelMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetnPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetnPixelMapfv(arg0,arg1,arg2);
    println("");
  }
  public  void glClearBufferfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glClearBufferfv(arg0,arg1,arg2);
    println("");
  }
  public  void glNormal3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glNormal3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormal3fv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3dvARB(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3dvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glCompressedTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL3bc.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVDPAUUnmapSurfacesNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVDPAUUnmapSurfacesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVDPAUUnmapSurfacesNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL3i64NV(int arg0,long arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glVertexAttribL3i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glVertexAttribL3i64NV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompileShaderIncludeARB(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glCompileShaderIncludeARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glCompileShaderIncludeARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos2fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos2fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos2fv(arg0);
    println("");
  }
  public  void glVertexAttribL2ui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL2ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL2ui64vNV(arg0,arg1);
    println("");
  }
  public  void glColor3hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3hv(arg0,arg1);
    println("");
  }
  public  void glGetUniformfvARB(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformfvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetAttachedObjectsARB(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetAttachedObjectsARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetAttachedObjectsARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetAttachedObjectsARB(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetAttachedObjectsARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetAttachedObjectsARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetObjectParameterivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetObjectParameterivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetObjectParameterivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4ivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4ivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColor3uiv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glColor3uiv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glColor3uiv(arg0);
    println("");
  }
  public  void glGetnUniformdv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glGetnUniformdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord3dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord3dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord3dv(arg0,arg1);
    println("");
  }
  public  int glVideoCaptureNV(int arg0,int[] arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glVideoCaptureNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    int _res = downstreamGL3bc.glVideoCaptureNV(arg0,arg1,arg2,arg3,arg4);
    println(" = "+_res);
    return _res;
  }
  public  void glPixelMapusv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL3bc.glPixelMapusv(arg0,arg1,arg2);
    println("");
  }
  public  void glWindowPos3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glWindowPos3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glWindowPos3f(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glProgramParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL3bc.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glMatrixIndexusvARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMatrixIndexusvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMatrixIndexusvARB(arg0,arg1);
    println("");
  }
  public  void glColor3usv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3usv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3usv(arg0,arg1);
    println("");
  }
  public  void glRasterPos4sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos4sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos4sv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4NusvARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4NusvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4NusvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib1hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1hv(arg0,arg1);
    println("");
  }
  public  void glMapControlPointsNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glMapControlPointsNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glMapControlPointsNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glConvolutionParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glConvolutionParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL3bc.glConvolutionParameterf(arg0,arg1,arg2);
    println("");
  }
  public  void glLoadTransposeMatrixd(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glLoadTransposeMatrixd("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glLoadTransposeMatrixd(arg0,arg1);
    println("");
  }
  public  void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetActiveUniformBlockiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform2i64NV(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glUniform2i64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL3bc.glUniform2i64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVDPAUFiniNV()
  {
    printIndent();
    print(    "glVDPAUFiniNV("+")");
downstreamGL3bc.glVDPAUFiniNV();
    println("");
  }
  public  void glVertexAttrib4fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4fv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoord4dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord4dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord4dv(arg0);
    println("");
  }
  public  void glProgramUniform2iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glIsEnabledi(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnabledi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsEnabledi(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glBindVertexArray(int arg0)
  {
    printIndent();
    print(    "glBindVertexArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glBindVertexArray(arg0);
    println("");
  }
  public  void glGetSeparableFilter(int arg0,int arg1,int arg2,long arg3,long arg4,long arg5)
  {
    printIndent();
    print(    "glGetSeparableFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+", "+"<long> "+arg5+")");
downstreamGL3bc.glGetSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMap2d(int arg0,double arg1,double arg2,int arg3,int arg4,double arg5,double arg6,int arg7,int arg8,java.nio.DoubleBuffer arg9)
  {
    printIndent();
    print(    "glMap2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<double> "+arg5+", "+"<double> "+arg6+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg9+")");
downstreamGL3bc.glMap2d(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glMultiTexCoordPointerEXT(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glMultiTexCoordPointerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glMultiTexCoordPointerEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiDrawArrays(int arg0,int[] arg1,int arg2,int[] arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glMultiDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glMultiDrawArrays(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiDrawArrays(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2,int arg3)
  {
    printIndent();
    print(    "glMultiDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiDrawArrays(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex2hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertex2hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertex2hv(arg0);
    println("");
  }
  public  void glColor3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glColor3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glColor3i(arg0,arg1,arg2);
    println("");
  }
  public  void glWindowPos2fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos2fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos2fv(arg0,arg1);
    println("");
  }
  public  void glLightModelf(int arg0,float arg1)
  {
    printIndent();
    print(    "glLightModelf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glLightModelf(arg0,arg1);
    println("");
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4uivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4uivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetMultiTexGendvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexGendvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexGendvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertex3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex3iv(arg0,arg1);
    println("");
  }
  public  void glVertexWeighth(short arg0)
  {
    printIndent();
    print(    "glVertexWeighth("+"<short> "+arg0+")");
downstreamGL3bc.glVertexWeighth(arg0);
    println("");
  }
  public  void glGetnMapiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnMapiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetnMapiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetSamplerParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetDebugMessageLogAMD(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetDebugMessageLogAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
    int _res = downstreamGL3bc.glGetDebugMessageLogAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println(" = "+_res);
    return _res;
  }
  public  void glFlush()
  {
    printIndent();
    print(    "glFlush("+")");
downstreamGL3bc.glFlush();
    println("");
  }
  public  void glWeightivARB(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glWeightivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glWeightivARB(arg0,arg1);
    println("");
  }
  public  void glCopyMultiTexSubImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyMultiTexSubImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
downstreamGL3bc.glCopyMultiTexSubImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glMap1d(int arg0,double arg1,double arg2,int arg3,int arg4,java.nio.DoubleBuffer arg5)
  {
    printIndent();
    print(    "glMap1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg5+")");
downstreamGL3bc.glMap1d(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPNTrianglesfATI(int arg0,float arg1)
  {
    printIndent();
    print(    "glPNTrianglesfATI("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glPNTrianglesfATI(arg0,arg1);
    println("");
  }
  public  void glPatchParameterfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glPatchParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glPatchParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glMatrixIndexubvARB(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixIndexubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixIndexubvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4x2dvEXT(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x2dvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glNamedFramebufferTexture3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glNamedFramebufferTexture3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferTexture3DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glApplyTextureEXT(int arg0)
  {
    printIndent();
    print(    "glApplyTextureEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glApplyTextureEXT(arg0);
    println("");
  }
  public  void glVertexAttrib4Niv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Niv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4Niv(arg0,arg1);
    println("");
  }
  public  void glCullParameterdvEXT(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glCullParameterdvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glCullParameterdvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glWindowPos3sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos3sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos3sv(arg0,arg1);
    println("");
  }
  public  void glUniform1i64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform1i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform1i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3dv(arg0,arg1);
    println("");
  }
  public  void glTexCoord2fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord2fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord2fv(arg0,arg1);
    println("");
  }
  public  void glShaderOp3EXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glShaderOp3EXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glShaderOp3EXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoordP1ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoordP1ui(arg0,arg1,arg2);
    println("");
  }
  public  void glGenOcclusionQueriesNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenOcclusionQueriesNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glGenOcclusionQueriesNV(arg0,arg1);
    println("");
  }
  public  void glGetNamedRenderbufferParameterivEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetNamedRenderbufferParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetNamedRenderbufferParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glIsProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsProgramPipeline(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDeletePerfMonitorsAMD(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeletePerfMonitorsAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeletePerfMonitorsAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4ubv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4ubv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nuiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4Nuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glConvolutionFilter1D(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glConvolutionFilter1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glConvolutionFilter1D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glSetMultisamplefvAMD(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glSetMultisamplefvAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glSetMultisamplefvAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNamedProgramLocalParameterI4iEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glNamedProgramLocalParameterI4iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glNamedProgramLocalParameterI4iEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttrib4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4dv(arg0,arg1);
    println("");
  }
  public  void glFogCoordPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glFogCoordPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glFogCoordPointer(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedMultiTexSubImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glCompressedMultiTexSubImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glCompressedMultiTexSubImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glUniform3ivARB(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3ivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glBindTextureUnitParameterEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTextureUnitParameterEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    int _res = downstreamGL3bc.glBindTextureUnitParameterEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glMultiTexParameteriEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexParameteriEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glMultiTexParameteriEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFogi(int arg0,int arg1)
  {
    printIndent();
    print(    "glFogi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFogi(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3dvARB(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3dvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3dvARB(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4bvEXT(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4bvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI4bvEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL4i64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL4i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL4i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glLightModeliv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glLightModeliv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glLightModeliv(arg0,arg1);
    println("");
  }
  public  void glBeginConditionalRender(int arg0,int arg1)
  {
    printIndent();
    print(    "glBeginConditionalRender("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glBeginConditionalRender(arg0,arg1);
    println("");
  }
  public  void glCopyTextureSubImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glCopyTextureSubImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glCopyTextureSubImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  int glCreateShader(int arg0)
  {
    printIndent();
    print(    "glCreateShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL3bc.glCreateShader(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib1fvARB(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1fvARB(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetUniformIndices("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glGetUniformIndices(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPauseTransformFeedbackNV()
  {
    printIndent();
    print(    "glPauseTransformFeedbackNV("+")");
downstreamGL3bc.glPauseTransformFeedbackNV();
    println("");
  }
  public  void glLoadTransposeMatrixd(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glLoadTransposeMatrixd("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glLoadTransposeMatrixd(arg0);
    println("");
  }
  public  void glUniform3ui64NV(int arg0,long arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glUniform3ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL3bc.glUniform3ui64NV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVariantivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVariantivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVariantivEXT(arg0,arg1);
    println("");
  }
  public  void glTexCoord4sv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord4sv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord4sv(arg0,arg1);
    println("");
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVDPAUInitNV(java.nio.Buffer arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glVDPAUInitNV("+"<java.nio.Buffer> "+arg0+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glVDPAUInitNV(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI2ivEXT(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2ivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI2ivEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glLightiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glLightiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glLightiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnUniformdv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetnUniformdv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord3dv(arg0);
    println("");
  }
  public  void glVertexAttribI1iEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribI1iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1iEXT(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3svARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib3svARB(arg0,arg1);
    println("");
  }
  public  void glGetSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetSamplerParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDetachObjectARB(int arg0,int arg1)
  {
    printIndent();
    print(    "glDetachObjectARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDetachObjectARB(arg0,arg1);
    println("");
  }
  public  void glGetPixelMapuiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGetPixelMapuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteTransformFeedbacksNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacksNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteTransformFeedbacksNV(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib2sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2sv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultiTexGendvEXT(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexGendvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexGendvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex3fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex3fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex3fv(arg0,arg1);
    println("");
  }
  public  void glMatrixIndexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glMatrixIndexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glMatrixIndexPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertex2sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glVertex2sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glVertex2sv(arg0);
    println("");
  }
  public  void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMapParameterivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetMapParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetMapParameterivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glTexBuffer(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexBuffer(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramLocalParameterI4uivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glProgramLocalParameterI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glProgramLocalParameterI4uivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glMap2d(int arg0,double arg1,double arg2,int arg3,int arg4,double arg5,double arg6,int arg7,int arg8,double[] arg9,int arg10)
  {
    printIndent();
    print(    "glMap2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<double> "+arg5+", "+"<double> "+arg6+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL3bc.glMap2d(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform4ui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord4dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord4dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord4dv(arg0,arg1);
    println("");
  }
  public  void glGetnMapfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetnMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetnMapfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPolygonStipple(java.nio.ByteBuffer arg0)
  {
    printIndent();
    print(    "glGetPolygonStipple("+"<java.nio.ByteBuffer> "+arg0+")");
downstreamGL3bc.glGetPolygonStipple(arg0);
    println("");
  }
  public  void glColor3h(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glColor3h("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glColor3h(arg0,arg1,arg2);
    println("");
  }
  public  void glColorTable(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glColorTable(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColor3s(short arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glColor3s("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL3bc.glColor3s(arg0,arg1,arg2);
    println("");
  }
  public  void glFogiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glFogiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glFogiv(arg0,arg1);
    println("");
  }
  public  void glVertex3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glVertex3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glVertex3f(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttrib3dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformui64NV(int arg0,long arg1)
  {
    printIndent();
    print(    "glUniformui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL3bc.glUniformui64NV(arg0,arg1);
    println("");
  }
  public  void glCullParameterdvEXT(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glCullParameterdvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glCullParameterdvEXT(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2x4fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix2x4fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWeightfvARB(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glWeightfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glWeightfvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramEnvParameterI4ivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramEnvParameterI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramEnvParameterI4ivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
    printIndent();
    print(    "glGetActiveSubroutineName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL3bc.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glMap1d(int arg0,double arg1,double arg2,int arg3,int arg4,double[] arg5,int arg6)
  {
    printIndent();
    print(    "glMap1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glMap1d(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glRasterPos4fv(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glRasterPos4fv("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glRasterPos4fv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix4x2dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix4x2dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glResumeTransformFeedbackNV()
  {
    printIndent();
    print(    "glResumeTransformFeedbackNV("+")");
downstreamGL3bc.glResumeTransformFeedbackNV();
    println("");
  }
  public  void glGetUniformSubroutineuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformSubroutineuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetUniformSubroutineuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoord1hv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord1hv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord1hv(arg0);
    println("");
  }
  public  void glGetMultisamplefvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMultisamplefvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetMultisamplefvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos2sv(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos2sv("+"<java.nio.ShortBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos2sv(arg0);
    println("");
  }
  public  int glGetUniformLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL3bc.glGetUniformLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glColor3bv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3bv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3bv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nubv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4Nubv(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteObjectARB(int arg0)
  {
    printIndent();
    print(    "glDeleteObjectARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDeleteObjectARB(arg0);
    println("");
  }
  public  void glEdgeFlagPointer(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glEdgeFlagPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL3bc.glEdgeFlagPointer(arg0,arg1);
    println("");
  }
  public  void glTextureParameterIivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glTextureParameterIivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glTextureParameterIivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTexStorage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3fvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3fvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniformui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glMatrixPopEXT(int arg0)
  {
    printIndent();
    print(    "glMatrixPopEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMatrixPopEXT(arg0);
    println("");
  }
  public  int glCreateProgramObjectARB()
  {
    printIndent();
    print(    "glCreateProgramObjectARB("+")");
    int _res = downstreamGL3bc.glCreateProgramObjectARB();
    println(" = "+_res);
    return _res;
  }
  public  void glGenFencesAPPLE(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenFencesAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glGenFencesAPPLE(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnPixelMapuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetnPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetnPixelMapuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDrawBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDrawBuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glIndexfv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glIndexfv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glIndexfv(arg0);
    println("");
  }
  public  void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix3x2fvEXT(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x2fvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPixelMapfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glPixelMapfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColor3ubv(byte[] arg0,int arg1)
  {
    printIndent();
    print(    "glColor3ubv("+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColor3ubv(arg0,arg1);
    println("");
  }
  public  void glFogCoorddv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glFogCoorddv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glFogCoorddv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribPointerARB(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glVertexAttribPointerARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glVertexAttribPointerARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glCullParameterfvEXT(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glCullParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glCullParameterfvEXT(arg0,arg1);
    println("");
  }
  public  void glClearDepth(double arg0)
  {
    printIndent();
    print(    "glClearDepth("+"<double> "+arg0+")");
downstreamGL3bc.glClearDepth(arg0);
    println("");
  }
  public  void glProgramUniform1iEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1iEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4iARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4iARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glUniform4iARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColorP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glColorP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glColorP3ui(arg0,arg1);
    println("");
  }
  public  void glGetMinmaxParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetMinmaxParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetMinmaxParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glPrioritizeTextures(int arg0,java.nio.IntBuffer arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glPrioritizeTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glPrioritizeTextures(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4svARB(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib4svARB(arg0,arg1);
    println("");
  }
  public  void glMatrixMultfEXT(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMatrixMultfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMatrixMultfEXT(arg0,arg1);
    println("");
  }
  public  void glGetPixelMapfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glGetPixelMapfv(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord3iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord3iv(arg0,arg1,arg2);
    println("");
  }
  public  void glFlushMappedNamedBufferRangeEXT(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glFlushMappedNamedBufferRangeEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL3bc.glFlushMappedNamedBufferRangeEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMapControlPointsNV(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glGetMapControlPointsNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glGetMapControlPointsNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetTextureLevelParameterfvEXT(int arg0,int arg1,int arg2,int arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetTextureLevelParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetTextureLevelParameterfvEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL3bc.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glTexParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glRecti(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRecti("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glRecti(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTexLevelParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoord1fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord1fv(arg0,arg1);
    println("");
  }
  public  void glGetUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glGetUniformiv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTextureImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedTextureImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glCompressedTextureImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glNamedFramebufferTextureEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glNamedFramebufferTextureEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glNamedFramebufferTextureEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetMinmax(int arg0,boolean arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glGetMinmax("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL3bc.glGetMinmax(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glRects(short arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glRects("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL3bc.glRects(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVariantPointerEXT(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glVariantPointerEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glVariantPointerEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glShaderBinary(int arg0,int[] arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5)
  {
    printIndent();
    print(    "glShaderBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glShaderBinary(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWeightbvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glWeightbvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glWeightbvARB(arg0,arg1);
    println("");
  }
  public  void glPatchParameteri(int arg0,int arg1)
  {
    printIndent();
    print(    "glPatchParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glPatchParameteri(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetQueryObjecti64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjecti64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetQueryObjecti64v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDisableVertexAttribArrayARB(int arg0)
  {
    printIndent();
    print(    "glDisableVertexAttribArrayARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glDisableVertexAttribArrayARB(arg0);
    println("");
  }
  public  void glProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  long glGetUniformOffsetEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glGetUniformOffsetEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    long _res = downstreamGL3bc.glGetUniformOffsetEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glGetQueryObjecti64vEXT(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjecti64vEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryObjecti64vEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glColorFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glColorFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glColorFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoord4hv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord4hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord4hv(arg0,arg1);
    println("");
  }
  public  void glGetConvolutionParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetConvolutionParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetConvolutionParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4uiEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4uiEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMatrixMultTransposefEXT(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMatrixMultTransposefEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMatrixMultTransposefEXT(arg0,arg1);
    println("");
  }
  public  void glEnableVariantClientStateEXT(int arg0)
  {
    printIndent();
    print(    "glEnableVariantClientStateEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glEnableVariantClientStateEXT(arg0);
    println("");
  }
  public  void glCompressedTextureImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glCompressedTextureImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glCompressedTextureImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glDeleteProgramsARB(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteProgramsARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glDeleteProgramsARB(arg0,arg1,arg2);
    println("");
  }
  public  int glClientWaitSync(long arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glClientWaitSync("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
    int _res = downstreamGL3bc.glClientWaitSync(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib1sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttrib1sv(arg0,arg1);
    println("");
  }
  public  void glScalef(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glScalef("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL3bc.glScalef(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramEnvParameterIuivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramEnvParameterIuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramEnvParameterIuivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveUniformARB(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveUniformARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL3bc.glGetActiveUniformARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVariantusvEXT(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVariantusvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVariantusvEXT(arg0,arg1);
    println("");
  }
  public  void glUniform1iARB(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1iARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glUniform1iARB(arg0,arg1);
    println("");
  }
  public  void glPrioritizeTextures(int arg0,int[] arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glPrioritizeTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glPrioritizeTextures(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4x3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetMultiTexParameterfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexParameterfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteFencesAPPLE(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteFencesAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteFencesAPPLE(arg0,arg1);
    println("");
  }
  public  void glMultiTexGendvEXT(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexGendvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glMultiTexGendvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glRectd(double arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glRectd("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glRectd(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramBufferParametersIivNV(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramBufferParametersIivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramBufferParametersIivNV(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultTransposeMatrixd(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glMultTransposeMatrixd("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glMultTransposeMatrixd(arg0);
    println("");
  }
  public  void glRectf(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glRectf("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glRectf(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnPixelMapusv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetnPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetnPixelMapusv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEvalPoint2(int arg0,int arg1)
  {
    printIndent();
    print(    "glEvalPoint2("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glEvalPoint2(arg0,arg1);
    println("");
  }
  public  void glEndVertexShaderEXT()
  {
    printIndent();
    print(    "glEndVertexShaderEXT("+")");
downstreamGL3bc.glEndVertexShaderEXT();
    println("");
  }
  public  void glVertexAttribs2hv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glVertexAttribs2hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL3bc.glVertexAttribs2hv(arg0,arg1,arg2);
    println("");
  }
  public  void glProvokingVertex(int arg0)
  {
    printIndent();
    print(    "glProvokingVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glProvokingVertex(arg0);
    println("");
  }
  public  void glDebugMessageControlARB(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glDebugMessageControlARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL3bc.glDebugMessageControlARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttribI4usv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4usv(arg0,arg1);
    println("");
  }
  public  void glWindowPos2iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glWindowPos2iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glWindowPos2iv(arg0,arg1);
    println("");
  }
  public  void glGetCompressedTexImage(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glGetCompressedTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glGetCompressedTexImage(arg0,arg1,arg2);
    println("");
  }
  public  void glMatrixLoadTransposedEXT(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glMatrixLoadTransposedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMatrixLoadTransposedEXT(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsTransformFeedback(int arg0)
  {
    printIndent();
    print(    "glIsTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsTransformFeedback(arg0);
    println(" = "+_res);
    return _res;
  }
  public  boolean glIsQuery(int arg0)
  {
    printIndent();
    print(    "glIsQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsQuery(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetProgramInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetProgramInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetProgramInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoord4fv(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glTexCoord4fv("+"<java.nio.FloatBuffer> "+arg0+")");
downstreamGL3bc.glTexCoord4fv(arg0);
    println("");
  }
  public  void glGetMultiTexParameterivEXT(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetMultiTexParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetMultiTexParameterivEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int glCreateShaderProgramv(int arg0,int arg1,com.jogamp.common.nio.PointerBuffer arg2)
  {
    printIndent();
    print(    "glCreateShaderProgramv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg2+")");
    int _res = downstreamGL3bc.glCreateShaderProgramv(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib2fvARB(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2fvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2fvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetPerfMonitorGroupStringAMD(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetPerfMonitorGroupStringAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glGetPerfMonitorGroupStringAMD(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertex4dv(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glVertex4dv("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertex4dv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramEnvParameterI4uivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glProgramEnvParameterI4uivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glProgramEnvParameterI4uivNV(arg0,arg1,arg2);
    println("");
  }
  public  java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "glMapBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGL3bc.glMapBufferRange(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glStencilFunc(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glStencilFunc(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib2svARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2svARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib2svARB(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glBitmap(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glBitmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL3bc.glBitmap(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  int glBindTexGenParameterEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBindTexGenParameterEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    int _res = downstreamGL3bc.glBindTexGenParameterEXT(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glSamplerParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL1dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribL1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glLoadMatrixd(double[] arg0,int arg1)
  {
    printIndent();
    print(    "glLoadMatrixd("+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glLoadMatrixd(arg0,arg1);
    println("");
  }
  public  void glMultiTexImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glMultiTexImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
downstreamGL3bc.glMultiTexImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glVertexAttrib4Nbv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nbv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4Nbv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glTexCoordPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL3bc.glTexCoordPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glWeightubvARB(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glWeightubvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL3bc.glWeightubvARB(arg0,arg1);
    println("");
  }
  public  int glGetUniformLocationARB(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformLocationARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL3bc.glGetUniformLocationARB(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glGetNamedBufferParameterivEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetNamedBufferParameterivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetNamedBufferParameterivEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPrimitiveRestartNV()
  {
    printIndent();
    print(    "glPrimitiveRestartNV("+")");
downstreamGL3bc.glPrimitiveRestartNV();
    println("");
  }
  public  void glColor3iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glColor3iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glColor3iv(arg0);
    println("");
  }
  public  void glMultiTexEnvfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexEnvfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexEnvfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glLighti(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glLighti("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glLighti(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI1uivEXT(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI1uivEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI1uivEXT(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindFragDataLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glBindFragDataLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
downstreamGL3bc.glBindFragDataLocation(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedStringARB(int arg0,int arg1,java.lang.String arg2,int arg3,java.lang.String arg4)
  {
    printIndent();
    print(    "glNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.lang.String> "+arg4+")");
downstreamGL3bc.glNamedStringARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform4iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform4iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib3dARB(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glVertexAttrib3dARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glVertexAttrib3dARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glIndexi(int arg0)
  {
    printIndent();
    print(    "glIndexi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glIndexi(arg0);
    println("");
  }
  public  void glUniform1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glUniform1ui(arg0,arg1);
    println("");
  }
  public  void glMakeBufferNonResidentNV(int arg0)
  {
    printIndent();
    print(    "glMakeBufferNonResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glMakeBufferNonResidentNV(arg0);
    println("");
  }
  public  void glBlendEquationSeparatei(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendEquationSeparatei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glBlendEquationSeparatei(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4usvEXT(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4usvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI4usvEXT(arg0,arg1);
    println("");
  }
  public  void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glVertexAttribLPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int getDefaultReadFramebuffer()
  {
        return downstreamGL3bc.getDefaultReadFramebuffer();
  }
  public  void glVertexAttribP1ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP1ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniform3fvEXT(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform3fvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTextureSubImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glTextureSubImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glTextureSubImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glClientAttribDefaultEXT(int arg0)
  {
    printIndent();
    print(    "glClientAttribDefaultEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glClientAttribDefaultEXT(arg0);
    println("");
  }
  public  void glGetActiveAttrib(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL3bc.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glMultiTexGendEXT(int arg0,int arg1,int arg2,double arg3)
  {
    printIndent();
    print(    "glMultiTexGendEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<double> "+arg3+")");
downstreamGL3bc.glMultiTexGendEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribLdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribLdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL3bc.glGetVertexAttribLdv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVertexAttribP4uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int glGetDebugMessageLogARB(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.IntBuffer arg6,java.nio.ByteBuffer arg7)
  {
    printIndent();
    print(    "glGetDebugMessageLogARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.IntBuffer> "+arg6+", "+"<java.nio.ByteBuffer> "+arg7+")");
    int _res = downstreamGL3bc.glGetDebugMessageLogARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println(" = "+_res);
    return _res;
  }
  public  void glGetMapParameterfvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMapParameterfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glGetMapParameterfvNV(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2f(int arg0,int arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glProgramUniform2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glProgramUniform2f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexGenfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glMultiTexGenfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glMultiTexGenfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPixelMapfv(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL3bc.glPixelMapfv(arg0,arg1,arg2);
    println("");
  }
  public  void glTextureMaterialEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glTextureMaterialEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTextureMaterialEXT(arg0,arg1);
    println("");
  }
  public  void glUniform1iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform1iv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnConvolutionFilter(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetnConvolutionFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glGetnConvolutionFilter(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSecondaryColor3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSecondaryColor3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glSecondaryColor3i(arg0,arg1,arg2);
    println("");
  }
  public  void glSampleMaski(int arg0,int arg1)
  {
    printIndent();
    print(    "glSampleMaski("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glSampleMaski(arg0,arg1);
    println("");
  }
  public  void glUniform4dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform2d(int arg0,int arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glProgramUniform2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL3bc.glProgramUniform2d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindVideoCaptureStreamBufferNV(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glBindVideoCaptureStreamBufferNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glBindVideoCaptureStreamBufferNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetSamplerParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramEnvParameters4fvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramEnvParameters4fvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glProgramEnvParameters4fvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRasterPos2iv(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glRasterPos2iv("+"<java.nio.IntBuffer> "+arg0+")");
downstreamGL3bc.glRasterPos2iv(arg0);
    println("");
  }
  public  void glVertexAttrib4iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4iv(arg0,arg1,arg2);
    println("");
  }
  public  void glClearBufferiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glClearBufferiv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedTextureImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTextureImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL3bc.glCompressedTextureImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glGetTextureImageEXT(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetTextureImageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL3bc.glGetTextureImageEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  boolean glIsBuffer(int arg0)
  {
    printIndent();
    print(    "glIsBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL3bc.glIsBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glMultiTexCoord2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord2dv(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoord1hv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoord1hv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glMultiTexCoord1hv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompressedMultiTexImage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedMultiTexImage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glCompressedMultiTexImage1DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glVertexAttribI2uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribI2uiv(arg0,arg1);
    println("");
  }
  public  void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexImage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexImage3DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL3bc.glTexImage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glCopyTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glCopyTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL3bc.glCopyTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glProgramUniform2fEXT(int arg0,int arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glProgramUniform2fEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL3bc.glProgramUniform2fEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoord4sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glMultiTexCoord4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL3bc.glMultiTexCoord4sv(arg0,arg1);
    println("");
  }
  public  int glBindMaterialParameterEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindMaterialParameterEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    int _res = downstreamGL3bc.glBindMaterialParameterEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform1uiEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1uiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1uiEXT(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI1iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttribI1iv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramEnvParametersI4ivNV(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramEnvParametersI4ivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramEnvParametersI4ivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2dvEXT(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2dvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL3bc.glProgramUniformMatrix2dvEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL3bc.glTexGenfv(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMaterialiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMaterialiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glMaterialiv(arg0,arg1,arg2);
    println("");
  }
  public  void glLineStipple(int arg0,short arg1)
  {
    printIndent();
    print(    "glLineStipple("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL3bc.glLineStipple(arg0,arg1);
    println("");
  }
  public  void glGetTextureParameterfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetTextureParameterfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetTextureParameterfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2ui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform2ui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetProgramStageiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetProgramStageiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glGetProgramStageiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoord2iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord2iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord2iv(arg0,arg1);
    println("");
  }
  public  void glGetQueryObjectui64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectui64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetQueryObjectui64v(arg0,arg1,arg2);
    println("");
  }
  public  void glSeparableFilter2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glSeparableFilter2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL3bc.glSeparableFilter2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glSeparableFilter2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6,long arg7)
  {
    printIndent();
    print(    "glSeparableFilter2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+", "+"<long> "+arg7+")");
downstreamGL3bc.glSeparableFilter2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glVertexAttribL4ui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL4ui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL3bc.glVertexAttribL4ui64vNV(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL3bc.glProgramUniform1iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexP4ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glVertexP4ui(arg0,arg1);
    println("");
  }
  public  void glMapParameterivNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMapParameterivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glMapParameterivNV(arg0,arg1,arg2);
    println("");
  }
  public  void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glBlendFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL3bc.glProgramUniform4i(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoord4hv(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoord4hv("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glTexCoord4hv(arg0,arg1);
    println("");
  }
  public  void glGetProgramStringARB(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glGetProgramStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL3bc.glGetProgramStringARB(arg0,arg1,arg2);
    println("");
  }
  public  void glGetFloatIndexedvEXT(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFloatIndexedvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetFloatIndexedvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glNormal3iv(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glNormal3iv("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glNormal3iv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4f(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glProgramUniform4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL3bc.glProgramUniform4f(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetColorTable(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glGetColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL3bc.glGetColorTable(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glStencilMask(int arg0)
  {
    printIndent();
    print(    "glStencilMask("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glStencilMask(arg0);
    println("");
  }
  public  void glProgramUniform4d(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glProgramUniform4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL3bc.glProgramUniform4d(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColor4dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glColor4dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glColor4dv(arg0);
    println("");
  }
  public  void glVideoCaptureStreamParameterdvNV(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glVideoCaptureStreamParameterdvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL3bc.glVideoCaptureStreamParameterdvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glUniform3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform1i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glProgramUniform1i(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexImage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glMultiTexImage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL3bc.glMultiTexImage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glProgramUniform3fEXT(int arg0,int arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glProgramUniform3fEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL3bc.glProgramUniform3fEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glVertexAttribL4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL3bc.glVertexAttribL4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPixelStoref(int arg0,float arg1)
  {
    printIndent();
    print(    "glPixelStoref("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL3bc.glPixelStoref(arg0,arg1);
    println("");
  }
  public  void glGetNamedBufferParameterui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetNamedBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glGetNamedBufferParameterui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glSecondaryColor3dv(java.nio.DoubleBuffer arg0)
  {
    printIndent();
    print(    "glSecondaryColor3dv("+"<java.nio.DoubleBuffer> "+arg0+")");
downstreamGL3bc.glSecondaryColor3dv(arg0);
    println("");
  }
  public  void glCallList(int arg0)
  {
    printIndent();
    print(    "glCallList("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glCallList(arg0);
    println("");
  }
  public  void glUniform4i64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniform4i64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL3bc.glUniform4i64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGenerateMultiTexMipmapEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glGenerateMultiTexMipmapEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glGenerateMultiTexMipmapEXT(arg0,arg1);
    println("");
  }
  public  void glProgramVertexLimitNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glProgramVertexLimitNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glProgramVertexLimitNV(arg0,arg1);
    println("");
  }
  public  void glDeleteQueries(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL3bc.glDeleteQueries(arg0,arg1);
    println("");
  }
  public  void glRasterPos3i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glRasterPos3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glRasterPos3i(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramEnvParameterfvARB(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramEnvParameterfvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glGetProgramEnvParameterfvARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramSubroutineParametersuivNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glProgramSubroutineParametersuivNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramSubroutineParametersuivNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetShaderSourceARB(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderSourceARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL3bc.glGetShaderSourceARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMatrixLoadfEXT(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glMatrixLoadfEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL3bc.glMatrixLoadfEXT(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2iEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2iEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glProgramUniform2iEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDisablei(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisablei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL3bc.glDisablei(arg0,arg1);
    println("");
  }
  public  void glGetMultiTexEnvfvEXT(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetMultiTexEnvfvEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL3bc.glGetMultiTexEnvfvEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4NsvARB(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4NsvARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL3bc.glVertexAttrib4NsvARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1ivARB(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1ivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL3bc.glUniform1ivARB(arg0,arg1,arg2);
    println("");
  }
  public  void glClearColorIi(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glClearColorIi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL3bc.glClearColorIi(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoordPointer(javax.media.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glTexCoordPointer("+"<javax.media.opengl.GLArrayData> "+arg0+")");
downstreamGL3bc.glTexCoordPointer(arg0);
    println("");
  }
  public  void glCopyMultiTexSubImage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glCopyMultiTexSubImage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
downstreamGL3bc.glCopyMultiTexSubImage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glGetProgramBinary(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glGetProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL3bc.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetProgramBinary(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL3bc.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3ui64NV(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glProgramUniform3ui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL3bc.glProgramUniform3ui64NV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glClear(int arg0)
  {
    printIndent();
    print(    "glClear("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL3bc.glClear(arg0);
    println("");
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("TraceGL3bc [ implementing javax.media.opengl.GL3bc,\n\t");
    sb.append(" downstream: "+downstreamGL3bc.toString()+"\n\t]");
    return sb.toString();
  }
private PrintStream stream;
private int indent = 0;
protected String dumpArray(Object obj)
{
  if (obj == null) return "[null]";
  StringBuilder sb = new StringBuilder("[");
  int len  = java.lang.reflect.Array.getLength(obj);
  int count = Math.min(len,16);
  for ( int i =0; i < count; i++ ) {
    sb.append(java.lang.reflect.Array.get(obj,i));
    if (i < count-1)
      sb.append(',');
  }
  if ( len > 16 )
    sb.append("...").append(len);
  sb.append(']');
  return sb.toString();
}
protected void print(String str)
{
  stream.print(str);
}
protected void println(String str)
{
  stream.println(str);
}
protected void printIndent()
{
  for( int i =0; i < indent; i++) {stream.print(' ');}
}

  private GL3bc downstreamGL3bc;
} // end class TraceGL3bc
