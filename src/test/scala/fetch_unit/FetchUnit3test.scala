package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec

import chisel3._
import org.scalatest._

class FetchUnit3test extends AnyFreeSpec with ChiselScalatestTester{
    "FetchUnit3Test" in { 
        test(new FetchUnit3()){ a=>
         a.io.npc.poke(0.U)
         a.io.npc_en.poke(0.B)
         a.io.pc.expect(0.U)
         a.clock.step(20)
         }
        
        }
        }