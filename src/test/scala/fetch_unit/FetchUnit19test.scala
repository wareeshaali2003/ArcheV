package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec
import chisel3._
import org.scalatest._

class FetchUnit19Test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit19 Test" in {
    test(new FetchUnit19()) { a =>
      
      a.io.imm.poke(123.S)
      a.io.rs1.poke(456.S)
      a.io.stall_en.poke(0.B)
      a.io.jalr_en.poke(1.B)
      a.io.jal_en.poke(1.B)
      a.io.pc.expect(0.U) 
      a.clock.step(20) 
    }
  }
}
