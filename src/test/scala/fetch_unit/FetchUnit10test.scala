package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit10Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit10 Test" in {
    test(new FetchUnit10()) { a =>
      
      a.io.ctrl(0).poke(true.B)
      a.io.ctrl(1).poke(false.B)
      a.io.imm.poke(123.S)
      a.io.pc.expect(0.U)
      a.clock.step(20)  
    }
  }
}
