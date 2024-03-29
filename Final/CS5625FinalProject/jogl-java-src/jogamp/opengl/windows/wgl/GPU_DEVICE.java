/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/opengl/GLEmitter.java on Thu Nov 01 02:15:59 CET 2012 ----! */


package jogamp.opengl.windows.wgl;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import java.util.*;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
import jogamp.opengl.*;

public class GPU_DEVICE {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] GPU_DEVICE_size = new int[] { 172 /* ARMle_EABI */, 172 /* X86_32_UNIX */, 172 /* X86_64_UNIX */, 172 /* X86_32_MACOS */, 172 /* X86_32_WINDOWS */, 172 /* X86_64_WINDOWS */  };
  private static final int[] cb_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };
  private static final int[] DeviceName_offset = new int[] { 4 /* ARMle_EABI */, 4 /* X86_32_UNIX */, 4 /* X86_64_UNIX */, 4 /* X86_32_MACOS */, 4 /* X86_32_WINDOWS */, 4 /* X86_64_WINDOWS */ };
  private static final int[] DeviceString_offset = new int[] { 36 /* ARMle_EABI */, 36 /* X86_32_UNIX */, 36 /* X86_64_UNIX */, 36 /* X86_32_MACOS */, 36 /* X86_32_WINDOWS */, 36 /* X86_64_WINDOWS */ };
  private static final int[] Flags_offset = new int[] { 164 /* ARMle_EABI */, 164 /* X86_32_UNIX */, 164 /* X86_64_UNIX */, 164 /* X86_32_MACOS */, 164 /* X86_32_WINDOWS */, 164 /* X86_64_WINDOWS */ };
  private static final int[] rcVirtualScreen_offset = new int[] { 168 /* ARMle_EABI */, 168 /* X86_32_UNIX */, 168 /* X86_64_UNIX */, 168 /* X86_32_MACOS */, 168 /* X86_32_WINDOWS */, 168 /* X86_64_WINDOWS */ };

  public static int size() {
    return GPU_DEVICE_size[mdIdx];
  }

  public static GPU_DEVICE create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static GPU_DEVICE create(java.nio.ByteBuffer buf) {
      return new GPU_DEVICE(buf);
  }

  GPU_DEVICE(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public GPU_DEVICE setCb(int val) {
    accessor.setIntAt(cb_offset[mdIdx], val);
    return this;
  }

  public int getCb() {
    return accessor.getIntAt(cb_offset[mdIdx]);
  }

  public GPU_DEVICE setDeviceName(byte[] val) {
    accessor.setBytesAt(DeviceName_offset[mdIdx], val);    return this;
  }

  public byte[] getDeviceName() {
    return accessor.getBytesAt(DeviceName_offset[mdIdx], new byte[32]); }

  public GPU_DEVICE setDeviceString(byte[] val) {
    accessor.setBytesAt(DeviceString_offset[mdIdx], val);    return this;
  }

  public byte[] getDeviceString() {
    return accessor.getBytesAt(DeviceString_offset[mdIdx], new byte[128]); }

  public GPU_DEVICE setFlags(int val) {
    accessor.setIntAt(Flags_offset[mdIdx], val);
    return this;
  }

  public int getFlags() {
    return accessor.getIntAt(Flags_offset[mdIdx]);
  }

  public GPU_DEVICE setRcVirtualScreen(int val) {
    accessor.setIntAt(rcVirtualScreen_offset[mdIdx], val);
    return this;
  }

  public int getRcVirtualScreen() {
    return accessor.getIntAt(rcVirtualScreen_offset[mdIdx]);
  }
}
