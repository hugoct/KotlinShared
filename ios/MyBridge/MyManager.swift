import Foundation
import LibTest

@objc(MyManager)
class MyManager: NSObject {
    @objc static func requiresMainQueueSetup() -> Bool {
        return true
    }

    @objc
    func logTest(_ msg: String, resolver resolve: RCTPromiseResolveBlock, rejecter reject: RCTPromiseRejectBlock) {
      let address = LogTestIos().getAddress(privateKey: "")
      resolve(address)
    }
}
