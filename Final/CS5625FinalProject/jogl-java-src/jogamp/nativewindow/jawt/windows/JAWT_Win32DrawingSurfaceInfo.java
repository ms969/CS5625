/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Thu Nov 01 02:13:12 CET 2012 ----! */


package jogamp.nativewindow.jawt.windows;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import java.security.*;
import jogamp.nativewindow.jawt.*;
import com.jogamp.common.os.Platform;
import com.jogamp.common.util.VersionNumber;

public class JAWT_Win32DrawingSurfaceInfo implements JAWT_PlatformInfo {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] JAWT_Win32DrawingSurfaceInfo_size = new int[] { 12 /* ARMle_EABI */, 12 /* X86_32_UNIX */, 24 /* X86_64_UNIX */, 12 /* X86_32_MACOS */, 12 /* X86_32_WINDOWS */, 24 /* X86_64_WINDOWS */  };
  private static final int[] handle_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };
  private static final int[] hdc_offset = new int[] { 4 /* ARMle_EABI */, 4 /* X86_32_UNIX */, 8 /* X86_64_UNIX */, 4 /* X86_32_MACOS */, 4 /* X86_32_WINDOWS */, 8 /* X86_64_WINDOWS */ };

  public static int size() {
    return JAWT_Win32DrawingSurfaceInfo_size[mdIdx];
  }

  public static JAWT_Win32DrawingSurfaceInfo create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static JAWT_Win32DrawingSurfaceInfo create(java.nio.ByteBuffer buf) {
      return new JAWT_Win32DrawingSurfaceInfo(buf);
  }

  JAWT_Win32DrawingSurfaceInfo(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public JAWT_Win32DrawingSurfaceInfo setHandle(long val) {
    accessor.setLongAt(handle_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
    return this;
  }

  public long getHandle() {
    return accessor.getLongAt(handle_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
  }

  public JAWT_Win32DrawingSurfaceInfo setHdc(long val) {
    accessor.setLongAt(hdc_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
    return this;
  }

  public long getHdc() {
    return accessor.getLongAt(hdc_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
  }
}
