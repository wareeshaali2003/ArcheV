package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit6Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit6Test" in {
    test(new FetchUnit6()) { a =>
      a.io.imm.poke(123.S) 
      a.io.rs1.poke(456.S) 
      a.io.npc_en.poke(2.U)
      a.io.pc.expect(0.U) 
      a.clock.step(20)
    }
  }
}
