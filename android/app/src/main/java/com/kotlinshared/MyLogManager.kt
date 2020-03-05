package com.kotlinshared

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.*

import com.shared.LogTestAndroid

@ReactModule(name = MyLogManager.reactClass)
class MyLogManager(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) { 

  companion object {
    const val reactClass = "MyLogManager"
  }

  override fun getName(): String {
    return reactClass
  }

  @ReactMethod
  fun logTest(msg: String, promise: Promise) {
    Thread(Runnable {
      try {
          val address = LogTestAndroid.generateMnemonic()
          promise.resolve(address)
      } catch (e: Exception) {
          promise.reject(e)
      }
    }).start()
  }
}
