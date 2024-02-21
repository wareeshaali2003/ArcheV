package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec

import chisel3._
import org.scalatest._
class FetchUnit4test extends AnyFreeSpec with ChiselScalatestTester {
  "FetchUnit4Test" in {
     test(new FetchUnit4()){ a =>
        a.io.imm.poke(1.S)
        a.io.jal_en.poke(1.U)
        a.io.pc.expect(1.U)
        a.clock.step(20)
        }
       
  }
}

