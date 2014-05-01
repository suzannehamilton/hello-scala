package uk.co.suzannehamilton.helloscala

import uk.co.suzannehamilton.helloscala.specs2.Specification
import com.typesafe.config.{ConfigFactory, Config}
import java.util.concurrent.TimeUnit

class ConfigSpec extends Specification {

  val config: Config = ConfigFactory.load()

  "A configured duration with units" should {
    "respond in the specified units if they are the same as the configured units" in {
      config.getDuration("timeConfig.valueWithUnit", TimeUnit.SECONDS) mustEqual 5
    }

    "respond in the specified units if they are different to the configured units" in {
      config.getDuration("timeConfig.valueWithUnit", TimeUnit.MICROSECONDS) mustEqual 5000000
    }
  }

  "A configured duration with NO units" should {
    "be parsed in milliseconds and then converted to the given time unit" in {
      config.getDuration("timeConfig.valueWithoutUnit", TimeUnit.SECONDS) mustEqual 2
    }
  }
}
