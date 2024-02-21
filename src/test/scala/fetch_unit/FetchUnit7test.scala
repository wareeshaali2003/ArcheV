package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit7Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit7 Test" in {
    test(new FetchUnit7()) { a =>
      
      a.io.npc.poke(123.U)
      a.io.npc_en.poke(true.B)
      a.io.stall_en.poke(false.B)
      a.io.pc.expect(123.U)
      a.clock.step(20) 
    }
  }
}
