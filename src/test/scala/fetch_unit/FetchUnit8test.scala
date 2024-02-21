package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit8Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit8 Test" in {
    test(new FetchUnit8()) { a =>
     
      a.io.npc.poke(123.U)
      a.io.ctrl(0).poke(true.B)
      a.io.ctrl(1).poke(false.B)
      a.io.pc.expect(123.U) 
      a.clock.step(20) 
    }
  }
}
