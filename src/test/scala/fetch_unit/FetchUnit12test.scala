package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit12Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit12 Test" in {
    test(new FetchUnit12()) { a =>
     
      a.io.ctrl(0).poke(true.B)
      a.io.ctrl(1).poke(false.B)
      a.io.imm.poke(123.S)
      a.io.rs1.poke(456.S)
      a.io.pc.expect(0.U) 
      a.clock.step(20) 
          }
  }
}
