/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Thu Nov 01 02:13:05 CET 2012 ----! */


package jogamp.nativewindow.x11;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import java.nio.*;
import java.util.*;
import javax.media.nativewindow.util.Point;

public class XRenderDirectFormat {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] XRenderDirectFormat_size = new int[] { 16 /* ARMle_EABI */, 16 /* X86_32_UNIX */, 16 /* X86_64_UNIX */, 16 /* X86_32_MACOS */, 16 /* X86_32_WINDOWS */, 16 /* X86_64_WINDOWS */  };
  private static final int[] red_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };
  private static final int[] redMask_offset = new int[] { 2 /* ARMle_EABI */, 2 /* X86_32_UNIX */, 2 /* X86_64_UNIX */, 2 /* X86_32_MACOS */, 2 /* X86_32_WINDOWS */, 2 /* X86_64_WINDOWS */ };
  private static final int[] green_offset = new int[] { 4 /* ARMle_EABI */, 4 /* X86_32_UNIX */, 4 /* X86_64_UNIX */, 4 /* X86_32_MACOS */, 4 /* X86_32_WINDOWS */, 4 /* X86_64_WINDOWS */ };
  private static final int[] greenMask_offset = new int[] { 6 /* ARMle_EABI */, 6 /* X86_32_UNIX */, 6 /* X86_64_UNIX */, 6 /* X86_32_MACOS */, 6 /* X86_32_WINDOWS */, 6 /* X86_64_WINDOWS */ };
  private static final int[] blue_offset = new int[] { 8 /* ARMle_EABI */, 8 /* X86_32_UNIX */, 8 /* X86_64_UNIX */, 8 /* X86_32_MACOS */, 8 /* X86_32_WINDOWS */, 8 /* X86_64_WINDOWS */ };
  private static final int[] blueMask_offset = new int[] { 10 /* ARMle_EABI */, 10 /* X86_32_UNIX */, 10 /* X86_64_UNIX */, 10 /* X86_32_MACOS */, 10 /* X86_32_WINDOWS */, 10 /* X86_64_WINDOWS */ };
  private static final int[] alpha_offset = new int[] { 12 /* ARMle_EABI */, 12 /* X86_32_UNIX */, 12 /* X86_64_UNIX */, 12 /* X86_32_MACOS */, 12 /* X86_32_WINDOWS */, 12 /* X86_64_WINDOWS */ };
  private static final int[] alphaMask_offset = new int[] { 14 /* ARMle_EABI */, 14 /* X86_32_UNIX */, 14 /* X86_64_UNIX */, 14 /* X86_32_MACOS */, 14 /* X86_32_WINDOWS */, 14 /* X86_64_WINDOWS */ };

  public static int size() {
    return XRenderDirectFormat_size[mdIdx];
  }

  public static XRenderDirectFormat create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static XRenderDirectFormat create(java.nio.ByteBuffer buf) {
      return new XRenderDirectFormat(buf);
  }

  XRenderDirectFormat(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public XRenderDirectFormat setRed(short val) {
    accessor.setShortAt(red_offset[mdIdx], val);
    return this;
  }

  public short getRed() {
    return accessor.getShortAt(red_offset[mdIdx]);
  }

  public XRenderDirectFormat setRedMask(short val) {
    accessor.setShortAt(redMask_offset[mdIdx], val);
    return this;
  }

  public short getRedMask() {
    return accessor.getShortAt(redMask_offset[mdIdx]);
  }

  public XRenderDirectFormat setGreen(short val) {
    accessor.setShortAt(green_offset[mdIdx], val);
    return this;
  }

  public short getGreen() {
    return accessor.getShortAt(green_offset[mdIdx]);
  }

  public XRenderDirectFormat setGreenMask(short val) {
    accessor.setShortAt(greenMask_offset[mdIdx], val);
    return this;
  }

  public short getGreenMask() {
    return accessor.getShortAt(greenMask_offset[mdIdx]);
  }

  public XRenderDirectFormat setBlue(short val) {
    accessor.setShortAt(blue_offset[mdIdx], val);
    return this;
  }

  public short getBlue() {
    return accessor.getShortAt(blue_offset[mdIdx]);
  }

  public XRenderDirectFormat setBlueMask(short val) {
    accessor.setShortAt(blueMask_offset[mdIdx], val);
    return this;
  }

  public short getBlueMask() {
    return accessor.getShortAt(blueMask_offset[mdIdx]);
  }

  public XRenderDirectFormat setAlpha(short val) {
    accessor.setShortAt(alpha_offset[mdIdx], val);
    return this;
  }

  public short getAlpha() {
    return accessor.getShortAt(alpha_offset[mdIdx]);
  }

  public XRenderDirectFormat setAlphaMask(short val) {
    accessor.setShortAt(alphaMask_offset[mdIdx], val);
    return this;
  }

  public short getAlphaMask() {
    return accessor.getShortAt(alphaMask_offset[mdIdx]);
  }
}
