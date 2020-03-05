#import "MyBridge.h"
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_REMAP_MODULE(MyLogManager, MyManager, NSObject)

  RCT_EXTERN_METHOD(
    logTest: (NSString)mnemonic
    resolver: (RCTPromiseResolveBlock)resolve
    rejecter: (RCTPromiseRejectBlock)reject
  )

@end
