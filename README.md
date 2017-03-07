This repo shows some example usage of [case-classy](https://github.com/47deg/case-classy):
 - Generic derivation of config classes using `classy-generic`s `deriveEncoder`:
    ```scala
    import com.typesafe.config._
    import classy.config._
    import classy.generic._

    val decoder = deriveDecoder[Config, MyCustomConfig]
    val customConfig: MyCustomConfig = decoder.decode(ConfigFactory.load())
    ```
    
 - Configuring custom decoder settings, e.g. naming strategies (`xyz.casperkoning.custom.naming.KebabCase`):
   ```scala
   import com.typesafe.config._
   import classy.config._
   import classy.generic._

   import xyz.casperkoning.custom.naming.KebabCase

   val decoder = makeDecoder[Config, MyCustomConfig]
         .withOptions
         .naming(KebabCase)
         .decoder
   ```
 - Defining custom decoders, see `xyz.casperkoning.custom.decoders`

