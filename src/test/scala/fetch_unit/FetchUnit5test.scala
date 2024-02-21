package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit5Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit5Test" in {
    test(new FetchUnit5()) { a =>
      a.io.imm.poke(123.S) 
      a.io.rs1.poke(456.S)  
      a.io.npc_en.poke(true.B) 
      a.io.pc.expect(0.U)
      a.clock.step(20) 
    }
  }
}
