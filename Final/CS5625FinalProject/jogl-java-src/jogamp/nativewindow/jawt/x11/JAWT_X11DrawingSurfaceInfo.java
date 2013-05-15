/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Thu Nov 01 02:13:09 CET 2012 ----! */


package jogamp.nativewindow.jawt.x11;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import java.security.*;
import jogamp.nativewindow.jawt.*;
import com.jogamp.common.os.Platform;
import com.jogamp.common.util.VersionNumber;

public class JAWT_X11DrawingSurfaceInfo implements JAWT_PlatformInfo {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] JAWT_X11DrawingSurfaceInfo_size = new int[] { 24 /* ARMle_EABI */, 24 /* X86_32_UNIX */, 48 /* X86_64_UNIX */, 24 /* X86_32_MACOS */, 24 /* X86_32_WINDOWS */, 48 /* X86_64_WINDOWS */  };
  private static final int[] drawable_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };
  private static final int[] display_offset = new int[] { 4 /* ARMle_EABI */, 4 /* X86_32_UNIX */, 8 /* X86_64_UNIX */, 4 /* X86_32_MACOS */, 4 /* X86_32_WINDOWS */, 8 /* X86_64_WINDOWS */ };
  private static final int[] visualID_offset = new int[] { 8 /* ARMle_EABI */, 8 /* X86_32_UNIX */, 16 /* X86_64_UNIX */, 8 /* X86_32_MACOS */, 8 /* X86_32_WINDOWS */, 16 /* X86_64_WINDOWS */ };
  private static final int[] colormapID_offset = new int[] { 12 /* ARMle_EABI */, 12 /* X86_32_UNIX */, 24 /* X86_64_UNIX */, 12 /* X86_32_MACOS */, 12 /* X86_32_WINDOWS */, 24 /* X86_64_WINDOWS */ };
  private static final int[] depth_offset = new int[] { 16 /* ARMle_EABI */, 16 /* X86_32_UNIX */, 32 /* X86_64_UNIX */, 16 /* X86_32_MACOS */, 16 /* X86_32_WINDOWS */, 32 /* X86_64_WINDOWS */ };

  public static int size() {
    return JAWT_X11DrawingSurfaceInfo_size[mdIdx];
  }

  public static JAWT_X11DrawingSurfaceInfo create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static JAWT_X11DrawingSurfaceInfo create(java.nio.ByteBuffer buf) {
      return new JAWT_X11DrawingSurfaceInfo(buf);
  }

  JAWT_X11DrawingSurfaceInfo(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public JAWT_X11DrawingSurfaceInfo setDrawable(long val) {
    accessor.setLongAt(drawable_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
    return this;
  }

  public long getDrawable() {
    return accessor.getLongAt(drawable_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
  }

  public JAWT_X11DrawingSurfaceInfo setDisplay(long val) {
    accessor.setLongAt(display_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
    return this;
  }

  public long getDisplay() {
    return accessor.getLongAt(display_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
  }

  public JAWT_X11DrawingSurfaceInfo setVisualID(long val) {
    accessor.setLongAt(visualID_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.longSizeInBytes());
    return this;
  }

  public long getVisualID() {
    return accessor.getLongAt(visualID_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.longSizeInBytes());
  }

  public JAWT_X11DrawingSurfaceInfo setColormapID(long val) {
    accessor.setLongAt(colormapID_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
    return this;
  }

  public long getColormapID() {
    return accessor.getLongAt(colormapID_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
  }

  public JAWT_X11DrawingSurfaceInfo setDepth(int val) {
    accessor.setIntAt(depth_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.intSizeInBytes());
    return this;
  }

  public int getDepth() {
    return accessor.getIntAt(depth_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.intSizeInBytes());
  }
}
