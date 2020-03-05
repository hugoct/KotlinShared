package com.shared

import java.security.SecureRandom;
import io.github.novacrypto.bip39.MnemonicValidator;
import io.github.novacrypto.bip39.MnemonicGenerator;
import io.github.novacrypto.bip39.Words;
import io.github.novacrypto.bip39.wordlists.English;

// HACK bip39 lib
class Appendable() : MnemonicGenerator.Target {
  var word: String = ""
  override fun append(S: CharSequence) {
    word = word + S   
  }
  override fun toString() : String {
    return word;
  }
}

object LogTestCommon {
    fun generateMnemonic() : String {
        var mnemonic = Appendable();
        val entropy = ByteArray(Words.TWELVE.byteLength());
        val secureRandom = SecureRandom()
        secureRandom.nextBytes(entropy);
        val generator = MnemonicGenerator(English.INSTANCE);
        generator.createMnemonic(entropy, mnemonic::append);
        return mnemonic.toString();
    }
}