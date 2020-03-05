package com.shared

import java.security.MessageDigest

import com.shared.byteArray.toHex
import com.shared.stringExtensions.hexStringToByteArray

/**
 * Hashing Utils
 * @author Sam Clarke <www.samclarke.com>
 * @license MIT
 */
object HashUtils {
    fun sha512(input: String) = hashString("SHA-512", input)
    fun sha256(input: String) = hashString("SHA-256", input)
    fun sha1(input: String) = hashString("SHA-1", input)

    fun sha512b(input: String) = hashHex("SHA-512", input)
    fun sha256b(input: String) = hashHex("SHA-256", input)
    fun sha1b(input: String) = hashHex("SHA-1", input)

    /**
     * Supported algorithms on Android:
     *
     * Algorithm	Supported API Levels
     * MD5          1+
     * SHA-1	    1+
     * SHA-224	    1-8,22+
     * SHA-256	    1+
     * SHA-384	    1+
     * SHA-512	    1+
     */
    private fun hashString(type: String, input: String): String {
        val bytes = MessageDigest
                .getInstance(type)
                .digest(input.toByteArray())

        return bytes.toHex()
    }

    private fun hashHex(type: String, input: String): ByteArray {
      val bytes = MessageDigest
              .getInstance(type)
              .digest(input.hexStringToByteArray())

      return bytes
    }
}
