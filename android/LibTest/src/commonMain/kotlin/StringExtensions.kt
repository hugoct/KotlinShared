package com.shared.stringExtensions

import java.math.BigInteger

private val HEX_CHARS = "0123456789ABCDEF"

fun String.hexStringToByteArray() : ByteArray {

  val result = ByteArray(length / 2)

  for (i in 0 until length step 2) {
      val firstIndex = HEX_CHARS.indexOf(this[i].toUpperCase());
      val secondIndex = HEX_CHARS.indexOf(this[i + 1].toUpperCase());

      val octet = firstIndex.shl(4).or(secondIndex)
      result.set(i.shr(1), octet.toByte())
  }

  return result
}

fun String.toBigInteger() : BigInteger {
  return BigInteger(this, 16)
}


fun String.toList() = trim().splitToSequence(",").filter { it.isNotEmpty() }.toList()
