package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit15Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit15 Test" in {
    test(new FetchUnit15()) { a =>
      
      a.io.stall_en.poke(false.B)
      a.io.br_en.poke(true.B)
      a.io.imm.poke(123.S)
      a.io.pc.expect(0.U) 
      a.clock.step(20) 
    }
  }
}
