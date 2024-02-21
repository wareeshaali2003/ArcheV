package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit9Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit9 Test" in {
    test(new FetchUnit9()) { a =>
    
      a.io.stall_en.poke(false.B)
      a.io.jal_en.poke(true.B)
      a.io.imm.poke(123.S)
      a.io.pc.expect(0.U)
      a.clock.step(20) 
    }
  }
}
